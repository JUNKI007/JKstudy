package com.example.test20230717.todos.repository;

import com.example.test20230717.todos.entity.Todos;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface TodosRepository extends JpaRepository<Todos, Long> {

        Page<Todos> findByContentContainingAndIsDone(String content, String isDone, Pageable pageable);
        Page<Todos> findByContentContaining(String content, Pageable pageable);


}
