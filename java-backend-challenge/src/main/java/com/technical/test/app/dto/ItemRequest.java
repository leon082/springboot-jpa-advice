package com.technical.test.app.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemRequest {

  private String title;
  private BigDecimal price;
  private String currency;
  private String country;
  @JsonProperty("category_id")
  private Long categoryId;


}
