package uzuz_todo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Data
public class UserData {
  
  private Integer userId;
  
  @NotBlank( message = "ユーザ名を入力してくださ" )
  private String userName;
  
  @NotNull( message = "年齢を入力してください" )
  private Integer age;
  
  @NotBlank( message = "パスワードを入力してくださ" )
  private String password;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
  private String createdAt;
  
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") 
  private String updatedAt;
  
}
