package univas.edu.br.si7.tpa.trabalho.Payment.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;

//@Repository
public interface PaymentRepository extends MongoRepository<PaymentEntity, Integer>{
	Optional<PaymentEntity> findAll (int number);
	
}
