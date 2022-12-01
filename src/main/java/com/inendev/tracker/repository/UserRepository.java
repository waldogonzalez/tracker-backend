package com.inendev.tracker.repository;

import com.inendev.tracker.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find one user by given name
     *
     * @param name Searched user name
     * @return Optional of found Attribute, or empty Optional if nothing is found
     */
    Optional<User> findByName(String name);
}
