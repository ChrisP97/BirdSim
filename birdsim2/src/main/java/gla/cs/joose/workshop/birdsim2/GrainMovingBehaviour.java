package gla.cs.joose.workshop.birdsim2;

import java.util.Random;

import gla.cs.joose.workshop.birdsim2.Grain;

public class GrainMovingBehaviour implements MoveBehaviour {
	static Random rand = new Random();
	Board board;
	Grain grain;
	
	public GrainMovingBehaviour(Board board, Grain grain){
		this.grain = grain;
		this.board = board;
	}
	
    public void move() {
        int randRowf = rand.nextInt(board.getRows() - 2);
        int randColf= rand.nextInt(board.getColumns() - 2);
        if(board != null && board.getDisplay() != null){
        	grain.moveTo(randRowf, randColf);
        	board.notifyObservers();
        }
        grain.setSpeed(10);
        if (grain.getRemaining() <= 0.0f && board != null){
        	grain.remove();
        	board.deleteObserver(grain);
        	
        }
    }

	public void setScareBirds(boolean boo) {
	}

	public void setBirdToBehaviour(Bird bird) {
	}

	public void setGrainToBehaviour(Grain grain) {
		this.grain = grain;
	}
	
}
