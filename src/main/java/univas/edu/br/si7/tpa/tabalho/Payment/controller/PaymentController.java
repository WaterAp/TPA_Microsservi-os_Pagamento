package univas.edu.br.si7.tpa.tabalho.Payment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import univas.edu.br.si7.tpa.tabalho.Payment.dtos.PaymentDTO;
import univas.edu.br.si7.tpa.tabalho.Payment.entities.PaymentEntity;
import univas.edu.br.si7.tpa.tabalho.Payment.service.PaymentService;
import univas.edu.br.si7.tpa.tabalho.Payment.util.PaymentEntityConverter;


@RestController
@RequestMapping("/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService service;
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<PaymentDTO> getAllPayments() {
		return service.findAll();
	}
	
	@GetMapping("/{code}")
	public PaymentDTO getPaymentById(@PathVariable Integer id) {
		PaymentEntity entity = service.findById(id);
		return PaymentEntityConverter.toDTO(entity);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createProduct(@RequestBody PaymentDTO payment) {
		service.createPayment(payment);
	}
	
	@PutMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updatePayment(@RequestBody PaymentDTO dto, @PathVariable Integer id) {
		service.updatePayment(dto, id);
	}
	
	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletePayment(@PathVariable Integer id) {
		service.deletePayment(id);
	}
	

}
