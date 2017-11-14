package ua.com.advocatus.lawyers

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import ua.com.advocatus.ViewModelFactory
import ua.com.advocatus.advocatus.R
import ua.com.advocatus.data.Lawyer
import ua.com.advocatus.data.source.LawyersDataSource
import ua.com.advocatus.data.source.LawyersRepository

class LawyersActivity : AppCompatActivity(), LawyersDataSource.LoadLawyersCallback {
    override fun onLawyersLoaded(lawyers: List<Lawyer>) {
        for(lawyer in lawyers){
            Log.d("LOADED", "Lawyer->${lawyer.name}")
        }
    }

    override fun onLawyersLoadedError() {
    }

    private lateinit var lawyersRepository: LawyersRepository

    lateinit var viewModelFactory: ViewModelFactory

    private lateinit var lawyersViewModel: LawyersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lawyersRepository = LawyersRepository()
        lawyersRepository.getLawyers(this)

        viewModelFactory = ViewModelFactory(application, lawyersRepository)

        obtainViewModel()
    }

    private fun obtainViewModel() {
        lawyersViewModel = viewModelFactory.create(LawyersViewModel::class.java)
    }
}
