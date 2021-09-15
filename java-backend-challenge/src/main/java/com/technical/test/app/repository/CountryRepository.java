package com.technical.test.app.repository;

import com.technical.test.app.model.Country;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends CrudRepository<Country, Long> {

  List<Country> findByShortName(String shortName);
}
