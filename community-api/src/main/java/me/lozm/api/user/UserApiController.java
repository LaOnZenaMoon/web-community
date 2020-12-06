package me.lozm.api.user;

import lombok.RequiredArgsConstructor;
import me.lozm.object.code.BoardType;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.ApiResponseCode;
import me.lozm.object.dto.ApiResponseDto;
import me.lozm.object.dto.user.UserDeleteDto;
import me.lozm.object.dto.user.UserGetDto;
import me.lozm.object.dto.user.UserPostDto;
import me.lozm.object.dto.user.UserPutDto;
import me.lozm.object.vo.user.UserVo;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@CrossOrigin("*")
@RestController @RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/usersType/{usersType}")
    public ApiResponseDto getUser(@PathVariable(value = "usersType") UsersType usersType, Pageable pageable) {
        UserGetDto.Response resDto = new UserGetDto.Response();
        resDto.setList(userService.getUserList(usersType, pageable));

        return ApiResponseDto.createException(ApiResponseCode.OK, resDto);
    }

    @PostMapping
    public ApiResponseDto postUser(@RequestBody @Valid UserPostDto.Request reqDto) {
        UserVo userVo = UserVo.builder()
                .name(reqDto.getName())
                .identifier(reqDto.getIdentifier())
                .password(passwordEncoder.encode(reqDto.getPassword()))
                .type(reqDto.getType())
                .createdBy(reqDto.getCreatedBy())
                .build();

        userService.save(userVo);

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @PutMapping
    public ApiResponseDto putUser(@RequestBody @Valid UserPutDto.Request reqDto) {
        UserVo userVo = UserVo.builder()
                .id(reqDto.getId())
                .name(reqDto.getName())
                .identifier(reqDto.getIdentifier())
                .password(isEmpty(reqDto.getPassword()) ? null : passwordEncoder.encode(reqDto.getPassword()))
                .type(reqDto.getType())
                .modifiedBy(reqDto.getModifiedBy())
                .build();

        userService.update(userVo);

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

    @DeleteMapping
    public ApiResponseDto deleteUser(@RequestBody @Valid UserDeleteDto.Request reqDto) {
        for(UserDeleteDto dto : reqDto.getList()) {
            UserVo userVo = UserVo.builder()
                    .id(dto.getId())
                    .modifiedBy(reqDto.getModifiedBy())
                    .build();

            userService.delete(userVo);
        }

        return ApiResponseDto.createException(ApiResponseCode.OK, null);
    }

}