package pl.alonurt.formexcerciseserver.repository.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "BANK_CLIENT")
data class BankClient(@Id val id: Int? = null, val firstName: String, val lastName: String, val address: String, val city: String, val postalCode: String, val phone: String?, val email: String?, val pesel: String)
