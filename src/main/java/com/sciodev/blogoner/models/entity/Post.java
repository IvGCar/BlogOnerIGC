package com.sciodev.blogoner.models.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table (name = "posts")
public class Post implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String content;
    @NotEmpty
    @Column (name = "user_name")
    private String userName;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}

    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}

    public String getUserName(){return userName;}
    public void setUserName(String user){this.userName=user;}

}
