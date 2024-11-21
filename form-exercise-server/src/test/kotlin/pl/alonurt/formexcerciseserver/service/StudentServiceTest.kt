package pl.alonurt.formexcerciseserver.service

import org.assertj.core.api.Assertions.assertThat
import pl.alonurt.formexcerciseserver.model.Student
import kotlin.test.BeforeTest
import kotlin.test.Test

class StudentServiceTest {
    private lateinit var studentService: StudentService

    @BeforeTest
    fun setUp() {
        studentService = StudentService()
    }

    @Test
    fun `should get no students when no students added`() {
        // given
        // when
        val students = studentService.getAllStudents()
        // then
        assertThat(students).isEmpty()
    }

    @Test
    fun `should add student`() {
        // given
        val student = Student("email1@m.com", "John", "Doe", 1)
        studentService.addStudent(student)
        // when
        val students = studentService.getAllStudents()
        // then
        assertThat(students).hasSize(1).containsExactly(student)
    }

    @Test
    fun `should remove student`() {
        // given
        val student = Student("email1@m.com", "John", "Doe", 1)
        studentService.addStudent(student)
        // when
        studentService.removeStudent(student.email)

        val students = studentService.getAllStudents()
        // then
        assertThat(students).isEmpty()
    }

    @Test
    fun `should get all students sorted by email`() {
        // given
        val student1 = Student("smail@m.pl", "John", "Doe", 1)
        val student2 = Student("amail@d.com", "Jane", "Doe", 2)
        val student3 = Student("azail@foo.com", "Alice", "Doe", 3)
        val student4 = Student("agail@foo.com", "John", "Smith", 4)
        studentService.addStudent(student1)
        studentService.addStudent(student2)
        studentService.addStudent(student3)
        studentService.addStudent(student4)
        // when
        val students = studentService.getAllStudents()
        // then
        assertThat(students).hasSize(4).containsExactly(student4, student2, student3, student1)
    }
}