package kg.megacom.validation;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class WebController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/results").setViewName("results");
    }

//    @GetMapping("/results")
//    public String showResults(PersonForm personForm) {
//        return "results";
//    }

    @GetMapping("/")
    public String showForm(PersonForm personForm, Model model) {
        PersonForm user = new PersonForm();
        model.addAttribute("user", user);
        List<String> professionList = Arrays.asList("Developer", "Designer","IT Analyst","IT Director","Java Developer");
        model.addAttribute("professionList", professionList);
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid PersonForm personForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Date.class,
                new DateEditor());
    }
    //@InitBinder определяется в контроллере, помогает контролировать и форматировать каждый поступающий к
    // нему запрос. Эта аннотация используется с методами, которые инициализируют WebDataBinder и работают
    // как препроцессор для каждого запроса, поступающего на контроллер.
}
