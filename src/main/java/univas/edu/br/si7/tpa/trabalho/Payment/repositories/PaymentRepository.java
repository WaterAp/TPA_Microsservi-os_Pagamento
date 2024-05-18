package univas.edu.br.si7.tpa.trabalho.Payment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {
    List<PaymentEntity> findAllByActiveTrue(); // Retorna todos os pagamentos ativos
    Optional<PaymentEntity> findByIdAndActiveTrue(Integer id); // Retorna um pagamento por ID se estiver ativo
}