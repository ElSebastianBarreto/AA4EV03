package com.sebastian.aa3ev1.controllers;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.sebastian.aa3ev1.models.Cliente;
import com.sebastian.aa3ev1.models.ClienteDto;
import com.sebastian.aa3ev1.services.ClientesRepository;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
public class ClientesController {

	@Autowired
	private ClientesRepository repo;
	
	
	 @GetMapping("/clientes")
	    public List<Cliente> getAllProducts() {
	        return repo.findAll();
	    }
	
	
	
	///

}
	