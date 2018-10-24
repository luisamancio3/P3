package br.cesed.si.p3.fila;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class FilaTest {

	private Fila fila;
	private Conta conta1 = new Conta(1,1,"a");
	private Conta conta2 = new Conta(2,2,"b");
	private Conta conta3 = new Conta(3,3,"c");
	
	@BeforeEach
	void setUp() {
		fila = new Fila();
	}
	
	@Test
	void adicionarContaTest() throws ContaInvalidaException, FilaVaziaException {
		fila.enqueue(conta1);
		fila.enqueue(conta2);
		fila.enqueue(conta3);
		
		Assert.assertEquals(conta1, fila.front());
	}
	
	@Test
	void adicionarContaInvalidaTest() {
		Assertions.assertThrows(ContaInvalidaException.class, ()-> {
			fila.enqueue(null);
		});
	}
	
	@Test
	void removerContaTest() throws ContaInvalidaException, FilaVaziaException {
		fila.enqueue(conta1);
		fila.enqueue(conta2);
		fila.enqueue(conta3);
		
		fila.dequeue();
		
		Assert.assertEquals(conta2, fila.front());
	}
	
	@Test
	void removerFilaVaziaTest() {
		Assertions.assertThrows(FilaVaziaException.class, ()-> {
			fila.dequeue();
		});
	}
	
	@Test
	void topFilaVaziaTest() {
		Assertions.assertThrows(FilaVaziaException.class, ()-> {
			fila.front();
		});
	}
	
	@Test
	void tamanhoTest() throws ContaInvalidaException, FilaVaziaException {
		fila.enqueue(conta1);
		fila.enqueue(conta2);
		fila.enqueue(conta3);
		
		Assert.assertEquals(3, fila.size());
		
		fila.dequeue();
		Assert.assertEquals(2, fila.size());
	}
	
	@Test
	void filaVaziaTest() throws ContaInvalidaException {
		Assert.assertEquals(true, fila.isEmpyt());
		
		fila.enqueue(conta1);
		Assert.assertEquals(false, fila.isEmpyt());
	}
}
