package jp.co.kokou.issuetracker.domain.auth.impl;

import jp.co.kokou.issuetracker.dao.user.UserDao;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDao.selectByUsername(username)
                .map(UserDetailsImpl::new)
                .orElseThrow(createUsernameNotFoundException(username));
    }

    private Supplier<UsernameNotFoundException> createUsernameNotFoundException(String username) {
        return () -> new UsernameNotFoundException("usernname " + username + " is not found.");
    }
}
