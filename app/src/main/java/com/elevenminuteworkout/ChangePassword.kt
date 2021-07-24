package com.elevenminuteworkout

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_change_password.*

class ChangePassword : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        setSupportActionBar(toolbar_changePassword_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Change Password"

        toolbar_changePassword_activity.setNavigationOnClickListener {
            onBackPressed()
        }
        onChangePass.setOnClickListener {
            onChangePassword()
        }
    }
    fun onChangePassword() {

        val currentPass = findViewById<EditText>(R.id.currentPass)
        val dbHandler = SqliteOpenHelper(this, null)

        val newPass = findViewById<EditText>(R.id.newPass)
        val confirmPass = findViewById<EditText>(R.id.confirnNewPass)

        try {
            if (currentPass.text.isEmpty()) throw Exception("Please enter current password!")
            if (newPass.text.isEmpty()) throw Exception("Please enter the new password!")
            if (confirmPass.text.isEmpty()) throw Exception("Please confirm the new password!")
            if( !newPass.text.toString().equals(confirmPass.text.toString()))throw Exception("New and confirm passwords do not match!")
            dbHandler.changePassword(currentPass.text.toString(), newPass.text.toString() )

            Toast.makeText(this, "Password successfully updated!", Toast.LENGTH_LONG).show()
            Log.i("INFO", "SUCESS3")
            finish()
        }
        catch (e: Exception){
            Log.i("INFO", "FAIL " + e.printStackTrace())
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
        }

    }
}