package uzuz_todo.support;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Service;

import uzuz_todo.entity.Task;
import uzuz_todo.form.TaskData;

@Service
public class TaskUtils {
    
  public TaskData Entity2Form( Task task ) {
    TaskData taskData = new TaskData();
    taskData.setTaskId( task.getTaskId() );
    taskData.setTitle( task.getTitle() );
    taskData.setDescription( task.getDescription() );
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
    taskData.setDueDate( task.getDueDate().format( formatter ) );
    taskData.setPriority( task.getPriority() );
    taskData.setStatus( task.getStatus() );
    taskData.setUserId( task.getUserId() );
    taskData.setUserName( task.getUserName() );
    taskData.setRole( task.getRole() );
    taskData.setDel( task.getDel() );
    return taskData;
  }

}
