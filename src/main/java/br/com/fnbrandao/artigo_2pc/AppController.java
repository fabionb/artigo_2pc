package br.com.fnbrandao.artigo_2pc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("non-2pc")
public class AppController {

	@Autowired
	private ProducerService producerService;

	@GetMapping("/produce")
	public Long produce() {
		return producerService.produce();
	}

}
