package gla.cs.joose.workshop.birdsim1;

import java.util.Random;

import gla.cs.joose.workshop.birdsim1.Grain;

public class GrainMovingBehaviour implements MoveBehaviour {
	static Random rand = new Random();
	Board board;
	Grain grain;
	
	public GrainMovingBehaviour(Board board){
		this.board = board;
	}
	
    public void move() {
        int randRowf = rand.nextInt(board.getRows() - 2);
        int randColf= rand.nextInt(board.getColumns() - 2);
        grain.moveTo(randRowf, randColf);
        grain.setSpeed(10);
    }

	public void setScareBirds(boolean boo) {
	}

	public void setBirdToBehaviour(Bird bird) {
	}

	public void setGrainToBehaviour(Grain grain) {
		this.grain = grain;
	}
	
}
