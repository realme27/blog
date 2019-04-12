package com.realme.repository;

import com.realme.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Luxshare-ict on 2019/4/11.
 */
public interface UserRepository extends CrudRepository<User,Integer>{

}
