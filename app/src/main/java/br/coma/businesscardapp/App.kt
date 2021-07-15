package br.coma.businesscardapp

import android.app.Application
import br.coma.businesscardapp.data.AppDatabase
import br.coma.businesscardapp.data.BusinessCardRepository

class App: Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }

}