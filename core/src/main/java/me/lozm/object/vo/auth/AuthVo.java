package me.lozm.object.vo.auth;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import me.lozm.object.code.UsersType;
import me.lozm.object.vo.BaseVo;

import java.io.Serializable;

@Getter @SuperBuilder
public class AuthVo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1000100010000000001L;

    private Long id;
    private String name;
    private String identifier;
    private String password;
    private UsersType type;
    @Setter
    private String token;

}
