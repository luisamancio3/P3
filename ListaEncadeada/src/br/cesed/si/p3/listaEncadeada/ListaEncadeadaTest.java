package br.cesed.si.p3.listaEncadeada;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.Assert;

class ListaEncadeadaTest {

	private ListaEncadeada lista;
	private Conta conta1 = new Conta(1,1,"a");
	private Conta conta2 = new Conta(2,2,"b");
	private Conta conta3 = new Conta(3,3,"c");
	
	@BeforeEach
	void setUp() {
		lista = new ListaEncadeada();
	}
	
	@Test
	void tamanhoTeste() throws ContaInvalidaException {
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		
		Assert.assertEquals(3, lista.tamanho());
	}
	
	@Test
	void ItemInvalidoTest() {
		Assertions.assertThrows(ContaInvalidaException.class, () -> {
			lista.adicionar(null);
		});
	}
	
	@Test
	void getItensPorPosicaoTest() throws ContaInvalidaException, PosicaoInvalidaException {
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		
		Assert.assertEquals(conta1, lista.get(0));
		Assert.assertEquals(conta2, lista.get(1));
		Assert.assertEquals(conta3, lista.get(2));
	}
	
	@Test
	void getPosicaoInvalidaTest() throws ContaInvalidaException {

		Assertions.assertThrows(PosicaoInvalidaException.class, ()-> {
			lista.get(-1);
		});
		
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		
		Assertions.assertThrows(PosicaoInvalidaException.class, ()-> {
			lista.get(2);
		});

	}
	
	@Test
	void removerPorObjetoTest() throws ContaInvalidaException, PosicaoInvalidaException, ListaVaziaException {
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		lista.adicionar(conta3);
		
		lista.remover(conta1);
		Assert.assertEquals(conta2, lista.get(0));
		
		Assert.assertEquals(2, lista.tamanho());
	}
	
	@Test
	void removerPorPosicaoTest() throws ContaInvalidaException, PosicaoInvalidaException, ListaVaziaException {
		lista.adicionar(conta1);
		lista.adicionar(conta2);
		
		lista.remover(0);
		Assert.assertEquals(conta2, lista.get(0));
		Assert.assertEquals(1, lista.tamanho());
	}
	
	@Test
	void removerPosicaoInvalidaTest() throws ContaInvalidaException {
		lista.adicionar(conta1);
		
		Assertions.assertThrows(PosicaoInvalidaException.class, () -> {
			lista.remover(1);
		});
	}
	
	@Test
	void removerObjetoInvalidoTest() {
		Assertions.assertThrows(ContaInvalidaException.class, ()-> {
			lista.remover(null);
		});
	}
	
	@Test
	void removerComListaVaziaTest() {
		Assertions.assertThrows(ListaVaziaException.class, ()-> {
			lista.remover(conta1);
		});
	}
	
	@Test
	void vazioTest() throws ContaInvalidaException {
		Assert.assertEquals(true, lista.isEmpyt());
		
		lista.adicionar(conta1);
		
		Assert.assertEquals(false, lista.isEmpyt());
	}
}
