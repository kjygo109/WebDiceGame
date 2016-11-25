package hansung.jaeyoung.webdicegame.Controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public String Result(HttpServletRequest request, Model model){
		
		return "result";
	}
}
