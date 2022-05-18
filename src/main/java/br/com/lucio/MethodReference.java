package br.com.lucio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import com.sun.jdi.IntegerType;

public class MethodReference {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("curso bem longo com bastante caracteres");
		palavras.add("a");
		palavras.add("casa do c�digo");
		palavras.add("caelum");
		palavras.add("abcd");

		//Ordenando as palavras de acordo com o tamanho
		
		//Jeito 1
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		//Jeito 2 - Bem enxuto
		palavras.sort(Comparator.comparing(s -> s.length()));
		
		//Quebrando mais
		Comparator<String> comparator = Comparator.comparing(s -> s.length());
		palavras.sort(comparator);
		
		//Quebrando mais um pouco
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparator2 = Comparator.comparing(funcao);
		palavras.sort(comparator2);
		
		
		//Quebrando Mais ainda, com classe anonima, do jeito antigo
		Function<String, Integer> funcao2 = new Function<String, Integer>() {
			
			@Override
			public Integer apply(String s) {
				return s.length();
			}
		};
		
		Comparator<String> comparator3 = Comparator.comparing(funcao2);
		palavras.sort(comparator3);
		
		//Agora utilizando method references
		palavras.sort(Comparator.comparing(s -> s.length()));
		//� a mesma coisa
		palavras.sort(Comparator.comparing(String::length));
		

		//Esse caso
		Function<String, Integer> funcao3 = s -> s.length();
		
		//� a mesma coisa que 
		Function<String, Integer> funcao4 = String::length;
		//uma forma de escrever os lambdas mais enxutos
		
				
		palavras.forEach(palavra -> System.out.println(palavra));
		
		//� a mesma coisa que
		Consumer<String> consumer = palavra -> System.out.println(palavra);
		palavras.forEach(consumer);
		
		//� a mesma coisa que
		Consumer<String> consumer3 = System.out::println;
		palavras.forEach(consumer3);
		
		//� a mesma coisa que
		palavras.forEach(System.out::println);
		
		//Esses casos s�o apenas para interfaces que invoca apenas um metodo com um argumento
		
		
	}

}