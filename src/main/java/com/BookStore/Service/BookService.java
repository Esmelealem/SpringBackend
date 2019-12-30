package com.BookStore.Service;

import java.util.List;

import com.BookStore.Domain.Book;
public interface BookService {
	List<Book> findAll();
	Book findOne(Long id);
	Book save(Book book);
	List<Book> blurrySearch(String keyword);
	void removeOne(Long id);

}
