package jp.co.kokou.issuetracker.domain.auth.impl;

import jp.co.kokou.issuetracker.domain.user.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class UserDetailsImpl extends User {

    public UserDetailsImpl(String username, String password) {
        super(username, password, Collections.emptyList());
    }
    public UserDetailsImpl(UserEntity entity) {
        this(entity.getUsername(), entity.getPassword());
    }
}
