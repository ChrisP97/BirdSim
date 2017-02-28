package gla.joose.birdsim.behaviours;

import gla.joose.birdsim.boards.Board;

public interface MoveBehaviour {
	Board board = null;
	void move();
}