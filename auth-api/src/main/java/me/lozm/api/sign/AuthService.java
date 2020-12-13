package me.lozm.api.sign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.lozm.entity.user.User;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.ApiException;
import me.lozm.object.dto.ApiResponseCode;
import me.lozm.object.vo.auth.AuthVo;
import me.lozm.repository.user.AuthRepositorySupport;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class AuthService implements UserDetailsService {

    private final AuthRepositorySupport authRepositorySupport;


    public AuthVo getUserInfo(AuthVo authVo) {
        Optional<User> findUser = findUserInfo(authVo);
        return buildAuthVo(findUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> findUser = findUserInfo(AuthVo.builder()
                .identifier(username)
                .build());
        AuthVo authVo = buildAuthVo(findUser);

        return new org.springframework.security.core.userdetails.User(
                authVo.getIdentifier(),
                authVo.getPassword(),
                new ArrayList<>()
        );
    }


    private Optional<User> findUserInfo(AuthVo authVo) {
        Optional<User> findUser = authRepositorySupport.selectUserInfo(authVo);

        if (!findUser.isPresent()) {
            log.error("Fail to sign in. User name: {}, User Identifier: {}", authVo.getName(), authVo.getIdentifier());
            throw new ApiException(ApiResponseCode.BAD_REQUEST);
        }
        return findUser;
    }

    private AuthVo buildAuthVo(Optional<User> findUser) {
        return AuthVo.builder()
                .id(findUser.get().getId())
                .name(findUser.get().getName())
                .identifier(findUser.get().getIdentifier())
                .password(findUser.get().getPassword())
                .type(UsersType.valueOf(findUser.get().getType()))
                .build();
    }

}

