package github.nisrulz.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBhelper extends SQLiteOpenHelper {

    //Table Name
    public static final String TABLE_NAME = "emp";
    //Column Names
    public static final String COL_EMP_ID = "_id";
    public static final String COL_EMP_NAME = "_name";
    public static final String COL_EMP_ADDRESS = "_address";
    public static final String COL_EMP_PHONE = "_phone";
    static final String[] columns = new String[]{DBhelper.COL_EMP_ID,
            DBhelper.COL_EMP_NAME, DBhelper.COL_EMP_ADDRESS,
            DBhelper.COL_EMP_PHONE};
    //Database Information
    private static final String DATABASE_NAME = "emp.db";
    private static final int DATABASE_VERSION = 1;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_NAME
            + "(" + COL_EMP_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_EMP_NAME + " TEXT NOT NULL, " + COL_EMP_ADDRESS + " TEXT," + COL_EMP_PHONE + " TEXT NOT NULL);";

    public DBhelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("DB Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        System.out.println("Table Created");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
        System.out.println("DB Updated");
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}