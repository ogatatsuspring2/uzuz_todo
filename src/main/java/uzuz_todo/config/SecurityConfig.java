package uzuz_todo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;
  
  public SecurityConfig( UserDetailsService userDetailsService, PasswordEncoder passwordEncoder ) {
    this.userDetailsService = userDetailsService;
    this.passwordEncoder = passwordEncoder;
  }
  
  
  
  @Bean
  public SecurityFilterChain filterChain( HttpSecurity http ) throws Exception {
    
    http
      .authorizeHttpRequests( authz -> authz
        .requestMatchers( "/login" ).permitAll()
        .anyRequest().authenticated() )
      .formLogin( loginForm -> loginForm
        .loginPage( "/login" )
        .loginProcessingUrl( "/authentication" )
        .usernameParameter( "username" )
        .passwordParameter( "password" )
        .defaultSuccessUrl( "/" )
        .failureUrl( "/login?error" ) )
      .logout( logout -> logout
        .logoutUrl( "/logout" )
        .logoutSuccessUrl( "/login?logout" )
        .invalidateHttpSession( true )
        .deleteCookies( "JSESSIONID" ) );
          
    return http.build();
    
  }

}
