import java.util.ArrayList;

import javax.swing.JFrame;

import gla.cs.joose.workshop.birdsim1.*;
import gla.cs.joose.workshop.birdsim1.view.*;

public class Main extends JFrame {

	public static void main(String[] args) {
		JFrame main = new Main();
		HatchEggListener egg = new HatchEggListener();
		FeedBirdsListener fb = new FeedBirdsListener();
		ScareBirdsListener scare = new ScareBirdsListener();
		StarveBirdsListener starve = new StarveBirdsListener();
		ArrayList<BoardListener> listeners = new ArrayList<>();
		listeners.add(egg);
		listeners.add(fb);
		listeners.add(scare);
		listeners.add(starve);
		Board board = new Board(50, 50, listeners);
//		MoveBehaviour birdMove = new BirdBehaviour(board);
//		MoveBehaviour grainMove = new GrainMovingBehaviour(board);
//		board.setBirdBehaviour(birdMove);
//		board.setGrainBehaviour(grainMove);
		board.initBoard(main);
	}

}
