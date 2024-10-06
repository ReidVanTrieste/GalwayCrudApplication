package com.vantrieste.CRUDApplication.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.vantrieste.CRUDApplication.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long>{

	@Query("SELECT b FROM Book b WHERE b.author = :author")
	List<Book> findByAuthor(@Param("author") String author);
	
	@Query("SELECT b FROM Book b WHERE b.title = :title")
	List<Book> findByTitle(@Param("title") String title);

}
