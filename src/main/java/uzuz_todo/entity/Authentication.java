package uzuz_todo.entity;

import lombok.Data;

@Data
public class Authentication {
  
  private String username;
  private String password;
  private String role;

}
