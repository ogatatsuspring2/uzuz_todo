package uzuz_todo.form;

import lombok.Data;



@Data
public class TaskData {
  private Integer taskId;
  private String title;
  private String description;
  private String dueDate;
  private Integer priority;
  private String status;
  private Integer userId;
  private String userName;
  private String role;
  private String del;
}
