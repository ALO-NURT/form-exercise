package pl.alonurt.formexcerciseserver.repository

import org.springframework.data.repository.CrudRepository
import pl.alonurt.formexcerciseserver.repository.entity.BankClient

interface BankClientRepository : CrudRepository<BankClient, Int> {
}