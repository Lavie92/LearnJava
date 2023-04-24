import java.util.Scanner;

public class Book {
    public Book(int id, String title, String author, long price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public Book() {
    }


    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    private int id;
    private String title;
    private String author;
    private long price;

    public void Input() {
        Scanner x = new Scanner(System.in);
        System.out.print("Nhap ma sach: ");
        this.id = Integer.parseInt(x.nextLine());
        System.out.print("Nhap ten sach");
        this.title = x.nextLine();
        System.out.print("Nhap ten tac gia");
        this.author = x.nextLine();
        System.out.print("Nhap don gia");
        this.price = x.nextLong();
    }
    public void Output() {
        String mgs = """
                Book: id = %d, title = %s, author = %s, price = %d
                """.formatted(id, title, author, price);
        System.out.println(mgs);
    }

}
