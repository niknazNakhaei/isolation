package com.nakhaei.isolationtransaction.repository;

import com.nakhaei.isolationtransaction.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request,Long> {
}
