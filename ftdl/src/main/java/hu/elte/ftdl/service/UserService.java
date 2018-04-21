package hu.elte.ftdl.service;

/**
 *
 * @author Horváth Csilla
 */
import hu.elte.ftdl.model.Family;

import hu.elte.ftdl.repository.UserRepository;
import hu.elte.ftdl.service.exceptions.UserNotValidException;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private Family user;

    public Family login(Family user) throws UserNotValidException {
        if (isValid(user)) {
            return this.user = userRepository.findByUsername(user.getUsername()).get();
        }
        throw new UserNotValidException();
    }

    public Family register(Family user) {
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isValid(Family user) {
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword()).isPresent();
    }

    public boolean isLoggedIn() {
        return user != null;
    }
}
