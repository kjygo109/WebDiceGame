package hansung.jaeyoung.webdicegame.dto;

import org.springframework.stereotype.Component;

@Component
public class Dice {
	public int roll() {
		return (int) (Math.random() * 6 + 1);
	}

}
