package com.example.navybattle;


import java.util.ArrayList;
import android.view.MotionEvent;
import android.graphics.Canvas;

public class Game {

    private GameSurface gameSurface;

    private ArrayList<Asset> assets = new ArrayList();
    private ArrayList<Projectile> projectiles = new ArrayList();

    public Game(GameSurface gameSurface) {

        // Keep track of GameSurface.
        this.gameSurface = gameSurface;

        // Testing.
        this.assets.add(new Boat(gameSurface, "left"));
        this.assets.add(new Boat(gameSurface, "right"));

    }


    public void deleteOutOfScreen() {
        for(int i=0; i<this.assets.size(); ++i) {

            // Remove asset if out of screen.
            if(this.assets.get(i).x < 0 ||
               this.assets.get(i).x > this.gameSurface.getWidth()) {
                this.assets.remove(i);
            }

            // Remove asset if no health.
            if(this.assets.get(i).health <= 0) {
                this.assets.remove(i);
            }
        }

        for(int i=0; i<this.projectiles.size(); ++i) {

            // Remove asset if out of screen.
            if(this.projectiles.get(i).x < 0 ||
                    this.projectiles.get(i).x > this.gameSurface.getWidth()) {
                this.projectiles.remove(i);
            }
        }

    }

    public boolean onTouchEvent(MotionEvent event) {

        // If screen is pressed
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            if(x < this.gameSurface.getWidth() / 2)
                this.assets.add(new Boat(this.gameSurface, "left"));
            else
                this.assets.add(new Boat(this.gameSurface, "right"));

            return true;
        }

        return false;
    }

    public void update() {
        for(Asset asset : this.assets) {
            Projectile ret = asset.update(this.assets);
            if(ret != null) {
                this.projectiles.add(ret);
            }
        }
        for(int i=0; i<this.projectiles.size(); ++i) {
            if(projectiles.get(i).update())
                this.projectiles.remove(i);
        }

    }

    public void draw(Canvas canvas) {
        for(Asset asset : this.assets) {
            asset.draw(canvas);
        }
        for(Projectile proj : this.projectiles) {
            proj.draw(canvas);
        }
    }


}
