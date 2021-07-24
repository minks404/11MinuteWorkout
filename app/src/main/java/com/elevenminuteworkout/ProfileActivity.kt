package com.elevenminuteworkout

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        setSupportActionBar(toolbar_profile_activity)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Profile"

        toolbar_profile_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        viewHistpryBtn.setOnClickListener {

            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        deleteProfileBtn.setOnClickListener{

            val customDialog = Dialog(this)

            customDialog.setContentView(R.layout.dialog_custom_delete_profile)
            customDialog.tvYes.setOnClickListener {
                Toast.makeText(
                    this,
                    "User profile " + LoginActivity.profile_name + " successfully deleted, now you will be logged out!",
                    Toast.LENGTH_LONG
                ).show()

                val dbHandler = SqliteOpenHelper(this, null)
                dbHandler.deleteProfile()
                finish()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
                customDialog.dismiss()
            }
            customDialog.tvNo.setOnClickListener {
                customDialog.dismiss()
            }

            customDialog.show()

        }

        changePassBtn.setOnClickListener {

            val intent = Intent(this, ChangePassword::class.java)
            startActivity(intent)

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
                if( !newPass.text.equals(confirmPass.text))throw Exception("New and confirm passwords do not match!")
                dbHandler.changePassword(currentPass.text.toString(), newPass.text.toString() )

                Toast.makeText(this, "Password successfully updated!", Toast.LENGTH_LONG)
                finish()
            }
            catch (e:java.lang.Exception){
                Toast.makeText(this, e.localizedMessage, Toast.LENGTH_LONG)
            }

        }


    }
}