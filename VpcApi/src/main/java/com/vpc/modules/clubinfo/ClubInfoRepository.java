package com.vpc.modules.clubinfo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubInfoRepository extends JpaRepository<ClubInfoEntity, Long>{

}
