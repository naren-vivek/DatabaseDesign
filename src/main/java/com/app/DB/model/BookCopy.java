package com.app.DB.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the book_copies database table.
 * 
 */
@Entity
@Table(name="book_copies")
@NamedQuery(name="BookCopy.findAll", query="SELECT b FROM BookCopy b")
public class BookCopy implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="book_id")
	private int bookId;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="isbn")
	private Book book;

	//bi-directional many-to-one association to LibraryBranch
	@ManyToOne
	@JoinColumn(name="branch_id")
	private LibraryBranch libraryBranch;

	//bi-directional many-to-one association to BookLoan
	@OneToMany(mappedBy="bookCopy")
	private List<BookLoan> bookLoans;

	public BookCopy() {
	}

	public int getBookId() {
		return this.bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LibraryBranch getLibraryBranch() {
		return this.libraryBranch;
	}

	public void setLibraryBranch(LibraryBranch libraryBranch) {
		this.libraryBranch = libraryBranch;
	}

	public List<BookLoan> getBookLoans() {
		return this.bookLoans;
	}

	public void setBookLoans(List<BookLoan> bookLoans) {
		this.bookLoans = bookLoans;
	}

	public BookLoan addBookLoan(BookLoan bookLoan) {
		getBookLoans().add(bookLoan);
		bookLoan.setBookCopy(this);

		return bookLoan;
	}

	public BookLoan removeBookLoan(BookLoan bookLoan) {
		getBookLoans().remove(bookLoan);
		bookLoan.setBookCopy(null);

		return bookLoan;
	}

}