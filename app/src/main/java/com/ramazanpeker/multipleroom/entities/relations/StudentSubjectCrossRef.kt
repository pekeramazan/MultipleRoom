package com.ramazanpeker.multipleroom.entities.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName","subjectName"])
data class StudentSubjectCrossRef(


    val studenName: String,
    val subjectName: String
)