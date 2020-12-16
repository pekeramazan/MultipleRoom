package com.ramazanpeker.multipleroom.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.ramazanpeker.multipleroom.entities.School
import com.ramazanpeker.multipleroom.entities.Student

data class SchoolWithStudents (
    @Embedded val school: School,
    @Relation(
        parentColumn = "schoolName",
        entityColumn = "schoolName"
    )
    val students:List<Student>


        )