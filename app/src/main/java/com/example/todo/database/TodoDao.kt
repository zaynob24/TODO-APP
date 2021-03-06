package com.example.todo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.todo.database.model.CategoryModel
import com.example.todo.database.model.TasksModel
import com.example.todo.database.model.relations.CategoryModelWithTasksModel


@Dao
interface TodoDao {

    @Insert
    suspend fun addTask(tasksModel: TasksModel)

    @Query("SELECT * FROM tasksmodel WHERE isDone = :done")
    //LiveData -> to make data  updated or refreshed if there is changes
    fun getTask(done: Boolean): LiveData<List<TasksModel>>

    @Update
    suspend fun updateTask(tasksModel: TasksModel)

    @Delete
    suspend fun deleteTask(tasksModel: TasksModel)


    @Query("SELECT * FROM tasksmodel  WHERE isDone = :done")
    //LiveData -> to make data  updated or refreshed if there is changes
    fun getCompletedTask(done: Boolean): LiveData<List<TasksModel>>


    // For category

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCategory(categoryModel: CategoryModel)

    @Query("SELECT * FROM CategoryModel")
    //LiveData -> to make data  updated or refreshed if there is changes
    fun getCategory(): LiveData<List<CategoryModel>>

    @Transaction
    @Query("SELECT * FROM tasksmodel  WHERE categoryName = :category")
    //LiveData -> to make data  updated or refreshed if there is changes
    fun getCategoryWithTasks(category: String): LiveData<List<CategoryModelWithTasksModel>>

}