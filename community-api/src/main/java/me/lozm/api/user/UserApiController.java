package me.lozm.api.user;

import lombok.RequiredArgsConstructor;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.user.UserDeleteDto;
import me.lozm.object.dto.user.UserGetDto;
import me.lozm.object.dto.user.UserPostDto;
import me.lozm.object.dto.user.UserPutDto;
import me.lozm.object.vo.user.UserVo;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController @RequestMapping(value = "/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;


    @GetMapping("/usersType/{usersType}")
    public UserGetDto.Response getUserList(@PathVariable(value = "usersType") UsersType usersType, Pageable pageable) {
        UserGetDto.Response resDto = new UserGetDto.Response();
        resDto.setList(userService.getUserList(usersType, pageable));

        return resDto;
    }

    @PostMapping
    public void postUser(@RequestBody @Valid UserPostDto.Request reqDto) {
         userService.save(UserVo.of(reqDto, passwordEncoder.encode(reqDto.getPassword())));
    }

    @PutMapping
    public void putUser(@RequestBody @Valid UserPutDto.Request reqDto) {
        userService.update(UserVo.of(reqDto, passwordEncoder.encode(reqDto.getPassword())));
    }

    @DeleteMapping
    public void deleteUser(@RequestBody @Valid UserDeleteDto.Request reqDto) {
        for(UserDeleteDto dto : reqDto.getList()) {
            userService.delete(UserVo.of(reqDto.getModifiedBy(), dto));
        }
    }

}