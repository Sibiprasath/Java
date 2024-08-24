@FunctionalInterface

interface father{
    void print();
}
class son implements father{
    public void print(){
        System.out.println("Money: "+100000);
    }
}
class Interface{
    public static void main(String[] args) {
        father obj=new son();
        obj.print();
    }
}                         
