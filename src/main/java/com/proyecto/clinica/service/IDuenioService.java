package com.proyecto.clinica.service;

import com.proyecto.clinica.dto.DuenioMascotaDTO;
import com.proyecto.clinica.model.Duenio;
import java.util.List;

public interface IDuenioService {

    public List<Duenio> getDuenio();

    public void saveDuenio(Duenio duenio);

    public void deleteDuenio(Long id);

    public void editDuenio(Duenio duenio);

    public Duenio findDuenio(Long id);
}
