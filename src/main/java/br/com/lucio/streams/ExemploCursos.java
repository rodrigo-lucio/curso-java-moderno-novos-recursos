package br.com.lucio.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ExemploCursos {
	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python", 445l));
		cursos.add(new Curso("Java", 512l));
		cursos.add(new Curso("JavaScript", 345l));
		cursos.add(new Curso("C#", 123l));
		cursos.add(new Curso("GO", 412l));
	
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.forEach(System.out::println);
		cursos.forEach(c -> System.out.println(c.getNome()));

		//Imprimir cursos com mais de 300 alunos
		cursos.stream()
			.filter(c -> c.getAlunos() > 400)
			.map(c -> c.getAlunos())
			.forEach(System.out::println);
		
		//Caso quizesse somar a quantidade de alunos de cursos com mais de 400 alunos
		int sum = (int) cursos.stream()
				.filter(c -> c.getAlunos() > 400)
				.mapToLong(c -> c.getAlunos())
				.sum();
		
		System.out.println(sum);
	}
}
