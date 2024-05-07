package univas.edu.br.si7.tpa.tabalho.Payment.util;


import org.springframework.stereotype.Component;

import univas.edu.br.si7.tpa.tabalho.Payment.dtos.PaymentDTO;
import univas.edu.br.si7.tpa.tabalho.Payment.entities.PaymentEntity;

@Component
public class PaymentEntityConverter {
	public static PaymentDTO toDTO(PaymentEntity payment) {
		return new PaymentDTO(
				payment.getId(), payment.getMethod(), 
				payment.getDueDate(), payment.getAmount(), payment.getPaidAt(),
				payment.getTransactionId());
	}
	
	public PaymentEntity toEntity(PaymentDTO paym) {
		System.out.println("toEntity: " + paym);
		return new PaymentEntity(paym.getId(), paym.getMethod(), 
				paym.getDueDate(), paym.getAmount(), paym.getPaidAt(),
				paym.getTransactionId());
	}
}
