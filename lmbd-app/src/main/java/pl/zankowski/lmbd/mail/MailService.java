package pl.zankowski.lmbd.mail;

import pl.zankowski.lmbd.user.api.UserTO;

public interface MailService {

    void sendActivationEmail(final UserTO user);

}
