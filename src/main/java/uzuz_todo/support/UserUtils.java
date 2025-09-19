package uzuz_todo.support;

import org.springframework.stereotype.Service;

import uzuz_todo.entity.User;
import uzuz_todo.form.UserData;

@Service
public class UserUtils {
  
  public User Form2Entity( UserData userData ) {
    User user = new User();
    user.setUserId( userData.getUserId() );
    user.setUserName( userData.getUserName() );
    user.setAge( userData.getAge() );
    user.setPassword( userData.getPassword() );
    return user;
    
  }
  
  public UserData Entity2Form( User user ) {
    UserData userData = new UserData();
    userData.setUserId( user.getUserId() );
    userData.setUserName( user.getUserName() );
    userData.setAge( user.getAge() );
    userData.setPassword( user.getPassword() );
    return userData;
  }

}
