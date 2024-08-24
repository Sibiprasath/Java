import java.util.Scanner;

public class Number extends Thread {
    int size;
    int[] arr;
    int z = 0;
    int a = 0;

public void run() {

    for (int i = 0; i < size; i++) {

        for(int j=i+1; j < size; j++) {

            if (arr[i] == arr[j]) {

                a = arr[i];

                z = 1;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e)
            {
                System.out.println("Exception Occured");
            }
        }
    }
}

if (z == 1)

System.out.println("Error: Duplicate number found: "+ a);

else

System.out.println("No duplicate found");

}   
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int size=sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++)
        {
            arr[i] = sc.nextInt();
        }
        Number n =new Number();
        n.size = size;
        n.arr = arr;
        n.start();
    }
}