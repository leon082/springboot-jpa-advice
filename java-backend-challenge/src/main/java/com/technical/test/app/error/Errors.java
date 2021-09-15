package com.technical.test.app.error;

import lombok.Getter;

@Getter
public enum Errors {

  ITEM_NOT_FOUND_ERROR("4000", "Item not found"),
  CATEGORY_NOT_FOUND_ERROR("4002", "Category not found"),
  CURRENCY_NOT_FOUND_ERROR("4003", "Currency not found"),
  COUNTRY_NOT_FOUND_ERROR("4003", "Country not found"),
  INTERNAL_SERVER_ERROR("4001", "An error has happened, please try later or contact an administrator");


  private String code;
  private String message;

  Errors(String code, String message) {
    this.code = code;
    this.message = message;
  }
}
