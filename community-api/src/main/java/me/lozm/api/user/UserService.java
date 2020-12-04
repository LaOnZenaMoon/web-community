package me.lozm.api.user;

import lombok.RequiredArgsConstructor;
import me.lozm.entity.user.User;
import me.lozm.global.exception.ServiceException;
import me.lozm.object.vo.user.UserVo;
import me.lozm.repository.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public List<User> getUserList() {
        return userRepository.selectUserList();
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

