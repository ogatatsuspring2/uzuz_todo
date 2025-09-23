package uzuz_todo.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
  
  private String createdAt;
  
  private String updatedAt;
  
  @NotBlank( message = "権限を入力してください" )
  private String role;
  
  @NotBlank
  private String del;
  
}
