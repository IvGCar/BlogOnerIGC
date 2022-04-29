package com.sciodev.blogoner.models.dao;

import com.sciodev.blogoner.models.entity.Post;

import java.util.List;

public interface IPostDAO {
    public List<Post> findAll();
    public Post findOne(Long id);
    public void save(Post post);
    public void update(Post post);
    public void delete(Long id);
}
