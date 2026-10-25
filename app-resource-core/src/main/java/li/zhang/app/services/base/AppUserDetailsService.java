package li.zhang.app.services.base;

import li.zhang.app.persistence.dao.base.UserInfoDAO;
import li.zhang.app.persistence.entity.base.UserInfo;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.NullMarked;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;


@Profile("DEV")
@Service
public class AppUserDetailsService implements UserDetailsService {

    private static final Logger logger = Logger.getLogger(AppUserDetailsService.class.getName());
    private final UserInfoDAO userInfoDAO;

    public AppUserDetailsService(UserInfoDAO userInfoDAO) {
        this.userInfoDAO = userInfoDAO;
    }

    @Override
    @NullMarked
    public @NonNull UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserInfo appUser = userInfoDAO.findByUserName(username).orElse(null);
            if(appUser == null) {
                appUser = new UserInfo();
            }
            return org.springframework.security.core.userdetails.User.builder()
                    .username(appUser.getUserName())
                    .password(appUser.getPassword())
                    .authorities(appUser.getRole()) // e.g., "ROLE_USER"
                    .build();
        } catch (Exception exception) {
                logger.info(exception.getMessage());
            throw new UsernameNotFoundException("User not found", exception);
        }


    }

}
