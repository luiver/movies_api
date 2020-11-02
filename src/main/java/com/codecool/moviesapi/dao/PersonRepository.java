package com.codecool.moviesapi.dao;

import com.codecool.moviesapi.entity.Person;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("fakePersonDao")
public interface PersonRepository extends CrudRepository<Person, Long> {

    public Person findByPersonId(Long id);

    public void deleteByPersonId(Long id);
}
