package com.example.navybattle;


import java.util.ArrayList;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.MotionEvent;
import android.graphics.Canvas;

public class Game {

    private GameSurface gameSurface;

    private ArrayList<Asset> assets = new ArrayList();
    private ArrayList<Projectile> projectiles = new ArrayList();
    private Bitmap boatBitmap1;
    private Bitmap boatBitmap2;
    private Bitmap helicopterBitmap1;
    private Bitmap helicopterBitmap2;

    public Game(GameSurface gameSurface) {

        // Keep track of GameSurface.
        this.gameSurface = gameSurface;

        // Load all the bitmaps.
        this.boatBitmap1 = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.boat1);
        this.boatBitmap1 = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.boat2);
        this.helicopterBitmap1 = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.helicopter1);
        this.helicopterBitmap2 = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.helicopter2);


        // Testing.
        this.assets.add(new Boat(gameSurface, this.boatBitmap1, 200, 600));

    }


    public void deleteAssets() {
        for(int i=0; i<this.assets.size(); ++i) {

            // Remove asset if out of screen.
            if(this.assets.get(i).getX() < 0 ||
               this.assets.get(i).getX() > this.gameSurface.getWidth()) {
                this.assets.remove(i);
            }

            // Remove asset if no health.
            if(this.assets.get(i).getHealth() <= 0) {
                this.assets.remove(i);
            }
        }

    }

    public void deleteProjectiles() {

    }


    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            if(x < this.gameSurface.getWidth() / 2)
                this.assets.add(new Boat(this.gameSurface, this.boatBitmap1, 200, 600));
            else
                this.assets.add(new Helicopter(this.gameSurface, this.helicopterBitmap1, 200, 600));

            return true;
        }

        return false;
    }

    public void update() {
        for(Asset asset : this.assets) {
            asset.update();
        }
    }

    public void draw(Canvas canvas) {
        for(Asset asset : this.assets) {
            asset.draw(canvas);
        }
    }


}
