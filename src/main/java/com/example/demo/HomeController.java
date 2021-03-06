package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    ActorRepository actorRepository;

    @RequestMapping("/")
    public String index(Model model){
        // First let's create an actor
        Actor actor = new Actor();
        actor.setName("Sandra Bullock");
        actor.setRealname("Sandra Mae Bullowski");

        //Now let's create a movie
        Movie movie = new Movie();
        movie.setTitle("Emoji Movie");
        movie.setYear(2017);
        movie.setDescription("About Emojis...");

        //Now let's create a movie
        Movie movie1 = new Movie();
        movie1.setTitle("Valerian and the City of a Thousand Planets");
        movie1.setYear(2017);
        movie1.setDescription("About Planets...");

        //Now let's create a movie
        Movie movie2 = new Movie();
        movie2.setTitle("Wonder Woman");
        movie2.setYear(2017);
        movie2.setDescription("About Wonder Woman...");

        //Add the movie to an empty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movies.add(movie1);
        movies.add(movie2);

        // Add the list of movies to the actor's movie list
        actor.setMovies(movies);

        //Save the actor to the database
        actorRepository.save(actor);

        // Grad all the actors from the database and send them to
        // the template
        model.addAttribute("actors", actorRepository.findAll());
        return "index";
    }


}
