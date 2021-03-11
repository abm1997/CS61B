public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst; //the index of next first item
    private int nextLast; //the index of next last item

    public ArrayDeque(){//done
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public ArrayDeque(ArrayDeque other){
        items = (T[]) new Object[other.items.length];
        size = other.size();
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        System.arraycopy(this.items,0,other.items,0,other.items.length);
    }

    public int minus(int x , int y){
        if (x-y<0) {
            return x-y+items.length;
        }
        return x-y;
    }

    public int plus(int x , int y){
        if (x+y>=items.length) {
            return x+y-items.length;
        }
        return x+y;
    }

    public void resize(int newLength){//done
        T[] a = (T[]) new Object[newLength];
        int currentFirst = plus(nextFirst,1);
        int currentLast = minus(nextLast,1);

        if(currentFirst < currentLast) {
            System.arraycopy(items,currentFirst,a,0,currentLast-currentFirst+1);
        } else {
            System.arraycopy(items,currentFirst,a,0,items.length-currentFirst);
            System.arraycopy(items,0,a,items.length-currentFirst,nextLast);
        }
        nextFirst = newLength-1;
        nextLast = size;
        items = a;
    }

    @Override
    public void addFirst(T item){
        if (size == items.length){
            this.resize(2*size);
        }

        items[nextFirst] = item;
        nextFirst = minus(nextFirst,1);
        size++;
    }

    @Override
    public void addLast(T item){//done
        if (size == items.length){
            this.resize(2*size);
        }

        items[nextLast] = item;
        nextLast = plus(nextLast,1);
        size++;
    }

    @Override
    public boolean isEmpty(){//done
        if (size == 0){
            return true;
        }
        return false;
    }

    @Override
    public int size(){//done
        return size;
    }

    @Override
    public void printDeque(){//done
        if (!this.isEmpty()){
            for(int index=0 ; index<size ; index++){
                System.out.print(this.get(index));
            }
            System.out.println("");
        }
    }

    @Override
    public T removeFirst(){
        if(this.isEmpty()){
            return null;
        }
        nextFirst = plus(nextFirst,1);
        T removedItem = items[nextFirst];
        items[nextFirst] = null;
        size--;

        if( ((double)size/items.length<=0.25 && items.length>=16) ){
            this.resize(size);
        }
        return removedItem;
    }

    @Override
    public T removeLast(){
        if(this.isEmpty()){
            return  null;
        }
        nextLast = minus(nextLast,1);
        T removedItem = items[nextLast];
        items[nextLast] = null;
        size--;

        if( ((double)size/items.length<=0.25 && items.length>=16) ){
            this.resize(size);
        }
        return removedItem;
    }

    @Override
    public T get(int index){//done
        if(this.isEmpty() || index<0 || index>items.length){
            return null;
        }

        int currentFirst = plus(nextFirst,1);
        int currentLast = minus(nextLast,1);
        int number_of_firsts = items.length-currentFirst;//no of firsts at the end only
        if(currentFirst>currentLast){
            if(index <= number_of_firsts-1) {
                return items[index+currentFirst];
            } else {
                return items[index-number_of_firsts];
            }
        } else {
            return items[index];
        }
    }

    /** public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<Integer>();
        L.addLast(17);
        L.addLast(18);
        L.addLast(19);
        L.addLast(199);

        L.addLast(17);
        L.addLast(3);
        L.addLast(4);
        L.addLast(5);

        L.removeFirst();
        L.removeFirst();
        L.removeFirst();
        L.removeFirst();

        L.addFirst(20);
        L.addFirst(21);
        L.addFirst(22);
        L.addFirst(23);

        L.removeLast();
        L.removeLast();

        L.addFirst(24);
        L.addFirst(25);

        System.out.println(L.get(6));



    }
     */

}