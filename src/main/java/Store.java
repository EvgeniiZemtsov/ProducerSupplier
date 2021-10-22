public class Store {
    private int numberOfProducts;
    private static final Object monitor = new Object();

    public Store() {
        numberOfProducts = 0;
    }

    public void take() {
        synchronized (monitor) {
            while (numberOfProducts <= 0) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numberOfProducts--;
            System.out.println("Consumer took one product");
            System.out.println("Products left: " + numberOfProducts);
            monitor.notifyAll();
        }
    }

    public void put() {
        synchronized (monitor) {
            while (numberOfProducts >= 3) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            numberOfProducts++;
            System.out.println("Producer put one product");
            System.out.println("Products left: " + numberOfProducts);
            monitor.notify();
        }
    }
}
