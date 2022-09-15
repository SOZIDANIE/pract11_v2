package com.bignerdranch.android.pract11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.edit
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File

class zapomnit : AppCompatActivity() {

    private val Books: MutableList<Book> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zapomnit)
        val toast = Toast.makeText(applicationContext, "Запомнили)", Toast.LENGTH_SHORT)
        val b3 = findViewById<Button>(R.id.button2)
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val editText1 = findViewById<EditText>(R.id.editTextTextPersonName3)
        val editText2 = findViewById<EditText>(R.id.editTextNumber)
        val intent = Intent(this, spisok :: class.java)
        b3.setOnClickListener{
            val preferences = getSharedPreferences("pref", MODE_PRIVATE)

            if(preferences.contains("json")){
                val listBooks: List<Book> = Gson().fromJson<MutableList<Book>>(preferences.getString("json", "qwe").toString(), object : TypeToken<MutableList<Book>>(){}.type)
                Books.addAll(listBooks)
            }

            val book: Book = Book(editText.text.toString(), listOf(editText1.text.toString()), editText2.text.toString().toInt(), true)
            Books.add(book)

            preferences.edit{
                this.putString("json", Gson().toJson(Books))
            }


            /*val preferences = getSharedPreferences("str", MODE_PRIVATE)
            val preferences1 = getSharedPreferences("lol", MODE_PRIVATE)
            val preferences2 = getSharedPreferences("zxc", MODE_PRIVATE)
            val pref = getSharedPreferences("kniga", MODE_PRIVATE)
            val prefs = getSharedPreferences("nazv", MODE_PRIVATE)
            val prefes = getSharedPreferences("avtor", MODE_PRIVATE)
            val prefies = getSharedPreferences("kolvo", MODE_PRIVATE)
            val pre = getSharedPreferences("razd", MODE_PRIVATE)
            val b: String = Gson().toJson(editText.text.toString())
            val v: String = Gson().toJson(editText1.text.toString())
            val q: String = Gson().toJson(editText2.text.toString())
            Log.d("Preferences", pre.getString("razd", "----------------------------------------------").toString())
            Log.d("Preferences", pref.getString("kniga", "Книга:").toString())
            Log.d("Preferences", prefs.getString("nazv", "Название:").toString())
            Log.d("Preferences", preferences.getString("str", editText.text.toString()).toString())
            Log.d("Preferences", prefes.getString("avtor", "Автор:").toString())
            Log.d("Preferences", preferences1.getString("lol", editText1.text.toString()).toString())
            Log.d("Preferences", prefies.getString("kolvo", "Количество страниц:").toString())
            Log.d("Preferences", preferences2.getString("zxc", editText2.text.toString()).toString())
            val edit = preferences.edit()
            val edit1 = preferences1.edit()
            val edit2 = preferences2.edit()
            edit.putString("str", b)
            intent.putExtra("nazvanie", b)
            edit1.putString("lol", v)
            intent.putExtra("avtor", v)
            edit2.putString("zxc", q)
            intent.putExtra("kolichestvo", q)
            edit.apply()
            edit1.apply()
            edit2.apply()
            toast.show()*/
        }
    }
}