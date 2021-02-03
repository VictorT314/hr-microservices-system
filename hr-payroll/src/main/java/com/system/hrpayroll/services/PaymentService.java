package com.system.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.system.hrpayroll.entities.Payment;
import com.system.hrpayroll.entities.Worker;

@Service
public class PaymentService {
	
	//WORKER_HOST ATTRIBUTE
	@Value("${hr-worker.host}")
	private String workerHost;
	
	
	//REST_TEMPLATE INJECTION
	@Autowired
	private RestTemplate restTemplate;

	
	//GET_PAYMENT DYNAMICALLY
	public Payment getPayment(long workerId, int days) {
		//MAPPING ID
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("id", ""+workerId);
		
		//DYNAMIC GET METHOD USING MAPPED PARAMETERS
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables);
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
