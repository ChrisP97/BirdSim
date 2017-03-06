package gla.cs.joose.workshop.birdsim1;

import java.util.Random;

public class GrainStaticBehaviour implements MoveBehaviour{
	
	
	Board board;
	Grain grain;
	public GrainStaticBehaviour(Board board, Grain grain){
		this.board = board;
		this.grain = grain;
	}
	
    public void move(){
    	if(grain.getRemaining() != 1.0f){
        	grain.remove();
    	}
    }

	public void setScareBirds(boolean boo) {
		// TODO Auto-generated method stub
		
	}

	public void setBirdToBehaviour(Bird bird) {
		// TODO Auto-generated method stub
		
	}

	public void setGrainToBehaviour(Grain grain) {
		// TODO Auto-generated method stub
		
	}
	
}
