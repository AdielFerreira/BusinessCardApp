package br.coma.businesscardapp.ui


import android.os.Bundle
import android.widget.*
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import br.coma.businesscardapp.App
import br.coma.businesscardapp.R
import br.coma.businesscardapp.data.BusinessCard
import br.coma.businesscardapp.databinding.ActivityAddBusinessCardBinding


class AddBusinessCardActivity : AppCompatActivity() {

    private lateinit var spinnerColor:Spinner
    private val binding by lazy { ActivityAddBusinessCardBinding.inflate(layoutInflater) }
    private val mainViewModel: MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListenners()
    }

    private fun insertListenners() {

        spinnerColor = findViewById(R.id.spinner_color)

        val arraySpinner = resources.getStringArray(R.array.color_list)
        val arrayAdapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,arraySpinner)

        spinnerColor.adapter = arrayAdapter

        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnConfirmar.setOnClickListener {
           val bCard = BusinessCard(
               name = binding.tilName.editText?.text.toString(),
               phone = binding.tilPhone.editText?.text.toString(),
               company = binding.tilCompanyName.editText?.text.toString(),
               email = binding.tilEmail.editText?.text.toString(),
               background = select_color(binding.spinnerColor.selectedItem.toString())
           )
            mainViewModel.insert(bCard)
            Toast.makeText(this,"Cartao adicionado",Toast.LENGTH_LONG).show()
            finish()
        }

    }

    private fun select_color(string: String): String {
        when(string){
            "Amarelo"-> return "#FFFF00"
            "Cinza" -> return "#B6B6B6"
            "Branco" -> return "#000000"
            "Azul" -> return "#205375"
            "Rosa" -> return "#A64682"
            "Vermelho" -> return "#C31717"
            else -> return "#B6B6B6"
        }
    }
}

