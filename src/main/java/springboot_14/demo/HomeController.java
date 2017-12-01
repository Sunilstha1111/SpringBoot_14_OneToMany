package springboot_14.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    DirectoryRepository directoryRepository;

    @RequestMapping("/")
    public String index (Model model){
        Director director = new Director();
        director.setName("Stephen Bullock");
        director.setGenre(" Sci Fic");

        Movie movie = new Movie();
        movie.setTitle("Star Movie");
        movie.setYear(2017);
        movie.setDescription("About Stars");

        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("DeathStar Ewoks");
        movie.setYear(2011);
        movie.setDescription("About Ewoks");
        movies.add(movie);

        director.setMovies(movies);

        directoryRepository.save(director);

        model.addAttribute("directors", directoryRepository.findAll());
        return "index";
    }

}
