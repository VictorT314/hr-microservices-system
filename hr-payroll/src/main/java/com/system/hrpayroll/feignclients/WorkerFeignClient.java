package com.system.hrpayroll.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.system.hrpayroll.entities.Worker;



@Component
@FeignClient(name = "hr-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

	//WEB SERVICE CALLOUT FOR WORKER ID
	@GetMapping(value = "/{id}")
	ResponseEntity<Worker> findByID(@PathVariable Long id);
}
