package uzuz_todo.support;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import uzuz_todo.entity.Todo;
import uzuz_todo.form.TodoData;

@Service
public class TodoUtils {
  
  public Todo Form2Entity( TodoData todoData ) {
    Todo todo = new Todo();
    todo.setTaskId( todoData.getTaskId() );
    todo.setTitle( todoData.getTitle() );
    todo.setDescription( todoData.getDescription() );
    System.out.println( todoData.getDueDate() );
    LocalDate localDate = LocalDate.parse( todoData.getDueDate(), DateTimeFormatter.ofPattern( "yyyy-MM-dd" ) );
    todo.setDueDate( localDate.atStartOfDay() );
    todo.setPriority( todoData.getPriority() );
    todo.setStatus( todoData.getStatus() );
    todo.setUserId( todoData.getUserId() );
    return todo;
  }
  
  public TodoData Entity2Form( Todo todo ) {
    TodoData todoData = new TodoData();
    todoData.setTaskId( todo.getTaskId() );
    todoData.setTitle( todo.getTitle() );
    todoData.setDescription( todo.getDescription() );
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    todoData.setDueDate( todo.getDueDate().format( formatter ) );
    todoData.setPriority( todo.getPriority() );
    todoData.setStatus( todo.getStatus() );
    todoData.setUserId( todo.getUserId() );
    return todoData;
  }

}
