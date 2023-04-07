package lab1;


import lombok.Setter;

@Setter
public class Hero {
    private MoveType moveType;
    private Point currentCoordinates;

    public Hero(MoveType moveType) {
        this.moveType = moveType;
        this.currentCoordinates = new Point();
    }

    public void move(Point movePoint) {
        if (movePoint == null) {
            return;
        }

        moveType.move(currentCoordinates, movePoint);
    }

    public void showCurrentCoordinates() {
        System.out.println("Координаты по x: " + currentCoordinates.getX());
        System.out.println("Координаты по y: " + currentCoordinates.getY());
    }
}
