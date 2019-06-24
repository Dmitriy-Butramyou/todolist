package by.butramyou.todolist;

import by.butramyou.todolist.domain.Task;
import by.butramyou.todolist.repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.crypto.Data;
import java.util.Map;

@Controller
public class GreetingController {

    @Autowired
    private TaskRepo taskRepo;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

    @GetMapping()
    public String index(Map<String, Object> model) {
        Iterable<Task> tasks = taskRepo.findAll();
        model.put("tasks", tasks);
        return "index";
    }

    @GetMapping("/addTask")
    public String add() {
        return "addTask";
    }

    @PostMapping("/addTask")
    public String add(@RequestParam String textTask, @RequestParam String deadline) {

        Task task = new Task(textTask, deadline);
        taskRepo.save(task);
        return "addTask";
    }

}
