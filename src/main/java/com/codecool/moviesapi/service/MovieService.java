package com.codecool.moviesapi.service;

import com.codecool.moviesapi.model.Movie;
import com.codecool.moviesapi.model.MoviePersonRole;
import com.codecool.moviesapi.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends GenericService<Movie> {
    private final MoviePersonRoleService moviePersonRoleService;

    @Autowired
    MovieService(MovieRepository repository, MoviePersonRoleService moviePersonRoleService) {
        super(repository);
        this.moviePersonRoleService = moviePersonRoleService;
    }

    @Override
    public void insert(Movie movie) {
        super.insert(movie);

        Long count = getMaxId();
        movie.setId(count);

        for (MoviePersonRole moviePersonRole : movie.getPeople()) {
            moviePersonRole.setMovie(movie);
            moviePersonRoleService.insert(moviePersonRole);
        }
    }
}
