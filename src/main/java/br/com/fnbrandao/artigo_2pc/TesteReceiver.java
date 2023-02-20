package br.com.fnbrandao.artigo_2pc;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TesteReceiver {

	private static final Logger logger = LoggerFactory.getLogger(TesteReceiver.class);

	@Autowired
	private EntityManager entityManager;

	@JmsListener(destination = "teste", concurrency = "10-10")
	public void process(Long id) {
		logger.info("Consuming: {}", id);
		final Test1Entity entity = entityManager.find(Test1Entity.class, id);
		logger.info("Consumed: {}", entity.getId());
	}
}
