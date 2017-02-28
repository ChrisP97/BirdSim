package gla.joose.birdsim.behaviours;

import gla.joose.birdsim.pieces.Grain;

public class GrainMovingBehaviour {
	
	public GrainMovingBehaviour{
		
	}
	
    public static void move(Grain grain) {
        int randRowf = rand.nextInt(getRows() - 2);
        int randColf= rand.nextInt(getColumns() - 2);
        grain.moveTo(randRowf, randColf);
        grain.setSpeed(10);
    }
	
}
