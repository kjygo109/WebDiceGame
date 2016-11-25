package hansung.jaeyoung.webdicegame.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hansung.jaeyoung.webdicegame.Service.DicegameService;

@Controller
public class HomeController {
	@Autowired
	DicegameService dicegameService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(HttpServletRequest request, Model model) {
		
		dicegameService.init();
		dicegameService.make_cells();
		return "home";
	}
	
}
