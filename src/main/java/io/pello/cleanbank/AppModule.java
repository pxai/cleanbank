package io.pello.cleanbank;

import com.google.inject.AbstractModule;

public class AppModule extends AbstractModule {
	  @Override 
	  protected void configure() {
		    bind(io.pello.cleanbank.entity.gateway.UserEntityGateway.class)
    			.to(io.pello.cleanbank.external.entityrepository.UserEntityDAO.class);
		    bind(io.pello.cleanbank.boundaries.LoginBoundary.class)
		    		.to(io.pello.cleanbank.usecase.Login.class);
		    bind(io.pello.cleanbank.boundaries.UserDetailBoundary.class)
    			.to(io.pello.cleanbank.usecase.UserDetail.class);
		    bind(io.pello.cleanbank.boundaries.DepositMoneyBoundary.class)
				.to(io.pello.cleanbank.usecase.DepositMoney.class);
		    bind(io.pello.cleanbank.boundaries.WithdrawMoneyBoundary.class)
				.to(io.pello.cleanbank.usecase.WithdrawMoney.class);
		    bind(io.pello.cleanbank.entity.gateway.AccountEntityGateway.class)
					.to(io.pello.cleanbank.external.entityrepository.AccountEntityDAO.class);

	  }
}