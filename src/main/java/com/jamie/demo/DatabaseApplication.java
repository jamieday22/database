package com.jamie.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;


@SpringBootApplication
@RestController
@RequestMapping("/Home")

public class DatabaseApplication {

	@Autowired
	//private LanguageRepository languageRepository;
	private ActorRepository actorRepository;

//	public DatabaseApplication(LanguageRepository languageRepository){
//		this.languageRepository = languageRepository;
//	}

	public DatabaseApplication(ActorRepository actorRepository){
		this.actorRepository = actorRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@GetMapping("/AllActor")
	public @ResponseBody
	Iterable<Actor> getAllActors(){return actorRepository.findAll();
	}

//	@GetMapping("/AllLanguages")
//	public @ResponseBody
//	Iterable<Language> getAllLanguages(){return languageRepository.findAll();
//	}


}
