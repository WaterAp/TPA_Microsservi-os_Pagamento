package univas.edu.br.si7.tpa.trabalho.Payment.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import univas.edu.br.si7.tpa.trabalho.Payment.enums.PaymentStatus;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PaymentDTO {
	
	private int id;
	private String method;
	private Date dueDate;
	private float amount;
	private Date paidAt;
	private int transactionId;
	private Boolean active;
	private PaymentStatus status;
	
	
}
