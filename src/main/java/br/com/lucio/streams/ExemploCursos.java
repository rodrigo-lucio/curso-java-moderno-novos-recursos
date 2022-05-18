package br.com.lucio.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExemploCursos {
	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python", 445));
		cursos.add(new Curso("Java", 512));
		cursos.add(new Curso("JavaScript", 345));
		cursos.add(new Curso("C#", 123));
		cursos.add(new Curso("GO", 412));
	
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.forEach(System.out::println);
		cursos.forEach(c -> System.out.println(c.getNome()));

		//Imprimir cursos com mais de 300 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() > 400)
			.map(c -> c.getAlunos())
			.forEach(System.out::println);
		
		//Caso quizesse somar a quantidade de alunos de cursos com mais de 400 alunos
		int sum = cursos.stream()
				.filter(c -> c.getAlunos() > 400)
				.mapToInt(c -> c.getAlunos())
				.sum();
		
		System.out.println(sum);
	}
}
