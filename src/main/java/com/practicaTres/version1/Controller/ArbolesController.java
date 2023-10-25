/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.practicaTres.version1.Controller;

import com.practicaTres.version1.domain.Arboles;
import com.practicaTres.version1.service.ArbolesService;
import com.practicaTres.version1.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/arboles")
public class ArbolesController {
    
    @Autowired
    private ArbolesService arbolesService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var arboles = arbolesService.getArboles(false);
        model.addAttribute("arboles", arboles);
        model.addAttribute("totalarboles", arboles.size());
        return "/arboles/listado";
    }
    
    @GetMapping("/nuevo")
    public String arbolesNuevo(Arboles arboles) {
        return "/arboles/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @PostMapping("/guardar")
    public String arbolesGuardar(Arboles arboles,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            arbolesService.save(arboles);
            arboles.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile, 
                            "arboles", 
                            arboles.getIdArboles()));
        }
        arbolesService.save(arboles);
        return "redirect:/arboles/listado";
    }

    @GetMapping("/eliminar/{idArboles}")
    public String arbolesEliminar(Arboles arboles) {
        arbolesService.delete(arboles);
        return "redirect:/arboles/listado";
    }

    @GetMapping("/modificar/{idArboles}")
    public String arbolesModificar(Arboles arboles, Model model) {
        arboles = arbolesService.getArboles(arboles);
        model.addAttribute("arboles", arboles);
        return "/categoria/modifica";
    }
}
