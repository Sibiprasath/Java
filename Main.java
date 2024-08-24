public class Main {
    public static void main(String[]args){
        String s1="Java Programming is";
        String s2="Roshan";
        String s3="Roshan Yughan";
        System.out.println("Legth of s1 : "+s1.length());
        System.out.println("Uppercase of s2: "+s2.toUpperCase());
        System.out.println("Lower case 0f s3: "+s3.toLowerCase());
        System.out.println("Trimming s2: "+s2.trim());
        System.out.println("StratsWith s3:  "+s3.startsWith("Roshan"));
        System.out.println("EndsWith s1: "+s1.endsWith("is"));
        System.out.println("CharAt s2: "+s2.charAt(4));
        System.out.println("Substring s3: "+s3.substring(3.6));
        System.out.println("IndexOf s1: "+s1.indexOf("i"));
        System.out.println("LastIndexof s3: "+s3.lastIndexOf("h"));
        System.out.println("ReplaceAll s3: "+s3.replaceAll("h", "31"));
        System.out.println("ReplaceFirst s1 : "+s1.replaceFirst("o", "9"));
        System.out.println("Contains s1: "+s1.contains("is"));
    }
}
