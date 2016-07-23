package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.Domain.BookDomain;
import com.app.DB.model.Book;
import com.app.DB.model.BookLoan;

@Repository
public interface BookSearchRepository extends CrudRepository<Book, String> {

	/*
	 * @Query("from Book bk " + " where bk.isbn=:value or bk.title=:value")
	 */
	@Query("select new com.app.DB.Domain.BookDomain(b.isbn,b.title,a.name,bc.bookId,lb.branchId,bc.availability) from Book b join"
			+ " b.authors a join b.bookCopies bc join bc.libraryBranch lb where (lb.branchId=:branch and (lower(a.name) like %:author% or lower(b.isbn) like %:isbn% or lower(b.title) like %:title% ))")
	public List<BookDomain> searchBooks(@Param("isbn") String isbn,@Param("title") String title,@Param("author") String author, @Param("branch") int branch);

	@Query("select new com.app.DB.Domain.BookDomain(b.isbn,b.title,a.name,bc.bookId,lb.branchId,bc.availability) from Book b join"
			+ " b.authors a join b.bookCopies bc join bc.libraryBranch lb where (lb.branchId=:branch and (lower(a.name) like %:common% or lower(b.isbn) like %:common% or lower(b.title) like %:common% ))")
	public List<BookDomain> searchBooks(@Param("common") String common, @Param("branch") int branch);

	/*
	 * @Query(
	 * "insert into BookLoan (bookId,cardNo,dateOut,dueDate) select ?1,?2,curdate(),adddate(curdate())"
	 * ) public void checkout(int bookId,String cardNo);
	 */

	// Date in to be validated
	@Query("select count(*) from BookLoan where cardNo=:cardNo and dateIn is null")
	public Long check(@Param("cardNo") String cardNo);

	@Query("select b.availability from BookCopy b where b.bookId=:bookId")
	public int avaliable(@Param("bookId") int bookId);

	@Modifying
	@Query("update BookCopy set availability=:availability where bookId=:bookId")
	public void setBookAvailable(@Param("bookId") int bookId, @Param("availability") int availability);

	@Query("select count(*) from Fine f join f.bookLoan bl where bl.cardNo=:cardNo and f.paid=0")
	public int isPaid(@Param("cardNo") String cardNo);

	@Query("select count(*) from BookLoan b where b.bookId=:bookId and b.dateIn is null and datediff(curdate(), b.dueDate) > 0)")
	public int isOverDue(@Param("bookId") int bookId);
	
	@Query("select count(*) from BookLoan b where b.cardNo=:cardNo and b.dateIn is null and datediff(curdate(), b.dueDate) > 0)")
	public int isOverDueCheckOut(@Param("cardNo") String cardNo);

	@Modifying
	@Query("update BookLoan set dateIn=curdate() where cardNo=:cardNo and bookId=:bookId")
	public void checkIn(@Param("cardNo") String cardNo, @Param("bookId") int bookId);

	@Query("select loanId from BookLoan bl where bl.bookId=:bookId and dateIn is null and datediff(curdate(),bl.dueDate)> 0 ")
	public int OverDueLoanId(@Param("bookId") int bookId);

	@Query("select datediff(curdate(),bl.dueDate) from BookLoan bl where bl.bookId=:bookId and dateIn is null and datediff(curdate(),bl.dueDate)> 0 ")
	public int OverDueLoan(@Param("bookId") int bookId);

	@Modifying
	@Query("update Fine set fineAmt=(:dateDiff)*0.25 where loanId=:loanId")
	public void UpdateOverDue(@Param("loanId") int loanId, @Param("dateDiff") double dateDiff);
	
	@Query("select new com.app.DB.Domain.BookLoanDomain(loanId,bookId,cardNo,dateOut,dueDate,dateIn) from BookLoan where cardNo like %:cardNo% and dateIn is null")
	public List<BookLoan> getActiveBooksCardNo(@Param("cardNo")String cardNo);
	
	@Query("select new com.app.DB.Domain.BookLoanDomain(bk.loanId,bk.bookId,bk.cardNo,bk.dateOut,bk.dueDate,bk.dateIn) from BookLoan bk join bk.bookCopy bc join bc.book b where b.isbn like %:isbn% and bk.dateIn is null")
	public List<BookLoan> getActiveBooks(@Param("isbn")String isbn);
	
	@Query("select new com.app.DB.Domain.BookLoanDomain(bk.loanId,bk.bookId,bk.cardNo,bk.dateOut,bk.dueDate,bk.dateIn) from BookLoan bk join bk.bookCopy bc join bc.book b where bk.cardNo=:cardNo and bk.bookId=:bookId")
	public List<BookLoan> getSingleBooks(@Param("cardNo")String cardNo,@Param("bookId")int bookId);

}
