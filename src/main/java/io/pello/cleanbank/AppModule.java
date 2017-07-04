package io.pello.cleanbank;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
	  @Override 
	  protected void configure() {
		    bind(io.pello.cleanbank.entity.gateway.UserEntityGateway.class)
    			.to(io.pello.cleanbank.external.entityrepository.UserEntityDAO.class);
		    bind(io.pello.cleanbank.boundaries.LoginBoundary.class)
		    		.to(io.pello.cleanbank.usecase.Login.class);
		    
		    bind(io.pello.cleanbank.entity.gateway.AccountEntityGateway.class)
					.to(io.pello.cleanbank.external.entityrepository.AccountEntityDAO.class);
		    bind(io.pello.cleanbank.boundaries.SeeDepositBoundary.class)
    				.to(io.pello.cleanbank.usecase.SeeDeposit.class);

	  }
}