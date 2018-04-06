package it.frame.progettocorso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

public class Splash extends AppCompatActivity {

    Thread mSplashThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mSplashThread = new Thread(){
            @Override
            public void run() {
                try {

                    synchronized (this){

                        wait(getResources().getInteger(R.integer.timeout_splash_screen));
                    }

                }catch (InterruptedException e){

                }

                Intent intent = new Intent(Splash.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        };

        mSplashThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction()==MotionEvent.ACTION_DOWN){
            synchronized (mSplashThread){

                mSplashThread.notifyAll();
            }
        }

        return true;
    }
}
