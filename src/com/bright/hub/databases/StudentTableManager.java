/*******************************************************************************
 * Este código está bajo la licencia CC by sa 
 * http://creativecommons.org/licenses/by-sa/2.5/es/
 * 
 * Licencia que le permite copiar, distribuir y comunicar públicamente la obra, transformar la obra o hacer un uso comercial de esta obra siempre y cuando cumpla las condiciones de:
 * Reconocimiento — Debe reconocer los créditos de la obra de la manera especificada por el autor Jose B. Cortés (pero no de una manera que sugiera que tiene su apoyo o apoyan el uso que hace de su obra).
 * 
 * Compartir bajo la misma licencia — Si altera o transforma esta obra, o genera una obra derivada, sólo puede distribuir la obra generada bajo una licencia idéntica a ésta.
 ******************************************************************************/
package com.bright.hub.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class StudentTableManager {

	public static final String KEY_NAME = "name";
	public static final String KEY_ROWID = "_id";
	private DatabaseHandler mDbHelper;
	private SQLiteDatabase mDb;

	/**
	 * Database creation sql statement
	 */
	public static final String STUDENT_TABLE_CREATE =
		"create table students (_id integer primary key autoincrement, "
		+ "name text not null);";

	private static final String STUDENTS_TABLE_NAME = "students";
	private final Context mCtx;
	
	public StudentTableManager(Context ctx) {
		this.mCtx = ctx;
	}


	public StudentTableManager open() throws SQLException {
		mDbHelper = new DatabaseHandler(mCtx);
		mDb = mDbHelper.getWritableDatabase();
		return this;
	}

	public void close() {
		mDbHelper.close();
	}

	public long createStudent(String title) {
		ContentValues initialValues = new ContentValues();
		initialValues.put(KEY_NAME, title);
		return mDb.insert(STUDENTS_TABLE_NAME, null, initialValues);
	}

	public boolean deleteStudent(long rowId) {
		return mDb.delete(STUDENTS_TABLE_NAME, KEY_ROWID + "=" + rowId, null) > 0;
	}

	public Cursor fetchAllStudents() {
		return mDb.query(STUDENTS_TABLE_NAME, new String[] {KEY_ROWID, KEY_NAME}, null, null, null, null, null);
	}

	public Cursor fetchStudent(long rowId) throws SQLException {
		Cursor mCursor = mDb.query(true, STUDENTS_TABLE_NAME, new String[] {KEY_ROWID,
					KEY_NAME}, KEY_ROWID + "=" + rowId, null,
					null, null, null, null);
		if (mCursor != null) {
			mCursor.moveToFirst();
		}
		return mCursor;
	}

	public boolean updateStudent(long rowId, String title) {
		ContentValues args = new ContentValues();
		args.put(KEY_NAME, title);
		return mDb.update(STUDENTS_TABLE_NAME, args, KEY_ROWID + "=" + rowId, null) > 0;
	}
}

