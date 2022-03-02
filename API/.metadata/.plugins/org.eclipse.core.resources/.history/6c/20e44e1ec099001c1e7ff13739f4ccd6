package com.germano.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.germano.os.domain.Tecnico;
import com.germano.os.dtos.TecnicoDTO;
import com.germano.os.repositories.TecnicoRepository;
import com.germano.os.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Tecnico.class.getName()));
	}
	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	public Tecnico create(TecnicoDTO objDTO) {
		return repository.save( new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
		
	}
}
