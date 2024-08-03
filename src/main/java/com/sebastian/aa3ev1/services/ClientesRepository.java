package com.sebastian.aa3ev1.services;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sebastian.aa3ev1.models.Cliente;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {
	

}
