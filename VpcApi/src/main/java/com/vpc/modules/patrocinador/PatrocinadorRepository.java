package com.vpc.modules.patrocinador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<PatrocinadorEntity, Long> {

}
