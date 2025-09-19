package uzuz_todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uzuz_todo.entity.Task;
import uzuz_todo.form.TaskData;
import uzuz_todo.repository.TaskRepository;
import uzuz_todo.service.TaskService;
import uzuz_todo.support.TaskUtils;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
  
  private final TaskRepository taskRepository;
  private final TaskUtils taskUtils;
  
  public TaskServiceImpl(
    TaskRepository taskRepository,
    TaskUtils taskUtils ) {
    
    this.taskRepository = taskRepository;
    this.taskUtils = taskUtils;
  
  }
  
 
  
  @Override
  public List<TaskData> readAll() {
    List<Task> tasks = taskRepository.findAll( Sort.by( Sort.Direction.ASC, "taskId" ) );
    List<TaskData> taskList = new ArrayList<TaskData>();
    for ( Task task: tasks ) {
      taskList.add( taskUtils.Entity2Form( task ) );
    }
    return taskList;
  }

}
