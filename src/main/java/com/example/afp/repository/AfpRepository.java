package com.example.afp.repository;

import com.example.afp.model.Afp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AfpRepository extends JpaRepository<Afp, Long> {
}
