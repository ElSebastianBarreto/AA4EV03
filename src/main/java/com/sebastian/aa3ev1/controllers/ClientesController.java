package com.sebastian.aa3ev1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.sebastian.aa3ev1.commons.*;
import com.sebastian.aa3ev1.controllers.*;
import com.sebastian.aa3ev1.services.ClientesRepository;

@Controller
@RequestMapping("/home")
public class ClientesController {
	@Autowired
	private ClientesRepository repo;

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("list", ClientesRepository.getAll());
		return "index";
	}

	@GetMapping("/create")
	public String create(Model model) {
		model.addAttribute("persona", new Persona());
		return "save";
	}

	@GetMapping("/save/{id}")
	public String showSave(@PathVariable("id") Long id, Model model) {
		if (id != null && id != 0) {
			model.addAttribute("persona", personaServiceAPI.get(id));
		} else {
			model.addAttribute("persona", new Persona());
		}
		return "save";
	}

	@PostMapping("/save")
	public String save(Persona persona, Model model) {
		personaServiceAPI.save(persona);
		return "redirect:/home/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Long id, Model model) {
		personaServiceAPI.delete(id);

		return "redirect:/home/";
	}

}
