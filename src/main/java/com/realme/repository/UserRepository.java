package com.realme.repository;

import com.realme.domain.User;

import java.util.List;

/**
 * Created by Luxshare-ict on 2019/4/11.
 */
public interface UserRepository {
    User saveOrUpdate(User user);
    void delete(int id);
    User  getUserById(int id);
    List<User> getList();
}
