package com.example.demo.Controller;


import com.example.demo.Comment.Comment;
import com.example.demo.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/comments")
public class IndexController {


    private final IndexService indexService;

    @Autowired
    public IndexController(IndexService indexService) {
        this.indexService = indexService;
    }

    @GetMapping("/list")
    public String listComments(Model model) {
        List<Comment> comments = indexService.findAllComments();
        model.addAttribute("comments", comments);
        return "comments/list";
    }

    @GetMapping("/new")
    public String newCommentForm(Model model) {
        model.addAttribute("comment", new Comment());
        return "comments/new";
    }

    @PostMapping("/save")
    public String saveComment(@ModelAttribute("comment") Comment comment) {
        indexService.saveComment(comment);
        return "redirect:/comments/list";
    }

    @GetMapping("/edit/{id}")
    public String editCommentForm(@PathVariable Long id, Model model) {
        Comment comment = indexService.findCommentById(id);
        model.addAttribute("comment", comment);
        return "comments/edit";
    }

    @GetMapping("/delete/{id}")
    public String deleteComment(@PathVariable Long id) {
        indexService.deleteComment(id);
        return "redirect:/comments/list";
    }




}

