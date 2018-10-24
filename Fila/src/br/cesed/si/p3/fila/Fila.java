package br.cesed.si.p3.fila;

public class Fila {
	
	private static final int TAM_INICIAL = 2;
	private Conta array[] = new Conta[TAM_INICIAL];
	private int inseridos;
	
	public void enqueue(Conta conta) throws ContaInvalidaException{
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
	
	public Conta dequeue() throws FilaVaziaException{
		if(inseridos == 0) {
			throw new FilaVaziaException();
		}
		
		Conta temp = array[0];
		for (int i = 0; i < inseridos; i++) {
			array[i] = array[i + 1];
		}
		
		inseridos--;
		return temp;
	}
	
	public Conta front() throws FilaVaziaException{
		if(inseridos == 0){
			throw new FilaVaziaException();
		}
		return array[0];
	}
	
	public int size() {
		return inseridos;
	}
	
	public boolean isEmpyt() {
		return inseridos == 0;
	}
}
