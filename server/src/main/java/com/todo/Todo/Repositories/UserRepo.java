package com.todo.Todo.Repositories;


import com.todo.Todo.Entitiy.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserEntity,Long> {

}
