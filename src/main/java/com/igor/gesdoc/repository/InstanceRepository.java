package com.igor.gesdoc.repository;

import com.igor.gesdoc.entity.Instance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstanceRepository extends JpaRepository<Instance, Long> {
}
