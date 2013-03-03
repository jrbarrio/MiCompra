package com.roldan.android.micompra;

import java.io.File;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;

import com.roldan.android.micompra.db.MyOpenHelper;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);	
		
		File f = getDatabasePath("micompra");
		Log.i("", "Ruta de la base de datos: " + f.getAbsolutePath());
		
		MyOpenHelper helper = new MyOpenHelper(this, "micompra", null, 1);
		SQLiteDatabase db = helper.getWritableDatabase();
		Log.i("", "Base de datos abierta, v." + db.getVersion());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
