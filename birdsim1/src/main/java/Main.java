import java.util.ArrayList;

import javax.swing.JFrame;

import gla.cs.joose.workshop.birdsim1.*;
import gla.cs.joose.workshop.birdsim1.view.*;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
		board.initBoard(main);
	}

}
