package Spring.Classes;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Controller
public class WebController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/result").setViewName("result");
    }

    @GetMapping("/")
    public String showForm(InputForm inputForm) {
        return "form";
    }


    @PostMapping("/")
    public String checkPersonInfo(@Valid InputForm inputForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
        	return "form";
        }
        return "redirect:/result";
    }
    
    @GetMapping("/result")
    public String showProjectForm(ProjectForm projectForm) {
    	return "result";
    }
  
    
    @PostMapping("/result")
    public String checkProjectInfo(@Valid ProjectForm projectForm,BindingResult projectResult,Model model) {
    
    		ExecuteShellCommand obj = new ExecuteShellCommand();
			String path=projectForm.getpath();
			System.out.println(path);
			//String output1=obj.executeCommand(path);
			//System.out.println(output1);
			String cmd=projectForm.getcmd();
			System.out.println(cmd);
			
			String output = obj.executeCommand(cmd);
			System.out.println(output);
			model.addAttribute("output", output);
			return "greeting";
	    		
    }
}