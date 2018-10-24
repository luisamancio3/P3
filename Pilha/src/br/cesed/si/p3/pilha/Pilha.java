package br.cesed.si.p3.pilha;

public class Pilha {
	
	private static final int TAM_INICIAL = 2;
	private Conta array[] = new Conta[TAM_INICIAL];
	private int inseridos;
	
	public void push(Conta conta) throws ContaInvalidaException{
		if(conta == null) {
			throw new ContaInvalidaException();
		}
		
		if(this.array.length == inseridos) {
			Conta clone[] = new Conta[array.length * TAM_INICIAL];		
			
			for (int i = 0; i < array.length; i++) {
				clone[i] = array[i];
			}
			
			array = clone;
		}
		
		array[inseridos] = conta;
		inseridos++;
	}
	
	public void pop() throws arrayVazioException{
		if(inseridos == 0) {
			throw new arrayVazioException();
		}
		
		array[inseridos] = null;
		inseridos--;
	}
	
	public Conta top() throws arrayVazioException{
		if(inseridos == 0) {
			throw new arrayVazioException();
		}
		
		return array[inseridos - 1];
	}
	
	public int size() {
		return inseridos;
	}
	
	public boolean isEmpyt() {
		return inseridos == 0;
	}
}
