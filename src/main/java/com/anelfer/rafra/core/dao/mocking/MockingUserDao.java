package com.anelfer.rafra.core.dao.mocking;

import com.anelfer.rafra.core.dao.UserDao;
import com.anelfer.rafra.core.model.UserModel;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class MockingUserDao extends UserDao {

    private final List<UserModel> users = new ArrayList<>();

    public MockingUserDao() {
        try {
            String pass = "admin";
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(pass.getBytes());
            byte[] digest = md5.digest();
            String s = DatatypeConverter.printHexBinary(digest).toUpperCase(Locale.ROOT);
            users.add(new UserModel("admin", "admin@admin.ru", s));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserModel get(int id) {
        return users.stream().filter(u -> u.getId() == id).collect(Collectors.toList()).get(0);
    }

    @Override
    public List<UserModel> getAll() {
        return users;
    }

    @Override
    public void add(UserModel userModel) {
        users.add(userModel);
    }

    @Override
    public UserModel getByLogin(String login) {
        return users.stream().filter(u -> u.getName().equals(login)).collect(Collectors.toList()).get(0);
    }

    @Override
    public boolean containsUser(String login) {
        for (UserModel user : users) {
            if (user.getName().equals(login)) return true;
        }
        return false;
    }
}
