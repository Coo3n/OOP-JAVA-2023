package lab1;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Point {
    private int x;
    private int y;

    public void sumCoordinationPoints(Point otherPoint) {
        x += otherPoint.x;
        y += otherPoint.y;
    }
}
