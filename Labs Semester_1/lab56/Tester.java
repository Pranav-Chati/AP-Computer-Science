package lab56;

import java.util.Scanner;

public class Tester {
	static Scanner input = new Scanner(System.in); //for the scanner
	static int choice; //for the meny option
	static Book[] books = new Book[3]; //book objects

	public static void main(String[] args) {
		Patron p1, p2; //patron objects
		int i=0; //as counter
		
		int ans; //for the whle loop
		
		String bookt = null; //this is for the book title
		String booka = null; //for the author of the book
		
		for(i = 0;i<3; i++) {
			books[i] = new Book();
		}
		System.out.print("Enter Patron 1:");
		p1= new Patron(input.nextLine());
		
		System.out.print("Enter Patron 2:");
		p2 = new Patron(input.nextLine());
		
		do {
			//Menu
			
			if (choice == 2) {
				System.out.println("Index: ");
				int index = input.nextInt();
				books[index].change();
				
			}else if(choice == 4) {
				System.out.println("Index: ");
				int index = input.nextInt();
				System.out.println(books[index].toString());
			
			} else if (choice == 1) { //for any value that isn't 0 or 2
				System.out.println("Enter your title: ");
				bookt = input.nextLine();
				
				System.out.println("Enter your author: ");
				booka = input.nextLine();
				
				books[i].setAuthor(booka);
				books[i].setTitle(bookt);
				i++;
			} else if(choice == 3) {
				System.out.println("Enter your title: ");
				bookt = input.nextLine();
				
				System.out.println("Enter your author: ");
				booka = input.nextLine();
				
				books[i].setAuthor(booka);
				books[i].setTitle(bookt);
			} else if(choice == 5) {
				System.out.println("Enter your title: ");
				bookt = input.nextLine();
				
				System.out.println("Enter your author: ");
				booka = input.nextLine();
				
				books[i].setAuthor(booka);
				books[i].setTitle(bookt);				
			}
			
			peep();
			
		}while(true);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void peep() {
	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status"+ "\n\t6:View all Books");
	choice = input.nextInt(); //1

	
	System.out.println("Enter your title: hp\n"
			+ "Enter your author name: jk\n");
	
	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status"+ "\n\t6:View all Books");
	choice = input.nextInt(); //2
	
	System.out.println("Index: 0\nTitle:hp\nAuthor:jk");
	
	
	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status"+ "\n\t6:View all Books");
	choice = input.nextInt(); //3
	
	System.out.println("Enter your title: hp\n"
			+ "Enter your author name: jk\n");
	
	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status"+ "\n\t6:View all Books");
	choice = input.nextInt(); //4
	
	System.out.println("Index: 0\nBook Returned");
	
	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status");
	choice = input.nextInt(); //4
	
	System.out.println("Index: 0\nBook Returned");

	System.out.println("Menu"
			+ "\n\t0:Quit"
			+ "\n\t1:Instantiate A Book"
			+ "\n\t2:View Book"
			+ "\n\t3:Borrow Book"
			+ "\n\t4:Return Book"
			+ "\n\t5:Check Book Borrowed Status"
			+ "\n\t6:View all Books");
	choice = input.nextInt(); //4

	for(int i = 0; i <3;i++) {
			System.out.println("Index: " +i+"\n" + books[i].toString());
	}
	}
}
