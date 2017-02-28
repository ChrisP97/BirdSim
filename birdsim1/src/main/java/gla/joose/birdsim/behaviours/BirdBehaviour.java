package gla.joose.birdsim.behaviours;

import java.util.Random;

import gla.joose.birdsim.boards.Board;
import gla.joose.birdsim.pieces.Bird;
import gla.joose.birdsim.pieces.Grain;
import gla.joose.birdsim.pieces.Piece;
import gla.joose.birdsim.util.Distance;
import gla.joose.birdsim.util.DistanceMgr;

public class BirdBehaviour implements MoveBehaviour {
	
	public void move() {
		
		static Random rand = new Random();
		
		DistanceMgr dmgr = new DistanceMgr();
		int current_row = bird.getRow();
		int current_col = bird.getColumn();
		int randRow = rand.nextInt(board.getRows() - 2);
    	int randCol = rand.nextInt(board.getColumns() - 2);    	
		place(bird, randRow, randCol);
		bird.setDraggable(false);
		bird.setSpeed(20);
		board.updateStockDisplay();
		
		while(true){
			synchronized(board.allPieces){
				for (int i=0;i< board.getAllPieces().size(); i++) {
	                Piece piece = board.getAllPieces().get(i);
	                int dist_from_food_row = current_row - piece.getRow();
		            int dist_from_food_col = piece.getColumn() - current_col;
		            Distance d = null;
					d = new Distance(bird, (Grain)piece, dist_from_food_row, dist_from_food_col);
		            dmgr.addDistance(d);
	            }
			}
		}
			
		Distance distances[] = dmgr.getDistances();
		boolean movedone = false;

		for(int i =0; i< distances.length;i++){
			Distance d = distances[i];
				
			if(d.getRowDist() <= d.getColDist()){
					
				if(d.getRowDist() >0){
					boolean can_move_down= bird.canMoveTo(current_row-1, current_col);
		    		if(can_move_down){
						bird.moveTo(current_row-1, current_col);
						movedone = true;
						break;
					}
				}
				else if(d.getRowDist() < 0){
					boolean can_move_down= bird.canMoveTo(current_row+1, current_col);
		    		if(can_move_down){
						bird.moveTo(current_row+1, current_col);
						movedone = true;
						break;
					}
				}
				else if(d.getRowDist() ==0){
					if(d.getColDist() >0){
						boolean can_move_right = bird.canMoveTo(current_row, current_col+1);
						if(can_move_right){
							bird.moveTo(current_row, current_col+1);
							movedone = true;
							break;
						}
					}
					else if(d.getColDist()< 0){
						boolean can_move_left = bird.canMoveTo(current_row, current_col-1);
						if(can_move_left){
							bird.moveTo(current_row, current_col-1);
							movedone = true;
							break;
						}
					}
					else if(d.getColDist() ==0){
						//bingo -food found (eat and move away)
						Grain grain = (Grain)d.getTargetpiece();
						grain.deplete();
                        GrainMovingBehaviour.move(grain);
		            	bird.moveTo(randRow, randCol);
		        		bird.setSpeed(20);
						movedone = true;
						break;
					}
						
				}
			}
			else if(d.getRowDist() > d.getColDist()){
            	
				if(d.getColDist() >0){
					boolean can_move_right = bird.canMoveTo(current_row, current_col+1);
					if(can_move_right){
						bird.moveTo(current_row, current_col+1);
						movedone = true;
						break;
					}
				}
				else if(d.getColDist()<0){
					boolean can_move_left = bird.canMoveTo(current_row, current_col-1);
					if(can_move_left){
						bird.moveTo(current_row, current_col-1);
						movedone = true;
						break;
					}
				}
				else if(d.getColDist() == 0){
					if(d.getRowDist() >0){
						boolean can_move_up= bird.canMoveTo(current_row-1, current_col);
				   		if(can_move_up){
							bird.moveTo(current_row-1, current_col);
							movedone = true;
							break;
						}
						
					}
					else if(d.getRowDist() < 0){
						boolean can_move_down = bird.canMoveTo(current_row+1, current_col);
				   		if(can_move_down){
							bird.moveTo(current_row+1, current_col);
							movedone = true;
							break;
						} 
					}
					else if(d.getRowDist() ==0){
						//bingo -food found (eat and move away)
						Grain grain = (Grain)d.getTargetpiece();
						grain.deplete();
                        GrainMovingBehaviour.move(grain);
			           	bird.moveTo(randRow, randCol);
			       		bird.setSpeed(20);
						movedone = true;
						break;
					}
				}
			}
		}
		if(!movedone){ 
           	bird.moveTo(randRow, randCol);
		}
	}
	bird.remove();
	board.updateStockDisplay();
	
}