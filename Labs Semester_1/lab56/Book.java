package lab56;

public class Book {
	private String title, author;
	boolean Returned;
	//constructors
	public Book() {
		Returned = false;
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
	public void change() {
		Returned = true;
		System.out.println("True");
	}
	

	public String toString() {
		return("Title:" + title + "\n" + 
				"\nAuthor: " + author);
	}
}
