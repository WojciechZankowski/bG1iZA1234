package pl.lodomaniak.mail.spi;

import pl.lodomaniak.mail.api.UserMailTO;

public interface MailService {

    void sendActivationEmail(final UserMailTO user);

    void sendResetPasswordEmail(final UserMailTO user);

}
