package com.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.assignment.entity.Comment;
import com.assignment.entity.User;
import com.assignment.service.CommentService;
import com.assignment.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public String addComment(
        @RequestParam("commentFrom") String commentFrom,
        @RequestParam("commentTo") String commentTo,
        @RequestParam("message") String message
    ) {
        User fromUser = userService.getUserByCommentFrom(commentFrom);
        User toUser = userService.getUserByCommentTo(commentTo);

        if (fromUser == null || toUser == null) {
            return "Invalid user(s). Comment not added.";
        }

        Comment comment = new Comment();
        comment.setPostedByUser(fromUser);
        comment.setMessage(message);

        commentService.createComment(comment);
        
        return "Comment added successfully.";
    }

    @GetMapping("/get")
    public List<Comment> getComments(
        @RequestParam("commentTo") String commentTo
    ) {
        User user = userService.getUserByCommentTo(commentTo);
        if (user == null) {
            // Handle the case where the user is not found
            return null;
        }

        return commentService.getCommentsByUser(user);
    }
}
