package univas.edu.br.si7.tpa.trabalho.Payment;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;
import univas.edu.br.si7.tpa.trabalho.Payment.enums.PaymentStatus;
import univas.edu.br.si7.tpa.trabalho.Payment.repositories.PaymentRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaymentApplication implements CommandLineRunner {
	
	@Autowired
	private PaymentRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(PaymentApplication.class, args);
		
	}
	
	@Override
	public void run(String... args) throws Exception {
		PaymentEntity p1 = new PaymentEntity(1, "Cartão", new Date(), 7.30f, null, 1, true, PaymentStatus.PENDING);
		repo.save(p1);
		
		
		List<PaymentEntity> payments = repo.findAll();
		System.out.println(payments);
	}

}
