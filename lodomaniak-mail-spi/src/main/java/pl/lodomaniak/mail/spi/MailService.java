package pl.lodomaniak.mail.spi;

import pl.lodomaniak.user.api.UserTO;

public interface MailService {

    void sendActivationEmail(final UserTO user);

}
