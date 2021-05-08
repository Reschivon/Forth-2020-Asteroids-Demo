package asteroids;

import java.awt.*;

public class Ship {
    public float x = 500, y = 500, rot = 0;
    public int width = 20;

    public Ship(float x, float y, float rot){
        this.x = x;
        this.y = y;
        this.rot = rot;
    }

    public void draw(Graphics g){
        point tip = new point(0, -15);
        point l = new point(-6, 0);
        point r = new point(6, 0);

        tip.rotate(rot);
        l.rotate(rot);
        r.rotate(rot);

        tip.translate(x, y);
        l.translate(x, y);
        r.translate(x, y);

        g.setColor(Color.WHITE);
        g.drawLine((int) tip.x, (int) tip.y, (int) l.x, (int) l.y);
        g.drawLine((int) tip.x, (int) tip.y, (int) r.x, (int) r.y);
        g.drawLine((int) r.x, (int) r.y, (int) l.x, (int) l.y);
    }

    public void forward(float tick){
        point tip = new point(0, 30);

        tip.rotate(rot);

        x -= tip.x * tick;
        y -= tip.y * tick;
    }

    public boolean hit(double xa, double ya){
        if(Math.abs(xa-x) < width/2 && Math.abs(ya-y) < width/2){
            return true;
        }
        return false;
    }

    public void left(double tick){
        rot -= 4 * tick;
    }

    public void right(double tick){
        rot += 4 * tick;
    }
}
