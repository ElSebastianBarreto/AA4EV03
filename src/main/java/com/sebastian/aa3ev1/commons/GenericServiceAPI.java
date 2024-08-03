package com.sebastian.aa3ev1.commons;

import java.io.Serializable;
import java.util.List;

public interface GenericServiceAPI <T, ID extends Serializable> {

	T save(T entity);
	
	void delete(ID cedula);
	
	T get(ID cedula);
	
	List<T> getAll();
}