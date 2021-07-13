package br.coma.businesscardapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.coma.businesscardapp.R
import br.coma.businesscardapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}