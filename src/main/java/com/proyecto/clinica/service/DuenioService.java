package com.proyecto.clinica.service;

import com.proyecto.clinica.dto.DuenioMascotaDTO;
import com.proyecto.clinica.model.Duenio;
import com.proyecto.clinica.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService {

    @Autowired
    private IDuenioRepository duenioRepository;

    @Override
    public List<Duenio> getDuenio() {
        return duenioRepository.findAll();
    }

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepository.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id) {
        duenioRepository.deleteById(id);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }

    @Override
    public Duenio findDuenio(Long id) {
        return duenioRepository.findById(id).orElse(null);
    }

}
