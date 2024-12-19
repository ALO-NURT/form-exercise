package pl.alonurt.formexcerciseserver.service

import org.springframework.stereotype.Service
import pl.alonurt.formexcerciseserver.repository.BankClientRepository
import pl.alonurt.formexcerciseserver.repository.entity.BankClient

@Service
data class BankClientService(
    val bankClientRepository: BankClientRepository
) {
    fun getAllBankClients(): Iterable<BankClient> = bankClientRepository.findAll()
}