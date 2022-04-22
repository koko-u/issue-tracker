package jp.co.kokou.issuetracker.domain.user.impl;

import jp.co.kokou.issuetracker.dao.user.UserDao;
import jp.co.kokou.issuetracker.domain.user.UserEntity;
import jp.co.kokou.issuetracker.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<UserEntity> getUserList() {
        return userDao.selectAll();
    }
}
