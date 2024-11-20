package pl.alonurt.formexcerciseserver.service

import org.springframework.stereotype.Service
import pl.alonurt.formexcerciseserver.model.Student
import java.util.concurrent.ConcurrentHashMap

@Service
data class StudentService(
    val studentMap: MutableMap<String, Student> = ConcurrentHashMap()

) {
    fun addStudent(student: Student) {
        studentMap[student.email] = student
    }

    fun getAllStudents(): List<Student> {
        return studentMap.values.toList().sortedBy { it.email }
    }

    fun removeStudent(email: String) {
        studentMap.remove(email)
    }
}