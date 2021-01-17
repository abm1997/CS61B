public class array {

    public static int largestNumber(int[] numbers) {
        int larger = numbers[0];
        for(int counter = 1; counter<numbers.length ;counter++) {
           if (numbers[counter] > larger) {
               larger = numbers[counter];
           } 
        }
         return larger;
    }

    public static void main(String[] args){
        int[] num = new int[]{1,9,-5,11,-7,2,3};
        System.out.println(largestNumber(num));
    }
}