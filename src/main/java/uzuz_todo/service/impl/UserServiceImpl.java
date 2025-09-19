package uzuz_todo.service.impl;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import uzuz_todo.entity.User;
import uzuz_todo.form.UserData;
import uzuz_todo.repository.UserRepository;
import uzuz_todo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  
  private final UserRepository userRepository;
  
  public UserServiceImpl( UserRepository userRepository ) {
    this.userRepository = userRepository;
  }

  
  
  @Override
  public User read( int user_id ) {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

  @Override
  public List<User> readAll() {
    return userRepository.findAll( Sort.by( Sort.Direction.ASC, "userId" ) );
  }

  @Override
  public boolean create(UserData todoData, BindingResult result) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

  @Override
  public boolean update(UserData todoData, BindingResult result) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

  @Override
  public boolean delete(UserData todoData) {
    // TODO 自動生成されたメソッド・スタブ
    return false;
  }

}
