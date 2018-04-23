package threadtesting;

public class MainClass {

    public static void main(String args[]) {
        ThreadClass one = new ThreadClass("A");
        ThreadClass two = new ThreadClass("B");
        one.start();
        two.start();
    }
}
