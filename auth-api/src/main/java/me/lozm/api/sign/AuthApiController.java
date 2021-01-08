package me.lozm.api.sign;

import lombok.RequiredArgsConstructor;
import me.lozm.object.dto.auth.AuthPostDto;
import me.lozm.object.vo.auth.AuthVo;
import me.lozm.global.jwt.JwtAuthenticationService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController @RequestMapping(value = "/api/sign")
@RequiredArgsConstructor
public class AuthApiController {

    private final JwtAuthenticationService jwtAuthenticationService;


    @PostMapping(value = "/in")
    public AuthPostDto.Response signIn(@RequestBody @Valid AuthPostDto.Request reqDto) {
        AuthVo authVo = AuthVo.builder()
                .identifier(reqDto.getIdentifier())
                .password(reqDto.getPassword())
                .build();

        AuthVo jwt = jwtAuthenticationService.getToken(authVo);
        AuthPostDto.Response resDto = new AuthPostDto.Response();
        resDto.setToken(jwt.getToken());
        resDto.setPreviousPage("/pages/home");

        return resDto;
    }

}