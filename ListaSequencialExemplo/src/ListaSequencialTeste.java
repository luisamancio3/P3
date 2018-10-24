import static org.junit.jupiter.api.Assertions.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ListaSequencialTeste {
	
	ListaSequencial listaSequencial;

	
	@BeforeEach
	void setUp() throws Exception {
		listaSequencial = new ListaSequencial();
	}
	
	@Test
	void adicionarItemTest() throws EstadoInvalidoException, ItemInvalidoException, IndiceInvalidoException {
		listaSequencial.add("item1");
		listaSequencial.add("item2");
		listaSequencial.add("item3");
		
		Assert.assertEquals("item1", listaSequencial.ObterItem(0));
		Assert.assertEquals("item2", listaSequencial.ObterItem(1));
		Assert.assertEquals("item3", listaSequencial.ObterItem(2));
	}
	
	@Test
	void adicionarPorPosicaoTest() throws ItemInvalidoException, IndiceInvalidoException {
		listaSequencial.add("item3", 0);
		listaSequencial.add("item2", 1);
		listaSequencial.add("item1", 2);
		
		Assert.assertEquals("item3", listaSequencial.ObterItem(0));
		Assert.assertEquals("item2", listaSequencial.ObterItem(1));
		Assert.assertEquals("item1", listaSequencial.ObterItem(2));
	}
	
	@Test
	void adicionarItemInvalidoTest() {
		Assertions.assertThrows(ItemInvalidoException.class, () -> {
			listaSequencial.add(null);
		});
	}
	
	@Test
	void adiconarPosicaoInvalidaTest() {
		Assertions.assertThrows(IndiceInvalidoException.class,() -> {
			listaSequencial.add("item1", -5);
		});
		
		Assertions.assertThrows(IndiceInvalidoException.class,() -> {
			listaSequencial.add("item1", listaSequencial.tamanho() + 5);
		});
	}
	
	@Test
	void adicionarItemInvalidoComPosicaoTest() {
		Assertions.assertThrows(ItemInvalidoException.class, () ->{
			listaSequencial.add(null, 0);
		});
	}
	
	@Test
	void removerPorItemTest() throws ItemInvalidoException, IndiceInvalidoException {
		listaSequencial.add("item3", 0);
		listaSequencial.add("item2", 1);
		listaSequencial.add("item1", 2);
		
		listaSequencial.remover("item2");
		Assert.assertEquals("item1", listaSequencial.ObterItem(1));
	}
	
	@Test
	void removerPorIndiceTest() throws IndiceInvalidoException, ItemInvalidoException {
		listaSequencial.add("item3", 0);
		listaSequencial.add("item2", 1);
		listaSequencial.add("item1", 2);
		
		listaSequencial.remover(1);
		
		Assert.assertEquals("item1", listaSequencial.ObterItem(1));
	}
	
	@Test
	void removerPorItemInvalidoTest() {
		Assertions.assertThrows(ItemInvalidoException.class, () ->{
			listaSequencial.remover(null);
		});
	}
	
	@Test
	void removerPorIndiceInvalidoTest() {
		Assertions.assertThrows(IndiceInvalidoException.class, () ->{
			listaSequencial.remover(0);
		});
		
		Assertions.assertThrows(IndiceInvalidoException.class, () ->{
			listaSequencial.remover(-2);
		});
	}
	
	@Test
	void tamanhoTest() throws ItemInvalidoException, IndiceInvalidoException {
		listaSequencial.add("item3", 0);
		listaSequencial.add("item2", 1);
		listaSequencial.add("item1", 2);
		
		Assert.assertEquals(3, listaSequencial.tamanho());
		
		listaSequencial.remover("item1");
		
		Assert.assertEquals(2, listaSequencial.tamanho());
		
		listaSequencial.remover(0);
		
		Assert.assertEquals(1, listaSequencial.tamanho());
	}
	
	@Test
	void obterPorPosicaoInvalida() {
		Assertions.assertThrows(IndiceInvalidoException.class, () ->{
			listaSequencial.ObterItem(0);
		});
		
		Assertions.assertThrows(IndiceInvalidoException.class, () ->{
			listaSequencial.ObterItem(-6);
		});
	}
	
	@Test
	void vazioTest() throws ItemInvalidoException, IndiceInvalidoException {
		Assert.assertEquals(true, listaSequencial.isEmpyt());
		
		listaSequencial.add("item1", 0);
		
		Assert.assertEquals(false, listaSequencial.isEmpyt());
	}
}
