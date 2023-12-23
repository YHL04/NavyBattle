package com.example.navybattle;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import java.util.ArrayList;

public class Helicopter extends Asset {

    private GameSurface gameSurface;
    private Bitmap bitmap;

    private int x;
    private int y;
    private int health;
    private long lastDrawNanoTime = -1;

    public Helicopter(GameSurface gameSurface, Bitmap bitmap, int x, int y) {
        super();
        this.gameSurface = gameSurface;
        this.bitmap = bitmap;

        this.x = x;
        this.y = y;
        this.health = 10;
    }

    public Projectile update(ArrayList<Asset> assets) {
        this.x += 4;
        return null;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, this.x, this.y, null);
        this.lastDrawNanoTime = System.nanoTime();
    }

}
