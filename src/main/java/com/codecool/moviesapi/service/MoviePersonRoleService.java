package com.codecool.moviesapi.service;

import com.codecool.moviesapi.entity.MoviePersonRole;
import com.codecool.moviesapi.exception.BadRequestException;
import com.codecool.moviesapi.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;

@Service
public class MoviePersonRoleService extends GenericService<MoviePersonRole> {
    private PersonService personService;

    @Autowired
    MoviePersonRoleService(CrudRepository<MoviePersonRole, Long> repository) {
        super(repository);
    }

    @Autowired
    public void setMovieService(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void insert(MoviePersonRole moviePersonRole) {
        int movieYear = moviePersonRole.getMovieYear();
        Date personBirthDate = personService.getById(moviePersonRole.getPerson().getId()).getDateOfBirth();
        Calendar cal = Calendar.getInstance();
        cal.setTime(personBirthDate);
        int personBirthYear = cal.get(Calendar.YEAR);

        if (movieYear < personBirthYear) {
            throw new BadRequestException("movie year is before person birth year");
        }

        super.insert(moviePersonRole);
    }

    @Override
    public void update(MoviePersonRole newObject, Long id) {
        repository.save(newObject); // TODO do something with this
    }
}
