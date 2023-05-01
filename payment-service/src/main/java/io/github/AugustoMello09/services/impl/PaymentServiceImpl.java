package io.github.AugustoMello09.services.impl;

import org.springframework.stereotype.Service;

import io.github.AugustoMello09.model.Payment;
import io.github.AugustoMello09.services.PaymentService;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{

	@Override
	public void sendPayment(Payment payment) {
		log.info("PAYMENT_SERVICE_IMPL ::: Recebi o pagamento {}", payment);	
	}

}
