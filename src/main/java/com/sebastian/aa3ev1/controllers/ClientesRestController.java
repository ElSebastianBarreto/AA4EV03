package com.sebastian.aa3ev1.controllers;
import com.sebastian.aa3ev1.commons.*;
import com.sebastian.aa3ev1.controllers.*;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.sebastian.aa3ev1.models.Cliente;
import com.sebastian.aa3ev1.models.ClienteDto;
import com.sebastian.aa3ev1.services.ClientesRepository;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
public class ClientesRestController {

	@Autowired
	private ClientesRepository repo;
	
	
	 @GetMapping("/clientes")
	    public List<Cliente> getAllProducts() {
	        return repo.findAll();
	    }
	
	// funcion para buscar un cliente mediante cedula
	@GetMapping(value = "/find/{cedula}")
	public Cliente find(@PathVariable int cedula)
	{return repo.get(cedula);}
	///
	
	//funcion de guardar y enviar al servidor
	@PostMapping(value ="/save")
	public ResponseEntity<Cliente> save(@RequestBody Cliente Cliente){
		
		Cliente obj = ResponseEntity.save(Cliente);
		return new ResponseEntity<Cliente>(obj, HttpStatus.ok);
	}

	
	@GetMapping(value = "/delete/{cedula}")
	public ResponseEntity<Cliente> delete(@PathVariable)
}
	