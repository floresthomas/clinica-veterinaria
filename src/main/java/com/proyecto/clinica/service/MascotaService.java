package com.proyecto.clinica.service;

import com.proyecto.clinica.dto.DuenioMascotaDTO;
import com.proyecto.clinica.model.Mascota;
import com.proyecto.clinica.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {

    @Autowired
    private IMascotaRepository mascoRepository;

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepository.findAll();
    }

    @Override
    public void saveMascota(Mascota mascota) {
        mascoRepository.save(mascota);
    }

    @Override
    public void deleteMascota(Long id) {
        mascoRepository.deleteById(id);
    }

    @Override
    public void editMascota(Mascota mascota) {
        this.saveMascota(mascota);
    }

    @Override
    public Mascota findMascota(Long id) {
        return mascoRepository.findById(id).orElse(null);
    }

    @Override
    public List<DuenioMascotaDTO> duenioMasco() {
        //Primero me traigo todas las mascotas
        List<Mascota> listaMascotas = this.getMascotas();
        //Creo un array donde voy a guardar las mascotas DTO
        List<DuenioMascotaDTO> listaMascoDuenio = new ArrayList<DuenioMascotaDTO>();
        //Me traigo mi clase DTO
        DuenioMascotaDTO masco_duenio = new DuenioMascotaDTO();

        //Recorro con un foreach cada mascota
        for (Mascota masco : listaMascotas) {
            System.out.println(masco.getNombre());
            //Con los setters reemplazo los valores de mi clase DTO con los de masco
            masco_duenio.setNombre_duenio(masco.getDuenio().getNombre());
            masco_duenio.setNombre_mascota(masco.getNombre());
            masco_duenio.setApellido_duenio(masco.getDuenio().getApellido());
            masco_duenio.setEspecie(masco.getEspecie());
            masco_duenio.setRaza(masco.getRaza());

            listaMascoDuenio.add(masco_duenio);
            masco_duenio = new DuenioMascotaDTO();
        }
        return listaMascoDuenio;
    }

    @Override
    public List<Mascota> getCaniches() {
        List<Mascota> listaMascotas = this.getMascotas();
        List<Mascota> listaCaniches = new ArrayList<Mascota>();

        for (Mascota masco : listaMascotas) {
            if (masco.getEspecie().equalsIgnoreCase("perro") && masco.getRaza().equalsIgnoreCase("caniche")) {
                listaCaniches.add(masco);
            }
        }
        return listaCaniches;
    }

}
