package com.technical.test.app.utils;

import com.technical.test.app.dto.ItemRequest;
import com.technical.test.app.model.Category;
import com.technical.test.app.model.Country;
import com.technical.test.app.model.Currency;
import com.technical.test.app.model.Item;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class BuilderTestItemObject {

  public static Optional<Category> getValidOptionalCategory() {

    return Optional.of(new Category(1L, "Test"));

  }

  public static List<Currency> getValidListOptionalCurrency() {

    return Arrays.asList(new Currency(1L, "COP", "Pesos Colombianos"));

  }

  public static List<Country> getValidListOptionalCountry() {

    return Arrays.asList(new Country(1L, "CO", "Colombia"));

  }

  public static ItemRequest getValidItemRequest() {

    return new ItemRequest("RequestDemo", new BigDecimal(1), "COP", "CO", 7L);

  }

  public static Optional<Item> getValidItem() {

    return Optional.of(new Item(1L, "Demo", new Category(1L, "Test"), new BigDecimal(1), new Currency(1L, "COP", "Pesos Colombianos"),
        new Country(1L, "CO", "Colombia"), new Date(), new Date()));

  }
}
