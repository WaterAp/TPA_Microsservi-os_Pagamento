package univas.edu.br.si7.tpa.trabalho.Payment.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import univas.edu.br.si7.tpa.trabalho.Payment.dtos.PaymentDTO;
import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;
import univas.edu.br.si7.tpa.trabalho.Payment.repositories.PaymentRepository;
import univas.edu.br.si7.tpa.trabalho.Payment.support.ObjectNotFoundException;
import univas.edu.br.si7.tpa.trabalho.Payment.support.PaymentException;
import univas.edu.br.si7.tpa.trabalho.Payment.util.PaymentEntityConverter;

@Service
public class PaymentService {
	
	private PaymentRepository repo;
	
	@Autowired
	private PaymentEntityConverter converter;
	
	@Autowired
	public PaymentService(PaymentRepository repo) {
		this.repo = repo;
	}
	
	
	public List<PaymentDTO> findAll() {
		return repo.findAll().stream().map(PaymentEntityConverter::toDTO) // usando lambda para converter os objetos
				.collect(Collectors.toList());
	}
	
	public PaymentEntity findById(Integer id) {
		Optional<PaymentEntity> obj = repo.findById(id);
		PaymentEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id));
		return entity;
	}
	
	public void createPayment(PaymentDTO payment) {
		repo.save(converter.toEntity(payment));
	}
	
	public void updatePayment(PaymentDTO payment, Integer id) {
		if (id == null || payment == null || !id.equals(payment.getId())) {
			throw new PaymentException("Invalid payment Id.");
		}
		PaymentEntity existingObj = findById(id);
		updateData(existingObj, payment);
		repo.save(existingObj);
	}
	
	private void updateData(PaymentEntity existingObj, PaymentDTO newObj) {
		existingObj.setMethod(newObj.getMethod());
		//Pode haver mais atualizações de campo
	}
	
	public void deletePayment(Integer id) {
		if (id == null) {
			throw new PaymentException("Payment Id can not be null.");
		}
		PaymentEntity obj = findById(id);
		try {
			repo.delete(obj);
			
		} catch (DataIntegrityViolationException e) {
			throw new PaymentException("Can not delete a Payment with dependencies constraints.");
		}
	}
	
}
