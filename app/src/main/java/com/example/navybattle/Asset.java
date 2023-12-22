package com.example.navybattle;

import android.graphics.Canvas;

public abstract class Asset {

    public Asset() {}

    public abstract void update();

    public abstract void draw(Canvas canvas);

    public abstract int getX();

    public abstract int getY();

    public abstract int getHealth();

}
