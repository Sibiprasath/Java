import java.util.HashSet;
import java.util.Scanner;

public class PangramChecker {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String in1=sc.nextLine();

        Thread thread= new Thread(() -> {
            boolean isPangram = isPangram(in1);
            System.out.println("Input 1: " + (isPangram ? "Pangram" : "Not a Pangram"));
        });

        thread.start();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private static boolean isPangram(String str) {
        HashSet<Character> alphabetSet = new HashSet<>();
        for (char c : str.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                alphabetSet.add(c);
            }
        }
        return alphabetSet.size() == 26;
    }
}