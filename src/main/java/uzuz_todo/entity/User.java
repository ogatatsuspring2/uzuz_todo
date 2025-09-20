package uzuz_todo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table( name = "user" )
@Data
public class User {
  
  @Id
  @GeneratedValue( strategy = GenerationType.IDENTITY )
  @Column( name = "user_id" )
  private Integer userId;
  
  @Column( name = "user_name" )
  private String userName;;
  
  @Column( name = "age" )
  private Integer age;
  
  @Column( name = "password" )
  private String password;
  
  @Column( name = "created_at", updatable = false )
  private LocalDateTime createdAt;
  
  @Column( name = "updated_at" )
  private LocalDateTime updatedAt;
  
  
  
  @PrePersist
  public void onPrePersist() {
      this.createdAt = LocalDateTime.now();
      this.updatedAt = LocalDateTime.now();
  }

  @PreUpdate
  public void onPreUpdate() {
      this.updatedAt = LocalDateTime.now();
  }

}
