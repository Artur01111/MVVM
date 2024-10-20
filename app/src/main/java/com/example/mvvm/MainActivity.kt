package com.example.mvvm

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}
    private lateinit var viewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[CountViewModel::class.java]
        Log.e("ololo", "onCreate: ${viewModel.liveData::hasActiveObservers}")

        binding.btnPlus.setOnClickListener {
            viewModel.increment()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.decrement()
        }
        viewModel.liveData.observe(this){count->
            binding.tvCount.text = count.toString()

            if (count == 10){
                Toast.makeText(this, "Поздравляем", Toast.LENGTH_SHORT).show()
            }

            if (count == 15){
                binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.green))
            } else{
                binding.tvCount.setTextColor(ContextCompat.getColor(this, R.color.black))
            }
        }
    }

    override fun onStart() {
        Log.e("ololo", "onStart: ${viewModel.liveData::hasActiveObservers}")
        super.onStart()
    }

    override fun onResume() {
        Log.e("ololo", "onResume: ${viewModel.liveData::hasActiveObservers}")
        super.onResume()
    }
}