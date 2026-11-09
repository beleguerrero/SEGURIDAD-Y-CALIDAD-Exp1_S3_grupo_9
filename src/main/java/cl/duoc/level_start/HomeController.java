package cl.duoc.level_start;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class HomeController {
    
    @GetMapping("/")
    public String root(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/home")
    public String home(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }

    @GetMapping("/login")
    public String login(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "login";
    }

    @GetMapping("/registro")
    public String registro(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "registro";
    }

    @GetMapping("/eventos-privados")
    public String eventos_privados(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "eventos_privados";
    }

    @GetMapping("/403")
    public String forbidden(@RequestParam(name="name", required=false, defaultValue="Level Start") String name, Model model) {
        model.addAttribute("name", name);
        return "403";
    }
}
