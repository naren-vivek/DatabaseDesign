package com.app.DB.Domain;

public class BookDomain {
	private String isbn;
	private String title;
	private String author;
	private int bookId;
	private int branchId;
	private int availability;

	public BookDomain(String isbn, String title, String author, int bookId, int branchId, int availability) {
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.bookId = bookId;
		this.branchId = branchId;
		this.availability = availability;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability) {
		this.availability = availability;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
}
