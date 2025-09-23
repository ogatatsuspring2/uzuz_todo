package uzuz_todo.controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uzuz_todo.form.TaskData;
import uzuz_todo.form.TodoData;
import uzuz_todo.form.UserData;
import uzuz_todo.service.TaskService;
import uzuz_todo.service.TodoService;
import uzuz_todo.service.UserService;


@Controller
public class TodoController {
  
  
  
  private final TaskService taskService;
  private final TodoService todoService;
  private final UserService userService;
  private final HttpSession session;
  
  
  
  public TodoController( 
      TaskService taskService,
      TodoService todoService,
      UserService userService,
      HttpSession session ) {
    
    this.taskService = taskService;
    this.todoService = todoService;
    this.userService = userService;
    this.session = session;
    
  }
  
  
  
  @GetMapping( "/" )
  public String showMenu() {
    return "menu";
  }
  
  
  @GetMapping( "/todo" )
  public String showTodoList( Model model ) {
    List<TaskData> taskList = taskService.readAll();
    model.addAttribute( "taskList", taskList );
    return "taskList";
  }
  
  
  
  @GetMapping( "/todo/{task_id}" )
  public String showTodo( @PathVariable( name = "task_id" ) int taskId, Model model ) {
    TodoData todoData = todoService.read( taskId );
    model.addAttribute( "todoData", todoData );
    List<UserData> users = userService.readAll();
    model.addAttribute( "users", users );
    session.setAttribute( "mode", "update" );
    return "todoForm";
    
  }
  
  
  
  @GetMapping( "/todo/create" )
  public String createTodo( Model model ) {
    model.addAttribute( "todoData", new TodoData() );
    List<UserData> users = userService.readAll();
    model.addAttribute( "users", users );
    session.setAttribute( "mode", "create" );
    return "todoForm";
  }
  
  
  
  @PostMapping( "/todo/create" )
  public String createTodo( 
    @ModelAttribute @Validated TodoData todoData,
    BindingResult result,
    Model model ) {
    
    if ( todoService.create( todoData, result ) ) {
      return "redirect:/todo";
    } else {
      List<UserData> users = userService.readAll();
      model.addAttribute( "users", users );
      return "todoForm";
    }
    
  }
  
  
  
  @PostMapping( "/todo/cancel" )
  public String cancelTodo() {
    return "redirect:/todo";
  }
  
  
  
  @PostMapping( "/todo/update" )
  public String updateTodo( 
    @ModelAttribute @Validated TodoData todoData,
    BindingResult result,
    Model model ) {
    
    if ( todoService.update( todoData, result ) ) {
      return "redirect:/todo";
    } else {
      return "todoForm";
    }
  }
  
  
  
  @PostMapping( "/todo/delete" )
  public String deleteTodo( @ModelAttribute @Validated TodoData todoData ) {
    
    if ( todoData.getUserId() == null ) {
      todoData.setUserId( 0 );
    }
    if ( todoService.delete( todoData ) ) {
      return "redirect:/todo";
    } else {
      return "todoForm";
    }
  }
  
  
  
  
  
  
  @GetMapping( "/user" )
  public String showUserList( Model model ) {
    List<UserData> userList = userService.readAll();
    model.addAttribute( "userList", userList );
    return "userList";
  }
  
  
  
  @GetMapping( "/user/{user_id}" )
  public String showUser( @PathVariable( name = "user_id" ) int userId, Model model ) {
    UserData userData = userService.read( userId );
    model.addAttribute( "userData", userData );
    session.setAttribute( "mode", "update" );
    return "userForm";    
  }
  
  
  
  @GetMapping( "/user/create" )
  public String createUser( Model model ) {
    model.addAttribute( "userData", new UserData() );
    session.setAttribute( "mode", "create" );
    return "userForm";
  }
  
  
  
  @PostMapping( "/user/create" )
  public String createUser( 
    @ModelAttribute @Validated UserData userData,
    BindingResult result,
    Model model ) {
    
    if ( userService.create( userData, result ) ) {
      return "redirect:/user";
    } else {
      return "userForm";
    }
    
  }
  
  
  
  @PostMapping( "/user/cancel" )
  public String cancelUser() {
    return "redirect:/user";
  }
  
  
  
  @PostMapping( "/user/update" )
  public String updateUser( 
    @ModelAttribute @Validated UserData userData,
    BindingResult result,
    Model model ) {
    
    System.out.println( userData );
    
    if ( userService.update( userData, result ) ) {
      return "redirect:/user";
    } else {
      return "userForm";
    }
  }
  
  
  
}
