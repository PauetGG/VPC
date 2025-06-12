package com.vpc.modules.clubinfo;

import java.time.LocalDateTime;
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
    public List<ClubInfoEntity> getClubInfoBySeccionYOrden(String seccion) {
        return clubInfoRepository.findBySeccionOrderByOrdenAsc(seccion);
    }

    public List<ClubInfoEntity> searchClubInfo(String query) {
        return clubInfoRepository.findByTituloContainingIgnoreCaseOrContenidoContainingIgnoreCase(query, query);
    }

    public ClubInfoEntity toggleImagenPrincipal(Long id, String nuevaImagen) {
        Optional<ClubInfoEntity> optionalClubInfo = clubInfoRepository.findById(id);
        if (optionalClubInfo.isPresent()) {
            ClubInfoEntity clubInfo = optionalClubInfo.get();
            clubInfo.setImagenPrincipal(nuevaImagen);
            clubInfo.setActualizadoEn(LocalDateTime.now());
            return clubInfoRepository.save(clubInfo);
        } else {
            throw new RuntimeException("ClubInfo no encontrado con ID: " + id);
        }
    }

    public ClubInfoEntity toggleOrden(Long id, Integer nuevoOrden) {
        Optional<ClubInfoEntity> optionalClubInfo = clubInfoRepository.findById(id);
        if (optionalClubInfo.isPresent()) {
            ClubInfoEntity clubInfo = optionalClubInfo.get();
            clubInfo.setOrden(nuevoOrden);
            clubInfo.setActualizadoEn(LocalDateTime.now());
            return clubInfoRepository.save(clubInfo);
        } else {
            throw new RuntimeException("ClubInfo no encontrado con ID: " + id);
        }
    }
   
}