package com.cman.helloandroid;

import android.app.Activity;
import android.os.Bundle;

public class MainMenu extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        //Draw the splash screen
        setContentView(R.layout.activity_main);
	}
}
