package com.ramazanpeker.multipleroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.ramazanpeker.multipleroom.entities.Student
import com.ramazanpeker.multipleroom.entities.Subject


data class SubjectWithStudents(

    @Embedded val subject: Subject,
    @Relation(
        parentColumn = "subjectName",
        entityColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val students:List<Student>
)