package com.codecool.moviesapi.controller;

import com.codecool.moviesapi.entity.Movie;
import com.codecool.moviesapi.entity.MoviePersonRole;
import com.codecool.moviesapi.service.GenericService;
import com.codecool.moviesapi.service.MoviePersonRoleService;
import com.codecool.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController extends GenericController<Movie> {
    private MovieService movieService;
    private MoviePersonRoleService moviePersonRoleService;

    @Autowired
    MovieController(@Qualifier("movieService") GenericService<Movie> service) {
        super(service);
    }

    @Override
    public void insert(@RequestBody Movie movie) {
        super.insert(movie);

        Long count = movieService.getMaxId();
        movie.setId(count);

        for (MoviePersonRole moviePersonRole : movie.getPeople()) {
            moviePersonRole.setMovie(movie);
            moviePersonRoleService.insert(moviePersonRole);
        }
    }

    @Autowired
    public void setMovieService(MovieService movieService) {
        this.movieService = movieService;
    }

    @Autowired
    public void setMoviePersonRoleService(MoviePersonRoleService moviePersonRoleService) {
        this.moviePersonRoleService = moviePersonRoleService;
    }
}
