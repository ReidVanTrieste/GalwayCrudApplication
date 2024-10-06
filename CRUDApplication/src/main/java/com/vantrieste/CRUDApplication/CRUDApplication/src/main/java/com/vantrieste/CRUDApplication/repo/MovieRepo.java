package com.vantrieste.CRUDApplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vantrieste.CRUDApplication.model.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

	@Query("SELECT b FROM Movie b WHERE b.director = :director")
	List<Movie> findByDirector(@Param("director") String director);
	
	@Query("SELECT b FROM Movie b WHERE b.title = :title")
	List<Movie> findByTitle(@Param("title") String title);

}
