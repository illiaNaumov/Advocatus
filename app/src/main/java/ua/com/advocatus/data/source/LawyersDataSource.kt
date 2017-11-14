package ua.com.advocatus.data.source

import android.support.annotation.NonNull
import ua.com.advocatus.data.Lawyer

/**
 * @author il_mov.
 */
interface LawyersDataSource {

    interface LoadLawyersCallback {
        fun onLawyersLoaded(lawyers: List<Lawyer>)
        fun onLawyersLoadedError()
    }

    fun getLawyers(@NonNull loadLawyersCallback: LoadLawyersCallback)
}