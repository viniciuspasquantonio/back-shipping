package br.com.pasquantonio.walmart.backshipping.receiver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import br.com.pasquantonio.walmart.backshipping.dto.ShippingSchedule;
public class ShippingScheduleListener {

	private static final Logger log = LoggerFactory.getLogger(ShippingScheduleListener.class);

	@RabbitListener(queues = "QUEUE_GENERIC_NAME")
	public void receiveMessage(final Message message) {
		log.info("Received message as generic: {}", message.toString());
	}

	@RabbitListener(queues = "QUEUE_SPECIFIC_NAME")
	public void receiveMessage(final ShippingSchedule customMessage) {
		log.info("Received message as specific class: {}", customMessage.toString());
	}
}
