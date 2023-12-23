package com.example.navybattle;

import android.graphics.Canvas;

public abstract class Projectile {
    public int x;
    public int y;


    public Projectile() {}

    // Need to check when to despawn projectile according to returned boolean.
    public abstract boolean update();

    public abstract void draw(Canvas canvas);

}
