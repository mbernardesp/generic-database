package com.leucotron.database.model.dao;

import java.util.List;

/**
 *
 * @param <T>
 */
public interface IGenericDao<T> {

    public void create(T object);

    public T read(T object);

    public List<T> readAll(T object);

    public T update(T object);

    public void delete(T object);
}