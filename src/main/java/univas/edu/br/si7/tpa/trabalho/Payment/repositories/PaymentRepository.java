package univas.edu.br.si7.tpa.trabalho.Payment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer>{
	public List<PaymentEntity> findAll();
	
}
