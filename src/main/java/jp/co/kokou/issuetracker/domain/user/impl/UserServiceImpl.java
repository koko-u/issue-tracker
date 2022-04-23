package jp.co.kokou.issuetracker.domain.user.impl;

import jp.co.kokou.issuetracker.dao.user.UserDao;
import jp.co.kokou.issuetracker.domain.user.UserEntity;
import jp.co.kokou.issuetracker.domain.user.UserService;
import jp.co.kokou.issuetracker.web.user.UserForm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.seasar.doma.jdbc.UniqueConstraintException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<UserEntity> getUserList() {
        return userDao.selectAll();
    }

    @Override
    public UserEntity createUser(UserForm user) {
        if (user == null) return null;
        if (!Objects.equals(user.getPassword(), user.getPasswordConfirm())) {
            return null;
        }

        try {
            var entity = new UserEntity();
            entity.setUsername(user.getUsername());
            entity.setPassword(user.getPassword());
            userDao.insert(entity);
            return entity;
        } catch (UniqueConstraintException e) {
            log.error("{}", e.getMessage());
            log.error("SQL: {}", e.getFormattedSql());
            return null;
        }
    }
}
