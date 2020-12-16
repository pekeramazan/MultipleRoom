package com.ramazanpeker.multipleroom

import androidx.room.*
import com.ramazanpeker.multipleroom.entities.Director
import com.ramazanpeker.multipleroom.entities.School
import com.ramazanpeker.multipleroom.entities.Student
import com.ramazanpeker.multipleroom.entities.Subject
import com.ramazanpeker.multipleroom.entities.relations.*

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossRef: StudentSubjectCrossRef)

    @Transaction
    @Query("SELECT*FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolName(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT*from subject WHERE subjectName= :subjectName")
    suspend fun getSchoolWithStudents(subjectName: String):List<SubjectWithStudents>

    @Transaction
    @Query("SELECT*FROM school WHERE schoolName = :schoolName")
    suspend fun getStudentsofSubject(schoolName:String):List<SchoolAndDirector>

    @Transaction
    @Query("SELECT*FROM student WHERE studentName = :studentName")
    suspend fun getSubjectOfStudent(studentName:String):List<StudentWithSubjects>
}