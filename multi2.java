import java.util.Scanner;

class ZigZagSum implements Runnable {
    private int[][] matrix;
    private int rows;
    private int cols;
    private int sum = 0;

    public ZigZagSum(int[][] matrix, int rows, int cols) {
        this.matrix = matrix;
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    public void run() {
        for (int j = 0; j < cols; j++) {
            sum += matrix[0][j];
        }
        for (int i = 1; i < rows - 1; i++) {
            sum += matrix[i][cols - i - 1];
        }
        for (int j = 0; j < cols; j++) {
            sum += matrix[rows - 1][j];
        }
    }

    public int getSum() {
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        ZigZagSum zigZagSum = new ZigZagSum(matrix, rows, cols);
        Thread thread = new Thread(zigZagSum);
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The sum of Zig-Zag pattern is " + zigZagSum.getSum());
    }
}