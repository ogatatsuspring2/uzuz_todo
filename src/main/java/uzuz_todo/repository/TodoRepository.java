package uzuz_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uzuz_todo.entity.Todo;



public interface TodoRepository extends JpaRepository<Todo,Integer> {
}
