package com.proyecto.clinica.controller;

import com.proyecto.clinica.model.Duenio;
import com.proyecto.clinica.service.DuenioService;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class DuenioController {

    @Autowired
    private DuenioService duenioService;

    @PostMapping("/duenio/crear")
    public String saveDuenio(@RequestBody Duenio duenio) {
        duenioService.saveDuenio(duenio);
        return "Duenio creado correctamente";
    }

    @GetMapping("/duenio/traer")
    public List<Duenio> getDuenio() {
        return duenioService.getDuenio();
    }

    @DeleteMapping("/duenio/eliminar/{id_duenio}")
    public String deleteDuenio(@PathVariable Long id_duenio) {
        duenioService.deleteDuenio(id_duenio);
        return "Duenio eliminado correctamente";
    }

    @PutMapping("/duenio/editar")
    public String editDuenio(@RequestBody Duenio duenio) {
        duenioService.saveDuenio(duenio);
        return "Duenio editado correctamente";
    }

}
