package com.example.navybattle;

import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements SurfaceHolder.Callback {

    private GameThread gameThread;
    private Game game;

    public GameSurface(Context context) {
        super(context);
        this.setFocusable(true);
        this.getHolder().addCallback(this);

        // All game logic is inside Game class.
        this.game = new Game(this);
    }

    public void update() {
        this.game.update();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.game.onTouchEvent(event);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        this.game.draw(canvas);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

        // game thread starts running
        this.gameThread = new GameThread(this, holder);
        this.gameThread.setRunning(true);
        this.gameThread.start();

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        while(retry) {
            try {
                this.gameThread.setRunning(false);
                this.gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
