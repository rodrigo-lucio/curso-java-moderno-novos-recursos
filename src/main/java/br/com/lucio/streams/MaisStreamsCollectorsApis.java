package br.com.lucio.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaisStreamsCollectorsApis {
	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<>();
		
		cursos.add(new Curso("Python", 445l));
		cursos.add(new Curso("Java", 512l));
		cursos.add(new Curso("JavaScript", 345l));
		cursos.add(new Curso("C#", 123l));
		cursos.add(new Curso("GO", 412l));
	
		//Optional ajuda a trabalhar com objetos null
		Optional<Curso> cursoOptional = cursos.stream()
            .filter(c -> c.getAlunos() > 400)
            .findFirst();

		//Se nao existir retorna: NoSuchElementException
		cursoOptional.get();
		
		//Se nao existir, nao exeuta o Sysout
		cursoOptional.ifPresent(curso -> System.out.println(curso.getNome()));
		
		//Convertendo para um list
        List<Curso> cursosComMaisDe400Alunos = cursos.stream()
            .filter(c -> c.getAlunos() > 400)
            .collect(Collectors.toList());

        cursosComMaisDe400Alunos.forEach(System.out::println);
        
        //Agora convertendo para um map, cursos com mais de 200 alunos
        //Map com chave/valor id/nome
        Map<UUID, String> mapaCursos = cursos.stream()
            .filter(c -> c.getAlunos() > 200)
            .collect(Collectors.toMap(
                        (curso) -> curso.getId(),
                        (curso) -> curso.getNome()));
        
        //Aqui recebe um BigConsumer com dois tipos
        mapaCursos.forEach((id, nome) -> System.out.println("O curso " + nome + " possui o id " + id));
        
        //Média de alunos no curso
        OptionalDouble average = cursos.stream()
                .mapToLong(curso -> curso.getAlunos())
                .average();
        
        average.ifPresent(value -> System.out.println("Média de numero de alunos: " + value));
        
        
	}
}
