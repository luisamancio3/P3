package br.cesed.si.p3.pilha;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

class PilhaTest {

	private Pilha pilha;
	private Conta conta1 = new Conta(1,1,"a");
	private Conta conta2 = new Conta(2,2,"b");
	private Conta conta3 = new Conta(3,3,"c");
	
	@BeforeEach
	void setUp() {
		pilha = new Pilha();
	}
	
	@Test
	void adicionarContaTest() throws ContaInvalidaException, arrayVazioException {
		pilha.push(conta1);
		pilha.push(conta2);
		pilha.push(conta3);
		
		Assert.assertEquals(conta3, pilha.top());
	}
	
	@Test
	void adicionarContaInvalidaTest() {
		Assertions.assertThrows(ContaInvalidaException.class, ()-> {
			pilha.push(null);
		});
	}
	
	@Test
	void removerContaTest() throws ContaInvalidaException, arrayVazioException {
		pilha.push(conta1);
		pilha.push(conta2);
		pilha.push(conta3);
		
		pilha.pop();
		
		Assert.assertEquals(conta2, pilha.top());
	}
	
	@Test
	void removerArrayVazioTest() {
		Assertions.assertThrows(arrayVazioException.class, ()->{
			pilha.pop();
		});
	}
	
	@Test
	void topComArrayVazioTest() {
		Assertions.assertThrows(arrayVazioException.class, ()-> {
			pilha.top();
		});
	}
	
	@Test
	void tamanhoTest() throws ContaInvalidaException, arrayVazioException {
		pilha.push(conta1);
		pilha.push(conta2);
		pilha.push(conta3);
		
		Assert.assertEquals(3, pilha.size());
		
		pilha.pop();
		pilha.pop();
		pilha.pop();
		
		Assert.assertEquals(0, pilha.size());
	}
	
	@Test
	void vazioTest() throws ContaInvalidaException {
		Assert.assertEquals(true, pilha.isEmpyt());
		pilha.push(conta1);
		Assert.assertEquals(false, pilha.isEmpyt());
	}
}
