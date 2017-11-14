package ua.com.advocatus

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context
import ua.com.advocatus.data.source.LawyersRepository
import ua.com.advocatus.lawyers.LawyersViewModel

/**
 * @author il_mov.
 */
class ViewModelFactory(private val application: Context,
                       private val lawyerRepository: LawyersRepository) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel?> create(modelClass: Class<T>): T  {
        if (modelClass.isAssignableFrom(LawyersViewModel::class.java)) {
            return LawyersViewModel(application, lawyerRepository) as T
        }

        return super.create(modelClass)
    }
}