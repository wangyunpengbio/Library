package model;
/**
 * 
 * @author lygwangyp
 * @category ¡°½èÔÄ±í¡±
 */


import java.util.Date;

public class Borrow {
	private String idReader;
	private String idBook;
	private Date lendDate;
	private Date dueDate;
	private String overtime;
	public String getIdReader() {
		return idReader;
	}
	public void setIdReader(String idReader) {
		this.idReader = idReader;
	}
	public String getIdBook() {
		return idBook;
	}
	public void setIdBook(String idBook) {
		this.idBook = idBook;
	}
	public Date getLendDate() {
		return lendDate;
	}
	public void setLendDate(Date lendDate) {
		this.lendDate = lendDate;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public String getOvertime() {
		return overtime;
	}
	public void setOvertime(String overtime) {
		this.overtime = overtime;
	}

	public String toString() {
		return "Borrow [idReader=" + idReader + ", idBook=" + idBook + ", lendDate=" + lendDate + ", dueDate=" + dueDate
				+ ", overtime=" + overtime + "]";
	}
	
}
