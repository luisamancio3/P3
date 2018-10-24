package br.cesed.si.p3.deque;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class DequeTest {
	
	private Deque deque;
	private Conta conta1 = new Conta(1,1,"a");
	private Conta conta2 = new Conta(2,2,"b");
	private Conta conta3 = new Conta(3,3,"c");

	@BeforeEach
	void setUp() {
		deque = new Deque();
	}
	
	@Test
	void inserirNaPrimeiroPosicaoTest() throws ContaInvalidaException {
		deque.insertFirst(conta1);
		deque.insertFirst(conta2);
		deque.insertFirst(conta3);
		
		Assert.assertEquals(conta3, deque.getItem(0));
	}
	
	@Test
	void inserirNaUltimaPosicaoTest() throws ContaInvalidaException{
		deque.insertLast(conta1);
		deque.insertLast(conta2);
		deque.insertLast(conta3);
		
		Assert.assertEquals(conta3, deque.getItem(deque.size() - 1));
	}
	
	@Test
	void removerPrimeiroPosicaoTest() throws ContaInvalidaException, DequeVazioException {
		deque.insertFirst(conta1);
		deque.insertFirst(conta2);
		deque.insertFirst(conta3);
		
		deque.removeFirst();
		
		Assert.assertEquals(conta2, deque.getItem(0));
		Assert.assertEquals(2, deque.size());
	}
	
	@Test
	void removerUltimaPosicaoTest() throws ContaInvalidaException, DequeVazioException {
		deque.insertLast(conta1);
		deque.insertLast(conta2);
		deque.insertLast(conta3);
		
		deque.removeLast();
		
		Assert.assertEquals(2, deque.size());
	}
	
	@Test
	void removerPorPosicaoTest() throws ContaInvalidaException, PosicaoInvalidaException {
		deque.insertFirst(conta1);
		deque.insertFirst(conta2);
		deque.insertFirst(conta3);
		
		deque.removeByIndex(1);
		
		Assert.assertEquals(conta1, deque.getItem(deque.size() - 1));
		Assert.assertEquals(2, deque.size());
	}
	
	@Test
	void removerPorObjetoTest() throws ContaInvalidaException, PosicaoInvalidaException {
		deque.insertFirst(conta1);
		deque.insertFirst(conta2);
		deque.insertFirst(conta3);
	
		deque.removeByValue(conta2);
		Assert.assertEquals(conta1, deque.getItem(deque.size() - 1));
		Assert.assertEquals(conta3, deque.getItem(0));
		Assert.assertEquals(2, deque.size());
	}
	
	@Test
	void tamanhoTest() throws ContaInvalidaException {
		deque.insertFirst(conta1);
		deque.insertFirst(conta2);
		deque.insertFirst(conta3);
		
		Assert.assertEquals(3, deque.size());
	}
	
	@Test
	void inserirContaInvalidaTest() {
		Assertions.assertThrows(ContaInvalidaException.class, ()-> {
			deque.insertFirst(null);
			deque.insertLast(null);
		});
	}
	
	@Test
	void removerPosicaoInvalidaTest() {
		Assertions.assertThrows(PosicaoInvalidaException.class, ()-> {
			deque.removeByIndex(2);
			deque.removeByIndex(-5);
		});
	}
	
	@Test
	void removerPorContaInvalida() {
		Assertions.assertThrows(ContaInvalidaException.class, ()->{
			deque.removeByValue(null	);
		});
	}
	
	@Test 
	void removerComArrayVazioTest(){
		Assertions.assertThrows(DequeVazioException.class, ()-> {
			deque.removeFirst();
			deque.removeLast();
		});
	}
}
