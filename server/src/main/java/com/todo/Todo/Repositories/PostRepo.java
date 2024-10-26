package com.todo.Todo.Repositories;


import com.todo.Todo.Entitiy.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepo extends JpaRepository<PostEntity, Long > {
}
