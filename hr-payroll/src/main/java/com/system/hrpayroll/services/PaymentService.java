package com.system.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.system.hrpayroll.entities.Payment;
import com.system.hrpayroll.entities.Worker;
import com.system.hrpayroll.feignclients.WorkerFeignClient;

@Service
public class PaymentService {

	@Autowired
	private WorkerFeignClient workerFeignClient;
	
	//GET_PAYMENT DYNAMICALLY WITH FEIGN
	public Payment getPayment(long workerId, int days) {
		
		//DYNAMIC GET METHOD USING FEIGN_CLIENT
		Worker worker = workerFeignClient.findByID(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(), days);
	}
}
