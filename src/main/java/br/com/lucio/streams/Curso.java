package br.com.lucio.streams;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class Curso {
    
    private UUID id;
	private String nome;
	private Long alunos;
	
    public Curso(String nome, Long alunos) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.alunos = alunos;
    }

	
}
