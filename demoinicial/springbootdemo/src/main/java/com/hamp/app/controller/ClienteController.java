package com.hamp.app.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.hamp.app.models.entity.Cliente;
import com.hamp.app.service.IClienteService;

@Controller
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	

	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public String listar(Model model) {

		model.addAttribute("titulo", "Listado de clientes");
		model.addAttribute("clientes", clienteService.findAll());

		return "listar";
	}

	@RequestMapping(value = "/form")
	public String crear(Model model) {

		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		model.addAttribute("titulo", "Crear Cliente");
		return "form";
	}

	
	@RequestMapping(value = "/form", method = RequestMethod.POST)
	public String guardar(Cliente cliente) {
		clienteService.save(cliente);
		return "redirect:listar";
	}

	
}
