package threadtesting;

public class ThreadClass implements Runnable {
    Thread t;
    private String name;

    public void run() {
        try {
            for (int i = 0; i < 2000; i++) {
                System.out.println(name + ": " + i);
                Thread.sleep(50);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("interrupted: " + name);
        }
        System.out.println("exiting: " + name);
    }

    public void start() {
        if (t == null) {
            t = new Thread(this, this.name);
            t.start();
        }
    }

    public ThreadClass(String name) {
        System.out.println("creating: " + name);
        this.name = name;
    }
}
