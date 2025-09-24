package uzuz_todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import uzuz_todo.entity.Todo;
import uzuz_todo.form.TodoData;
import uzuz_todo.repository.TodoRepository;
import uzuz_todo.service.TodoService;
import uzuz_todo.support.TodoUtils;

@Service
@Transactional
public class TodoServiceImpl implements TodoService {
  
  private final TodoRepository todoRepository;
  private final TodoUtils todoUtils;
  
  public TodoServiceImpl(
    TodoRepository todoRepository,
    TodoUtils todoUtils ) {
    
    this.todoRepository = todoRepository;
    this.todoUtils = todoUtils;
  
  }
  
 
  
  @Override
  public TodoData read( int task_id ) {
    return todoUtils.Entity2Form( todoRepository.findById( task_id ).get() );
  }

  @Override
  public List<TodoData> readAll() {
    List<Todo> todos = todoRepository.findAll( Sort.by( Sort.Direction.ASC, "taskId" ) );
    List<TodoData> todoList = new ArrayList<TodoData>();
    for ( Todo todo: todos ) {
      todoList.add( todoUtils.Entity2Form( todo ) );
    }
    return todoList;
  }

  
  
  @Override
  public boolean create( TodoData todoData, BindingResult result ) {
    if ( !result.hasErrors() ) {
      Todo todo = todoUtils.Form2Entity( todoData );
      todoRepository.saveAndFlush( todo );
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean update( TodoData todoData, BindingResult result ) {
    if ( !result.hasErrors() ) {
      Todo todo = todoUtils.Form2Entity( todoData );
      todoRepository.saveAndFlush( todo );
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean delete( TodoData todoData ) {
    Todo todo = todoUtils.Form2Entity( todoData );
    todoRepository.deleteById( todo.getTaskId() );
    return true;
  }

}
