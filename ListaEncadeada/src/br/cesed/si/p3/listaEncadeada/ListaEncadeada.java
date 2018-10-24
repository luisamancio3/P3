package br.cesed.si.p3.listaEncadeada;

public class ListaEncadeada {
	
	private Conta primeiroElemento;
	private Conta ultimoElemento;
	
	private int inseridos;
	
	public void adicionar(Conta c) throws ContaInvalidaException{
		if(c == null) {
			throw new ContaInvalidaException();
		}
		
		if(primeiroElemento == null) {
			primeiroElemento = c;
			ultimoElemento = c;
		} else {
			ultimoElemento.setProximo(c);
			ultimoElemento = c;
		}
		
		inseridos++;
	}
	
	public Conta get(int posicao) throws PosicaoInvalidaException{
		if(posicao >= tamanho() || posicao < 0) {
			throw new PosicaoInvalidaException();
		}
		
		Conta temp = primeiroElemento;
		int contador = 0;
		
		if(posicao == 0) {
			return primeiroElemento;
		}
		
		while(contador < inseridos) {
			if(contador == posicao) {
				return temp;
			} else {
				temp = temp.getProximo();
				contador++;
			}
		}
		return null;
	}
	
	public void remover(Conta c) throws ContaInvalidaException, ListaVaziaException{
		if(c == null) {
			throw new ContaInvalidaException();
		}
		
		if(inseridos == 0) {
			throw new ListaVaziaException();
		}
		
		if(c.equals(primeiroElemento)) {
			primeiroElemento = primeiroElemento.getProximo();
		} else {
			Conta temp = primeiroElemento;
			while(temp.getProximo() != c) {
				temp = temp.getProximo();
			}
			temp.setProximo(c.getProximo());
		}
		inseridos--;
	}
	
	public void remover(int pos) throws ContaInvalidaException, PosicaoInvalidaException, ListaVaziaException{
		if(pos >= tamanho() || pos < 0) {
			throw new PosicaoInvalidaException();
		}
		
		Conta temp = primeiroElemento;
		int contador = 0;
		
		if(pos == 0) {
			primeiroElemento = primeiroElemento.getProximo();
			inseridos--;
		} else {
			while(contador < inseridos) {
				if(contador == pos) {
					this.remover(temp);
				} else {
					temp = temp.getProximo();
					contador++;
				}
			}
		}
	}
	
	public int tamanho() {
		return inseridos;
	}
	
	public boolean isEmpyt() {
		return inseridos == 0;
	}
}
