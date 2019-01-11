package com.mitrais.bootcamp.springboot.dao;

import com.mitrais.bootcamp.springboot.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserDao extends PagingAndSortingRepository<User, Long> {

    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUserName(String u);
}
