public class fibo {

    public static void fib(int n){
        int currentTerm=0;
        int previousTerm=1; 
        int lastTerm=0;       

        for(int i=2;i<n;i++){
            currentTerm = previousTerm + lastTerm ;
            lastTerm = previousTerm ;
            previousTerm = currentTerm ;
        }
        System.out.println(currentTerm);
    }

    public static int fibRecursion(int n){
        if(n==1) {
            return 0;
        } else if(n==2) {
            return 1;
        } else {
	    return fibRecursion(n-1)+fibRecursion(n-2);
        }
    }

    public static void main(String args[]){
        fib(7);
	System.out.println(fibRecursion(7));
    }
}