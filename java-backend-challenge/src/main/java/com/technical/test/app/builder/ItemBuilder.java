package com.technical.test.app.builder;

import com.technical.test.app.dto.ItemRequest;
import com.technical.test.app.dto.ItemResponse;
import com.technical.test.app.model.Category;
import com.technical.test.app.model.Country;
import com.technical.test.app.model.Currency;
import com.technical.test.app.model.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemBuilder {

  public static Item buildItemFromItemRequest(ItemRequest request, Category category, Country country, Currency currency) {
    Item item = new Item();
    item.setCategory(category);
    item.setCountry(country);
    item.setCurrency(currency);
    item.setPrice(request.getPrice());
    item.setTitle(request.getTitle());
    return item;
  }

  public static ItemResponse buildItemResponseFromItem(Item item) {
    ItemResponse itemResponse = new ItemResponse();
    itemResponse.setCategoryId(item.getCategory().getId());
    itemResponse.setCountry(item.getCountry().getShortName());
    itemResponse.setCurrency(item.getCurrency().getShortName());
    itemResponse.setPrice(item.getPrice());
    itemResponse.setTitle(item.getTitle());
    itemResponse.setId(item.getId());
    return itemResponse;
  }

}
