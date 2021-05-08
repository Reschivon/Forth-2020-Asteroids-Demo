package asteroids;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public JFrame frame;

    public Ship ship;
    public List<Asteroid> asteroids = new ArrayList<>();
    public List<Bullet> bullets = new ArrayList<>();

    float tick = 0.1f;

    public Game(){
        frame = new JFrame("Asteroids!");
        ship = new Ship(250, 250, 0);
        int i = 10;
        while (i-->0)
            asteroids.add(new Asteroid());

        frame.add(new JPanel(){
            public void paintComponent(Graphics g) {
                super.paintComponent(g);

                Graphics2D g2 = (Graphics2D) g;
                g2.setStroke(new BasicStroke(3));

                g.setColor(Color.BLACK);
                g.fillRect(0, 0, getWidth(), getHeight());

                for (var a : asteroids)
                    a.draw(g, tick);

                for (var b : bullets)
                    b.draw(g, tick);

                ship.draw(g);

                // collision
                for (var b : bullets) {
                    for (var a : asteroids) {
                        if(a.hit(b.x, b.y)) {
                            a.grave = true;
                            b.grave = true;
                        }
                    }
                }

                //clear garbage
                for(int i = 0; i < bullets.size(); i++){
                    if(bullets.get(i).grave){
                        bullets.remove(i);
                        i--;
                    }
                }

                for(int i = 0; i < asteroids.size(); i++){
                    if(asteroids.get(i).grave){
                        asteroids.remove(i);
                        i--;
                    }
                }

                if(Math.random() > 0.997)
                    asteroids.add(new Asteroid());

                repaint();
            }
        });

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);

                int keyCode = e.getKeyCode();
                switch( keyCode ) {
                    case KeyEvent.VK_UP:
                        ship.forward(tick);
                        break;
                    case KeyEvent.VK_DOWN:
                        fire();
                        break;
                    case KeyEvent.VK_LEFT:
                        ship.left(tick);
                        break;
                    case KeyEvent.VK_RIGHT :
                        ship.right(tick);
                        break;
                }
            }
        });

        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    Long lastFire = System.currentTimeMillis();
    void fire(){
        if(System.currentTimeMillis() - lastFire > 0.2 * 1000){
            lastFire = System.currentTimeMillis();
            bullets.add(new Bullet(ship.x, ship.y, ship.rot));
        }
    }
}
