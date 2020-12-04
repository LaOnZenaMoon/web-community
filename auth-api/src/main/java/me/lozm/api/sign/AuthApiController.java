package me.lozm.api.sign;

import lombok.RequiredArgsConstructor;
import me.lozm.object.dto.ApiResponseCode;
import me.lozm.object.dto.ApiResponseDto;
import me.lozm.object.dto.auth.PostAuthDto;
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
    public ApiResponseDto signIn(@RequestBody @Valid PostAuthDto.Request reqDto) {
        AuthVo authVo = AuthVo.builder()
                .identifier(reqDto.getIdentifier())
                .password(reqDto.getPassword())
                .build();

        AuthVo jwt = jwtAuthenticationService.getToken(authVo);
        PostAuthDto.Response resDto = new PostAuthDto.Response();
        resDto.setToken(jwt.getToken());
        resDto.setPreviousPage("/pages/home");

        return ApiResponseDto.createException(ApiResponseCode.OK, resDto);
    }

}