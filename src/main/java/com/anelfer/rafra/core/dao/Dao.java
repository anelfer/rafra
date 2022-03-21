package com.anelfer.rafra.core.dao;

import java.util.List;

public abstract class Dao<T> {

    public abstract T get(int id);

    public abstract List<T> getAll();

    public abstract void add(T t);

}
