package ua.com.advocatus.data.source.remote

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import ua.com.advocatus.data.Lawyer
import ua.com.advocatus.data.source.LawyersDataSource


/**
 * @author il_mov.
 */
class LawyerRemoteDataSource : LawyersDataSource {

    private val database: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val collectionReference: CollectionReference

    init {
        collectionReference = database.collection("lawyers")
    }

    override fun getLawyers(loadLawyersCallback: LawyersDataSource.LoadLawyersCallback) {
        collectionReference.get().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                val lawyerList = task.result.toObjects(Lawyer::class.java)
                loadLawyersCallback.onLawyersLoaded(lawyerList)
            } else {
                loadLawyersCallback.onLawyersLoadedError()
            }
        }
    }
}