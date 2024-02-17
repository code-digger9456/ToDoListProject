package com.toDo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.toDo.model.ToDO;

@Repository
public interface IToDoRepo extends JpaRepository<ToDO, Long> {

}
