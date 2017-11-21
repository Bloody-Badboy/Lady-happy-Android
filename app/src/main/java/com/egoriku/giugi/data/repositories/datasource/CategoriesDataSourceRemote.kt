package com.egoriku.giugi.data.repositories.datasource

import com.egoriku.giugi.data.entities.CategoriesEntity
import com.egoriku.giugi.firebase.RxFirestore
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import javax.inject.Inject
import io.reactivex.Observable

class CategoriesDataSourceRemote
@Inject constructor(private val firebaseFirestore: FirebaseFirestore)
    : BaseFirebaseDataSource() {

    private var query: Query? = null

    private fun getCategoriesReference(): Query? {
        if (query == null) {
            query = firebaseFirestore
                    .collection(COLLECTION_KEY_CATEGORIES)
                    .orderBy("id", Query.Direction.ASCENDING)
        }

        return query
    }

    fun getCategories(): Observable<List<Class<CategoriesEntity>>>? =
            getCategoriesReference()?.let {
                RxFirestore.getObservable(it, CategoriesEntity::class.java)
            }
}