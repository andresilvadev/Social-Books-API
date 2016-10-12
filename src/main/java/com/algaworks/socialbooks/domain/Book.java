package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
public class Book {
	
	@JsonInclude(Include.NON_NULL)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo nome não pode ser vazio.")
	@JsonInclude(Include.NON_NULL)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	@JsonFormat(pattern = "dd/MM/yyyy")
	@NotNull(message = "O campo publicação é de preenchimento obrigatório.")
	private Date publication;
	
	@JsonInclude(Include.NON_NULL)
	@NotNull(message = "O campo editora é de preenchimento obrigatório.")
	private String publishingCompany;
	
	@JsonInclude(Include.NON_NULL)
	@NotEmpty(message = "O resumo deve ser preenchido.")
	@Size(max = 1500, message = "O resumo não pode conter mais de 1500 caracteres.")
	private String summary;

	@JsonInclude(Include.NON_EMPTY)
	@OneToMany(mappedBy = "book")
	private List <Comment> comments;
	
	@ManyToOne
	@JoinColumn(name = "AUTHOR_ID")
	@JsonInclude(Include.NON_NULL)
	private Author author;
	
	public Book(){
		
	}
	
	public Book(String name){
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getPublication() {
		return publication;
	}
	public void setPublication(Date publication) {
		this.publication = publication;
	}
	public String getPublishingCompany() {
		return publishingCompany;
	}
	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
