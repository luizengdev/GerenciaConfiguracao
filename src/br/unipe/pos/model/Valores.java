package br.unipe.pos.model;

import br.unipe.pos.accessor.ValoresITF;

/*
 * CLASSE COM METODOS DE CALCULO PARA UM ARRAY
*/
public class Valores implements ValoresITF {

	private int valores [] = new int[10];

	/*
	 * INSERE UM VALOR NO ARRAY SE O VALOR FOR MAIOR QUE ZERO
	 * @param Valor
	 * @author Otacilio
	*/
	@Override
	public boolean ins(int valor) {

		boolean valorAdicionado = false;

		for(int i = 0; i < valores.length; i++) {
			if(valores[i] == 0 && valor > 0) {
				valores[i] = valor;

				valorAdicionado = true;
				break;
			} 
		}

		return valorAdicionado;
	}

	/*
	 * REMOVE UM VALOR NO ARRAY
	 * @param Indice
	 * @author Otacilio
	*/
	@Override
	public int del(int indice) {
		
		int retorno = -1;
		
		if(indice >= 0 && indice < 10) {
			if(valores[indice] > 0 ) {
				retorno = valores[indice];

				valores[indice] = 0;
			} 
		}
		
		return retorno;
	}

	/*
	 * RETORNAR O TAMANHO DO ARRAY
	 * @author Otacilio
	*/
	@Override
	public int size() {
		
		int count = 0;
		
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] > 0 ) {
				count++;
			} 
		}
		
		return count;
	}

	/*
	 * RETORNAR A MEDIA DOS VALORES DO ARRAY
	 * @author Otacilio
	*/
	@Override
	public double mean() {
		
		double total = 0;
		
		for(int i = 0; i < valores.length; i++) {
			total += valores[i];
		}
		
		double media = total/size();
		
		return (total > 0d ? media : -1);
	}

	/*
	 * RETORNAR O MAIOR VALOR DO ARRAY
	 * @author Otacilio
	*/
	@Override
	public int greater() {
		
		int maior = 0;
		
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] > maior ) {
				maior = valores[i];
			} 
		}
		
		return (maior > 0 ? maior : -1);
	}

	/*
	 * RETORNAR O MENOR VALOR DO ARRAY
	 * @author Otacilio
	*/
	@Override
	public int lower() {
		int menor = 0;
		boolean pegarPrimeiro = true;
		
		for(int i = 0; i < valores.length; i++) {
			if(valores[i] > 0) {				
				if(pegarPrimeiro) {
					menor = valores[i];
					
					pegarPrimeiro = false;
				} else {
					if(valores[i] < menor ) {
						menor = valores[i];
					} 									
				}				
			}
		}
		
		return (menor > 0 ? menor : -1);
	}

}
