package fr.emse.test;

import java.util.Vector;

public class MoneyBag implements IMoney {
	private Vector<Money> fMonies = new Vector<Money>();
	
	MoneyBag(Money m1, Money m2) {
		appendMoney(m1);
		appendMoney(m2);
	}
	
	MoneyBag(Money bag[]) {
		for (int i = 0; i < bag.length; i++)
		appendMoney(bag[i]);
	}
	
	private void appendMoney(Money m) {
		if (fMonies.isEmpty()) {
			fMonies.add(m);
		} else {
			int i = 0;
			while ((i < fMonies.size()) && (!(fMonies.get(i).currency().equals(m.currency()))))
				i++;
			if (i >= fMonies.size()) {
				fMonies.add(m);
			} else {
				fMonies.set(i, new Money(fMonies.get(i).amount() +
							m.amount(),
							m.currency()));
				if(fMonies.get(i).amount() == 0) fMonies.remove(i);
			}
		}
	}
	
	public IMoney add(IMoney m) {
		return m.addMoneyBag(this);
	}
	
	public IMoney addMoney(Money m) {
        appendMoney(m);
        if(fMonies.size() == 1) return fMonies.get(0);
        else return this;
    }

    public IMoney addMoneyBag(MoneyBag m) {
        for(Money money : m.fMonies) {
        	appendMoney(money);
        }
        return this;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoneyBag other = (MoneyBag) obj;
		if (fMonies == null) {
			if (other.fMonies != null)
				return false;
		} else {
			boolean found = true;
			for(Money m1 : fMonies) {
				found = false;
				for(Money m2 : other.fMonies) {
					if(m1.equals(m2)) {
						found = true;
						break;
					}
				}
				if(!found) return false; 
			}
		}
		return true;
	}
}