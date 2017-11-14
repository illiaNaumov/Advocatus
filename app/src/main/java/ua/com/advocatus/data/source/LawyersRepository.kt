package ua.com.advocatus.data.source

import android.support.annotation.NonNull
import ua.com.advocatus.data.source.remote.LawyerRemoteDataSource

/**
 * @author il_mov.
 */
class LawyersRepository(private val lawyerRemoteDataSource: LawyerRemoteDataSource = LawyerRemoteDataSource()) : LawyersDataSource {

    override fun getLawyers(@NonNull loadLawyersCallback: LawyersDataSource.LoadLawyersCallback) {
        lawyerRemoteDataSource.getLawyers(loadLawyersCallback)
    }
}