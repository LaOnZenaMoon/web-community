package me.lozm.global.jwt;

import lombok.RequiredArgsConstructor;
import me.lozm.object.vo.auth.AuthVo;
import me.lozm.api.sign.AuthService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JwtAuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtils jwtTokenUtils;
    private final AuthService authService;


    public AuthVo getToken(AuthVo authVo) {
        authenticate(authVo.getIdentifier(), authVo.getPassword());
        AuthVo userInfo = authService.getUserInfo(authVo);
        final String token = jwtTokenUtils.generateToken(userInfo);
        userInfo.setToken(token);

        return userInfo;
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new RuntimeException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new RuntimeException("INVALID_CREDENTIALS", e);
        }
    }

}
