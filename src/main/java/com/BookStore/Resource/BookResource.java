package com.BookStore.Resource;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.BookStore.Domain.Book;
import com.BookStore.Service.BookService;

@RestController
@RequestMapping("/book")
public class BookResource {
	@Autowired
	private BookService bookService;
	
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public Book addBookPost(@RequestBody Book book)
	{
		return bookService.save(book);
	}
	@RequestMapping(value="/add/image", method=RequestMethod.POST)
	public ResponseEntity upload(@RequestParam("Id") Long id,
			HttpServletRequest request, HttpServletResponse response
			) {
	try{
		Book book=bookService.findOne(id);
		MultipartHttpServletRequest multipartRequest=(MultipartHttpServletRequest) request;
		Iterator<String> it=multipartRequest.getFileNames();
		MultipartFile multipartfile= multipartRequest.getFile(it.next());
		String fileName=id+".png";
		byte[] bytes=multipartfile.getBytes();
		BufferedOutputStream stream= new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/image/book/"+fileName)));
		stream.write(bytes);
		stream.close();
		return new ResponseEntity("Uploaded Successfully!", HttpStatus.OK);
		
	} catch(Exception e)
	
	{
		e.printStackTrace();
		return new ResponseEntity("Uploaded Failed", HttpStatus.BAD_REQUEST);
	}
	}
}
