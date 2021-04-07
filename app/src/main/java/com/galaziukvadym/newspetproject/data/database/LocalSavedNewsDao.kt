package com.galaziukvadym.newspetproject.data.database

import androidx.room.*
import com.galaziukvadym.newspetproject.data.database.LocalSavedNewsDatabase.Companion.LOCAL_SAVED_NEWS_TABLE_NAME
import io.reactivex.Observable

@Dao
interface LocalSavedNewsDao {

    @Query("Select * from $LOCAL_SAVED_NEWS_TABLE_NAME")
    fun getAll(): Observable<List<NewsDatabaseDto>>

    @Query("Delete from $LOCAL_SAVED_NEWS_TABLE_NAME")
    fun clearAll()

    @Insert
    fun addAll(newsDtos: List<NewsDatabaseDto>)
}

@Entity(tableName = LOCAL_SAVED_NEWS_TABLE_NAME)
data class NewsDatabaseDto(
    @PrimaryKey(autoGenerate = true) val newsId: Int = 0,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "url_path") val urlPath: String,
    @ColumnInfo(name = "url_image") val urlImage: String,
    @ColumnInfo(name = "content") val content: String,
)