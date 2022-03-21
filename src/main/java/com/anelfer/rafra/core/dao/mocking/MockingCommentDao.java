package com.anelfer.rafra.core.dao.mocking;

import com.anelfer.rafra.core.dao.CommentDao;
import com.anelfer.rafra.core.model.CommentModel;

import java.util.List;

public class MockingCommentDao extends CommentDao {

    @Override
    public CommentModel get(int id) {
        return null;
    }

    @Override
    public List<CommentModel> getAll() {
        return null;
    }

    @Override
    public void add(CommentModel comment) {

    }

}
