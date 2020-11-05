package com.codecool.moviesapi.service;

import com.codecool.moviesapi.model.Movie;
import com.codecool.moviesapi.model.MoviePersonRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService extends GenericService<Movie> {
    private MoviePersonRoleService moviePersonRoleService;

    @Autowired
    MovieService(CrudRepository<Movie, Long> repository) {
        super(repository);
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

    @Autowired
    public void setMoviePersonRoleService(MoviePersonRoleService moviePersonRoleService) {
        this.moviePersonRoleService = moviePersonRoleService;
    }
}
