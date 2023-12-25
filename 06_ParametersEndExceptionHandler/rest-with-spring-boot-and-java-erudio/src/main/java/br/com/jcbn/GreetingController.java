package br.com.jcbn;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private final String templateName = "Hwllo, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "nome", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(templateName, name));
	}
	
	
}
