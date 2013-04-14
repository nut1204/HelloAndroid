package com.cman.helloandroid;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity {

	long m_dwSplashTime = 3000;
	boolean m_bPaused = false;
	boolean m_bSplashActive = true;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Draw the splash screen
        setContentView(R.layout.splash);
        //Very simple timer thread
        Thread splashTimer = new Thread() {
        	public void run()
            {
        		try 
        		{
	                //Wait loop
	                long ms = 0;
	                while(m_bSplashActive && ms < m_dwSplashTime) 
	                {
		                sleep(100);
		                //Advance the timer only if we're running. 
		                if(!m_bPaused)
		                	ms += 100;
	                }
	                //Advance to the next screen. 
	                startActivity(new Intent("com.google.app.splashy.CLEARSPLASH")); 
        		}
        		catch(Exception e)
                {
                    Log.e("Splash", e.toString());
                }
                finally
                {
                	finish();
                }
            }
        };
        splashTimer.start();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
