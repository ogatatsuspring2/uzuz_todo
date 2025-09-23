package uzuz_todo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table( name = "view_task" )
@Data
public class Task {
  
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  @Column( name = "task_id" )
  private Integer taskId;
  
  @Column( name = "title" )
  private String title;
  
  @Column( name = "description" )
  private String description;
  
  @Column( name = "due_date" )
  private LocalDateTime dueDate;
  
  @Column( name = "priority" )
  private Integer priority;
  
  @Column( name = "status" )
  private String status;
  
  @Column( name = "user_id" )
  private Integer userId;
  
  @Column( name = "user_name" )
  private String userName;
  
  @Column( name = "role" )
  private String role;
  
  @Column( name = "del" )
  private String del;
    
}
