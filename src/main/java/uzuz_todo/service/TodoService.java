package uzuz_todo.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import uzuz_todo.form.TodoData;


public interface TodoService {
    
  List<TodoData> readAll();
  TodoData read( int task_id );
  boolean create( TodoData todoData, BindingResult result );
  boolean update( TodoData todoData, BindingResult result );
  boolean delete( TodoData todoData );

}
