package pl.lodomaniak.mail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import pl.lodomaniak.core.Constants;
import pl.lodomaniak.core.LodomaniakConfigurationProperties;
import pl.lodomaniak.mail.api.UserMailTO;
import pl.lodomaniak.mail.spi.MailService;

import javax.mail.internet.MimeMessage;
import java.util.Locale;

@Service
public class DefaultMailService implements MailService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultMailService.class);

    private static final String USER = "user";
    private static final String BASE_URL = "baseUrl";

    private final LodomaniakConfigurationProperties lodomaniakConfigurationProperties;
    private final JavaMailSender javaMailSender;
    private final MessageSource messageSource;
    private final SpringTemplateEngine templateEngine;

    @Autowired
    public DefaultMailService(
            final LodomaniakConfigurationProperties lodomaniakConfigurationProperties,
            final JavaMailSender javaMailSender,
            final MessageSource messageSource,
            final SpringTemplateEngine templateEngine) {
        this.lodomaniakConfigurationProperties = lodomaniakConfigurationProperties;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    @Async
    @Override
    public void sendActivationEmail(final UserMailTO user) {
        LOG.debug("Sending activation email to {}", user.getEmail());

        sendEmailFromTemplate(user, "activationEmail", "email.activation.title");
    }

    @Override
    public void sendResetPasswordEmail(final UserMailTO user) {
        LOG.debug("Sending password reset email to {}", user.getEmail());

        sendEmailFromTemplate(user, "passwordResetEmail", "email.reset.title");
    }

    private void sendEmailFromTemplate(final UserMailTO user, final String templateName, final String titleKey) {
        final Locale locale = Locale.forLanguageTag(user.getLangKey());

        final Context context = new Context(locale);
        context.setVariable(USER, user);
        context.setVariable(BASE_URL, lodomaniakConfigurationProperties.getMail().getBaseUrl());

        final String content = templateEngine.process(templateName, context);
        final String subject = messageSource.getMessage(titleKey, null, locale);

        sendEmail(user.getEmail(), subject, content, false, true);
    }

    private void sendEmail(final String to, final String subject, final String content, final boolean isMultipart,
            final boolean isHtml) {
        LOG.debug("Sending email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
                isMultipart, isHtml, to, subject, content);

        final MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, Constants.UTF_8);
            message.setTo(to);
            message.setFrom(lodomaniakConfigurationProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);

            javaMailSender.send(mimeMessage);

            LOG.debug("Sent email to user '{}'", to);
        } catch (Exception e) {
            LOG.warn("Email could not be sent to user '{}'", to, e);
        }
    }

}
