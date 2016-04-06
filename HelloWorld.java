public class HelloWorld{
    private native void print(int i, String s, int[] sumArray);
    
    static int[] sums = {1, 2, 3};

    public static void main(String[] args){
        new HelloWorld().print(20, "me", sums);
    }

    static{
        System.loadLibrary("HelloWorld");
    }
}
