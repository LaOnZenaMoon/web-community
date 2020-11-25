package me.lozm.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import me.lozm.entity.user.User;
import me.lozm.object.vo.auth.AuthVo;
import org.springframework.stereotype.Repository;

import java.util.List;

import static me.lozm.entity.user.QUser.user;


@Repository
@RequiredArgsConstructor
public class RepositorySupport {

    private final JPAQueryFactory jpaQueryFactory;


    public List<User> selectUserDetail(AuthVo authVo) {
        return jpaQueryFactory
                .select(Projections.fields(
                    User.class,
                        user.id,
                        user.name,
                        user.identifier,
                        user.type
                ))
                .from(user)
                .where(
                        user.identifier.eq(authVo.getIdentifier())
                        .and(user.password.eq(authVo.getPassword()))
                        .and(user.flag.eq(1))
                )
                .fetch();
    }

    public List<User> selectUserInfoForJwt(AuthVo authVo) {
        return jpaQueryFactory
                .select(Projections.fields(
                        User.class,
                        user.id,
                        user.name,
                        user.identifier,
                        user.password,
                        user.type
                ))
                .from(user)
                .where(
                        user.flag.eq(1)
                        .and(user.identifier.eq(authVo.getIdentifier()))
                ).fetch();
    }

}
