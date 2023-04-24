import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;public class Main {
    public static void main(String[] args) {
        List<Book> listBook = new ArrayList<>();
        Scanner x = new Scanner(System.in);
        String mgs = """
                Chuong trinh quan ly sach:
                1. Them 1 cuon sach
                2. Xoa 1 cuon sach
                3. Thay doi sach
                4. Xuat thong tin
                5. Tim sach lap trinh
                6. Lay sach toi da theo gia
                7. Tim kiem sach theo tac gia
                0. Thoat
                Chon chuc nang:
                """;
        int choose = 0;
        do {
            System.out.printf(mgs);
            choose = x.nextInt();
            switch (choose) {
                case 1 -> {
                    Book newBook = new Book();
                    newBook.Input();
                    listBook.add(newBook);
                }
                case 2 -> {
                    System.out.print("Nhap ma sach can xoa: ");
                    int bookId = x.nextInt();
                    Book find = listBook.stream().filter(p -> p.getId() == bookId).findFirst().orElseThrow();
                    listBook.remove(find);
                    System.out.print("Xoa sach thanh cong");
                }
                case 3 -> {
                    System.out.print("Nhap ma sach can dieu chinh: ");
                    int bookId = x.nextInt();
                    Book find = listBook.stream().filter(p -> p.getId() == bookId).findFirst().orElseThrow();
                    x.nextLine();
                    System.out.print("Nhap ten sach: ");
                    find.setTitle(x.nextLine());
                    System.out.print("Nhap tac gia: ");
                    find.setAuthor(x.nextLine());
                    System.out.print("Nhap gia: ");
                    find.setPrice(x.nextLong());
                    System.out.print("Chinh sua sach thanh cong!!");
                }
                case 4 -> {
                    System.out.println("Xuat thong tin sach: ");
                    listBook.forEach(p -> p.Output());
                }
                case 5 -> {
                    System.out.print("Sach lap trinh: ");
                    List<Book> find = listBook.stream().filter(u -> u.getTitle().toLowerCase().contains("lap trinh")).toList();
                    find.forEach(Book::Output);
                }
                case 6 -> {
                    System.out.print("Nhap so luong sach muon loc: ");
                    int k = x.nextInt();
                    System.out.print("Nhap gia sach mong muon: ");
                    long p = x.nextLong();
                    List<Book> find = listBook.stream().filter(s -> s.getPrice() <= p).limit(k).toList();
                    find.forEach(Book::Output);
                }
                case 7 -> {
                    String author;
                    Set<String> setAuthor = new HashSet<String>();
                    do {
                        author = "0";
                        x.nextLine();
                        System.out.print("Nhap tac gia (nhap '0' de thoat): ");
                        author = x.nextLine();
                        setAuthor.add(author);
                    } while (!author.equals("0"));

                    System.out.println("Danh sach ne");
                    List<Book> find = new ArrayList<>();
                    for (String element : setAuthor) {
                        find = listBook.stream().filter(s -> s.getAuthor().equals(element)).toList();
                        find.forEach(Book :: Output);
                    }
                }
            }
        } while (choose != 0);
    }
}