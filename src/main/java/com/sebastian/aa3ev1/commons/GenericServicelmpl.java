package com.sebastian.aa3ev1.commons;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public abstract class GenericServicelmpl<T, ID extends Serializable> implements GenericServiceAPI<T, ID> {
	
	@Override
	public T save(T entity) {
		return getDao().save(entity);
	}

	@Override
	public void delete(ID cedula) {
		getDao().deleteById(cedula);
	}

	@Override
	public T get(ID cedula) {
		Optional<T> obj = getDao().findById(cedula);
		if (obj.isPresent()) {
			return obj.get();
		}
		return null;
	}

	@Override
	public List<T> getAll() {
		List<T> returnList = new ArrayList<>();
		getDao().findAll().forEach(obj -> returnList.add(obj));
		return returnList;
	}

	public abstract CrudRepository<T, ID> getDao();

}
