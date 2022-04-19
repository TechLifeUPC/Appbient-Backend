package com.example.appbient.api.domain.persistence;

import com.example.appbient.api.domain.model.entity.Ong;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngRepository extends JpaRepository<Ong, Long> {
}
