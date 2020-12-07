package me.lozm.repository.user;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.lozm.entity.user.User;
import me.lozm.object.vo.auth.AuthVo;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static me.lozm.entity.user.QUser.user;


@Repository
@RequiredArgsConstructor
public class AuthRepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;


    public User selectUserInfo(AuthVo authVo) {
        return jpaQueryFactory
                .select(user)
                .from(user)
                .where(
                        user.flag.eq(1)
                        .and(user.identifier.eq(authVo.getIdentifier()))
                )
                .fetchOne();
    }

}
