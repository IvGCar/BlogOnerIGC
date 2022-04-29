package com.sciodev.blogoner.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table (name = "comments")
public class Comment implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String content;
    @Column (name = "post_id")
    private Long postId;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}

    public Long getPostId(){return postId;}
    public void setPostId(Long postId){this.postId=postId;}
}
