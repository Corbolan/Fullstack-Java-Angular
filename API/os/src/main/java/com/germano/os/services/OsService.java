package com.germano.os.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.germano.os.domain.OS;
import com.germano.os.repositories.OsRepository;
import com.germano.os.services.exceptions.ObjectNotFoundException;

@Service
public class OsService {

	@Autowired
	private OsRepository repository;
	
	public OS findById(Integer id) {
		Optional<OS> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id +", Tipo: "+ OS.class.getName()));
	}
}
