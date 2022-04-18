package com.example.appbient.api.domain.persistence;

import com.example.appbient.api.domain.model.entity.Voluntario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoluntarioRepository extends JpaRepository<Voluntario, Long> {

}
