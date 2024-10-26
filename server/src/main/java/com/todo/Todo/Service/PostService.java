package com.todo.Todo.Service;


import com.todo.Todo.Entitiy.PostEntity;
import com.todo.Todo.Repositories.PostRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    public final PostRepo postrepo;


    public PostEntity createPost(PostEntity post){
        post.setCreatedAt(LocalDateTime.now().toString());
        return postrepo.save(post);
    }

    public PostEntity updatePost(PostEntity post , Long id){
         PostEntity findPost = postrepo.findById(id)
                 .orElseThrow(() -> new RuntimeException("post not found with id: " + id));

        findPost.setTitle(post.getTitle());
        findPost.setContent(post.getContent());
        findPost.setLastUpdated(LocalDateTime.now().toString());

        return findPost;
    }

    public void deletePost( Long id){
        PostEntity findPost = postrepo.findById(id)
                .orElseThrow(() -> new RuntimeException("post not found with id: " + id));

        postrepo.deleteById(id);

    }

    public List<PostEntity> getAllPost(){
        return postrepo.findAll();
    }




}
