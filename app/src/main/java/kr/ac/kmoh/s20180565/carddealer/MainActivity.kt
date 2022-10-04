package kr.ac.kmoh.s20180565.carddealer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kr.ac.kmoh.s20180565.carddealer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}