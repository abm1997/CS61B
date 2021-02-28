public class Sort{
    /**
     Find the smallest item.
     Move it to the front.
     Selection sort the remaining N-1 items (without touching the front item).
     */

    //find the smallest
    //@Source Comparing strings https://stackoverflow.com/questions/5153496/how-can-i-compare-two-strings-in-java-and-define-which-of-them-is-smaller-than-t
    public static int findSmallest(String[] x ,int start){
        int smallestIndex = start;
        for(int i=start ; i<x.length ; i++){
            int cmp =x[i].compareToIgnoreCase(x[smallestIndex]);
            if (x[i].compareToIgnoreCase(x[smallestIndex]) < 0){//it returns negative number if the first is less than the seconde
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static void swap(String[] x , int a , int b ){
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /**Sort string x starting from start*/
    private static void sort(String[] x , int start){
        if(start == x.length){
            return ;
        }
        int smallestIndex = findSmallest(x,start);
        swap(x,start,smallestIndex);
        sort(x,start+1);
    }

    public static void sort(String[] x){
        sort(x,0);
    }
}