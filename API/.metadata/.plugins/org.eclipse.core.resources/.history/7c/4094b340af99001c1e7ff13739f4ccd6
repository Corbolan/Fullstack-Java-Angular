package com.germano.os.services;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.germano.os.domain.Cliente;
import com.germano.os.domain.OS;
import com.germano.os.domain.Tecnico;
import com.germano.os.domain.enuns.Prioridade;
import com.germano.os.domain.enuns.Status;
import com.germano.os.repositories.ClienteRepository;
import com.germano.os.repositories.OsRepository;
import com.germano.os.repositories.TecnicoRepository;

@Service
public class DBServices {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OsRepository osrepRepository;

	public void instanciaDB() {

		Tecnico t1 = new Tecnico(null,"Valdir Cezar","023.837.508-08","(88) 98888-8888");
		Cliente c1 = new Cliente(null,"Betina Campos","468.057.188-80","(88) 98888-7777");
		OS os1 = new OS(null,Prioridade.ALTA,"Teste create OD",Status.ANDAMENTO,t1,c1);

		t1.getList().add(os1);
		c1.getList().add(os1);

		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osrepRepository.saveAll(Arrays.asList(os1));

	}
}
