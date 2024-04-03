package fr.emse.test;

public class Money {
	private int fAmount;
	private String fCurrency;
	
	public Money(int amount, String currency) {
		fAmount = amount;
		fCurrency = currency;
	}
	
	public int amount() {
		return fAmount;
	}
	
	public String currency() {
		return fCurrency;
	}
	
	public Money add(Money m) {
		return new Money(amount() + m.amount(), currency());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Money other = (Money) obj;
		if (fAmount != other.fAmount)
			return false;
		if (fCurrency == null) {
			if (other.fCurrency != null)
				return false;
		} else if (!fCurrency.equals(other.fCurrency))
			return false;
		return true;
	}
}