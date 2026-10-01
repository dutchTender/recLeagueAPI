package li.zhang.app.services.base;

import li.zhang.app.persistence.dto.base.UserInfoDTO;
import org.jspecify.annotations.NullMarked;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Profile("PROD")
@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserInfoService userInfoService;

    public AppUserDetailsService(UserInfoService userInfoService) {
        this.userInfoService = userInfoService;
    }
    @NullMarked
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserInfoDTO appUser = userInfoService.findByUserName(username);
        return org.springframework.security.core.userdetails.User.builder()
                .username(appUser.getUserName())
                .password(appUser.getPassWord())
                .authorities(appUser.getRole()) // e.g., "ROLE_USER"
                .build();
    }


}
