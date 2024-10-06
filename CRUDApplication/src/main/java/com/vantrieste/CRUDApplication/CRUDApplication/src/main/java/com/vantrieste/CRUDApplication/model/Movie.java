package com.vantrieste.CRUDApplication.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity 
@Table(name="Movies")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String title;
	@Column
	private String director;
	public Movie() {}

    // Constructor with parameters
    public Movie(Long id, String title, String director) {
        this.id= id;
    	this.title = title;
        this.director = director;
    }
    
    // Getter for title
    public String getTitle() {
        return title;
    }

    // Setter for title
    public void setTitle(String title) {
        this.title = title;
    }

    // Getter for director
    public String getDirector() {
        return director;
    }

    // Setter for director
    public void setDirector(String director) {
        this.director = director;
    }

	public Long getId() {
		return id;
	}
	public void setId(int id) {
		this.id=(long) id;
	}

}
