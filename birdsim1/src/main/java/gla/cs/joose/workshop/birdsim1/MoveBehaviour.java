package gla.cs.joose.workshop.birdsim1;


public interface MoveBehaviour {
	
	public void move();
	public void setScareBirds(boolean boo);
	public void setBirdToBehaviour(Bird bird);
	public void setGrainToBehaviour(Grain grain);
}