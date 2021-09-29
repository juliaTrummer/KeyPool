package com.mobappdev.keypool.RegisterLogin

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.mobappdev.keypool.PwList.PasswordView

class EmailPasswordActivity {

    private lateinit var auth: FirebaseAuth
    private lateinit var context: Context
    private lateinit var activity: Activity

    fun init(context: Context, activity: Activity){
        this.activity = activity
        this.context = context
        auth = FirebaseAuth.getInstance()
    }

     fun isLoggedIn() : Boolean{
        val currentUser = auth.currentUser
         if (currentUser != null) {
             return true
         }
         return false
    }

    fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(activity)
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "createUserWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed. Please try again!",
                        Toast.LENGTH_SHORT).show()
                }
            }
    }

    //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
     fun signIn(email: String, password: String, emailField : TextInputLayout, passwordField : TextInputLayout) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(activity) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    Log.d(TAG, "signInWithEmail:success")
                    val user = auth.currentUser
                    updateUI(activity)
                } else {
                    if(task.exception.toString().contains("email address is badly formatted")){
                        passwordField.error = null
                        emailField.error = "Please enter a valid Email!"
                    }else if(task.exception.toString().contains("The password is invalid or the user does not have a password")){
                        passwordField.error = "Please enter valid credentials!"
                    }
                    Log.w(TAG, "signInWithEmail:failure", task.exception)
                    Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun sendEmailVerification() {
        // [START send_email_verification]
        val user = auth.currentUser!!
        user.sendEmailVerification()
            .addOnCompleteListener(activity) { task ->
                // Email Verification sent
            }
        // [END send_email_verification]
    }

    private fun updateUI(activity : Activity) {
        val intent = Intent(activity, PasswordView::class.java)
        activity.startActivity(intent)
    }

    private fun reload() {

    }

    companion object {
        private const val TAG = "EmailPassword"
    }
}