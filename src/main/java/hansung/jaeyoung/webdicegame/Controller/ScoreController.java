package hansung.jaeyoung.webdicegame.Controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hansung.jaeyoung.webdicegame.Service.ScoreService;
import hansung.jaeyoung.webdicegame.dto.Scores;

@Controller
public class ScoreController {

	@Autowired
	ScoreService scoreService;
	
	@RequestMapping(value = "/score", method = RequestMethod.POST)
	public String Score(Model model) throws Exception{
		List<Scores> scores = scoreService.scoreView();

		model.addAttribute("scores", scores);

		return "score";
	}
}
