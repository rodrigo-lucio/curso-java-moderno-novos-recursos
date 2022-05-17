package br.com.lucio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import com.sun.jdi.IntegerType;

public class Lambas {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");

		Collections.sort(palavras);
		System.out.println(palavras);

		// Também podemos fazer com classes anônimas
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		};

		palavras.forEach(consumer);

		// Ou fazer direto com o new
		palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		// Agora com o Java 8, quando tem interface que tem APENAS 1 METODO IMPLEMENTADO (São chamadas de interfaces funcionais)
		// Podemos utilizar os lambdas:
		palavras.forEach((String t) -> {
			System.out.println(t);
		});

		// Reduzindo mais ainda: 
		palavras.forEach((t) -> {
			System.out.println(t);
		});

		// Reduzindo mais ainda: (Quando tem só um parametro, não precisa dos parenteses)
		// Nao precisa também das chaves quado tem só uma linha
		palavras.forEach(t -> System.out.println(t));

		// Agora Fazendo o comparable
		palavras.sort((s1, s2) -> {
			if (s1.length() < s2.length())
				return -1;
			if (s1.length() > s2.length())
				return 1;
			return 0;
		});

		// Agora com a classe Integer, usando o metodo pronto
		palavras.sort((s1, s2) -> {
			return Integer.compare(s1.length(), s2.length());
		});

		// Também não precisamos do Return
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

		palavras.forEach(t -> System.out.println(t));
		
		//E o consumer do forEach acima é a mesma coisa que isso:
		Consumer<String> impressor = (String t) -> {
			System.out.println(t);
		};
		
		//Reduzindo...
		impressor = (t) -> {
			System.out.println(t);
		};
		
		//Reduzindo...
		impressor = t -> System.out.println(t);
		
		
		//Agora passando para o forEach
		palavras.forEach(impressor);
		
		
		//Com threads
		new Thread(new Runnable() {

		    @Override
		    public void run() {
		        System.out.println("Executando um Runnable");
		    }

		}).start();
		
		//Reduzindo
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
		
		

	}

}
