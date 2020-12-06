package me.lozm.object.vo.user;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import me.lozm.object.code.UsersType;
import me.lozm.object.dto.user.UserDeleteDto;
import me.lozm.object.dto.user.UserPostDto;
import me.lozm.object.dto.user.UserPutDto;
import me.lozm.object.vo.BaseVo;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Getter @SuperBuilder
public class UserVo extends BaseVo {

    private Long id;
    private String name;
    private String identifier;
    private String password;
    private UsersType type;
    private int flag;


    public static UserVo of(UserPostDto.Request reqDto, String encodedPassword) {
        return UserVo.builder()
                .name(reqDto.getName())
                .identifier(reqDto.getIdentifier())
                .password(encodedPassword)
                .type(reqDto.getType())
                .createdBy(reqDto.getCreatedBy())
                .build();
    }

    public static UserVo of(UserPutDto.Request reqDto, String encodedPassword) {
        return UserVo.builder()
                .id(reqDto.getId())
                .name(reqDto.getName())
                .identifier(reqDto.getIdentifier())
                .password(isEmpty(encodedPassword) ? null : encodedPassword)
                .type(reqDto.getType())
                .modifiedBy(reqDto.getModifiedBy())
                .build();
    }

    public static UserVo of(Long modifiedBy, UserDeleteDto targetDto) {
        return UserVo.builder()
                .id(targetDto.getId())
                .modifiedBy(modifiedBy)
                .build();
    }

}
