package com.mintshock.blog.services;

import java.util.UUID;

import com.mintshock.blog.domain.entities.User;

public interface UserService {
    User getUserById(UUID id);
}
