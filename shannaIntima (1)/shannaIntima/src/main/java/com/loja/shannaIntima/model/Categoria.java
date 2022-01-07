package com.loja.shannaIntima.model;

import java.util.List;

import javax.persistence.CascadeType;

//import java.time.LocalDate;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
    import javax.persistence.OneToMany;
    import javax.persistence.Table;
	import javax.validation.constraints.NotNull;
	import javax.validation.constraints.Size;

    import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

	@Entity
	@Table(name="tb_categoria")
	public class Categoria {

		//CHAVE PRIMÁRIA ID
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		
		//NOME DA CLASSIFICAÇÃO DO PRODUTO
		@NotNull(message="Campo Obrigatório")
		@Size(min=5, max=255, message="Esse campo deve conter 5 caracteres e no máximo 255")
		private String tipo;
		
		//DESCRIÇÃO DA CATEGORIA PARA CLASSFICAÇÃO DOS PRODUTOS
		@NotNull(message="Campo Obrigatório")
		@Size(min=5, max=1000, message="Esse campo deve conter 5 caracteres e no máximo 1000")
		private String descricao;
		
		//PALAVRAS CHAVES PARA FERRAMENTA DE BUSCA
		@NotNull(message="Campo Obrigatório")
		@Size(min=5, max=255, message="Esse campo deve conter 5 caracteres e no máximo 255")
		private String palavraChave;
		
		//CALCULO DE DIAS DE ENTREGA
		// private LocalDate data;
		// data.setDate(data.getDate( + a));
		
		//CHAVE ESTRANGEIRA DE CATEGORIA PARA O PRODUTO
		@OneToMany (mappedBy = "categoria", cascade = CascadeType.ALL)
		@JsonIgnoreProperties ({"categoria","produto"})
		private List <Produto> produto;
		
		
	public List<Produto> getProduto() {
			return produto;
		}

		public void setProduto(List<Produto> produto) {
			this.produto = produto;
		}

		//METODOS GETTERS AND SETTERS
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getTipo() {
			return tipo;
		}

		public void setTipo(String tipo) {
			this.tipo = tipo;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getPalavraChave() {
			return palavraChave;
		}

		public void setPalavraChave(String palavraChave) {
			this.palavraChave = palavraChave;
		}

		
	}

