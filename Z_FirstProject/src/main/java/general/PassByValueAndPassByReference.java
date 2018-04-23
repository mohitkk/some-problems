package general;

public class PassByValueAndPassByReference {


    public static void main(String args[]){

        String a = "hello";
        StringTest(a);
        System.out.println("in main: "+a);
        int b = 5;
        IntTest(b);
        System.out.println("in main: "+b);
        boolean c = false;
        BooleanTest(c);
        System.out.println("in main: "+c);
    }

    public static void StringTest(String a){
        System.out.println("in func: "+a);
        a += a+" --";
        System.out.println("in func: "+a);
    }

    public static void IntTest(int b){
        b++;
        System.out.println("in func: "+b);
    }

    public static void BooleanTest(boolean c){
        c = !c;
        System.out.println("in func: "+c);
    }
}
