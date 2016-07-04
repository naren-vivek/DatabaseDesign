package com.app.DB.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.app.DB.model.Book;
import com.app.DB.model.BookLoan;

@Repository
public interface BookSearchRepository extends CrudRepository<Book, String> {

	/*
	 * @Query("from Book bk " + " where bk.isbn=:value or bk.title=:value")
	 */
	@Query("select b.isbn,b.title,a.name,bc.bookId,lb.branchId,bc.availability from Book b join"
			+ " b.authors a join b.bookCopies bc join bc.libraryBranch lb where (lb.branchId=:branch and (lower(a.name) like %:value% or lower(b.isbn) like %:value% or lower(b.title) like %:value% ))")
	public List<Book> searchBooks(@Param("value") String value, @Param("branch") int branch);

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

	@Query("select count(*) from BookLoan b where b.cardNo=:cardNo and dateIn is null and datediff(curdate(), b.dueDate) > 0)")
	public int isOverDue(@Param("cardNo") String cardNo);

	@Modifying
	@Query("update BookLoan set dateIn=curdate() where cardNo=:cardNo and bookId=:bookId")
	public void checkIn(@Param("cardNo") String cardNo, @Param("bookId") int bookId);

	@Query("select loanId from BookLoan bl where bl.cardNo=:cardNo and dateIn is null and datediff(curdate(),bl.dueDate)> 0 ")
	public int OverDueLoanId(@Param("cardNo") String cardNo);

	@Query("select datediff(curdate(),bl.dueDate) from BookLoan bl where bl.cardNo=:cardNo and dateIn is null and datediff(curdate(),bl.dueDate)> 0 ")
	public int OverDueLoan(@Param("cardNo") String cardNo);

	@Modifying
	@Query("update Fine set fineAmt=(:dateDiff)*0.25 where loanId=:loanId")
	public void UpdateOverDue(@Param("loanId") int loanId, @Param("dateDiff") double dateDiff);
	
	@Query("select loanId,bookId,cardNo,dateOut,dueDate,dateIn from BookLoan where cardNo=:cardNo")
	public List<BookLoan> getActiveBooksCardNo(@Param("cardNo")String cardNo);
	
	@Query("select bk.loanId,bk.bookId,bk.cardNo,bk.dateOut,bk.dueDate,bk.dateIn from BookLoan bk join bk.bookCopy bc join bc.book b where b.isbn=:isbn")
	public List<BookLoan> getActiveBooks(@Param("isbn")String isbn);

}
