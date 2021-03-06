package com.anelfer.rafra;

import com.anelfer.rafra.core.dao.CommentDao;
import com.anelfer.rafra.core.dao.PostDao;
import com.anelfer.rafra.core.dao.UserDao;
import com.anelfer.rafra.core.dao.mocking.MockingCommentDao;
import com.anelfer.rafra.core.dao.mocking.MockingPostDao;
import com.anelfer.rafra.core.dao.mocking.MockingUserDao;
import com.anelfer.rafra.user.SessionStorage;

public class AppConfig {

    public static final PostDao postDao = new MockingPostDao();
    public static final CommentDao commentDao = new MockingCommentDao();
    public static final UserDao userDao = new MockingUserDao();
    public static final SessionStorage sessionStorage = new SessionStorage();

}
