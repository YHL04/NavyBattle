package com.example.navybattle;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import java.util.ArrayList;


public class Boat extends Asset {

    private GameSurface gameSurface;
    private Bitmap bitmap;

    private int t = 0;
    private int dx = 5;

    private int bulletDx;
    private int reloadDelay = 3;
    private int rangeX = 300;

    public Boat(GameSurface gameSurface, String side) {
        super();
        this.gameSurface = gameSurface;

        // parameters
        this.y = 600;
        this.health = 10;
        this.side = side;

        if(this.side.equals("left")) {
            this.bitmap = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.boatleft);
            this.x = 100;
            this.bulletDx = 10;
        }
        if(this.side.equals("right")) {
            this.bitmap = BitmapFactory.decodeResource(gameSurface.getResources(), R.drawable.boatright);
            this.x = 2000;
            this.bulletDx = -10;
        }
    }

    public boolean withinRange(Asset asset) {
        int assetX = this.x + this.w / 2;
        int assetY = this.y + this.h / 2;
        int targetX = asset.x + asset.w / 2;
        int targetY = asset.y + asset.h / 2;

        if(this.side.equals("left") && !this.side.equals(asset.side) && // check sides
                (targetX - assetX <= this.rangeX) && (targetX - assetX >= 0) &&  // check x within range
                (targetY - assetY <= 10) && (targetY - assetY >= 0)) {   // check y within range
            return true;
        }
        if(this.side.equals("right") && !this.side.equals(asset.side) && // check sides
                (assetX - targetX <= this.rangeX) && (assetX - targetX >= 0) &&  // check x within range
                (assetY - targetY <= 10) && (assetY - targetY >= 0)) {   // check y within range
            return true;
        }
        return false;
    }

    public Projectile update(ArrayList<Asset> assets) {
        this.t++;

        for(Asset asset : assets) {

            // if target within range stop to either shoot or reload
            if(this.withinRange(asset)) {
                if(this.t % this.reloadDelay == 0) {
                    return new Bullet(this.x+this.w/2, this.y+this.h/2 + 40,
                            this.bulletDx, 0, this.side);
                }
                return null;
            }
        }

        // if no targets within range then keep moving
        if(this.side.equals("left"))
            this.x += this.dx;
        if(this.side.equals("right"))
            this.x -= this.dx;

        return null;
    }

    public void draw(Canvas canvas) {
        // draw asset image
        canvas.drawBitmap(this.bitmap, this.x, this.y, null);

        // draw asset health bar
        canvas.drawLine(this.x, this.y - 30, this.x+this.health*20, this.y - 30, this.paint);

    }

}
