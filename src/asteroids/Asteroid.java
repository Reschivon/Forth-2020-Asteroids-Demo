package asteroids;

import java.awt.*;

public class Asteroid {
    double x = 500, y = 500, rot = 0;

    double x_drift = (Math.random()-0.5);
    double y_drift = (Math.random()-0.5);

    int width = 30;

    boolean grave = false;

    public Asteroid(){
        this.x = Math.random() * 500;
        this.y = Math.random() * 500;
        this.rot = rot;
    }

    public void draw(Graphics g, double tick){

        g.setColor(Color.WHITE);
        g.drawOval((int)x - width/2, (int)y - width/2, width, width);

        x += x_drift * tick;
        y += y_drift * tick;

        if(x < 0 || x > 500 || y < 0 || y > 500)
            grave = true;
    }

    public boolean hit(double xa, double ya){
        if(Math.abs(xa-x) < width/2 && Math.abs(ya-y) < width/2){
            return true;
        }
        return false;
    }
}
