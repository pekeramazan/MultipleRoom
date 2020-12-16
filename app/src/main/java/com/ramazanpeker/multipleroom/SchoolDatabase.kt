package com.ramazanpeker.multipleroom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ramazanpeker.multipleroom.entities.Director
import com.ramazanpeker.multipleroom.entities.School
import com.ramazanpeker.multipleroom.entities.Student
import com.ramazanpeker.multipleroom.entities.Subject
import com.ramazanpeker.multipleroom.entities.relations.StudentSubjectCrossRef

@Database(
    entities = [
        School::class,
        Student::class,
        Director::class,
        Subject::class,
        StudentSubjectCrossRef::class
    ],
version=1
)
abstract class SchoolDatabase:RoomDatabase (){
    abstract  val schoolDao:SchoolDao
    companion object{
        @Volatile
        private var INSTANCE:SchoolDatabase?=null

        fun getInstance(context: Context):SchoolDatabase{
            synchronized(this){
                return INSTANCE?: Room.databaseBuilder(
                    context.applicationContext,
                    SchoolDatabase::class.java,
                    "school_db"
                ).build().also {
                    INSTANCE=it
                }
            }
        }
    }
}