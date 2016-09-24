package com.algaworks.socialbooks.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class Book {
	
	@JsonInclude(Include.NON_NULL)
	private Long id;
	
	@JsonInclude(Include.NON_NULL)
	private String name;
	
	@JsonInclude(Include.NON_NULL)
	private Date publication;
	
	@JsonInclude(Include.NON_NULL)
	private String publishingCompany;
	
	@JsonInclude(Include.NON_NULL)
	private String summary;

	@JsonInclude(Include.NON_NULL)
	private List <Comment> comments;
	
	@JsonInclude(Include.NON_NULL)
	private String author;
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
