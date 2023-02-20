package br.com.fnbrandao.artigo_2pc.twophasecommit;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fnbrandao.artigo_2pc.Test1Entity;

@Service
@Profile("2pc")
public class ProducerService2PC {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private JmsTemplate jmsTemplate;

	@Transactional
	public Long produce() {
		final Long id = createAndPersistEntity(entityManager);
		jmsTemplate.convertAndSend("teste", id);
		return id;
	}

	public Long createAndPersistEntity(EntityManager em) {
		final Test1Entity entity = new Test1Entity();
		em.persist(entity);
		return entity.getId();
	}

}
