package uzuz_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uzuz_todo.entity.User;



public interface UserRepository extends JpaRepository<User,Integer> {
  
  User findByUserName( String userName );
  
}
