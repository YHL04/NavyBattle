package com.example.navybattle;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Boat extends Asset {

    private GameSurface gameSurface;
    private Bitmap bitmap;

    private int x;
    private int y;
    private int health;
    private long lastDrawNanoTime = -1;

    public Boat(GameSurface gameSurface, Bitmap bitmap, int x, int y) {
        super();
        this.gameSurface = gameSurface;
        this.bitmap = bitmap;

        this.x = x;
        this.y = y;
        this.health = 10;
    }

    public void update() {
        this.x += 4;
    }

    public void draw(Canvas canvas) {
        canvas.drawBitmap(this.bitmap, this.x, this.y, null);
        this.lastDrawNanoTime = System.nanoTime();
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getHealth() {
        return this.health;
    }

}
