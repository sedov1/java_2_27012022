package lesson1;

public class Main {
    public static void main(String[] args) {
        Competitor[] competitors= {
                new Human(),
                new Cat(),
                new Cat(300,3)
        };
    }
}
