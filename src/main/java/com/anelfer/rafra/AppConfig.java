package com.anelfer.rafra;

import com.anelfer.rafra.core.dao.CommentDao;
import com.anelfer.rafra.core.dao.PostDao;
import com.anelfer.rafra.core.dao.mocking.MockingCommentDao;
import com.anelfer.rafra.core.dao.mocking.MockingPostDao;

public class AppConfig {

    public static final PostDao postDao = new MockingPostDao();
    public static final CommentDao commentDao = new MockingCommentDao();

}
