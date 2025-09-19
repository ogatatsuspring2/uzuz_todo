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

import uzuz_todo.entity.User;
import uzuz_todo.form.TaskData;
import uzuz_todo.form.TodoData;
import uzuz_todo.service.TaskService;
import uzuz_todo.service.TodoService;
import uzuz_todo.service.UserService;
import uzuz_todo.support.TodoUtils;


@Controller
public class TodoController {
  
  
  
  private final TaskService taskService;
  private final TodoService todoService;
  private final UserService userService;
  private final TodoUtils todoUtils;
  private final HttpSession session;
  
  
  
  public TodoController( 
      TaskService taskService,
      TodoService todoService,
      UserService userService,
      TodoUtils todoUtils,
      HttpSession session ) {
    
    this.taskService = taskService;
    this.todoService = todoService;
    this.userService = userService;
    this.todoUtils = todoUtils;
    this.session = session;
    
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
    System.out.println( todoData );
    model.addAttribute( "todoData", todoData );
    List<User> users = userService.readAll();
    model.addAttribute( "users", users );
    session.setAttribute( "mode", "update" );
    return "todoForm";
    
  }
  
  
  
  @GetMapping( "/todo/create" )
  public String createTodo( Model model ) {
    model.addAttribute( "todoData", new TodoData() );
    List<User> users = userService.readAll();
    model.addAttribute( "users", users );
    session.setAttribute( "mode", "create" );
    return "todoForm";
  }
  
  
  
  @PostMapping( "/todo/create" )
  public String createTodo( 
    @ModelAttribute @Validated TodoData todoData,
    BindingResult result,
    Model model ) {
    
    System.out.println( todoData );
    
    if ( todoService.create( todoData, result ) ) {
      return "redirect:/todo";
    } else {
      List<User> users = userService.readAll();
      model.addAttribute( "users", users );
      return "todoForm";
    }
    
  }
  
  
  
  @PostMapping( "/todo/cancel" )
  public String cancel() {
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
    
    if ( todoService.delete( todoData ) ) {
      return "redirect:/todo";
    } else {
      return "todoForm";
    }
  }
  
}
