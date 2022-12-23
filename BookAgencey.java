package Practice;

 class BookAgencey {
	private int bookno;
	private String bookname;
	private String genre;
	private int bookpage;
	private float price;
	
	@Override
	public String toString() {
		return "BookAgencey [bookno=" + bookno + ", bookname=" + bookname + ", genre=" + genre + ", bookpage="
				+ bookpage + ", price=" + price + "]";
	}
	
	public BookAgencey() {
		super();
	}

	public BookAgencey(int number,String name,String style,int page,float amount) {
		super();
		bookno   = number;
		bookname = name;
		genre    = style;
		bookpage = page;
		price    = amount;
	}
	
	public int getBookno() {
		return bookno;
	}
	public void setBookno(int bookno) {
		this.bookno = bookno;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public int getBookpage() {
		return bookpage;
	}
	public void setBookpage(int bookpage) {
		this.bookpage = bookpage;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}	
}