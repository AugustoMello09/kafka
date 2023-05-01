package io.github.AugustoMello09.listener;

import static java.lang.Thread.sleep;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import io.github.AugustoMello09.model.Payment;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
public class JsonListener {

	@KafkaListener(topics = "payment-topic", groupId = "create-group", containerFactory = "jsonContainerFactory")
	public void antiFraud(@Payload Payment payment) throws Throwable {
		log.info("recebi o pagamento {}", payment.toString());
		sleep(2000);
		log.info("Validando fraude ...");
		sleep(2000);

		log.info("Compra aprovada");
		sleep(2000);
	}

	@KafkaListener(topics = "payment-topic", groupId = "pdf-group", containerFactory = "jsonContainerFactory")
	public void pfdGenerator(@Payload Payment payment) throws Throwable {
		log.info("Gerando PDF do produto de id {}", payment.getId());
		sleep(3000);
	}
	
	@KafkaListener(topics = "payment-topic", groupId = "email-group", containerFactory = "jsonContainerFactory")
	public void sendEmail() throws Throwable {
		log.info("Enviando email de confirmacao");
		
	}
}
