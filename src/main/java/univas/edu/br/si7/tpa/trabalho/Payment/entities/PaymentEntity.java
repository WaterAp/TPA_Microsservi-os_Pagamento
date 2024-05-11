package univas.edu.br.si7.tpa.trabalho.Payment.entities;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "Payments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity{
	
	@Id
	private Integer id;
	private String method;
	private Date dueDate;
	private float amount;
	private Date paidAt;
	private int transactionId;
	


}
