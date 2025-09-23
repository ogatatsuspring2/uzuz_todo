package uzuz_todo.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import uzuz_todo.entity.LoginUser;

@Service
public class LoginUserDetailsServiceImpl implements UserDetailsService {
  
/*
  private final AuthenticationMapper authenticationMapper;
  
  public LoginUserDetailsServiceImpl( AuthenticationMapper authenticationMapper ) {
    this.authenticationMapper = authenticationMapper;
  }
*/
  
  @Override
  public UserDetails loadUserByUsername( String username ) 
    throws UsernameNotFoundException {
    

    if ( username.equals( "ogawa" ) ) {
      return new LoginUser( "ogawa", "pass", Collections.emptyList() );
    } else {
      throw new UsernameNotFoundException( username + " => 指定ユーザは存在しません" );
    }

    
/*
    Authentication authentication = authenticationMapper.selectByUsername( username );
    System.out.println( "authentication => " + authentication );
    
    if ( authentication != null ) {
      return new LoginUser( authentication.getUsername(),
        authentication.getPassword(),
        getAuthorityList( authentication.getRole() ) );
//        Collections.emptyList() );
    } else {
      throw new UsernameNotFoundException( username + " => 指定したユーザは存在しません" );
    }
*/
    
  }
  
  private List<GrantedAuthority> getAuthorityList( String role ) {
    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    authorities.add( new SimpleGrantedAuthority( role ) );
    if ( role.equals( "A" ) ) {
      authorities.add( new SimpleGrantedAuthority( "U" ) );
    }
    return authorities;
  }
  
}
