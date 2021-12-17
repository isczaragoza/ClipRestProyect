package com.example.cliprestproyect.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cliprestproyect.core.Converters
import com.example.cliprestproyect.data.dao.NameDao
import com.example.cliprestproyect.data.dao.PictureDao
import com.example.cliprestproyect.data.dao.ResultsDao
import com.example.cliprestproyect.data.model.Name
import com.example.cliprestproyect.data.model.Picture
import com.example.cliprestproyect.data.model.Results

@Database(entities = arrayOf(Results::class, Picture::class, Name::class), version = 1, exportSchema = false)
@TypeConverters(Converters::class)
abstract class RoomDb : RoomDatabase() {

    abstract fun resultsDao(): ResultsDao;
    abstract fun pictureDao(): PictureDao;
    abstract fun nameDao(): NameDao;

    companion object {
        private var INSTANCE: RoomDb? = null;

        fun getDatabase(context: Context): RoomDb {
            if (INSTANCE == null) {
                synchronized(RoomDb::class) {
                    INSTANCE =
                        Room.databaseBuilder(
                            context.applicationContext,
                            RoomDb::class.java,
                            "roomdb"
                        ).fallbackToDestructiveMigration()
                            .build()
                }
            }
            return INSTANCE!!;
        }
    }

}