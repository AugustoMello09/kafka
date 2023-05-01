package io.github.AugustoMello09.services.impl;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import io.github.AugustoMello09.model.Payment;
import io.github.AugustoMello09.services.PaymentService;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private KafkaTemplate<String, Serializable> kafkaTemplate;
	
	@SneakyThrows
	@Override
	public void sendPayment(Payment payment) {
		log.info("PAYMENT_SERVICE_IMPL Recebi o pagamento {}", payment);
		log.info("Recebi o pagamento {}", payment);
        Thread.sleep(1000);

        log.info("Enviando pagamento...");
        kafkaTemplate.send("payment-topic", payment);
	}

}
