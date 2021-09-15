package com.technical.test.app.service;

import com.technical.test.app.dto.ItemResponse;
import com.technical.test.app.repository.CategoryRepository;
import com.technical.test.app.repository.CountryRepository;
import com.technical.test.app.repository.CurrencyRepository;
import com.technical.test.app.repository.ItemRepository;
import com.technical.test.app.service.impl.ItemService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static com.technical.test.app.utils.BuilderTestItemObject.getValidItem;
import static com.technical.test.app.utils.BuilderTestItemObject.getValidItemRequest;
import static com.technical.test.app.utils.BuilderTestItemObject.getValidListOptionalCountry;
import static com.technical.test.app.utils.BuilderTestItemObject.getValidListOptionalCurrency;
import static com.technical.test.app.utils.BuilderTestItemObject.getValidOptionalCategory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class ItemServiceTest {

  @InjectMocks
  private ItemService itemService;

  @Mock
  private CurrencyRepository currencyRepository;

  @Mock
  private ItemRepository itemRepository;

  @Mock
  private CountryRepository countryRepository;

  @Mock
  private CategoryRepository categoryRepository;


  @Before
  public void init() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void save() {
    when(categoryRepository.findById(any())).thenReturn(getValidOptionalCategory());
    when(currencyRepository.findByShortName(any())).thenReturn(getValidListOptionalCurrency());
    when(countryRepository.findByShortName(any())).thenReturn(getValidListOptionalCountry());
    when(itemRepository.save(any())).thenReturn(getValidItem().get());
    ItemResponse response = itemService.save(getValidItemRequest());
    assertEquals(response.getId().longValue(), 1L);
  }

  @Test
  public void getById() {
    when(itemRepository.findById(any())).thenReturn(getValidItem());
    ItemResponse response = itemService.getById(1L);
    assertEquals(response.getId().longValue(), 1L);
    assertEquals(response.getCountry(), "CO");
  }

  @Test
  public void update() {
    when(categoryRepository.findById(any())).thenReturn(getValidOptionalCategory());
    when(currencyRepository.findByShortName(any())).thenReturn(getValidListOptionalCurrency());
    when(countryRepository.findByShortName(any())).thenReturn(getValidListOptionalCountry());
    when(itemRepository.save(any())).thenReturn(getValidItem().get());
    when(itemRepository.findById(any())).thenReturn(getValidItem());
    ItemResponse response = itemService.update(getValidItemRequest(), 1L);
    assertEquals(response.getId().longValue(), 1L);
    assertEquals(response.getCountry(), "CO");
  }

  @Test
  public void delete() {
    when(itemRepository.findById(any())).thenReturn(getValidItem());
    doNothing().when(itemRepository).delete(any());

    Boolean response = itemService.delete(1L);
    assertTrue(response);

  }


}
