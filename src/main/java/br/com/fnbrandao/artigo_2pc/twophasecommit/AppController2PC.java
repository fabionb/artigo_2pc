package br.com.fnbrandao.artigo_2pc.twophasecommit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("2pc")
public class AppController2PC {

	@Autowired
	private ProducerService2PC producerService;

	@GetMapping("/produce")
	public Long produce() {
		return producerService.produce();
	}

}
