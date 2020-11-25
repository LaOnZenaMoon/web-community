package me.lozm.api.sign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.lozm.entity.user.User;
import me.lozm.object.vo.auth.AuthVo;
import me.lozm.repository.RepositorySupport;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {
    
    private final RepositorySupport repositorySupport;


    public AuthVo getUserInfo(AuthVo authVo) {
        List<User> users = repositorySupport.selectUserInfoForJwt(authVo);

        return AuthVo.builder()
                .id(users.get(0).getId())
                .name(users.get(0).getName())
                .identifier(users.get(0).getIdentifier())
                .password(users.get(0).getPassword())
                .type(users.get(0).getType())
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthVo authVo = AuthVo.builder()
                .identifier(username)
                .build();

        List<User> users = repositorySupport.selectUserInfoForJwt(authVo);
        AuthVo jwt = AuthVo.builder()
                .id(users.get(0).getId())
                .name(users.get(0).getName())
                .identifier(users.get(0).getIdentifier())
                .password(users.get(0).getPassword())
                .type(users.get(0).getType())
                .build();

        if (ObjectUtils.isNotEmpty(jwt)) {
            log.debug("login success");
        } else {
            log.debug("login failed");
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                jwt.getIdentifier(),
                jwt.getPassword(),
                new ArrayList<>()
        );
    }
}

