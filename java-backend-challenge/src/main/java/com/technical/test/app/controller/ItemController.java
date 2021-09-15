package com.technical.test.app.controller;

import com.technical.test.app.dto.ItemRequest;
import com.technical.test.app.dto.ItemResponse;
import com.technical.test.app.service.IService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class ItemController {

  private IService<ItemRequest, ItemResponse> service;

  public ItemController(IService service) {
    this.service = service;
  }

  @GetMapping("/item/{id}")
  public ItemResponse getItemDtoById(@PathVariable("id") Long id) {
    return service.getById(id);
  }


  @PostMapping("/item")
  public ItemResponse saveItem(@RequestBody ItemRequest item) {
    return service.save(item);
  }

  @PutMapping("/item/{id}")
  public ItemResponse updateItem(@RequestBody ItemRequest item, @PathVariable Long id) {
    return service.update(item, id);
  }

  @DeleteMapping("/item/{id}")
  public Boolean deleteItem(@PathVariable Long id) {
    return service.delete(id);
  }

}
