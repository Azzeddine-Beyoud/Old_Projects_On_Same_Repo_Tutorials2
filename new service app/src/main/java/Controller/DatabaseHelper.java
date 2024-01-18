package Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import Modul.ListPerson;
import Utils.Utils;


public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(@Nullable Context context) {
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Utils.TABLE_NAME +
                " (" + Utils.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utils.COLUMN_NAME + " TEXT,"
                + Utils.COLUMN_LASTNAME + " TEXT,"
                + Utils.COLUMN_EMAIL + " TEXT UNIQUE,"
                + Utils.COLUMN_PASSWORD + " TEXT,"
                + Utils.COLUMN_PHONENUMBER + " TEXT UNIQUE,"
                + Utils.COLUMN_CITY + " TEXT,"
                + Utils.COLUMN_JOB + " TEXT)");


        db.execSQL("CREATE TABLE " + Utils.TABLE_PAINTER +
                " (" + Utils.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utils.COLUMN_NAME + " TEXT,"
                + Utils.COLUMN_LASTNAME + " TEXT,"
                + Utils.COLUMN_EMAIL + " TEXT,"
                + Utils.COLUMN_PASSWORD + " TEXT,"
                + Utils.COLUMN_PHONENUMBER + " TEXT,"
                + Utils.COLUMN_CITY + " TEXT,"
                + Utils.COLUMN_JOB + " TEXT)");

        db.execSQL("CREATE TABLE " + Utils.TABLE_PLUMBER +
                " (" + Utils.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utils.COLUMN_NAME + " TEXT,"
                + Utils.COLUMN_LASTNAME + " TEXT,"
                + Utils.COLUMN_EMAIL + " TEXT,"
                + Utils.COLUMN_PASSWORD + " TEXT,"
                + Utils.COLUMN_PHONENUMBER + " TEXT,"
                + Utils.COLUMN_CITY + " TEXT,"
                + Utils.COLUMN_JOB + " TEXT)");

        db.execSQL("CREATE TABLE " + Utils.TABLE_MECHANIC +
                " (" + Utils.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utils.COLUMN_NAME + " TEXT,"
                + Utils.COLUMN_LASTNAME + " TEXT,"
                + Utils.COLUMN_EMAIL + " TEXT,"
                + Utils.COLUMN_PASSWORD + " TEXT,"
                + Utils.COLUMN_PHONENUMBER + " TEXT,"
                + Utils.COLUMN_CITY + " TEXT,"
                + Utils.COLUMN_JOB + " TEXT)");


    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME);
        onCreate(db);

    }


////////////////////////////////////////////////////////////////////////////////    //Insert Methods

    public long insertData(ListPerson person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME, person.getName());
        cv.put(Utils.COLUMN_EMAIL, person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD, person.getPassword());
        cv.put(Utils.COLUMN_LASTNAME, person.getLastname());
        cv.put(Utils.COLUMN_PHONENUMBER, person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY, person.getCity());
        cv.put(Utils.COLUMN_JOB, person.getJob());
        long id = db.insert(Utils.TABLE_NAME, null, cv);
        db.close();
        return id;
    }

    public long insertDataPainter(ListPerson person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME, person.getName());
        cv.put(Utils.COLUMN_EMAIL, person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD, person.getPassword());
        cv.put(Utils.COLUMN_LASTNAME, person.getLastname());
        cv.put(Utils.COLUMN_PHONENUMBER, person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY, person.getCity());
        cv.put(Utils.COLUMN_JOB, person.getJob());

        long id = db.insert(Utils.TABLE_PAINTER, null, cv);
        db.close();
        return id;
    }

    public long insertDataPlumber(ListPerson person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME, person.getName());
        cv.put(Utils.COLUMN_EMAIL, person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD, person.getPassword());
        cv.put(Utils.COLUMN_LASTNAME, person.getLastname());
        cv.put(Utils.COLUMN_PHONENUMBER, person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY, person.getCity());
        cv.put(Utils.COLUMN_JOB, person.getJob());

        long id = db.insert(Utils.TABLE_PLUMBER, null, cv);
        db.close();
        return id;
    }

    public long insertDataMechanic(ListPerson person) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME, person.getName());
        cv.put(Utils.COLUMN_EMAIL, person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD, person.getPassword());
        cv.put(Utils.COLUMN_LASTNAME, person.getLastname());
        cv.put(Utils.COLUMN_PHONENUMBER, person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY, person.getCity());
        cv.put(Utils.COLUMN_JOB, person.getJob());

        long id = db.insert(Utils.TABLE_MECHANIC, null, cv);
        db.close();
        return id;
    }

/////////////////////////////////////////////////////////////////////////////////////////////////Get Records


    public List<ListPerson> getAllRecordsForOtherTables(String Table) {

        List<ListPerson> DATA = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Table, null);

        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            ListPerson person = new ListPerson(
                    cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(Utils.COLUMN_LASTNAME)),
                    cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PHONENUMBER)),
                    cursor.getString(cursor.getColumnIndex(Utils.COLUMN_CITY)));

            DATA.add(person);
            cursor.moveToNext();
        }
        cursor.close();
        return DATA;
    }

    public List<ListPerson> getAllRecords(String name) {

        if (name.equals("")) {
            return null;
        } else {
            List<ListPerson> DATA = new ArrayList<>();

            SQLiteDatabase db = this.getReadableDatabase();
            Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME + " where " + Utils.COLUMN_NAME + " like '" + name + "'", null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                ListPerson person = new ListPerson(
                        cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)),
                        cursor.getString(cursor.getColumnIndex(Utils.COLUMN_LASTNAME)),
                        cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PHONENUMBER)),
                        cursor.getString(cursor.getColumnIndex(Utils.COLUMN_CITY)));
                DATA.add(person);
                cursor.moveToNext();
            }
            return DATA;
        }
    }


    public ListPerson LogInVerification(String Email, String Password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME +
                " where " + Utils.COLUMN_EMAIL +
                " like '" + Email +
                "  AND  " + Utils.COLUMN_PASSWORD +
                " like '" + Password + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {

            if (cursor.getString(cursor.getColumnIndex(Utils.COLUMN_EMAIL)).equals(Email)) {
                if (cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PASSWORD)).equals(Password)) {

                    return new ListPerson(
                            cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)),
                            cursor.getString(cursor.getColumnIndex(Utils.COLUMN_LASTNAME)),
                            cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PHONENUMBER)),
                            cursor.getString(cursor.getColumnIndex(Utils.COLUMN_CITY)),
                            cursor.getString(cursor.getColumnIndex(Utils.COLUMN_EMAIL))
                    );


                }
            }
            cursor.moveToNext();
        }
        return null;

    }


    public boolean checkEmail(String Email) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME + " where " + Utils.COLUMN_EMAIL + " like '" + Email + "'", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex(Utils.COLUMN_EMAIL)).equals(Email)) {
                return true;
            }
            cursor.moveToNext();
        }

        return false;
    }


    public boolean checkUserName(String Name) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME + " where " + Utils.COLUMN_NAME + " like '" + Name + "'", null);

        cursor.moveToFirst();
        if (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)).equals(Name)) {
                return true;
            }
            cursor.moveToNext();
        }
        return false;
    }

    public boolean checkPhoneNumber(String phonenumber) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("select * from " + Utils.TABLE_NAME + " where " + Utils.COLUMN_PHONENUMBER + " like '" + phonenumber + "'", null);
        cursor.moveToFirst();

        if (!cursor.isAfterLast()) {
            if (cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PHONENUMBER)).equals(phonenumber)) {
                return true;
            }
            cursor.moveToNext();
        }
        return false;


    }

}

