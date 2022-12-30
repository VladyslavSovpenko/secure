package com.example.demo.auth;

import java.util.Optional;

public interface AppUserDao {
    public Optional<AppUser> selectAppUserByName(String username);
}
