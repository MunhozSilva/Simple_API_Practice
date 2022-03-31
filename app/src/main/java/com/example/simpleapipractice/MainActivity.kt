package com.example.simpleapipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapipractice.databinding.ActivityMainBinding
import com.example.simpleapipractice.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer { response ->
            if (response.isSuccessful) {
                Log.d("Response", response.body()?.userID.toString())
                Log.d("Response", response.body()?.id.toString())
                binding.textView.text = response.body()?.title!!
                //Log.d("Response", response.body()?.title!!)
                Log.d("Response", response.body()?.body!!)
            } else{
                Log.d("Response", response.errorBody().toString())
                binding.textView.text = response.code().toString()
            }
        })
    }
}