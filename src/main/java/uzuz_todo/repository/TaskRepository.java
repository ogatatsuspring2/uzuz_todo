package uzuz_todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uzuz_todo.entity.Task;



public interface TaskRepository extends JpaRepository<Task,Integer> {
}
