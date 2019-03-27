
import eci.cosw.data.TodoRepository;
import eci.cosw.data.model.Todo;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class UserTest {

    @Autowired
    TodoRepository todoRepository;

    @Before
    public void init() {
        todoRepository.deleteAll();
        todoRepository.save(new Todo("Finish COSW 3th lab", 7, "9/03/2019", "martin@eci.com", "Pending"));
        todoRepository.save(new Todo("Finish COSW 4th lab", 4, "16/03/2019", "martin@eci.com", "Pending"));
        todoRepository.save(new Todo("Finish COSW 3th lab", 8, "28/03/2019", "juan@eci.com", "Completed"));
    }

    @Test
    public void itShouldListAllTheTodosFoundByResponsible() {
        List<Todo> TodoList = todoRepository.findByResponsible("martin@eci.com");
        System.out.println(TodoList.get(0).getDescription());
        assertEquals(3, TodoList.size());
    }

}
