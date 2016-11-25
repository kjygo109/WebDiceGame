package hansung.jaeyoung.webdicegame.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hansung.jaeyoung.webdicegame.Service.DicegameService;
import hansung.jaeyoung.webdicegame.Service.ScoreService;
import hansung.jaeyoung.webdicegame.dto.Scores;
import hansung.jaeyoung.webdicegame.dto.WinningStatus;


@Controller
public class PlayController {
	String username;
	Scores score;
	
	@Autowired
	DicegameService dicegameService;
	
	@Autowired
	ScoreService scoreService;
	

	@RequestMapping(value = "/play", method = RequestMethod.POST)
	public String play(HttpServletRequest request, Model model) throws Exception{
	
		

		username=(String)request.getParameter("username");
		score = scoreService.initScore(username);
		model.addAttribute("username",username);
		return "play";
	}
	
	@RequestMapping(value = "/roll", method = RequestMethod.POST)
	public String roll(HttpServletRequest request, Model model) throws Exception{
		
		WinningStatus ws = dicegameService.roll();
		String winner;
		
		if(ws.equals(WinningStatus.NotYet)){
			model.addAttribute("username",username);
			model.addAttribute("faceValue1", dicegameService.getFaceValue1());
			model.addAttribute("faceValue2", dicegameService.getFaceValue2());
			model.addAttribute("curCell1", dicegameService.getCurCell1());
			model.addAttribute("curCell2", dicegameService.getCurCell2());
			return "play";
		}
		
		else if(ws.equals(WinningStatus.AlphaDice)){
			scoreService.updateScore(score.setLose(score.getLose() + 1));
			winner = "AlphaDice";
			model.addAttribute("winner",winner);
			
			return "result";
			
		}else if(ws.equals(WinningStatus.Draw)){
			scoreService.updateScore(score.setDraw(score.getDraw() + 1));
			winner = "draw";
			model.addAttribute("winner",winner);
			
			return "result";
			
		}else{
			scoreService.updateScore(score.setWin(score.getWin() + 1));
			winner = username;
			model.addAttribute("winner",winner);
			
			return "result";
		}
			
	}
	
	
	
	@RequestMapping(value = "/random", method = RequestMethod.POST)
	public String random(HttpServletRequest request, Model model){
		dicegameService.random_cells();
	
		return "home";
	}

}
