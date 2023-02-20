package br.com.fnbrandao.artigo_2pc;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Profile("non-2pc")
public class ProducerService {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private EntityManager entityManagerWithoutXA;

	@Autowired
	private JmsTemplate jmsTemplateWithoutXA;

	@Transactional(propagation =  Propagation.NEVER)
	public Long produce() {
		final Long id = applicationContext.getBean(this.getClass()).createAndPersistEntity(entityManagerWithoutXA);
		jmsTemplateWithoutXA.convertAndSend("teste", id);
		return id;
	}

	@Transactional
	public Long createAndPersistEntity(EntityManager em) {
		final Test1Entity entity = new Test1Entity();
		em.persist(entity);
		return entity.getId();
	}

}
