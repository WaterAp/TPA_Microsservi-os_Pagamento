package univas.edu.br.si7.tpa.tabalho.Payment;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;


import univas.edu.br.si7.tpa.trabalho.Payment.dtos.PaymentDTO;
import univas.edu.br.si7.tpa.trabalho.Payment.entities.PaymentEntity;
import univas.edu.br.si7.tpa.trabalho.Payment.repositories.PaymentRepository;
import univas.edu.br.si7.tpa.trabalho.Payment.service.PaymentService;

public class PaymentServiceTest {

	private static PaymentService service;
	private static PaymentRepository repoMock;

	@BeforeAll
	public static void setup() {
		repoMock = Mockito.mock(PaymentRepository.class);
		service = new PaymentService(repoMock);
	}

	@Test
	void testGetAllPayments() {

		List<PaymentEntity> Payments = List.of(
				new PaymentEntity()
				);
		Mockito.when(repoMock.findAll()).thenReturn(Payments);

		List<PaymentDTO> allPayments = service.findAll();

		Mockito.verify(repoMock, Mockito.times(1)).findAll();

		assertNotNull(allPayments);
		assertEquals(1, allPayments.size());
	}

	@Test
	
	void testGetPaymentById() {
	    PaymentEntity p1 = new PaymentEntity();
	    p1.setId(1);
	    Mockito.when(repoMock.findById(1)).thenReturn(Optional.of(p1));
	    
	    PaymentEntity payment = service.findById(1); 
	    assertNotNull(payment);
	    assertEquals(1, payment.getId());
	}

	@Test
	public void testFindByActive() {
		fail("Not yet implemented");
	}
}

