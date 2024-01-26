package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;

public class FeedReaderDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "CollegeScheduler.db";
    private static final int DATABASE_VERSION = 1;

    // Table creation SQL for each table
    private static final String SQL_CREATE_CLASSES =
            "CREATE TABLE Classes (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "name TEXT," +
                    "time TEXT," +
                    "instructor TEXT)";

    private static final String SQL_CREATE_ASSIGNMENTS =
            "CREATE TABLE Assignments (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT," +
                    "dueDate TEXT," +
                    "classId INTEGER," +
                    "FOREIGN KEY(classId) REFERENCES Classes(_id))";

    private static final String SQL_CREATE_EXAMS =
            "CREATE TABLE Exams (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "date TEXT," +
                    "time TEXT," +
                    "location TEXT)";

    private static final String SQL_CREATE_TODO =
            "CREATE TABLE Todo (" +
                    "_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "task TEXT)";

    public FeedReaderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_CLASSES);
        db.execSQL(SQL_CREATE_ASSIGNMENTS);
        db.execSQL(SQL_CREATE_EXAMS);
        db.execSQL(SQL_CREATE_TODO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Classes");
        db.execSQL("DROP TABLE IF EXISTS Assignments");
        db.execSQL("DROP TABLE IF EXISTS Exams");
        db.execSQL("DROP TABLE IF EXISTS Todo");
        onCreate(db);
    }

    // Method to add a new class
    public long addClass(String name, String time, String instructor) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("time", time);
        values.put("instructor", instructor);
        return db.insert("Classes", null, values);
    }

    // Method to get all classes
    public Cursor getAllClasses() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM Classes", null);
    }
}
