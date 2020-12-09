package tacos.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tacos.dao.UserRepository;
import tacos.model.User;

@Service
public class UserRepositoryUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserRepositoryUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (null == user) {
            throw new UsernameNotFoundException(String.format("User %s is not found", username));
        }
        return user;
    }
}
