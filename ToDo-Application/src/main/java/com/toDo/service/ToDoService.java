package com.toDo.service;

import java.lang.foreign.SymbolLookup;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.toDo.model.ToDO;
import com.toDo.repo.IToDoRepo;

import jakarta.validation.Valid;
import lombok.Getter;

@Service
@Component
public class ToDoService {
	
	@Autowired
	IToDoRepo repo;
    public List<ToDO> getAllToDoItems()
    {
    	ArrayList<ToDO> todolist = new ArrayList<ToDO>();
    	repo.findAll().forEach(todo -> todolist.add(todo));
    	
		return todolist;
    	
    }
    public ToDO getTodoItemById( Long id) {
    	
    	
		return repo.findById(id).get();
    	
    }
    
    public boolean updateStatue(Long id) {
    	
    	ToDO todo = getTodoItemById(id);
    	todo.setStatus("Completed");
    	return saveOrUpdateToDoItem(todo);//todo arge requried
    }
    
    public boolean saveOrUpdateToDoItem(ToDO todo) {
    	
    	ToDO updatedObj = repo.save(todo);
    	if(getTodoItemById(updatedObj.getId())!= null)
    	{
    		return true;
    	}
    	return false;
    }
    
    public boolean deleteToDoItem(Long id)
    {
    	
    	if(getTodoItemById(id)!= null)
    	{
    		repo.deleteById(id);
    		return true;
    	}
    	return false;
    }
    
	

}
