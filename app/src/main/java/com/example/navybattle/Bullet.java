package com.example.navybattle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Color;

public class Bullet extends Projectile {

    public String side;
    public int x;
    public int y;
    public int tx;
    public int ty;
    public int dx;
    public int dy;
    public int range = 800;

    public static Paint paint = new Paint();

    public Bullet(int tx, int ty, int dx, int dy, String side) {
        super();
        this.x = tx;
        this.y = ty;
        this.tx = tx;
        this.ty = ty;
        this.dx = dx;
        this.dy = dy;
        this.side = side;
        this.paint.setColor(Color.YELLOW);
    }

    public boolean checkCollision(Asset asset) {
        if(asset.side.equals(this.side))
            return false;

        return false;
    }

    public boolean update() {
        this.x += this.dx;
        this.y += this.dy;

        return ((Math.abs(this.x - this.tx) > this.range) || (Math.abs(this.y - this.ty) > this.range));
    }

    public void draw(Canvas canvas) {
        canvas.drawLine(this.x, this.y, this.x+2, this.y, this.paint);
    }

}