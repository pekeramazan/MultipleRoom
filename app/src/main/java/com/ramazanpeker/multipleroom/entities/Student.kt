package com.ramazanpeker.multipleroom.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(

    @PrimaryKey
    val studentName: String,
    val semester: Int,
    val schoolName: String


)