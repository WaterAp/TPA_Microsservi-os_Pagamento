package univas.edu.br.si7.tpa.trabalho.Payment.enums;

public enum PaymentEnum {
	 PENDING(0),
     PAID(1),
     CANCELED(2);

	private final int value;

	PaymentEnum(final int newValue) {
         value = newValue;
     }

     public int getValue() { return value; }
}
