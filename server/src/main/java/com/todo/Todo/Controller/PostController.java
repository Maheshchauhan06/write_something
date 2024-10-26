package com.todo.Todo.Controller;

import com.todo.Todo.Entitiy.PostEntity;
import com.todo.Todo.Service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Get all posts
    @GetMapping("/get-all-posts")
    public ResponseEntity<List<PostEntity>> getAllPosts() {
        return new ResponseEntity<>(postService.getAllPost(), HttpStatus.OK);
    }

    // Create a new post
    @PostMapping("/create")
    public ResponseEntity<PostEntity> createPost(@RequestBody PostEntity post) {
        return new ResponseEntity<>(postService.createPost(post), HttpStatus.CREATED);
    }

    // Update an existing post by ID
    @PutMapping("/update/{id}")
    public ResponseEntity<PostEntity> updatePost(@RequestBody PostEntity post, @PathVariable Long id) {
        return new ResponseEntity<>(postService.updatePost(post, id), HttpStatus.OK);
    }

    // Delete a post by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
