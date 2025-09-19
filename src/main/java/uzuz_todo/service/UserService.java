package uzuz_todo.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import uzuz_todo.entity.User;
import uzuz_todo.form.UserData;


public interface UserService {
  
  List<User> readAll();
  User read( int user_id );
  boolean create( UserData userData, BindingResult result );
  boolean update( UserData userData, BindingResult result );
  boolean delete( UserData userData );

}
