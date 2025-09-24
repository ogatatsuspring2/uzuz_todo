package uzuz_todo.repository;

import org.apache.ibatis.annotations.Mapper;

import uzuz_todo.entity.Authentication;

@Mapper
public interface AuthenticationMapper {
  
  Authentication selectByUsername( String username );

}
