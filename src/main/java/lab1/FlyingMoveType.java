package lab1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FlyingMoveType implements MoveType {
    @Override
    public void move(Point currentCoordinationPoint, Point movePoint) {
        currentCoordinationPoint.sumCoordinationPoints(movePoint);
        Logger.getLogger("MyLogger").log(Level.INFO, "FlyingMoveType");
    }
}
