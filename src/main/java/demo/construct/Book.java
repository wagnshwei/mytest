package demo.construct;

public class Book extends Product{

    public Book(){
        super();
        System.out.println("Book");
    }

    public static void main(String[] args) {
        Book book = new Book();
    }

}
