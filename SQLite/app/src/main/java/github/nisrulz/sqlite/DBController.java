package github.nisrulz.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DBController {
    // Database fields
    private DBhelper dbHelper;
    private Context context;
    private SQLiteDatabase database;

    public DBController(Context context) {
        dbHelper = new DBhelper(context);
    }

    public void close() {
        dbHelper.close();
    }

    public void addEmployee(Employee emp) {

        database = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DBhelper.COL_EMP_NAME, emp.get_name());
        values.put(DBhelper.COL_EMP_ADDRESS, emp.get_address());
        values.put(DBhelper.COL_EMP_PHONE, emp.get_phone());

        database.insert(DBhelper.TABLE_NAME, null, values);

        System.out.println("Record Added");
        database.close();
    }

    public Employee getEmployee(int _id) {

        database = dbHelper.getReadableDatabase();

        Cursor cursor = database.query(DBhelper.TABLE_NAME, DBhelper.columns, DBhelper.COL_EMP_ID + " =?", new String[]{String.valueOf(_id)}, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        Employee emp = new Employee(Integer.parseInt(cursor.getString(0)), cursor.getString(1),
                cursor.getString(2), cursor.getString(3));

        return emp;
    }

    // Getting All Employees
    public List<Employee> getAllEmployee() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        List<Employee> contactList = new ArrayList<Employee>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + DBhelper.TABLE_NAME;

        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Employee emp = new Employee();
                emp.set_id(Integer.parseInt(cursor.getString(0)));
                emp.set_name(cursor.getString(1));
                emp.set_address(cursor.getString(2));
                emp.set_phone(cursor.getString(3));
                // Adding contact to list
                contactList.add(emp);
            } while (cursor.moveToNext());
        }

        // return contact list
        return contactList;
    }

    // Updating single employee
    public int updateEmployee(Employee emp) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DBhelper.COL_EMP_NAME, emp.get_name());
        values.put(DBhelper.COL_EMP_ADDRESS, emp.get_address());
        values.put(DBhelper.COL_EMP_PHONE, emp.get_phone());

        // updating row
        return db.update(DBhelper.TABLE_NAME, values, DBhelper.COL_EMP_ID + " = ?",
                new String[]{String.valueOf(emp.get_id())});
    }

    // Deleting single employee
    public void deleteEmployee(Employee emp) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(DBhelper.TABLE_NAME, DBhelper.COL_EMP_ID + " = ?",
                new String[]{String.valueOf(emp.get_id())});

        System.out.println("Record Deleted");
        db.close();
    }

    // Deleting single employee
    public void deleteEmployee(int _id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        db.delete(DBhelper.TABLE_NAME, DBhelper.COL_EMP_ID + " = ?",
                new String[]{String.valueOf(_id)});
        db.close();
    }
}
