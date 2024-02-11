package com.igor.gesdoc.repository;

import com.igor.gesdoc.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository <User, Long> {
}
