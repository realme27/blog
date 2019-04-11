package com.realme.repository.impl;

import com.realme.domain.User;
import com.realme.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Luxshare-ict on 2019/4/11.
 */
@Repository
public class UserRepositoryImpl implements UserRepository{
    /**
     * 计数器
     */
    private static AtomicInteger count = new AtomicInteger();
    private  final ConcurrentMap<Integer,User> userMap =new ConcurrentHashMap<Integer,User>();


    @Override
    public User saveOrUpdate(User user) {
        int id = user.getId();
        if(id == 0){
            id=count.incrementAndGet();
            user.setId(id);

        }
        this.userMap.put(id,user);
        return user;
    }

    @Override
    public void delete(int id) {
    this.userMap.remove(id);
    }

    @Override
    public User getUserById(int id) {
        return this.userMap.get(id);
    }

    @Override
    public List<User> getList() {
        return new ArrayList<>(this.userMap.values());
    }
}
