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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;

    private Family user;

    public Family register(Family user) {
        if(userRepository.findByUsername(user.getUsername()).isPresent()){
            return user;
        }
        user.setPassword(encoder.encode(user.getPassword()));
        this.user = userRepository.save(user);
        return user;
    }

    public boolean isLoggedIn() {
        return !"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}
