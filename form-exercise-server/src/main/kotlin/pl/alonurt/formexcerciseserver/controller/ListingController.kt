package pl.alonurt.formexcerciseserver.controller

import org.springframework.http.MediaType
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import pl.alonurt.formexcerciseserver.model.Student
import pl.alonurt.formexcerciseserver.service.StudentService

@Controller
@RequestMapping("/")
data class ListingController(
    val studentService: StudentService
) {

    @CrossOrigin
    @PostMapping("add", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE, MediaType.APPLICATION_JSON_VALUE])
    fun addStudent(student: Student): String {
        studentService.addStudent(student)
        return "redirect:/list"
    }

    @GetMapping("list")
    fun listStudents(model: Model): String {
        model.addAttribute("students", studentService.getAllStudents())
        return "listStudents"
    }

    @GetMapping("delete/{email}")
    fun deleteStudent(@PathVariable("email") email: String?): String {
        studentService.removeStudent(email!!)
        return "redirect:/list"
    }
}