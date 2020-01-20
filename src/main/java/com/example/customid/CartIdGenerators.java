package com.example.customid;

import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CartIdGenerators implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
				
				long Id = randomId();
		
				while (Id < 0) {
					
					Id = randomId();
					
				}
					
				return Id;
	}
	
	public long randomId() {
		return ThreadLocalRandom.current().nextLong();
	}

}
