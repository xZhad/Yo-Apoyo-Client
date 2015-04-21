package sarpi.temuco.yoapoyo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import sarpi.temuco.yoapoyo.obj.dataS;

public class SplashActivity extends Activity {

	private final int SPLASH_DISPLAY_LENGHT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		dataS.loadData(this);

		setContentView(R.layout.splash);

		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				finish();
				Intent mainIntent = new Intent(SplashActivity.this, MainActivity.class);
				SplashActivity.this.startActivity(mainIntent);
			}
		} , SPLASH_DISPLAY_LENGHT);

	}


	@Override
	public void onBackPressed() {
		//TODO
	}

}
