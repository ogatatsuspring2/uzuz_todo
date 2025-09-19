package uzuz_todo.form;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;



@Data
public class TaskData {
  
  private Integer taskId;
  
  @NotBlank( message = "件名を入力してください" )
  private String title;
  
  @NotBlank( message = "説明を入力してください" )
  private String description;
  
  @NotBlank( message = "期限を指定してください" )
  @DateTimeFormat( pattern = "yyyy-MM-dd" ) 
  private String dueDate;
  
  @NotNull( message = "優先度を指定してください" )
  @Min( value = 1, message = "優先度を1〜3で指定してください" )
  @Max( value = 3, message = "優先度を1〜3で指定してください" )
  private Integer priority;
  
  @NotBlank
  private String status;
  
  @NotNull
  @Min( value = 1, message = "担当者を指定してください" )
  private Integer userId;
  
  @NotBlank
  private String userName;
  
}
