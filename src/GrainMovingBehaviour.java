/**
 * Created by LeftClick on 2/20/2017.
 */
public class GrainMovingBehaviour {
    public void move(Grain grain) {

        int randRowf = rand.nextInt((getRows() - 3) + 1) + 0;
        int randColf= rand.nextInt((getColumns() - 3) + 1) + 0;
        grain.moveTo(randRowf, randColf);
        grain.setSpeed(10);

        if (starveBirdspressed) {
            grain.remove();
            updateStockDisplay();
        } else if (grain.getRemaining() <= 0) {
            grain.remove();
            updateStockDisplay();
        }

    }
}
