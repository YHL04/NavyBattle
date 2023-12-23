package com.example.navybattle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;

import java.util.ArrayList;

public abstract class Asset {
    public String side;
    public int health;
    public int x;
    public int y;
    public int w = 100;
    public int h = 100;

    public static Paint paint = new Paint();

    public Asset() {
        // Set health bar color to red
        this.paint.setColor(Color.RED);
    }

    public abstract Projectile update(ArrayList<Asset> assets);

    public abstract void draw(Canvas canvas);


}
