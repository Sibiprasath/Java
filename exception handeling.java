import java.util.Scanner;
class Vowel{

    static class NoVowelException extends Exception {
        public NoVowelException(String message) {
            super(message);
        }
    }

    public static void checkForVowels(String input) throws NoVowelException {
        
        String vowels = "AEIOUaeiou";
        
        for (char ch : input.toCharArray()) {
            if (vowels.indexOf(ch) != -1) {
                System.out.println("String contains vowels.");
                return;
            }
        }
        throw new NoVowelException("Error: String does not contain any vowels");
    }

    public static void main(String[] args) {
        // Sample inputs
        Scanner obj=new Scanner(System.in);

        String input=obj.nextLine();
       

        try {
            System.out.println("Original string: " + input);
            checkForVowels(input);
        } catch (NoVowelException e) {
            System.out.println(e.getMessage());
        }
    }
}