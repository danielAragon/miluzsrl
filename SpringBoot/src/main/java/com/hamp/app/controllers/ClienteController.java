package com.hamp.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hamp.app.models.entity.Cliente;
import com.hamp.app.models.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@RequestMapping(value = "/buses", method = RequestMethod.GET)
	public String listar(Model model) {
		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());
		return "buses";
	}
	
	@RequestMapping(value = "/busAddEdit")
	public String crear(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("Titulo","Formulario Cliente");
		return "busAddEdit";
	}
}
