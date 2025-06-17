package com.pronote.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.pronote.app.data.repository.NoteRepository
import com.pronote.app.ui.navigation.RootNavHost
import com.pronote.app.ui.screens.HomeScreen
import com.pronote.app.ui.theme.ProNoteTheme
import com.pronote.app.utils.DatabaseProvider
import com.pronote.app.viewmodel.MainViewModelFactory
import com.pronote.app.viewmodel.MainViewmodel
import kotlin.getValue

class MainActivity : ComponentActivity() {
    private lateinit var viewModel: MainViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val dao = DatabaseProvider.getDatabase(applicationContext).noteDao()
        val repository = NoteRepository(dao)
        val factory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory)[MainViewmodel::class.java]



        setContent {
            ProNoteTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    RootNavHost(navHostController = navController, mainViewmodel = viewModel)
                }
            }
        }

    }
}


