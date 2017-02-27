
public class BirdBehaviour implements MoveBehaviour {
	
	public void move(Bird bird, Board board) {

			DistanceMgr dmgr = new DistanceMgr();
			int current_row = board.getRows();
			int current_col = board.getColumns();

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

			for(int i =0; i< distances.length; i++){
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
			            	bird.moveTo(randRow1, randCol2);
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
			            	bird.moveTo(randRow1, randCol2);
			        		bird.setSpeed(20);
							movedone = true;
							break;
						}
					}
				}
			}
			if(!movedone){
				int randRow1 = rand.nextInt((getRows() - 3) + 1) + 0;
            	int randCol2 = rand.nextInt((getColumns() - 3) + 1) + 0; 
            	bird.moveTo(randRow1, randCol2);
			}
		}
		bird.remove();
		board.updateStockDisplay();
		
}