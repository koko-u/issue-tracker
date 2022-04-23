package jp.co.kokou.issuetracker.domain.user;

import jp.co.kokou.issuetracker.web.user.UserForm;

import java.util.List;

public interface UserService {
    List<UserEntity> getUserList();

    UserEntity createUser(UserForm user);
}
