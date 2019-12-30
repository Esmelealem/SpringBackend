package com.BookStore.Repository;


import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.BookStore.Domain.Book;
//import com.BookStore.Service.BookService;

public interface BookRepository extends CrudRepository<Book,Long>  {
	List<Book> findByTitleContaining(String keyword);
	

}
