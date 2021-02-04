package com.system.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.system.hrworker.entities.Worker;
import com.system.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	//USED TO PRINT INFO AT LOG
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);
	
	//ENVIRONMENT INJECTION FOR APP INFO
	@Autowired
	private Environment env;
	
	//REPOSITORY INJECTION
	@Autowired
	private WorkerRepository repository;

	//GET ALL WORKERS
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	//GET WORKERS BY ID
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findByID(@PathVariable Long id){
		
		//TIMEOUT TEST
		/*
		try {
			Thread.sleep(3000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/
		
		//PRINT PORT ON THE LOG
		logger.info("Port = " + env.getProperty("local.server.port"));
		
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
	
}
