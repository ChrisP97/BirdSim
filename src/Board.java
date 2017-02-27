import java.util.*;

public class Board extends Observable{

    private int rows;
    private int columns;
    protected Vector<Piece> allPieces = new Vector<Piece>();
	//Redundant as Grain does not need to be aware of Birds
	public void registerBirdObserver(Observer){
        for (int i=0;i< getAllPieces().size(); i++) {
            Piece piece = getAllPieces().get(i);
            if (piece instanceof Grain) {
                piece.update();
            }
        }
    }
	
    public void registerGrainObserver(Observer){
        for (int i=0;i< getAllPieces().size(); i++) {
            Piece piece = getAllPieces().get(i);
            if (piece instanceof Bird) {
                piece.update();
            }
        }
    }
	
    public void removeBirdObserver(){

    }
	
    public void removeGrainObserver(){

    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public int getRows(){
        return rows;
    }

    public int getColumns(){
        return columns;
    }

    public Vector<Piece> getAllPieces(){
        synchronized (allPieces){
            return allPieces;
        }
    }
	/**
     * Creates a board with the given number of rows and columns. This
     * board is a Swing <code>JPanel</code> and may be used wherever a
     * <code>JPanel</code> may be used.
     * 
     * @param rows
     *        Desired number of rows.
     * @param columns
     *        Desired number of columns.
     */

    @SuppressWarnings("rawtypes")
	public Board(int rows, int columns) {
    	rand = new Random();
        display = new DisplayPanel();
        this.rows = rows;
        this.columns = columns;
        thisBoard = this;
        board = new Vector[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = new Vector(1);
            }
        }
        display.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = yToRow(e.getY());
                int column = xToColumn(e.getX());
                selectedSquare = new int[] { row, column };
                setChanged();
                notifyObservers(selectedSquare);
            }
        });        
        display.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent arg0) {
                panelHasBeenResized = true;
            }
        });
    }
	
	/**
     * Configures a board with specific set of behaviour;
     * must be implemented by a subclass.
     * 
     * @param frame The JFrame on which the board will be created.
     */
    public abstract void initBoard(JFrame frame);
	
	/**
     * Notifies the board frame on changes in the number of birds/grains;
     * must be implemented by a subclass.
     * 
     */
    public abstract void updateStockDisplay();
	
	/**
     * Creates a new bird and tells it to move. 
     * 
     */
	public void hatchEgg(){
		Bird bird = new Bird();
        Thread thread = new Thread(bird);
        int randRow = rand.nextInt((Board.getRows() - 3) + 1) + 0;
        int randCol = rand.nextInt((Board.getColumns() - 3) + 1) + 0;
        place(bird,randRow, randCol);
        bird.setDraggable(false);
        bird.setSpeed(20);
        board.updateStockDisplay();
        BirdBehaviour.move(bird);
        thread.start();
	}

	public void feedBirds(){

    }
	
	/**
     * updates the number of birds and grains on the board.
     */
	public void updateStock(){
		synchronized(allPieces){
			noofbirds = 0;
			noofgrains = 0;
			for (int i=0;i< getAllPieces().size(); i++) {
                Piece piece = getAllPieces().get(i);
                if(piece instanceof Grain){
                	noofgrains = noofgrains +1;
                }
                else if(piece instanceof Bird){
                	noofbirds = noofbirds +1;
                }
			}
			
		}
	}

}
