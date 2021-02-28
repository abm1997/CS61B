public class SLList {
    private class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(){
        this.first = null;
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position) {
        if (position == 0) {
            this.addFirst(item);
            return;
        }

        IntNode ptr = first;
        IntNode prev = null;
        for (int i=0 ; i != position && ptr != null ; i++) {
            prev = ptr;
            ptr = ptr.next;
        }
        ptr = new IntNode(item,ptr);
        prev.next = ptr;
    }

    public void reverse() {
        IntNode forward = this.first;
        IntNode prev = null;
        while (forward!=null){
            forward = forward.next;
            this.first.next = prev;
            prev = this.first;
            this.first = forward;
        }
        this.first =  prev;
    }

    public void reverseRecur() {
        this.first = reverseRecurHelper(this.first, null);
    }

    private IntNode reverseRecurHelper(IntNode current, IntNode prev) {
        if (current == null) { //the base case : the list is empty.
            return prev;
        }
        IntNode forward = current.next;
        current.next = prev;
        return reverseRecurHelper(forward, current);
    }

    public static int[] insert(int[] oldArr, int item, int position) {
        int[] newArr = new int[oldArr.length+1];
        if (position > oldArr.length) {
            position = oldArr.length;
        }

        int i=0 ;
        while (i < position) {
            newArr[i] = oldArr[i];
            i++;
        }

        newArr[i] = item;
        i++;

        while(i<newArr.length) {
            newArr[i] = oldArr[i-1];
            i++;
        }
        return newArr;
    }

    public static void reverseArr(int[] arr) {
        for(int i=1 ; i<=arr.length/2 ; i++) {
            int temp = arr[i-1];
            arr[i-1] = arr[arr.length-i] ;
            arr[arr.length-i] = temp;
        }
    }

    public static void main(String[] args) {
        SLList A = new SLList();
        A.addFirst(3);
        A.addFirst(2);
        A.addFirst(1);
        A.addFirst(0);
        A.reverseRecur();

        int[] arr = new int[]{10,20,30,40,50};
        //int[] iarr = insert(arr, 99, 2);
        reverseArr(arr);
    }
}
