
public class recursion {

    public static void main(String[] args) {
//        System.out.println(sum(7));
//        System.out.println(sum(1));
//        int a[] = {2,4,1,5,2};
//        System.out.println(min(a,a.length));
//        System.out.println(findsum(a, a.length));
//        char c[] = "radares".toCharArray();
//        System.out.println(ispalindrome(c, c.length));
//        int m = 3, n = 2;
//        System.out.println(GCD(m, n));
//        System.out.println(power(m, n));
//        System.out.println(fact(3));
//        System.out.println(fib(9));

        
    }

    static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    static int min(int a[], int n) {
        if (n == 1) {
            return a[0];
        } else if (a[0] > a[n - 1]) {
            a[0] = a[n - 1];
        }
        return min(a, n - 1);

    }

    static int findsum(int a[], int n) {
        if (n <= 0) {
            return 0;
        } else //            System.out.println(n);
        //            System.out.println(a[n-1]);
        {
            return findsum(a, n - 1) + a[n - 1];
        }
    }

    static int ispalindrome(char a[], int n) {
        if (n == 1) {
            return 1;
        }
        int m = a.length;
        if (a[m - n] != a[n - 1]) {
            return 0;
        } else {
            return ispalindrome(a, n - 1);
        }
    }

    static int GCD(int m, int n) {
        if (n == 0) {
            return m;
        } else {
            return GCD(n, m % n);
        }
    }

    static int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return (x * power(x, n - 1));
        }
    }

    static int fact(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * fact(n - 1);
        }
    }

    static int fib(int n) {
        if (n <= 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }


}
