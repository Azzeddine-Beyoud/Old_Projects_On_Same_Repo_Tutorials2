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
        super(context, Utils.DATABASE_NAME, null, Utils.DATABASE_VERSION );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + Utils.TABLE_NAME +
                " ("+ Utils.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + Utils.COLUMN_NAME + " TEXT,"
                + Utils.COLUMN_LASTNAME + " TEXT,"
                + Utils.COLUMN_EMAIL +" TEXT,"
                + Utils.COLUMN_PASSWORD + " TEXT,"
                + Utils.COLUMN_AGE + " TEXT,"
                + Utils.COLUMN_PHONENUMBER + " INTEGER,"
                + Utils.COLUMN_CITY + " TEXT)" );

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + Utils.TABLE_NAME );
        onCreate(db);

    }

//    public long insertData(ListPerson person){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues cv = new ContentValues();
//
//        cv.put(Utils.COLUMN_NAME , person.getName());
//        cv.put(Utils.COLUMN_LASTNAME , person.getLastname());
//        cv.put(Utils.COLUMN_EMAIL , person.getEmail());
//        cv.put(Utils.COLUMN_PASSWORD , person.getPassword());
//        cv.put(Utils.COLUMN_AGE , person.getAge());
//        cv.put(Utils.COLUMN_PHONENUMBER , person.getPhonenumber());
//        cv.put(Utils.COLUMN_CITY , person.getCity());
//        long id = db.insert(Utils.TABLE_NAME, null,cv);
//        db.close();
//        return id;
//    }

    public long insertData(ListPerson person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME , person.getName());
        cv.put(Utils.COLUMN_EMAIL , person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD , person.getPassword());
        cv.put(Utils.COLUMN_PHONENUMBER , person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY , person.getCity());
        long id = db.insert(Utils.TABLE_NAME, null,cv);
        db.close();
        return id;
    }

    public int updatePerson(ListPerson person){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Utils.COLUMN_NAME , person.getName());
        cv.put(Utils.COLUMN_LASTNAME , person.getLastname());
        cv.put(Utils.COLUMN_EMAIL , person.getEmail());
        cv.put(Utils.COLUMN_PASSWORD , person.getPassword());
        cv.put(Utils.COLUMN_AGE , person.getAge());
        cv.put(Utils.COLUMN_PHONENUMBER , person.getPhonenumber());
        cv.put(Utils.COLUMN_CITY , person.getCity());

        int result = db.update(Utils.TABLE_NAME,cv,Utils.COLUMN_ID + "=?",
                     new String[]{ String.valueOf(person.getId()) });
        db.close();
        return result;

    }

    public void deletePerson(ListPerson person){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Utils.TABLE_NAME,Utils.COLUMN_ID + " =?",new String[]{ String.valueOf(person.getId())} );

    }

    public ListPerson getPerson(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(Utils.TABLE_NAME,
                new String[]{ Utils.COLUMN_ID , Utils.COLUMN_NAME , Utils.COLUMN_LASTNAME ,
                              Utils.COLUMN_EMAIL , Utils.COLUMN_PASSWORD , Utils.COLUMN_AGE ,
                              Utils.COLUMN_PHONENUMBER ,Utils.COLUMN_CITY },
                      Utils.COLUMN_ID + " =?",new String[]{String.valueOf(id)},
                       null,null,null,null);
        if (cursor != null)
            cursor.moveToFirst();
        ListPerson person = new ListPerson(
                cursor.getInt(cursor.getColumnIndex(Utils.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_LASTNAME)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_EMAIL)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PASSWORD)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_PHONENUMBER)),
                cursor.getInt(cursor.getColumnIndex(Utils.COLUMN_AGE)),
                cursor.getString(cursor.getColumnIndex(Utils.COLUMN_CITY)));
        cursor.close();
        return person;

    }

    public List<ListPerson> AllPerson(){
        SQLiteDatabase db = this.getReadableDatabase();
        List<ListPerson> dataList = new ArrayList<>();
        String query = "SELECT * FROM " + Utils.TABLE_NAME ;

//        + " ORDER BY " + Utils.COLUMN_TIME_STAMP + " DESC "

        Cursor cursor = db.rawQuery(query,null);

        if (cursor.moveToFirst())

            do {
                ListPerson person = new ListPerson();

                person.setId(cursor.getInt(0));
                person.setName(cursor.getString(1));
                person.setLastname(cursor.getString(2));
                person.setEmail(cursor.getString(3));
                person.setAge(cursor.getInt(4));
                person.setAge(cursor.getInt(5));
                person.setPhonenumber(cursor.getString(6));
                person.setCity(cursor.getString(7));


//                data.setId(cursor.getInt(cursor.getColumnIndex(Utils.COLUMN_ID)));
//                data.setName(cursor.getString(cursor.getColumnIndex(Utils.COLUMN_NAME)));
//                data.setLname(cursor.getString(cursor.getColumnIndex(Utils.COLUMN_LNAME)));
//                data.setTimeStamp(cursor.getString(cursor.getColumnIndex(Utils.COLUMN_TIME_STAMP)));
//                data.setDescription(cursor.getString(cursor.getColumnIndex(Utils.COLUMN_DESCRIPTION)));
//                data.setAge(cursor.getInt(cursor.getColumnIndex(Utils.COLUMN_AGE)));

                dataList.add(person);

            }while(cursor.moveToNext());
        db.close();
        return dataList;

    }

    public int getDataCount(){
        SQLiteDatabase db= this.getReadableDatabase();

        String query="SELECT * FROM " + Utils.TABLE_NAME;
        Cursor cursor = db.rawQuery(query,null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }

}

