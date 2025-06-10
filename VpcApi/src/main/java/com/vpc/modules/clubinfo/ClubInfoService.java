package com.vpc.modules.clubinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubInfoService {

    @Autowired
    private ClubInfoRepository clubInfoRepository;

    public List<ClubInfoEntity> getAllClubInfo() {
        return clubInfoRepository.findAll();
    }

    public Optional<ClubInfoEntity> getClubInfoById(Long id) {
        return clubInfoRepository.findById(id);
    }

    public ClubInfoEntity saveClubInfo(ClubInfoEntity clubInfo) {
        return clubInfoRepository.save(clubInfo);
    }

    public void deleteClubInfo(Long id) {
        clubInfoRepository.deleteById(id);
    }
    
    public List<ClubInfoEntity> getClubInfoBySeccion(String seccion) {
        return clubInfoRepository.findBySeccion(seccion);
    }
   
}