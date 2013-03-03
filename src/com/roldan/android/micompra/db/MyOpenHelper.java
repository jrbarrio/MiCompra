package com.roldan.android.micompra.db;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyOpenHelper extends SQLiteOpenHelper {

	private Context contexto;
	
	public MyOpenHelper(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
		contexto = context;
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		Log.i("", "Creando base de datos v." + db.getVersion());
		
		AssetManager assets = contexto.getAssets();
		try {
			InputStream is = assets.open("sql/micompra.sql");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			while (true) {
				String linea = br.readLine();
				if (linea == null) {
					break;
				}
				Log.i("", linea);
				db.execSQL(linea);
			} 
		} catch (IOException e) {
			Log.e("", "Error de E/S", e);
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		
	}

	@Override
	public void onOpen(SQLiteDatabase db) {
		super.onOpen(db);
	}
}
