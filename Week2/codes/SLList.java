public class SLList<sometype>{
	public class StuffNode{
		public sometype item;
		public StuffNode next;
		
		public StuffNode(sometype i , StuffNode n){
			item = i;
			next = n;
		}
	}

	private StuffNode sentinel;
	public StuffNode last;
	private int size;

	public SLList(){ //constructor for the empty list
		sentinel = new StuffNode(null,null);
		size = 0;
		last = sentinel;
	}
	public SLList(sometype x){
		sentinel = new StuffNode(null,null);
		sentinel.next = new StuffNode(x,null);
		size = 1;
		last = sentinel.next;
	}

	public void addFirst(sometype x){ 
		sentinel.next = new StuffNode(x,sentinel.next);
		if (last == sentinel) last = sentinel.next; //special case for the empty list first item.
		size++;
	}

	public sometype getFirst(){
		return sentinel.next.item;
	}

	public void addLast(sometype x){
		/*StuffNode p = sentinel;
		while (p.next != null){
			p = p.next;
		}
		p.next = new StuffNode(x,null);*/
		last.next = new StuffNode(x,null);
		last = last.next;
		size++;
	}

	/**
		Here we used 2 size methods because we are in
		SLList class not IntNode class and can't make recursive method that 
		is called by IntNode object
	
	public static int size(StuffNode p){
		if (p.next == null){
			return 1;
		} else {
			return 1 + size(p.next);
		}
	}

	public int size(){
		return size(first);
	}*/

	public int size(){
		return this.size;
	}


	public static void main(String[] args) {
		SLList<String> L = new SLList<>();
		L.addFirst("111");
		L.addLast("222generic");
		System.out.println(L.last.item);

		
	}
}