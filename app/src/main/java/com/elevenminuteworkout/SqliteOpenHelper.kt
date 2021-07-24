package com.elevenminuteworkout

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log


class SqliteOpenHelper(
    context: Context,
    factory: SQLiteDatabase.CursorFactory?
) :
    SQLiteOpenHelper(
        context, DATABASE_NAME,
        factory, DATABASE_VERSION
    ) {


    override fun onCreate(db: SQLiteDatabase) {

        val CREATE_HISTORY_TABLE = ("CREATE TABLE " +
                TABLE_HISTORY + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + HISTORY_PROFILE_COLUMN_ID + " INTEGER," +
                COLUMN_COMPLETED_DATE
                + " TEXT" + ")")
        db.execSQL(CREATE_HISTORY_TABLE)


        val CREATE_PROFILE_TABLE = ("CREATE TABLE " + PROFILE_TABLE_NAME + " ("
                + PROFILE_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + PROFILE_NAME_COL + " TEXT,"
                + PROFILE_PASSWORD_COL + " TEXT" + ")")

        db.execSQL(CREATE_PROFILE_TABLE)
    }

    fun addNewProfile(name: String?, password: String?): Boolean? {

        try {

            val dbw = this.writableDatabase
            val dbr = this.readableDatabase

            val values = ContentValues()

            val dbName: String
            val dbPass: String
            val dbUserID: Int

            val cursorProfile = dbr.rawQuery(
                "SELECT * FROM " + PROFILE_TABLE_NAME + " WHERE " + PROFILE_NAME_COL
                        + " = ?", arrayOf(name)
            )
            if (cursorProfile.moveToFirst()) {
                cursorProfile.close()
                dbr.close()
                Log.i("MSSG", "Registration already exists!")
                throw Exception("Username already registered!")
            } else {
                // on below line we are passing all values
                // along with its key and value pair.
                values.put(PROFILE_NAME_COL, name)
                values.put(PROFILE_PASSWORD_COL, password)

                // after adding all values we are passing
                // content values to our table.
                dbw.insert(PROFILE_TABLE_NAME, null, values)

                // at last we are closing our
                // database after adding database.
                dbw.close()
                return true
            }
        } catch (e: Exception){
            Log.e("ERROR",e.localizedMessage )
            return false
        }

    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_HISTORY)

        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + PROFILE_TABLE_NAME)
        onCreate(db)
    }

    fun login(username: String, password: String): Boolean? {
        try {
            val db = this.readableDatabase
            val dbName: String
            val dbPass: String
            val dbUserID: Int

            val cursorProfile = db.rawQuery(
                "SELECT * FROM " + PROFILE_TABLE_NAME + " WHERE " + PROFILE_NAME_COL
                        + " = ?", arrayOf(username)
            )
            if (cursorProfile.moveToNext()) {
                // on below line we are adding the data from cursor to our array list.
                dbUserID = cursorProfile.getInt(0)
                dbName = cursorProfile.getString(1)
                dbPass = cursorProfile.getString(2)
                cursorProfile.close()
                Log.i("MSSG", "Record found")
            } else {
                cursorProfile.close()
                Log.i("MSSG", "Record not found")
                throw Exception("Username does not exist!")
            }
            if ((dbPass == password)) {
                Log.i("MSSG", "Login success!")
                LoginActivity.profile_ID = dbUserID
                LoginActivity.profile_name = dbName
                return true
            } else throw Exception("Incorrect Password!")
        } catch (e: Exception) {
            Log.i("ERROR", e.message)
            return false;
        }
    }


    fun addDate(date: String) {
        val values =
            ContentValues()
        values.put(
            COLUMN_COMPLETED_DATE,
            date
        )
        values.put(
            HISTORY_PROFILE_COLUMN_ID,
            LoginActivity.profile_ID
        )
        val db =
            this.writableDatabase
        db.insert(TABLE_HISTORY, null, values)
        db.close()
    }


    fun getAllCompletedDatesList(): ArrayList<String> {
        val list = ArrayList<String>()
        val db =
            this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM $TABLE_HISTORY WHERE " + HISTORY_PROFILE_COLUMN_ID
                + " = ?", arrayOf(LoginActivity.profile_ID.toString()), null)


        while (cursor.moveToNext()) {

            list.add(cursor.getString(cursor.getColumnIndex(COLUMN_COMPLETED_DATE)))
        }
        cursor.close()
        return list
    }
    fun clearHistory(){
        val db = this.writableDatabase

        val CLEAR_HISTORY = ("DELETE FROM $TABLE_HISTORY WHERE " + HISTORY_PROFILE_COLUMN_ID
                + " = " + LoginActivity.profile_ID)

        db.execSQL(CLEAR_HISTORY)

    }
    fun deleteProfile(){
        val db = this.writableDatabase

        val CLEAR_HISTORY = ("DELETE FROM $TABLE_HISTORY WHERE " + HISTORY_PROFILE_COLUMN_ID
                + " = " + LoginActivity.profile_ID)

        db.execSQL(CLEAR_HISTORY)


        val DELETE_PROFILE = ("DELETE FROM $PROFILE_TABLE_NAME WHERE " + PROFILE_ID_COL
                + " = " + LoginActivity.profile_ID)

        db.execSQL(DELETE_PROFILE)

        LoginActivity.logout();
    }
    /*fun getPassword():String{
        val db = this.readableDatabase
        val dbPass:String

        val cursorPassword = dbr.rawQuery(
            "SELECT $PROFILE_PASSWORD_COL FROM " + PROFILE_TABLE_NAME + " WHERE " + PROFILE_ID_COL
                    + " = ?", arrayOf(LoginActivity.profile_ID.toString()), null)

        dbPass = cursorPassword.getString(0)

        return  dbPass

    }*/
    fun changePassword(currentPass:String, newPass:String){

        val dbw = this.writableDatabase
        val dbr = this.readableDatabase
        val dbPass:String
        val rowsUpdated:Int

        Log.i("INFO", "SUCCESS1")
        val cursorPassword = dbr.rawQuery(
            "SELECT * FROM " + PROFILE_TABLE_NAME + " WHERE " + PROFILE_ID_COL
                    + " = ?", arrayOf(LoginActivity.profile_ID.toString()), null)
        Log.i("INFO", "SUCCESS2")
        cursorPassword.moveToFirst()
        dbPass = cursorPassword.getString(2)

        if( !dbPass.equals(currentPass)){
            cursorPassword.close()
            throw java.lang.Exception("Current password incorrect!")
        }
        else {
            val cv = ContentValues()
            cv.put(PROFILE_PASSWORD_COL, newPass)
            val args = LoginActivity.profile_ID.toString()
            rowsUpdated = dbw.update(PROFILE_TABLE_NAME, cv, "$PROFILE_ID_COL = ?", arrayOf(args))
        }
        Log.i("INFO", "SUCCESS3")
        if(rowsUpdated != 1)
            throw java.lang.Exception("Unknown Error! ?Multiple rows updated?")

        dbw.close()
        dbr.close()

    }

    companion object {
        private const val DATABASE_VERSION = 7
        private const val DATABASE_NAME = "ElevenMinutesWorkout.db"
        private const val TABLE_HISTORY = "history"
        private const val COLUMN_ID = "_id"
        private const val HISTORY_PROFILE_COLUMN_ID = "profile_id"
        private const val COLUMN_COMPLETED_DATE = "completed_date"



        private const val PROFILE_TABLE_NAME = "userprofiles"
        private const val PROFILE_ID_COL = "id"
        private const val PROFILE_NAME_COL = "name"
        private const val PROFILE_PASSWORD_COL = "password"
    }
}