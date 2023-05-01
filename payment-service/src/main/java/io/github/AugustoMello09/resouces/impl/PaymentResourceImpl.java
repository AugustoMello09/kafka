package io.github.AugustoMello09.resouces.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.AugustoMello09.model.Payment;
import io.github.AugustoMello09.resouces.PaymentResource;
import io.github.AugustoMello09.services.PaymentService;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResourceImpl implements PaymentResource{
	
	@Autowired
	private PaymentService paymentService;
	
	@Override
	public ResponseEntity<Payment> payment(Payment payment) {
		paymentService.sendPayment(payment);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

}
