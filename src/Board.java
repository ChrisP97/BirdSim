import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by LeftClick on 2/20/2017.
 */
public class Board extends Observable{
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
                panelHasBeenResized  = true;
            }
        });
    }

    public initBoard(){

    }
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
}
