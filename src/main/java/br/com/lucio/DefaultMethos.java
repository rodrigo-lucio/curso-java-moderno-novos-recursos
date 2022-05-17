package br.com.lucio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class DefaultMethos {

	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		
		
		Collections.sort(palavras);
		System.out.println(palavras);
		

		//Com o java 8 foi lan�ado os default methods
		Comparator<String> comparador = new ComparadorDeStringPorTamanho();
		Collections.sort(palavras, comparador); 
		
		//Podendo adicionar um corpo ao m�todo, mas n�o tem estado, o que � diferente 
		//de classe abstrata
		
		
		//Da mesma maneira que o forEach, � um default method.
	
		
		Consumer<String> consumidor = new ConsumidorDeString();
		palavras.forEach(consumidor);
		
		//Os default method n�o quebram a implementa��o da interface
	}
	

	
}

class ComparadorDeStringPorTamanho implements Comparator<String> {
    public int compare(String s1, String s2) {
        if(s1.length() < s2.length()) 
            return -1;
        if(s1.length() > s2.length()) 
            return 1;
        return 0;
    }
}

class ConsumidorDeString implements Consumer<String> {
    public void accept(String s) {
        System.out.println(s);
    }
}
