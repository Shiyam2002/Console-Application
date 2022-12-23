package Practice;

import java.util.Scanner;

public class BookCompany implements BookAction
   {
	BookAgencey[] book = new BookAgencey[5];
	Scanner sc = new Scanner(System.in);
	public BookCompany() {
		book[0] = new BookAgencey(2385, "Forbidden Treasure", "Adventure", 350, 248.65f);
		book[1] = new BookAgencey(4327, "Harry Potter", "Fantacy", 500, 400f);
		book[2] = new BookAgencey(7527, "Peter Twinkle", "Fairy tale", 250, 215.69f);
		book[3] = new BookAgencey(1492, "Rich dad poor dad", "Money", 850, 637.26f);
	}
	
	public static void main(String[] args) {
		BookCompany obj = new BookCompany();
		Scanner sc = new Scanner(System.in);
		int bkno,bkpg,ch;
		float price;
		String bknm,gen,cat;
		do {
			System.out.println("~~~~~~~~~~~~Book Company~~~~~~~~~~~~~~~~~");
			System.out.println("Operations : ");
			System.out.println("1.Add a new book");
			System.out.println("2.Delete a book");
			System.out.println("3.Update a detail");
			System.out.println("4.Search a book");
			System.out.println("5.Sort books");
			System.out.println("6.Display all Books");
			System.out.println("Enter your choice: ");
			ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("Enter Details of the Book(Book number, Book name, Genre, No. of Pages, Price)");
				System.out.println("Enter the Book number :");
				bkno = sc.nextInt();
				System.out.print("Enter the Book name :");
				bknm = sc.next();
				System.out.print("Enter the Genre :");
				gen = sc.next();
				System.out.print("Enter number of Pages in the Book : ");
				bkpg = sc.nextInt();
				System.out.print("Enter the Price(in decimal) :");
				price = sc.nextFloat();
				BookAgencey as  = new BookAgencey(bkno, bknm, gen, bkpg, price);
				obj.AddnewProduct(as);
				obj.Listing();
				break;
			}
			
			case 2:{
				obj.Listing();
				System.out.println("What do you like to delete ?");
				System.out.print("Enter the name :");
				bknm = sc.next();
				obj.deleting(bknm);
				obj.Listing();
				break;
			}
			
			case 3:{
				obj.Listing();
				System.out.println("What do you like to Update ?(Book number, Book name, Genre, No. of Pages, Price)"); 
				cat = sc.next();
				System.out.print("Enter the "+cat);
				obj.Update(cat);
				obj.Listing();
				break;
			}
			
			case 4:{
				obj.Listing();
				System.out.println("What book you like to Search ?");
				System.out.print("Enter the name :");
				bknm = sc.next();
				obj.Searching(bknm);
				break;
			}
			
			case 5:{
				obj.Listing();
				obj.Sorting();
				break;
			}
			
			case 6:{
				obj.Listing();
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + ch);
			}
		}while(ch!=0);
		sc.close();
	}
	
	@Override
	public void Listing() {
		for(BookAgencey ba : book ) {
			System.out.println(ba);
		}
//		for(int i=0;i<book.length;i++) {
//			System.out.println(book[i]);
//		}
		
	}   
	
	@Override
	public String AddnewProduct(BookAgencey bk) {
		for(int index=0;index<book.length;index++)
		{
			if(book[index]==null)
			{
				book[index]=bk;
				//System.out.println("has added");
				break;
			}
		}
		return null;
	}

	@Override
	public void Update(String name) {
		for(int index=0;index<book.length;index++) {
			if(book[index].getBookname().equalsIgnoreCase(name)) {
				System.out.println(book[index]);
				System.out.println("tell us what to update");
				String update=sc.nextLine();
				switch(update)
				{
				case "BookName":
					System.out.println("tell us a new Bookname");
					String name1=sc.nextLine();
					book[index].setBookname(name1);
					break;
				case "genre":
					System.out.println("tell us a Genre ");
					String name2=sc.nextLine();
					book[index].setGenre(name2);
					break;
					default:System.out.println("Nothing to update");
			}
		}
	}
	}

	@Override
	public void deleting(String name) {
		for(int index = 0 ; index<book.length;index++) {
			if(book[index].getBookname().equalsIgnoreCase(name)) {
				book[index] = null;
				System.out.println(name+" has been deleted");
				break;
			}
		}
	}

	@Override
	public void Searching(String name) {
		System.out.println("Trying to fetch book matching the Bookname "+name);
		for(int index=0;index<book.length;index++) {
			if(book[index].getBookname().equalsIgnoreCase(name)) {
				System.out.println(book[index]);
			}
		}
	}

	@Override
	public void Sorting() {
		BookAgencey age = null;
		System.out.println("What do you wish for ?");
		String str = sc.next();
		for(int index=0;index<book.length;index++) {
			for(int com=index+1;com<book.length;com++) {

				if(str.equalsIgnoreCase("name")) {
					if(book[index].getBookname().compareTo(book[com].getBookname())>0) {
						age=book[index];
						book[index] = book[com];
						book[com] = age;
					}
				}
				
				else if(str.equalsIgnoreCase("genre")) {
					if(book[index].getGenre().compareTo(book[com].getGenre())>0) {
						age=book[index];
						book[index] = book[com];
						book[com] = age;
					}
				}
			}
		}
	}
}