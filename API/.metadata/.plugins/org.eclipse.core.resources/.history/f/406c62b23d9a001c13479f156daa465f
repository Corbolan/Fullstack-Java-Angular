package com.germano.os.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.germano.os.dtos.OSDTO;
import com.germano.os.services.OsService;

@RestController
@RequestMapping(value = "/os")
public class OsResource {
	@Autowired
	private OsService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<OSDTO> findById(@PathVariable Integer id){
		OSDTO obj = new OSDTO (service.findById(id));
		return ResponseEntity.ok().body(obj);
	}
}
