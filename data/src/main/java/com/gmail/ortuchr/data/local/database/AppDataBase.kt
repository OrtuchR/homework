package com.gmail.ortuchr.data.local.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.gmail.ortuchr.data.local.dao.StudentDao
import com.gmail.ortuchr.data.local.entity.StudentDb

@Database(entities = [StudentDb::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    companion object {
        const val DB_NAME = "randomName"

        fun getDatabase(context: Context): AppDataBase {
            return Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    DB_NAME)
                    .fallbackToDestructiveMigration()
                    .build()
        }
    }

    abstract fun getStudentDao(): StudentDao
}