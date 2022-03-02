package com.germano.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.germano.os.domain.Cliente;
import com.germano.os.domain.Pessoa;
import com.germano.os.dtos.ClienteDTO;
import com.germano.os.repositories.ClienteRepository;
import com.germano.os.repositories.PessoaRepository;
import com.germano.os.resource.exceptions.DataIntegratyViolationException;
import com.germano.os.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public List<Cliente> findAll() {
		return repository.findAll();
	}
	/*
	 * Trata CPF já cadastrado
	 */

	public Cliente create(ClienteDTO objDTO) {
		if (findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		return repository.save(new Cliente(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));

	}
	/*
	 * Atualiza Cliente
	 */
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		Cliente oldObj = findById(id);
		if (findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id) {
			throw new DataIntegratyViolationException("CPF já cadastrado na base de dados!");
		}
		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		return repository.save(oldObj);
	}
	/*
	 * Deleta Cliente pelo id
	 */
	public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getList().size() > 0) { // Se a lista for maior que 0
			throw new DataIntegratyViolationException("Pessoa possui Ordens de Serviço, não pode ser deletado!");
		}
		repository.deleteById(id);
	}

	private Pessoa findByCPF(ClienteDTO objDTO) {
		Pessoa obj = pessoaRepository.findByCPF(objDTO.getCpf());
		if (obj != null) {
			return obj;
		}
		return null;
	}

}
