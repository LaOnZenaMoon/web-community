package lozm.entity.user;

import lombok.*;
import lozm.entity.BaseEntity;
import lozm.object.code.UsersType;
import lozm.object.vo.user.UserVo;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.persistence.*;



@Entity @Table(schema = "LOZM", name = "USERS")
@Getter @Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED) @AllArgsConstructor
public class User extends BaseEntity {

    @Id @GeneratedValue
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "IDENTIFIER")
    private String identifier;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "TYPE")
    private UsersType type;


    public void insertUser(UserVo userVo) {
        this.name = userVo.getName();
        this.identifier = userVo.getIdentifier();
        this.password = userVo.getPassword();
        this.type = UsersType.valueOf(userVo.getType());
        this.setBaseEntity(userVo.getCreatedBy(), null, 1);
    }

    public void updateUser(UserVo userVo) {
        this.name = userVo.getName();
        this.identifier = userVo.getIdentifier();
        if(!ObjectUtils.isEmpty(userVo.getPassword())) {
            this.password = userVo.getPassword();
        }
        this.type = StringUtils.isEmpty(userVo.getType()) ? null : UsersType.valueOf(userVo.getType());
        this.setBaseEntity(null, userVo.getModifiedBy(), 1);
    }

    public void deleteUser(UserVo userVo) {
        this.setBaseEntity(null, userVo.getModifiedBy(), 0);
    }

}