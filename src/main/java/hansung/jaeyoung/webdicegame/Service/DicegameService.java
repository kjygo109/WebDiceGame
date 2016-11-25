package hansung.jaeyoung.webdicegame.Service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import hansung.jaeyoung.webdicegame.dto.Dice;
import hansung.jaeyoung.webdicegame.dto.WinningStatus;


@Service
public class DicegameService {
	@Resource(name="userDice")
	Dice userDice;
	
	@Resource(name="alphaDice")
	Dice alphaDice;
	
	private int faceValue1;
	private int faceValue2;
	private int[] cell;
	
	private int curCell1;
	private int curCell2;
	
	final private int Goal=29;

	public void init(){
		faceValue1=faceValue2=curCell1=curCell2=0;
		cell = new int[30];
		
		for (int i=0; i<30; i++) cell[i]=i;
	}
	
	public Dice getUserDice() {
		return userDice;
	}

	public void setUserDice(Dice userDice) {
		this.userDice = userDice;
	}

	public Dice getAlphaDice() {
		return alphaDice;
	}

	public void setAlphaDice(Dice alphaDice) {
		this.alphaDice = alphaDice;
	}

	public int getFaceValue1() {
		return faceValue1;
	}

	public void setFaceValue1(int faceValue1) {
		this.faceValue1 = faceValue1;
	}

	public int getFaceValue2() {
		return faceValue2;
	}

	public void setFaceValue2(int faceValue2) {
		this.faceValue2 = faceValue2;
	}

	public int[] getCell() {
		return cell;
	}

	public void setCell(int[] cell) {
		this.cell = cell;
	}

	public int getCurCell1() {
		return curCell1;
	}

	public void setCurCell1(int curCell1) {
		this.curCell1 = curCell1;
	}

	public int getCurCell2() {
		return curCell2;
	}

	public void setCurCell2(int curCell2) {
		this.curCell2 = curCell2;
	}

	public void make_cells() {
		cell[10]=0;
		cell[28]=0;
		cell[8]=3;
		cell[15]=5;
		cell[21]=12;
		cell[25]=17;
		cell[11]=20;
		cell[26]=27;
		cell[9]=14;
		cell[16]=22;
	}
	public void random_cells(){
		init();
		
		for(int i=1;i<30;i++){
			cell[i]=(int)(Math.random() * 30 + 1);
			System.out.println("cell[" + i +"]" + "=" +cell[i] );
		}
	
	}
	public WinningStatus roll(){
		faceValue1 = userDice.roll();
		faceValue2 = alphaDice.roll();
		
		curCell1 += faceValue1;
		curCell2 += faceValue2;
	
		if (curCell1 >=Goal && curCell2>=Goal) return WinningStatus.Draw;
		else if (curCell1 >=Goal && curCell2<Goal) return WinningStatus.Player;
		else if (curCell1 <Goal && curCell2>=Goal) return WinningStatus.AlphaDice;
		else {
			if (curCell1 != cell[curCell1]) curCell1 = cell[curCell1];
			if (curCell2 != cell[curCell2]) curCell2 = cell[curCell2];
			return WinningStatus.NotYet;
		}
	}

}
