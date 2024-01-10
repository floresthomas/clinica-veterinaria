package com.proyecto.clinica.controller;

import com.proyecto.clinica.dto.DuenioMascotaDTO;
import com.proyecto.clinica.model.Mascota;
import com.proyecto.clinica.service.MascotaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class MascotaController {

    @Autowired
    private MascotaService mascoService;

    @PostMapping("/mascotas/crear")
    public String createMascota(@RequestBody Mascota mascota) {
        mascoService.saveMascota(mascota);
        return "Mascota creada correctamente";
    }

    @GetMapping("/mascotas/traer")
    public List<Mascota> getMascotas() {
        return mascoService.getMascotas();
    }

    @DeleteMapping("/mascotas/eliminar/{id_mascota}")
    public String deleteMascota(@PathVariable Long id_mascota) {
        mascoService.deleteMascota(id_mascota);
        return "Mascota eliminada correctamente";
    }

    @PutMapping("/mascotas/editar")
    public String editMascota(@RequestBody Mascota mascota) {
        mascoService.editMascota(mascota);
        return "Mascota editada correctamente";
    }

    @GetMapping("/mascotas/duenio-masco")
    public List<DuenioMascotaDTO> getDuenioMascotaDTO() {
        return mascoService.duenioMasco();
    }

    @GetMapping("/mascotas/caniches")
    public List<Mascota> getMascotaCaniche() {
        return mascoService.getCaniches();
    }
}
