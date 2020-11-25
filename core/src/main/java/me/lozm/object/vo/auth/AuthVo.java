package me.lozm.object.vo.auth;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import me.lozm.object.code.UsersType;
import me.lozm.object.vo.BaseVo;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
public class AuthVo extends BaseVo implements Serializable {

    private static final long serialVersionUID = 1000100010000000001L;

    private Long id;
    private String name;
    private String identifier;
    private String password;
    private UsersType type;
    @Setter
    private String token;

    @Builder
    public AuthVo(LocalDateTime createdDt, LocalDateTime modifiedDt, Long createdBy, Long modifiedBy, int flag, Long id, String name, String identifier, String password, UsersType type, String token) {
        super(createdDt, modifiedDt, createdBy, modifiedBy, flag);
        this.id = id;
        this.name = name;
        this.identifier = identifier;
        this.password = password;
        this.type = type;
        this.token = token;
    }

}
