package com.example.assignment14.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.assignment14.model.StudentModel
import com.example.assignment14.utils.Constants

@Database(entities = [StudentModel::class], version = 1)
abstract class RoomInstance : RoomDatabase() {

    abstract fun getStudentDao() : StudentDao

    companion object{
        @Volatile
        private var instance: RoomInstance? = null
        fun getDatabase(ctx: Context): RoomInstance? {
            if (instance == null) {
                instance = Room.databaseBuilder(ctx, RoomInstance::class.java,Constants.DATABASE_NAME)
                        .build()
            }
            return instance
        }
    }

}