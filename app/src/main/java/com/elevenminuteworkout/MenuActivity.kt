package com.elevenminuteworkout

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*
import kotlinx.android.synthetic.main.dialog_custom_back_confirmation.*

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_menu)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }


        llStart.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        llBMI.setOnClickListener {

            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        llProfile.setOnClickListener {

            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        onLogoutBtn.setOnClickListener {


            val customDialog = Dialog(this)

            customDialog.setContentView(R.layout.menu_dialog_custom_logout_confirmation)
            customDialog.tvYes.setOnClickListener {
                Toast.makeText(
                    this,
                    "User " + LoginActivity.profile_name + " successfully logged out!",
                    Toast.LENGTH_LONG
                ).show()
                LoginActivity.logout();
                finish()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish();
                customDialog.dismiss()
            }
            customDialog.tvNo.setOnClickListener {
                customDialog.dismiss()
            }

            customDialog.show()

        }

    }
    override
    fun onBackPressed() {

        val customDialog = Dialog(this)

        customDialog.setContentView(R.layout.menu_dialog_custom_back_confirmation)
        customDialog.tvYes.setOnClickListener {
            LoginActivity.logout()
            finish()
            customDialog.dismiss()
        }
        customDialog.tvNo.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()

    }
}