package com.sciodev.blogoner.controllers;

import com.sciodev.blogoner.models.dao.IPostDAO;
import com.sciodev.blogoner.models.dao.ICommentDAO;
import com.sciodev.blogoner.models.entity.Post;
import com.sciodev.blogoner.models.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class PostController {
    @Autowired
    @Qualifier("PostDAOJPA")
    private IPostDAO postDAO;
    @Autowired
    @Qualifier("CommentDAOJPA")
    private ICommentDAO commentDAO;

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String listPosts(Model postModel, Model commentModel) {
        postModel.addAttribute("title", "Posts List");
        postModel.addAttribute("posts", postDAO.findAll());
        commentModel.addAttribute("comments", commentDAO.findAll());

        return "post-page";
    }

    @RequestMapping(value = "/deletepost/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id") Long id) {
        if(id>0){
            postDAO.delete(id);
        }
        return "redirect:/posts";
    }
    @RequestMapping(value = "/newpost/{id}")
    public String edit(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        if(id>0){
            Post post = postDAO.findOne(id);
            model.put("post", post);
            model.put("title", "Edit Post");
            return "new-post";
        }
        else {
            return "redirect:/posts";
        }
    }
    @RequestMapping(value = "/newpost")
    public String create(Map<String, Object> model) {
        Post post = new Post();
        model.put("post", post);
        model.put("title", "New Post");
        return "new-post";
    }
    @RequestMapping(value = {"/newpost", "/newpost/{id}"}, method = RequestMethod.POST)
    public String update(Post post, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("title", "UserForm");
            return "form";
        }
        try{
            postDAO.update(post);
        }catch (Exception e){
            postDAO.save(post);
        }
        return "redirect:posts";
    }

    @RequestMapping(value = "/editcomment/{id}")
    public String editComment(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        if(id>0){
            Comment comment = commentDAO.findOne(id);
            model.put("comment", comment);
            model.put("title", "Edit Comment");
            return "comment";
        }
        else {
            return "redirect:/posts";
        }
    }
    @RequestMapping(value = "/addcomment/{id}")
    public String addComment(@PathVariable(value = "id") Long id, Map<String, Object> model) {
        if(id>0){
            Comment comment = new Comment();
            comment.setPostId(id);
            model.put("comment", comment);
            model.put("title", "Add Comment");
            return "comment";
        }
        else {
            return "redirect:/posts";
        }
    }
    @RequestMapping(value = {"/addcomment", "/editcomment"}, method = RequestMethod.POST)
    public String updateComment(@Valid Comment comment, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("title", "Comment");
            return "comment";
        }
        try{
            commentDAO.save(comment);
        }catch (Exception e){
            commentDAO.update(comment);
        }
        return "redirect:posts";
    }
    @RequestMapping(value = "/deletecomment/{id}", method = RequestMethod.GET)
    public String deleteComment(@PathVariable(value = "id") Long id) {
        if(id>0){
            commentDAO.delete(id);
        }
        return "redirect:/posts";
    }
}
