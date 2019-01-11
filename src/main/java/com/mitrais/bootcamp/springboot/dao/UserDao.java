package com.mitrais.bootcamp.springboot.dao;

import com.mitrais.bootcamp.springboot.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

}
