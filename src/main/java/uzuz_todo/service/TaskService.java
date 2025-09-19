package uzuz_todo.service;

import java.util.List;

import uzuz_todo.form.TaskData;


public interface TaskService {
    
  List<TaskData> readAll();

}
