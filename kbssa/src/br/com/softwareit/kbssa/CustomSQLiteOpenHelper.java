package br.com.softwareit.kbssa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CustomSQLiteOpenHelper extends SQLiteOpenHelper {

	public static final String TABLE_RELATORIOS = "relatorios";
	public static final String COLUMN_ID = "id";
	public static final String COLUMN_DATA_HORA = "dataHora";
	public static final String COLUMN_COMENTARIO = "comentario";
	public static final String COLUMN_INTENSIDADE = "intensidade";
	public static final String COLUMN_USERNAME = "username";
	
	public static final String DATABASE_NAME = "relatorios.db";
	public static final int DATABASE_VERSION = 1;
	
	//Database creation sql statement
	private static final String DATABASE_CREATE = 
			"create table " + TABLE_RELATORIOS + " (" 
			+ COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_COMENTARIO	+ " text not null, "
			+ COLUMN_INTENSIDADE + " integer not null, "
			+ COLUMN_DATA_HORA + " integer not null, "
			+ COLUMN_USERNAME + " text not null "
			+ ");";
	
	public CustomSQLiteOpenHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_RELATORIOS);
		onCreate(db);
	}
	
}
