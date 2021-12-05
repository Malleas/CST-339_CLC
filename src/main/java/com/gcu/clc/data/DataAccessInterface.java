package com.gcu.clc.data;

import java.util.List;

public interface DataAccessInterface <T>{
    public List<T> getAll();
    public T getById(int id);
    public boolean create(T t);
    public boolean update(T t);
    public boolean delete(int id);
}
