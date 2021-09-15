package com.technical.test.app.repository;

import com.technical.test.app.model.Currency;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

  List<Currency> findByShortName(String shortName);
}
