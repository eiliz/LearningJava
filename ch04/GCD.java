package ch04;

public class GCD {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);

        while (b != 0) {
            if (a > b) {
                a = a- b;
            } else {
                b = b -a;
            }
        }

        System.out.println("GCD is " + a);
    }
}