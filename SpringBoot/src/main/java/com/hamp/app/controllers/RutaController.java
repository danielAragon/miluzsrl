package com.hamp.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamp.app.models.entity.Ruta;
import com.hamp.app.models.service.IRutaService;

@Controller
public class RutaController {
	@Autowired
	public IRutaService rutaService;
	
	@RequestMapping(value = "/rutas", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de rutas");
		model.addAttribute("rutas", rutaService.findAll());
		return "rutas";
	}
	@RequestMapping(value={"/rutaAddEdit","/rutaAddEdit/{id}"}, method = RequestMethod.GET)
    public String rutaFindOne(Model model, @PathVariable(required = false, name = "ruta_id") String id) {
        if (null != id) {
            model.addAttribute("ruta", rutaService.findOne(id));
        } else {
            model.addAttribute("ruta", new Ruta());
        }
        return "rutaAddEdit";
    }
	@RequestMapping(value = "/rutaAddEdit", method = RequestMethod.POST)
	public String rutaUpdate(Model model,Ruta ruta) {
		
		rutaService.save(ruta);
		model.addAttribute("rutas", rutaService.findAll());
		return "rutas";
	}
}
