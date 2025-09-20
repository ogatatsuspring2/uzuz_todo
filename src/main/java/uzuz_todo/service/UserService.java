package uzuz_todo.service;

import java.util.List;

import org.springframework.validation.BindingResult;

import uzuz_todo.form.UserData;


public interface UserService {
  
  List<UserData> readAll();
  UserData read( int user_id );
  boolean create( UserData userData, BindingResult result );
  boolean update( UserData userData, BindingResult result );
  boolean delete( UserData userData );

}
