package com.udeceduca.DAO;

import java.util.List;

public interface DAO<T, K> {
    T save(T entity);
    T update(T entity);
    void persist(T entity);
    void remove(T entity);
    T findById(K id);
    List<T> findAll();
}
