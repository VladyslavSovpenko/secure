package com.example.demo.auth;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.demo.security.AppRole.*;

@Repository("fake")
public class FakeAppUserDaoService implements AppUserDao {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public FakeAppUserDaoService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<AppUser> selectAppUserByName(String username) {
        return getAppUsers()
                .stream()
                .filter(appUser -> username.equals(appUser.getUsername()))
                .findFirst();
    }

    private List<AppUser> getAppUsers() {
        ArrayList<AppUser> appUsers = Lists.newArrayList(
                new AppUser("admin",
                        passwordEncoder.encode("pass"),
                        ADMIN.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true),
                new AppUser("admin-tr",
                        passwordEncoder.encode("pass"),
                        ADMIN_TRAINEE.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true),
                new AppUser("admin",
                        passwordEncoder.encode("pass"),
                        STUDENT.getGrantedAuthority(),
                        true,
                        true,
                        true,
                        true)
        );
        return appUsers;

    }
}
