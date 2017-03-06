package gla.cs.joose.workshop.birdsim2;

import java.util.Random;

import gla.cs.joose.workshop.birdsim2.Board;
import gla.cs.joose.workshop.birdsim2.Bird;
import gla.cs.joose.workshop.birdsim2.Grain;
import gla.cs.joose.workshop.birdsim2.Piece;
import gla.cs.joose.workshop.birdsim2.util.Distance;
import gla.cs.joose.workshop.birdsim2.util.DistanceMgr;

public class BirdBehaviour implements MoveBehaviour {
	Bird bird;
	Board board;
	static Random rand = new Random();
	boolean scareBirds = false;

	public BirdBehaviour(Board board, Bird bird) {
		this.board = board;
		this.bird = bird;
	}

	public void setBirdToBehaviour(Bird bird) {
		this.bird = bird;
	}

	public void move() {
		// while(true){
		// bird.moveTo(10, 10);
		// bird.redraw();
		// board.notifyObservers();

		// board.place(bird, randRow, randCol);
		bird.setDraggable(false);
		bird.setSpeed(20);
		board.updateStockDisplay();

		while (!scareBirds) {

			DistanceMgr dmgr = new DistanceMgr();
			int current_row = bird.getRow();
			int current_col = bird.getColumn();
			int randRow = rand.nextInt(board.getRows() - 2);
			int randCol = rand.nextInt(board.getColumns() - 2);

			synchronized (board.allPieces) {
				for (int i = 0; i < board.getAllPieces().size(); i++) {
					Piece piece = board.getAllPieces().get(i);
					if (piece instanceof Grain) {
						int dist_from_food_row = current_row - piece.getRow();
						int dist_from_food_col = piece.getColumn() - current_col;
						Distance d = null;
						d = new Distance(bird, (Grain) piece, dist_from_food_row, dist_from_food_col);
						dmgr.addDistance(d);
					}
				}
			}

			Distance distances[] = dmgr.getDistances();
			boolean movedone = false;

			for (int i = 0; i < distances.length; i++) {
				Distance d = distances[i];

				if (d.getRowDist() <= d.getColDist()) {

					if (d.getRowDist() > 0) {
						boolean can_move_down = bird.canMoveTo(current_row - 1, current_col);
						if (can_move_down) {
							bird.moveTo(current_row - 1, current_col);
							movedone = true;
							break;
						}
					} else if (d.getRowDist() < 0) {
						boolean can_move_down = bird.canMoveTo(current_row + 1, current_col);
						if (can_move_down) {
							bird.moveTo(current_row + 1, current_col);
							movedone = true;
							break;
						}
					} else if (d.getRowDist() == 0) {
						if (d.getColDist() > 0) {
							boolean can_move_right = bird.canMoveTo(current_row, current_col + 1);
							if (can_move_right) {
								bird.moveTo(current_row, current_col + 1);
								movedone = true;
								break;
							}
						} else if (d.getColDist() < 0) {
							boolean can_move_left = bird.canMoveTo(current_row, current_col - 1);
							if (can_move_left) {
								bird.moveTo(current_row, current_col - 1);
								movedone = true;
								break;
							}
						} else if (d.getColDist() == 0) {
							// bingo -food found (eat and move away)
							Random random = new Random();
							Grain grain = (Grain) d.getTargetpiece();
							if (grain.getBoard() != null) {
								grain.escape();
							}
							// grain.deplete();
							// grain.getBehaviour().move();
							if (random.nextInt(2) + 1 == 1) {
								board.hatchEgg(current_row, current_col);
							}
							bird.moveTo(randRow, randCol);
							bird.setSpeed(20);
							movedone = true;
							break;
						}

					}
				} else if (d.getRowDist() > d.getColDist()) {

					if (d.getColDist() > 0) {
						boolean can_move_right = bird.canMoveTo(current_row, current_col + 1);
						if (can_move_right) {
							bird.moveTo(current_row, current_col + 1);
							movedone = true;
							break;
						}
					} else if (d.getColDist() < 0) {
						boolean can_move_left = bird.canMoveTo(current_row, current_col - 1);
						if (can_move_left) {
							bird.moveTo(current_row, current_col - 1);
							movedone = true;
							break;
						}
					} else if (d.getColDist() == 0) {
						if (d.getRowDist() > 0) {
							boolean can_move_up = bird.canMoveTo(current_row - 1, current_col);
							if (can_move_up) {
								bird.moveTo(current_row - 1, current_col);
								movedone = true;
								break;
							}

						} else if (d.getRowDist() < 0) {
							boolean can_move_down = bird.canMoveTo(current_row + 1, current_col);
							if (can_move_down) {
								bird.moveTo(current_row + 1, current_col);
								movedone = true;
								break;
							}
						} else if (d.getRowDist() == 0) {
							// bingo -food found (eat and move away)
							Random random = new Random();
							Grain grain = (Grain) d.getTargetpiece();
							if(grain.getBoard() != null){
								grain.escape();
							}
							
							// grain.deplete();
							// grain.getBehaviour().move();
							if (random.nextInt(2) + 1 == 1) {
								board.hatchEgg(current_row, current_col);
							}
							bird.moveTo(randRow, randCol);
							bird.setSpeed(20);
							movedone = true;
							break;
						}
					}
				}
			}
			if (!movedone) {
				bird.moveTo(randRow, randCol);
				// movedone = true;
			}
		}
		bird.remove();
		board.updateStockDisplay();
		board.getDisplay().repaint();
	}

	public void setScareBirds(boolean boo) {
		scareBirds = boo;
	}

	public void setGrainToBehaviour(Grain grain) {

	}

}
