package asteroids;

import java.awt.*;

public class Bullet {
    double x = 500, y = 500, rot = 0;

    boolean grave = false;

    public Bullet(double x, double y, double rot){
        this.x = x;
        this.y = y;
        this.rot = rot;
    }

    public void draw(Graphics g, double tick){

        g.setColor(Color.WHITE);

        point rotated = new point(0, 10);
        rotated.rotate(rot);

        g.drawLine((int) x, (int) y, (int) x - (int) rotated.x, (int) y - (int) rotated.y);

        x -= rotated.x * tick;
        y -= rotated.y * tick;

        if(x < 0 || x > 500 || y < 0 || y > 500)
            grave = true;
    }
}
