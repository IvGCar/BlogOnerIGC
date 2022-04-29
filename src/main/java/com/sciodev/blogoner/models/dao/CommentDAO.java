package com.sciodev.blogoner.models.dao;

import com.sciodev.blogoner.models.entity.Comment;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository("CommentDAOJPA")
public class CommentDAO implements ICommentDAO{
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional(readOnly = true)
    @Override
    public List<Comment> findAll()
    {
        return entityManager.createQuery("from Comment").getResultList();
    }
    @Transactional
    @Override
    public Comment findOne(Long id) {
        return entityManager.find(Comment.class, id);
    }
    @Transactional
    @Override
    public void save(Comment comment) {
        entityManager.persist(comment);
    }
    @Transactional
    @Override
    public void update(Comment comment) {
        entityManager.merge(comment);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        entityManager.remove(findOne(id));
        entityManager.flush();
        entityManager.clear();
    }
}
