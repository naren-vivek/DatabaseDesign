package com.app.DB.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the book database table.
 * 
 */
/**
 * @author NARENTHARAA
 *
 */
@Entity
@Table(name = "book")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String isbn;

	private String title;

	// bi-directional many-to-many association to Author
	@ManyToMany
	@JoinTable(name = "book_authors", joinColumns = { @JoinColumn(name = "isbn") }, inverseJoinColumns = {
			@JoinColumn(name = "author_id") })
	private List<Author> authors;

	// bi-directional many-to-one association to BookCopy
	@OneToMany(mappedBy = "book")
	private List<BookCopy> bookCopies;

	public Book() {
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Author> getAuthors() {
		return this.authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public List<BookCopy> getBookCopies() {
		return this.bookCopies;
	}

	public void setBookCopies(List<BookCopy> bookCopies) {
		this.bookCopies = bookCopies;
	}

	public BookCopy addBookCopy(BookCopy bookCopy) {
		getBookCopies().add(bookCopy);
		bookCopy.setBook(this);

		return bookCopy;
	}

	public BookCopy removeBookCopy(BookCopy bookCopy) {
		getBookCopies().remove(bookCopy);
		bookCopy.setBook(null);

		return bookCopy;
	}

	@Override
	public String toString() {
		return "Book [isbn=" + isbn + ", title=" + title + "]";
	}

}