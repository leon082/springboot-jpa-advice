package com.technical.test.app.service;

public interface IService<R, T> {
  public T getById(Long id);

  public T save(R obj);

  public T update(R obj, Long id);

  public Boolean delete(Long id);

}
