package br.cesed.si.p3.deque;

public class Deque {
	
	private static final int TAM_INICIAL = 2;
	
	private Conta array[] = new Conta[TAM_INICIAL];
	
	private int inseridos;
	
	public Conta insertFirst(Conta conta) throws ContaInvalidaException{
		if(conta == null) {
			throw new ContaInvalidaException();
		}
		dobraArray();
		for (int i = inseridos; i > 0; i--) {
			array[i] = array[i - 1];
		}
		insere(0, conta);
		return conta;
	}
	
	public Conta insertLast(Conta conta) throws ContaInvalidaException{
		if(conta == null) {
			throw new ContaInvalidaException();
		}
		dobraArray();
		insere(inseridos, conta);
		return conta;
	}
	
	public void removeFirst() throws DequeVazioException{
		if(inseridos == 0) {
			throw new DequeVazioException();
		}
		refatora(0);
	}
	
	public void removeLast() throws DequeVazioException{
		if(inseridos == 0) {
			throw new DequeVazioException();
		}
		array[inseridos] = null;
		inseridos--;
	}
	
	public void removeByValue(Object conta) throws ContaInvalidaException, PosicaoInvalidaException{
		if(conta == null) {
			throw new ContaInvalidaException();
		}
		for (int i = 0; i < inseridos; i++) {
			if (conta.equals(array[i])) {
				removeByIndex(i);
				break;
			}
		}
	}
	
	public void removeByIndex(int index) throws PosicaoInvalidaException{
		if(index >= inseridos || index < 0) {
			throw new PosicaoInvalidaException();
		}
		refatora(index);
	}
	
	public int size() {
		return inseridos;
	}
	
	public boolean isEmpyt() {
		return array[0] == null;
	}
	
	public Conta getItem(int index) {
		return array[index];
	}
	
	private void dobraArray() {
		if(this.array.length == inseridos) {
			Conta clone[] = new Conta[array.length * TAM_INICIAL];		
			
			for (int i = 0; i < array.length; i++) {
				clone[i] = array[i];
			}
			
			array = clone;
		}
	}
	
	private void insere(int index, Conta item){
		array[index] = item;
		inseridos++;
	}
	
	private void refatora(int index) {
		for (int i = index; i < inseridos; i++) {
			array[i] = array[i + 1];
		}
		inseridos--;
	}
}
