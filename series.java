import java.util.Scanner;

class SeriesGenerator implements Runnable {
    private int n;

    public SeriesGenerator(int n) {
        this.n = n;
    }
    @Override
    public void run() {
        int current = 0;
        for (int i = 0; i < n; i++) {
            System.out.print(current + " ");
            current = current + 2 * i;
            step();
        }
    }
    private void step() {
        try {
            Thread.sleep(1100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        SeriesGenerator generator = new SeriesGenerator(n);
        Thread thread = new Thread(generator);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}