package com.example.appbient.api.domain.persistence;

import com.example.appbient.api.domain.model.entity.ComentariosForo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<ComentariosForo, Long> {

}
