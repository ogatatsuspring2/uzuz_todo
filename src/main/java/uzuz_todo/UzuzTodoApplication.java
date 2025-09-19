package uzuz_todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uzuz_todo.repository.TodoRepository;
import uzuz_todo.repository.UserRepository;
import uzuz_todo.service.TodoService;
import uzuz_todo.service.UserService;

@SpringBootApplication
public class UzuzTodoApplication implements CommandLineRunner {
  
  private final UserRepository userRepository;
  private final TodoRepository todoRepository;
  private final UserService userService;
  private final TodoService todoService;
  
  public UzuzTodoApplication(
    UserRepository userRepository,
    TodoRepository todoRepository,
    UserService userService,
    TodoService todoService ) {
    
    this.userRepository = userRepository;
    this.todoRepository = todoRepository;
    this.userService = userService;
    this.todoService = todoService;
  }

  
  
  
	public static void main(String[] args) {
		SpringApplication.run(UzuzTodoApplication.class, args);
	}
	
	@Override
	public void run( String... args ) {
	  System.out.println( "****************" );
	  System.out.println( userRepository.findAll() );
	  System.out.println( todoRepository.findAll() );
	  System.out.println( "****************" );
	  System.out.println( userService.readAll() );
	  System.out.println( todoService.readAll() );
	  System.out.println( "****************" );
	  return;
	}
	
}
