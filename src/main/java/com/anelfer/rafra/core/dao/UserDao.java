package com.anelfer.rafra.core.dao;

import com.anelfer.rafra.core.model.UserModel;

public abstract class UserDao extends Dao<UserModel> {

    public abstract UserModel getByLogin(String login);

    public abstract boolean containsUser(String login);

}
