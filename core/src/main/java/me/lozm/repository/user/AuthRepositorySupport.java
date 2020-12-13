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


    public Optional<User> selectUserInfo(AuthVo authVo) {
        return Optional.ofNullable(jpaQueryFactory
                .select(user)
                .from(user)
                .fetchOne());
    }

}
