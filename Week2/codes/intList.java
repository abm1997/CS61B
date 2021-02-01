public class intList{
	public int first ;
	public intList rest = null ;
	public intList(int f , intList r){
		first = f;
		rest = r;
	}

	public int size(){
		if (this.rest == null) {
			return 1;
		} else {
			return this.rest.size() + 1 ;
		}
	}

	public int iterativeSize() { 
		int sizeoflist = 1;
		intList t = this;
		while (t.rest != null) {
			sizeoflist++ ; 
			t = t.rest ;
		}
		return sizeoflist ;
	}

	public int get(int i){ // returns the ith item in the list "Recursion version"
		if(i==0) {
			return this.first;
		} else {
			return this.rest.get(i-1);
		}
	}

	public int iterativeGet(int i){ // returns the ith item in the list "Iterative version"
		intList p = this ;
		while(i>0){
			p = p.rest ;
			i--;
		}
		return p.first;
	}

	/** Returns an IntList identical to L, but with
      * each element incremented by x. Original L is not allowed
      * to change. */
    public static intList incrList(intList L, int x) {
       int lastElement = L.size()-1;
       intList newL = new intList(L.get(lastElement)+x,null); // copying last element (no: size of list - 1)
       for (int i=lastElement-1 ; i>=0 ;i--){ //giong backward . copying from the element before the last one to the first element(no 0)
       		newL = new intList(L.get(i)+x , newL);
       }
       return newL;
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x.It change the orginal L. Not allowed to use
      * the 'new' keyword. */
    public static intList dincrList(intList L, int x) {
    	L.first += x;
    	if (L.rest == null){
    	} else {
    		dincrList(L.rest,x);
    	}
    	return L;
    }

	public static void main(String[] args) {
		/** New list L contains 3 items : L0=5 - L1=10 - L2=15 
		//Method 1
		intList L = new intList(5,null);
		L.rest = new intList(10,null);
		L.rest.rest = new intList(15,null); */

		//Method 2
		intList L = new intList(15,null) ;
		L = new intList(10,L);
		L = new intList(5,L);

		//System.out.println(L.size());
		//System.out.println(L.iterativeSize());
		//System.out.println(L.iterativeGet(2));

		intList q = incrList(L,3);
		//dincrList(L,3);
		System.out.println(L.get(0));
		System.out.println(L.get(1));
		System.out.println(L.get(2));

		System.out.println(q.get(0));
		System.out.println(q.get(1));
		System.out.println(q.get(2));
	}
}