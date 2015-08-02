package br.com.softwareit.kbssa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RelatorioDAO {

	private SQLiteDatabase database;
	private String[] columns = {CustomSQLiteOpenHelper.COLUMN_ID, CustomSQLiteOpenHelper.COLUMN_COMENTARIO, CustomSQLiteOpenHelper.COLUMN_INTENSIDADE, CustomSQLiteOpenHelper.COLUMN_DATA_HORA, CustomSQLiteOpenHelper.COLUMN_USERNAME};
	private CustomSQLiteOpenHelper sqlLiteOpenHelper;
	
	public RelatorioDAO(Context context) {
		sqlLiteOpenHelper = new CustomSQLiteOpenHelper(context);
	}
	
	public void open() throws SQLException{
		database = sqlLiteOpenHelper.getWritableDatabase();
	}
	
	public void close(){
		sqlLiteOpenHelper.close();
	}
	
	public Relatorio create(String comentario, Integer intensidade, Date dataHora, String username){
		ContentValues values = new ContentValues();
		values.put(CustomSQLiteOpenHelper.COLUMN_COMENTARIO, comentario);
		values.put(CustomSQLiteOpenHelper.COLUMN_INTENSIDADE, intensidade);
		values.put(CustomSQLiteOpenHelper.COLUMN_DATA_HORA, dataHora.getTime());
		values.put(CustomSQLiteOpenHelper.COLUMN_USERNAME, username);
		
		long insertId = database.insert(CustomSQLiteOpenHelper.TABLE_RELATORIOS, null, 
				values);
		Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_RELATORIOS, 
				columns, CustomSQLiteOpenHelper.COLUMN_ID + " = " + insertId, null, 
				null, null, null);
		cursor.moveToFirst();
		Relatorio novo = new Relatorio();
		novo.setId(cursor.getLong(0));
		novo.setComentario(cursor.getString(1));
		novo.setIntensidade(cursor.getInt(2));
		novo.setDataHora(new Date(cursor.getLong(3)));
		novo.setUsername(cursor.getString(4));
		cursor.close();
		return novo;
	}
	
	public void delete(Relatorio note){
		long id = note.getId();
		database.delete(CustomSQLiteOpenHelper.TABLE_RELATORIOS, CustomSQLiteOpenHelper.COLUMN_ID + " = " + id, null);
	}
	
	public List<Relatorio> getAll(){
		List<Relatorio> relatorios = new ArrayList<Relatorio>();
		
		Cursor cursor = database.query(CustomSQLiteOpenHelper.TABLE_RELATORIOS, columns, null, null, null, null, null);
		
		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()){
			Relatorio novo = new Relatorio();
			novo.setId(cursor.getLong(0));
			novo.setComentario(cursor.getString(1));
			novo.setIntensidade(cursor.getInt(2));
			novo.setDataHora(new Date(cursor.getLong(3)));
			novo.setUsername(cursor.getString(4));
			relatorios.add(novo);
			cursor.moveToNext();
		}
		cursor.close();
		return relatorios;
	}
	
}
