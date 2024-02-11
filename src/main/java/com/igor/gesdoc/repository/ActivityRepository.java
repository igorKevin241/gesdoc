package com.igor.gesdoc.repository;

import com.igor.gesdoc.entity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository <Activity, Long> {
}
