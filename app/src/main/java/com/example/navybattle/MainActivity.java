package com.example.navybattle;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set fullscreen
        this.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set No Title
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // Set orientation to landscape
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        this.setContentView(new GameSurface(this));
    }

}




//package com.example.navybattle;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.Button;
//
//
//public class MainActivity extends Activity {
//
//    private Button startGame;
//    private Button exit;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Set orientation to landscape
//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//
//        startGame = (Button) findViewById(R.id.start_game);
//        startGame.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent game = new Intent(MainActivity.this, GameActivity.class);
//                // game.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                startActivity(game);
//            }
//        });
//
//        exit = (Button) findViewById(R.id.exit);
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                finish();
//                System.exit(0);
//            }
//        });
//    }
//}
