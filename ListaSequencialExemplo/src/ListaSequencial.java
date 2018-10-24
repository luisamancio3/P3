public class ListaSequencial{
	
	private static final int TAM_INICIAL = 2;
	
	private Object[] arrayInterno = new Object[TAM_INICIAL];
	
	private int inseridos = 0;
	
	public void add(Object item) throws ItemInvalidoException{
		if(item == null) {
			throw new ItemInvalidoException();
		}
		
		dobrar();
		
		arrayInterno[inseridos] = item;
		inseridos++;
	}
	
	public void add(Object item, int posicao) throws ItemInvalidoException, IndiceInvalidoException{
		if(item == null) {
			throw new ItemInvalidoException();
		}
		
		if(posicao < 0 || posicao > inseridos){
			throw new IndiceInvalidoException();
		}
		
		dobrar();
		
		for (int i = inseridos; i < posicao; i--) {
			arrayInterno[i] = arrayInterno[i - 1];
		}
		
		arrayInterno[posicao] = item;
		inseridos++;
	}
	
	public void remover(Object item) throws ItemInvalidoException, IndiceInvalidoException{
		remover(obterIndice(item));
	}
	
	public void remover(int indice) throws IndiceInvalidoException{
		if(indice >= inseridos || indice < 0) {
			throw new IndiceInvalidoException();
		}
		arrayInterno[indice] = null;
		refatorar(indice);
	}
	
	public Object ObterItem(int indice) throws IndiceInvalidoException{
		if(indice >= inseridos || indice < 0) {
			throw new IndiceInvalidoException();
		}
		return arrayInterno[indice];
	}
	
	public void limpar() {
		arrayInterno = new Object[TAM_INICIAL];
		inseridos = 0;
	}
	
	public int tamanho() {
		return inseridos;
	}
	
	public boolean isEmpyt() {
		return inseridos == 0;
	}
	
	private void dobrar() {
		if(inseridos == arrayInterno.length) {
			Object[] clone = new Object[arrayInterno.length * TAM_INICIAL];
			
			for (int i = 0; i < arrayInterno.length; i++) {
				clone[i] = arrayInterno[i];
			}
			
			arrayInterno = clone;
		}		
	}
	
	private int obterIndice(Object item) throws ItemInvalidoException{
		
		if(item == null) {
			throw new ItemInvalidoException();
		}
		
		int indice = -1;
		for (int i = 0; i < arrayInterno.length; i++) {
			if(item.equals(arrayInterno[i])) {
				indice = i;
			}
		}
		if(indice == -1) {
			throw new ItemInvalidoException();
		}
		return indice;
	}

	private void refatorar(int indice) {
		for (int i = indice; i < inseridos - 1; i++) {
			arrayInterno[i] = arrayInterno[i + 1];
		}
		inseridos--;
	}
}