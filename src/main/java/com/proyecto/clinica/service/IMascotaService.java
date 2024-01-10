package com.proyecto.clinica.service;

import com.proyecto.clinica.dto.DuenioMascotaDTO;
import com.proyecto.clinica.model.Mascota;
import java.util.List;

public interface IMascotaService {

    public List<Mascota> getMascotas();

    public void saveMascota(Mascota mascota);

    public void deleteMascota(Long id);

    public void editMascota(Mascota mascota);

    public Mascota findMascota(Long id);

    public List<Mascota> getCaniches();

    public List<DuenioMascotaDTO> duenioMasco();
}
