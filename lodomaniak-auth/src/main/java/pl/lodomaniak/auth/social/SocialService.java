package pl.lodomaniak.auth.social;

import org.springframework.social.connect.Connection;
import pl.lodomaniak.user.api.exception.UserNotFoundException;

public interface SocialService {

    void createUser(Connection<?> connection) throws UserNotFoundException;

}
