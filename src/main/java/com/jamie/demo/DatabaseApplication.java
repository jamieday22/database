package com.jamie.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@SpringBootApplication
@RestController
@RequestMapping("/Home")

public class DatabaseApplication {

	@Autowired
	private ActorRepository actorRepository;

	@Autowired
	private LanguageRepository languageRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private FilmRepository filmRepository;

	private String save = "save";
	public DatabaseApplication(ActorRepository actorRepository,
							   LanguageRepository languageRepository,
							   CategoryRepository categoryRepository,
							   FilmRepository filmRepository ){
		this.actorRepository = actorRepository;
		this.languageRepository = languageRepository;
		this.categoryRepository = categoryRepository;
		this.filmRepository = filmRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DatabaseApplication.class, args);
	}

	@GetMapping("/AllActors")
	public @ResponseBody
	Iterable<Actor> getAllActors(){return actorRepository.findAll();
	}

	@GetMapping("/AllLanguages")
	public @ResponseBody
	Iterable<Language> getAllLanguages(){return languageRepository.findAll();
	}



	@GetMapping("/AllCategories")
	public @ResponseBody
	Iterable<Category> getAllCategories(){return categoryRepository.findAll();
	}

	@GetMapping("/AllFilms")
	public @ResponseBody
	Iterable<Film> getAllFilms(){return filmRepository.findAll();
	}

	@GetMapping("/FindFilms/{film_id}")
	public @ResponseBody
	Optional<Film> getFilmById(@PathVariable int film_id){
		return filmRepository.findById(film_id);
	}

	@PostMapping("/AddLanguage")
	public @ResponseBody String addLanguage(@RequestParam String name){
		Language addLanguage = new Language(name);
		languageRepository.save(addLanguage);
		return save;
	}

	@PostMapping("/AddFilm")
	public @ResponseBody String addFilm(@RequestParam String title,String description,int release_year,String rating, int language_id) {
		Film addFilm = new Film(title, description, release_year, rating, language_id);
		filmRepository.save(addFilm);
		return save;


	}

}
