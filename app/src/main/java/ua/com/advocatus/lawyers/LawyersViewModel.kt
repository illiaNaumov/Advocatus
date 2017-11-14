package ua.com.advocatus.lawyers

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import ua.com.advocatus.data.source.LawyersRepository

/**
 * @author il_mov.
 */
class LawyersViewModel(application: Context,
                       lawyerRepository: LawyersRepository) : AndroidViewModel(application as Application) {

}