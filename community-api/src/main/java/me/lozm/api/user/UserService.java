package me.lozm.api.user;

import lombok.RequiredArgsConstructor;
import me.lozm.entity.user.User;
import me.lozm.global.exception.ServiceException;
import me.lozm.object.code.UsersType;
import me.lozm.object.vo.user.UserVo;
import me.lozm.repository.user.UserRepository;
import me.lozm.repository.user.UserRepositorySupport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserRepositorySupport userRepositorySupport;


    public Page<User> getUserList(UsersType usersType, Pageable pageable) {
        List<User> userList = userRepositorySupport.getUserListByUsersType(usersType, pageable);
        long totalCount = userRepositorySupport.getUserTotalCountByUsersType(usersType);
        return new PageImpl<>(userList, pageable, totalCount);
    }

    @Transactional
    public void save(UserVo userVo) {
        User user = User.builder().build();
        user.insertUser(userVo);

        //1. check ID duplicated
        List<User> findUsersIdDuplicated = userRepository.findByIdentifier(user.getIdentifier());
        if(findUsersIdDuplicated.size() > 0) throw new ServiceException("USER_0001", "User Identifier is duplicated.");

        userRepository.save(user);
    }

    @Transactional
    public void update(UserVo userVo) {
        Optional<User> findUser = findUser(userVo.getId());
        findUser.get().updateUser(userVo);
    }

    @Transactional
    public void delete(UserVo userVo) {
        Optional<User> findUser = findUser(userVo.getId());
        findUser.get().deleteUser(userVo);
    }

    private Optional<User> findUser(Long userId) {
        Optional<User> findUser = userRepository.findById(userId);
        findUser.orElseThrow(() -> new ServiceException("USER_0002", "User doesn't exist."));
        return findUser;
    }

}

