package com.generation.blogpessoal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A Annotation @Entity indica que a classe é uma entidade, ou seja, ele será
 * utilizada para gerar uma tabela no Banco de Dados.
 * 
 * A Annotation @Table indica o nome da tabela no Banco de dados. Caso ela não
 * seja declarada, o Banco criará a tabela com o mesmo nome da classe.
 */
@Entity
@Table( name = "tb_postagens") // create table tb_postagens(
public class Postagem {

	/**
	 * A Annotation @ID inidica que o atributo é a chave primária da tabela
	 * 
	 * A Annotation @GeneratedValue indica que a chavae primária será do tipo
	 * auto-incremento.
	 * 
	 * O parâmetro strategy indica como será gerada a chave.
	 * 
	 * GenerationType.IDENTITY indica que será uma sequência numérica iniciando em
	 * 1.
	 * 
	 * Não confundir o auto-incremento do Banco de Dados que inicia em 1 com o
	 * indice de um Array (Vetor ou Matriz) que inicia em 0.
	 */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/**
	 * A Annotation @NotNull indica que um atributo não pode ser nulo
	 * 
	 * O parâmtero message inidica a mensagem que será exibida caso o atributo seja
	 * nulo
	 * 
	 * Não confundir nulo com branco (você não obriga que o atributo seja
	 * preenchido, podendo ficar em branco).
	 * 
	 * Para evitar que o atributo fique em branco utilize a Annotation @NotBlank
	 * 
	 * A Annotation @Size tem a função de definir o tamanho minimo e máximo de
	 * caracteres de um atributo.
	 * 
	 * ***IMPORTANTE***
	 * 
	 * Para utilizar estas annotations, não se esqueça de inserir a dependência
	 * Validation na criação do projeto ou insira diretamente no arquivo pom.xml
	 */
	
	@NotBlank(message = "O título é obrigatório e não pode utilizar espaços em branco!")
	@Size(min = 5, max = 100, message = "O título deve conter entre 5 e 100 caracteres!")
	private String titulo;
	
	@NotNull(message = "O texto é obrigatório!")
	@Size(min = 10, max = 1000, message = "O texto deve conter entre 10 e 1000 caracteres!")
	private String texto;
	
	@UpdateTimestamp
	private LocalDateTime data;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}
	
}
