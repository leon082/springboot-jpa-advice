package com.technical.test.app.service.impl;

import com.technical.test.app.builder.ItemBuilder;
import com.technical.test.app.dto.ItemRequest;
import com.technical.test.app.dto.ItemResponse;
import com.technical.test.app.error.Errors;
import com.technical.test.app.error.GenericError;
import com.technical.test.app.model.Category;
import com.technical.test.app.model.Country;
import com.technical.test.app.model.Currency;
import com.technical.test.app.model.Item;
import com.technical.test.app.repository.CategoryRepository;
import com.technical.test.app.repository.CountryRepository;
import com.technical.test.app.repository.CurrencyRepository;
import com.technical.test.app.repository.ItemRepository;
import com.technical.test.app.service.IService;
import java.util.Date;
import java.util.List;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import static com.technical.test.app.builder.ItemBuilder.buildItemFromItemRequest;
import static com.technical.test.app.builder.ItemBuilder.buildItemResponseFromItem;

@Service
public class ItemService implements IService<ItemRequest, ItemResponse> {

  private ItemRepository itemRepository;
  private CountryRepository countryRepository;
  private CurrencyRepository currencyRepository;
  private CategoryRepository categoryRepository;


  public ItemService(ItemRepository itemRepository, CountryRepository countryRepository, CurrencyRepository currencyRepository, CategoryRepository categoryRepository, ItemBuilder itemBuilder) {
    this.itemRepository = itemRepository;
    this.countryRepository = countryRepository;
    this.currencyRepository = currencyRepository;
    this.categoryRepository = categoryRepository;

  }

  @SneakyThrows
  @Override
  public ItemResponse getById(Long id) {
    return buildItemResponseFromItem(itemRepository.findById(id).orElseThrow(() -> new GenericError(Errors.ITEM_NOT_FOUND_ERROR.getMessage(), Errors.ITEM_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND)));
  }

  @SneakyThrows
  @Override
  public ItemResponse save(ItemRequest obj) {
    Category category = categoryRepository.findById(obj.getCategoryId()).orElseThrow(() -> new GenericError(Errors.CATEGORY_NOT_FOUND_ERROR.getMessage(), Errors.CATEGORY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND));

    List<Currency> currencyList = currencyRepository.findByShortName(obj.getCurrency());
    if (currencyList.isEmpty())
      throw new GenericError(Errors.CURRENCY_NOT_FOUND_ERROR.getMessage(), Errors.CURRENCY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND);

    List<Country> countryList = countryRepository.findByShortName(obj.getCountry());
    if (countryList.isEmpty())
      throw new GenericError(Errors.COUNTRY_NOT_FOUND_ERROR.getMessage(), Errors.COUNTRY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND);

    Item itemToSave = buildItemFromItemRequest(obj, category, countryList.get(0), currencyList.get(0));
    itemToSave.setCreatedAt(new Date());
    return buildItemResponseFromItem(itemRepository.save(itemToSave));
  }

  @SneakyThrows
  @Override
  public ItemResponse update(ItemRequest obj, Long id) {

    Item currentItem = itemRepository.findById(id).orElseThrow(() -> new GenericError(Errors.ITEM_NOT_FOUND_ERROR.getMessage(), Errors.ITEM_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND));

    Category category = categoryRepository.findById(obj.getCategoryId()).orElseThrow(() -> new GenericError(Errors.CATEGORY_NOT_FOUND_ERROR.getMessage(), Errors.CATEGORY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND));

    List<Currency> currencyList = currencyRepository.findByShortName(obj.getCurrency());
    if (currencyList.isEmpty())
      throw new GenericError(Errors.CURRENCY_NOT_FOUND_ERROR.getMessage(), Errors.CURRENCY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND);

    List<Country> countryList = countryRepository.findByShortName(obj.getCountry());
    if (countryList.isEmpty())
      throw new GenericError(Errors.COUNTRY_NOT_FOUND_ERROR.getMessage(), Errors.COUNTRY_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND);

    Item itemToUpdate = buildItemFromItemRequest(obj, category, countryList.get(0), currencyList.get(0));
    itemToUpdate.setId(id);
    itemToUpdate.setModifiedAt(new Date());
    itemToUpdate.setCreatedAt(currentItem.getCreatedAt());

    return buildItemResponseFromItem(itemRepository.save(itemToUpdate));
  }

  @SneakyThrows
  @Override
  public Boolean delete(Long id) {
    itemRepository.delete(itemRepository.findById(id).orElseThrow(() -> new GenericError(Errors.ITEM_NOT_FOUND_ERROR.getMessage(), Errors.ITEM_NOT_FOUND_ERROR.getCode(), HttpStatus.NOT_FOUND)));
    return Boolean.TRUE;

  }
}
