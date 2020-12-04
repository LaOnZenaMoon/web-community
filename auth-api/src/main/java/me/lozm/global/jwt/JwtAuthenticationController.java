package me.lozm.global.jwt;

import lombok.RequiredArgsConstructor;
import me.lozm.object.dto.auth.AuthPostDto;
import me.lozm.object.vo.auth.AuthVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class JwtAuthenticationController {

    private final JwtAuthenticationService jwtAuthenticationService;


    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthPostDto.Request reqDto) {
        AuthPostDto.Response resDto = new AuthPostDto.Response();

        try {
            AuthVo loginReqVo = AuthVo.builder()
                    .identifier(reqDto.getIdentifier())
                    .password(reqDto.getPassword())
                    .build();

            AuthVo jwt = jwtAuthenticationService.getToken(loginReqVo);
            resDto.setToken(jwt.getToken());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(resDto);
    }

}
