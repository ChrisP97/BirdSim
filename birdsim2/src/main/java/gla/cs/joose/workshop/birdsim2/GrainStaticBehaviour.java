package gla.cs.joose.workshop.birdsim2;

public class GrainStaticBehaviour implements MoveBehaviour {

	Board board;
	Grain grain;

	public GrainStaticBehaviour(Board board, Grain grain) {
		this.board = board;
		this.grain = grain;
	}

	public void move() {
		if (grain.getRemaining() != 1.0f) {
			grain.remove();
		}
	}

	public void setScareBirds(boolean boo) {

	}

	public void setBirdToBehaviour(Bird bird) {

	}

	public void setGrainToBehaviour(Grain grain) {

	}

}
