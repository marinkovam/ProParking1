package com.example.proparking;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class DBOpenHelper extends SQLiteOpenHelper{
    private static final int DB_VERSION = 4;

    //tabelata za users
    private static final String DB_NAME = "Users";
    private static final String TABLE_Users = "userdetails";
    private static final String KEY_ID = "id";
    private static final String KEY_FIRST_NAME = "first_name";
    private static final String KEY_LAST_NAME = "last_name";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_PASSWORD = "password";

    ///tabelata za cities
    private static final String TABLE_Cities = "cities";
    private static final String CITY_ID = "id";
    private static final String CITY  = "city";
    private static final String CITY_IMAGE  = "city_image";


    ///tabelata za parking
    private static final String TABLE_Parking = "parking";

    ///tabelata za rezervacii
    private static final String TABLE_Reservation = "Reservation";
    private static final String RESERVATION_ID = "id";
    private static final String USER_NAME = "username";
    private static final String CITY_NAME = "name";
    private static final String DATE = "date";
    private static final String TIME = "time";
    private static final String PARKING_NAME = "parking_name";


    public DBOpenHelper(Context context){
        super(context,DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_TABLE1 = "CREATE TABLE " + TABLE_Users + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRST_NAME + " TEXT,"
                + KEY_LAST_NAME + " TEXT,"
                + KEY_USERNAME + " TEXT,"
                + KEY_PASSWORD + " TEXT"+")";
        db.execSQL(CREATE_TABLE1);
        String CREATE_TABLE2 = "CREATE TABLE " + TABLE_Reservation + "("
                + RESERVATION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + USER_NAME + " TEXT,"
                + CITY_NAME + " TEXT,"
                + DATE + " TEXT,"
                + TIME + " TEXT,"
                + PARKING_NAME + " TEXT"+")";
        db.execSQL(CREATE_TABLE2);
        String CREATE_TABLE3 = "CREATE TABLE " + TABLE_Cities + "(" +
                CITY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + CITY + " TEXT,"
                + CITY_IMAGE + " INTEGER"+")";
        db.execSQL(CREATE_TABLE3);

        db.execSQL("create table " + TABLE_Parking +"(id INTEGER PRIMARY KEY AUTOINCREMENT, parking_name VARCHAR, city_name VARCHAR, free VARCHAR, taken INTEGER, latitude VARCHAR, longitude VARCHAR)");
        ContentValues content = new ContentValues();
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('26ти Јули', 'Скопје', '20','10','41.989308','21.432300')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Беко-Центар', 'Скопје', '10','5','41.993260','21.428601')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Парк МКЦ', 'Скопје', '15','7','41.996262','21.442586')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Бит Пазар', 'Скопје', '20','13','42.000046','21.439192')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Широк Сокак', 'Битола', '28','18','41.028967','21.336041')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Национален музеј', 'Битола', '43','21','41.023664','21.336199')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Центар', 'Тетово', '12','32','42.006494','20.966111')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('PalmaMall', 'Тетово', '23','25','42.004326','20.989661')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Воена болница', 'Скопје', '17','25','42.006302','21.402672')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Центар', 'Велес', '15','4','41.717543','21.780445')");
        db.execSQL("insert into " + TABLE_Parking +"(parking_name, city_name, free, taken,latitude,longitude)" + "VALUES" + "('Костурница', 'Велес', '15','4','41.723105','21.788184')");

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        // Drop older table if exist
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Users);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Reservation);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Cities);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Parking);
        // Create tables again
        onCreate(db);
    }
    void insertUserDetails(String first_name, String last_name, String username, String password){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys

        ContentValues cValues = new ContentValues();
        cValues.put(KEY_FIRST_NAME, first_name);
        cValues.put(KEY_LAST_NAME, last_name);
        cValues.put(KEY_USERNAME, username);
        cValues.put(KEY_PASSWORD, password);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Users, null, cValues);
        db.close();
    }

    public boolean checkUser(String username, String password){
        // array of columns to fetch
        String[] columns = {
                KEY_ID
        };
        SQLiteDatabase db = this.getReadableDatabase();
        // selection criteria
        String selection = KEY_USERNAME + " = ?" + " AND " + KEY_PASSWORD + " = ?";
        // selection arguments
        String[] selectionArgs = {username, password};
        // query user table with conditions
        /**
         * Here query function is used to fetch records from user table this function works like we use sql query.
         * SQL query equivalent to this query function is
         * SELECT user_id FROM user WHERE user_email = 'jack@androidtutorialshub.com' AND user_password = 'qwerty';
         */
        Cursor cursor = db.query(TABLE_Users, //Table to query
                columns,                    //columns to return
                selection,                  //columns for the WHERE clause
                selectionArgs,              //The values for the WHERE clause
                null,                       //group the rows
                null,                       //filter by row groups
                null);                      //The sort order
        int cursorCount = cursor.getCount();
        cursor.close();
        db.close();
        if (cursorCount > 0) {
            return true;
        }
        return false;
    }


    void insertReservationDetails(String username, String city_name, String date, String time, String parking_name){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys

        ContentValues cValues = new ContentValues();
        cValues.put(USER_NAME, username);
        cValues.put(CITY_NAME, city_name);
        cValues.put(DATE, date);
        cValues.put(TIME, time);
        cValues.put(PARKING_NAME, parking_name);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Reservation, null, cValues);
        db.close();
    }

    void insertCityDetails(){
        //Get the Data Repository in write mode
        SQLiteDatabase db = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys

        ContentValues cValues = new ContentValues();
        cValues.put(CITY, "Скопје");
        cValues.put(CITY_IMAGE, R.drawable.skopje);
        cValues.put(CITY, "Битола");
        cValues.put(CITY_IMAGE, R.drawable.bitola);
        cValues.put(CITY, "Тетово");
        cValues.put(CITY_IMAGE, R.drawable.tetovo);
        cValues.put(CITY, "Велес");
        cValues.put(CITY_IMAGE, R.drawable.veles);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_Reservation, null, cValues);
        db.close();
    }
    public int getParkingID(String city)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor=null;
        String sql = String.format("SELECT id FROM %s WHERE city_name = city", TABLE_Parking);

        cursor = db.rawQuery(sql,  new String[]{ city});
        int ParkingId = -1;
        if(cursor.moveToFirst()) {
            ParkingId = cursor.getInt(0);
        }
        cursor.close();
        db.close();

        return ParkingId;
    }
    public List<Parking_places> getAllParkingPlaces(String city) {

        SQLiteDatabase db = this.getReadableDatabase();
        try {
            onCreate(db);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Parking_places> returnList = new ArrayList<>();

        String query = "SELECT * FROM "+ TABLE_Parking + " WHERE city_name=?";

        Cursor cursor = db.rawQuery(query,  new String[]{city});

        while(cursor.moveToNext()) {
            int parkingId = cursor.getInt(0);
            String parkingName = cursor.getString(1);
            String free=cursor.getString(3);
            String taken=cursor.getString(4);
            String latitude=cursor.getString(5);
            String longitude=cursor.getString(6);

            Parking_places parking =
                    new Parking_places(parkingId, parkingName, city, free, taken,latitude,longitude);
            returnList.add(parking);
        }
        cursor.close();
        db.close();
        return returnList;
    }

   ///funkcii za myreservations sho ne gi upotrebuvam :)

    // public boolean MyThreeReservations(String username) { // 3 rezervacii na eden korisnik
     //   SQLiteDatabase database = this.getReadableDatabase();
       // int count = 0;
        //Cursor c1 = database.rawQuery("SELECT * FROM Reservation WHERE username = '" + username + "'", null);
        //while (c1.moveToNext()) {
         //   String date = c1.getString(3);
          //  String time = c1.getString(4);
           // if (isActive(date, time)) { //ako se aktivni gi vkluchuvam
            //    count++;
            //}
        //}
        ///c1.close();
       /// if (count < 3) {
         ///   return false;
        ///} else {
          ///  return true;
       /// }
    ///}
    ///public boolean isActive(String date, String time) {
       // String[] date = date.split("/");
        //int Den = Integer.parseInt(date[0]);
        ///int Mesec = Integer.parseInt(date[1]);
       /// int Godina = Integer.parseInt(date[2]);
        ///String time = time.substring(0, 2);
        ///int time = Integer.parseInt(time);

       /// Calendar rightNow = Calendar.getInstance();
        ///int day = rightNow.get(Calendar.DAY_OF_MONTH);
        ///int month = rightNow.get(Calendar.MONTH) + 1;
        ///int year = rightNow.get(Calendar.YEAR);
        ///int hour = rightNow.get(Calendar.HOUR_OF_DAY);

}