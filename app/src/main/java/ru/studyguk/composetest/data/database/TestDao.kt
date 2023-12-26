package ru.studyguk.composetest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.studyguk.composetest.data.models.Question
import ru.studyguk.composetest.data.models.Test

@Dao
interface TestDao {
    @Query("SELECT * FROM question WHERE testName == :testName")
    suspend fun getQueList(testName: String): List<Question>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTest(test: Test)

    @Query("SELECT name FROM test ORDER BY name")
    suspend fun getCatalog(): List<String>
}