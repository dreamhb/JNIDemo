public class HelloWorld{
    private native void print(int i, String s, int[] sumArray);
    
    private native void printv2();

    private static native int getAgeFromC(Employee e);

    private native Employee createWithAge(int age);

    static int[] sums = {1, 2, 3};

    public static void main(String[] args){
        HelloWorld hl = new HelloWorld();
        hl.print(20, "me", sums);

        Employee emp = new Employee(32);
        System.out.println("Pass employee to C and get age back: " + getAgeFromC(emp));

        Employee emp2 = hl.createWithAge(23);
        System.out.println("Get employee object from C: " + emp2.getAge());
    }

    static{
        System.loadLibrary("HelloWorld");
    }



}

class Employee{
    private int age;

    public Employee(int age){
        this.age = age;
    }

    public int getAge(){
        return age;
    }
}

