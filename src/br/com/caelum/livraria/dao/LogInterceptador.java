package br.com.caelum.livraria.dao;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LogInterceptador {
	
	@AroundInvoke
	public Object intercepta(InvocationContext context) throws Exception {
		System.out.println("**** LOG para " 
							+ context.getTarget().getClass().getSimpleName() 
							+ ", " + context.getMethod().getName());
		
		long millis = System.currentTimeMillis();
		
		Object retorno = context.proceed();
		
		long duracao = System.currentTimeMillis() - millis;
		
		System.out.println("**** Duracao: " + duracao);
	
		return retorno;
	}

}
