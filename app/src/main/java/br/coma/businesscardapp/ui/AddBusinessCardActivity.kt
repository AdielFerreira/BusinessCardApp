package br.coma.businesscardapp.ui


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import br.coma.businesscardapp.R



class AddBusinessCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_business_card)
        insertListenners()
    }

    private fun insertListenners() {
        findViewById<ImageButton>(R.id.btn_close).setOnClickListener {
            this.finish()
        }
    }
}