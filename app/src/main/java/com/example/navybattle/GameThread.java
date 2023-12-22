package com.example.navybattle;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameThread extends Thread {

    private boolean running;
    private GameSurface gameSurface;
    private SurfaceHolder surfaceHolder;

    public GameThread(GameSurface gameSurface, SurfaceHolder surfaceHolder) {
        this.gameSurface = gameSurface;
        this.surfaceHolder = surfaceHolder;
    }

    @Override
    public void run() {

        while(running) {
            long startTime = System.nanoTime();

            Canvas canvas = null;
            try {
                canvas = this.surfaceHolder.lockCanvas();

                // Synchronized
                synchronized(canvas) {
                    this.gameSurface.update();
                    this.gameSurface.draw(canvas);
                }
            } catch(Exception e) {

            } finally {
                if(canvas != null) {
                    this.surfaceHolder.unlockCanvasAndPost(canvas);
                }
            }

            long now = System.nanoTime();
            long waitTime = (now - startTime) / 1000000;
            if(waitTime < 10) {
                waitTime = 10; // Milliseconds
            }
            System.out.println("Wait Time: " + waitTime);

            try {
                this.sleep(waitTime);
            } catch(InterruptedException e) {

            }
        }
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

}
