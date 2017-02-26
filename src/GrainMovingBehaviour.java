
public class GrainMovingBehaviour {
	
    public void move(Grain grain) {
        int randRowf = rand.nextInt((getRows() - 3) + 1) + 0;
        int randColf= rand.nextInt((getColumns() - 3) + 1) + 0;
        grain.moveTo(randRowf, randColf);
        grain.setSpeed(10);
    }
	
}
