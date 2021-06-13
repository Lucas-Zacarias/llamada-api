package com.example.apicalls

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import com.example.apicalls.api.API
import com.example.apicalls.databinding.ActivityMainBinding
import com.example.apicalls.model.Genres
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var api : API
    private lateinit var binding: ActivityMainBinding
    private lateinit var btn : Button
    private lateinit var txt : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        getViews()
        injectDependencies()
        setUpListeners()
    }


    private fun getViews() {
        btn = binding.button
        txt = binding.textView
    }

    private fun injectDependencies() {
        api = API()
    }

    private fun setUpListeners() {
      btn.setOnClickListener {
          searchGenres()
      }
    }

    private fun searchGenres() {
        api.getGenres().enqueue(object : Callback<Genres> {
            override fun onResponse(call: Call<Genres>, response: Response<Genres>) {
                if(response.isSuccessful){
                    val map = response.body()!!
                    txt.text = map.genres.map { "ID de genero:${it.key} Nombre de genero:${it.value}" }.toString()
                }
            }

            override fun onFailure(call: Call<Genres>, t: Throwable) {
                Log.e("SearchActivity", "Falló al obtener los generos", t)
            }

        })
    }


}