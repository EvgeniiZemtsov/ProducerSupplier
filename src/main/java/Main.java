public class Main {
    public static void main(String[] args) {
        Store store = new Store();

        Thread t1 = new Thread(new Producer(store));
        Thread t2 = new Thread(new Consumer(store));

        t1.start();
        t2.start();
    }
}
