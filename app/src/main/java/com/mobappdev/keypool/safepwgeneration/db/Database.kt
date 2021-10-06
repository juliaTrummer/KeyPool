package com.mobappdev.keypool.safepwgeneration.db

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings
import com.mobappdev.keypool.passwordlist.KeyItem
import java.security.Key

class Database {

    private lateinit var db: FirebaseFirestore
    private lateinit var baseContext : Context
    private var TAG : String = "ERROR"

    fun init(context : Context) {
        db = FirebaseFirestore.getInstance()
        db.firestoreSettings = FirebaseFirestoreSettings.Builder().build()
        baseContext = context
    }

    fun safeData(collectionPath:String, value:KeyItem){
        setData(collectionPath, value)
    }

    fun collectData(){
        getData()
    }

    private fun setData(collectionPath : String, value : KeyItem) {

    }

    private fun getData(){
        db
            .collection("keyitem").document()
            .get()
            .addOnSuccessListener { document ->
                try {
                    if (document != null) {
                        print(document.toObject(KeyItem::class.java) ?: KeyItem())
                        Toast.makeText(baseContext, "DocumentSnapshot read successfully!", Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(baseContext, "No such document!", Toast.LENGTH_LONG).show()
                    }
                }catch (ex: Exception){
                    ex.message?.let { Log.e(TAG, it) }
                }
            }.addOnFailureListener {
                    e -> Log.e(TAG, "Error writing document", e)
            }
    }


}