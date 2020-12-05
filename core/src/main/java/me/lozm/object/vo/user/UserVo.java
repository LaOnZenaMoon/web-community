package me.lozm.object.vo.user;

import lombok.Getter;
import lombok.experimental.SuperBuilder;
import me.lozm.object.vo.BaseVo;

@Getter @SuperBuilder
public class UserVo extends BaseVo {

    private Long id;
    private String name;
    private String identifier;
    private String password;
    private String type;
    private int flag;

}
