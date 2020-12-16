package com.ramazanpeker.multipleroom.entities.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.ramazanpeker.multipleroom.entities.Student
import com.ramazanpeker.multipleroom.entities.Subject

data class StudentWithSubjects(

    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn = "subjectName",
        associateBy = Junction(StudentSubjectCrossRef::class)
    )
    val subjects:List<Subject>
)