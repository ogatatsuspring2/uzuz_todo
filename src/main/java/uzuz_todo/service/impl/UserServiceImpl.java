package uzuz_todo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import uzuz_todo.entity.User;
import uzuz_todo.form.UserData;
import uzuz_todo.repository.UserRepository;
import uzuz_todo.service.UserService;
import uzuz_todo.support.UserUtils;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  private final UserUtils userUtils;
  
  public UserServiceImpl( UserRepository userRepository,
    UserUtils userUtils ) {
    
    this.userRepository = userRepository;
    this.userUtils = userUtils;
    
  }

  
  
  @Override
  public UserData read( int user_id ) {
    return userUtils.Entity2Form( userRepository.findById( user_id ).get() );
  }

  @Override
  public List<UserData> readAll() {
    List<User> users = userRepository.findAll( Sort.by( Sort.Direction.ASC, "userId" ) );
    List<UserData> userList = new ArrayList<UserData>();
    for ( User user: users ) {
      userList.add( userUtils.Entity2Form( user ) );
    }
    return userList;
  }

  @Override
  public boolean create(UserData userData, BindingResult result) {
    if ( !result.hasErrors() ) {
      User user = userUtils.Form2Entity( userData );
      userRepository.saveAndFlush( user );
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean update(UserData userData, BindingResult result) {
    if ( !result.hasErrors() ) {
      User user = userUtils.Form2Entity( userData );
      userRepository.saveAndFlush( user );
      return true;
    } else {
      return false;
    }
  }

  
  
  @Override
  public boolean delete(UserData userData) {
    User user = userUtils.Form2Entity( userData );
    userRepository.deleteById( user.getUserId() );
    return true;
  }

}
