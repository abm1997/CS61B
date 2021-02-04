public class SLList{
	public static class IntNode{
		public int item;
		public IntNode next;
		
		public IntNode(int i , IntNode n){
			item = i;
			next = n;
		}
	}

	private IntNode sentinel;
	public int size;

	public SLList(){ //constructor for the empty list
		sentinel = new IntNode(63,null);
		size = 0;
	}
	public SLList(int x){
		sentinel = new IntNode(63,null);
		sentinel.next = new IntNode(x,null);
		size = 1;
	}

	public void addFirst(int x){
		sentinel.next = new IntNode(x,sentinel.next);
		size++;
	}

	public int getFirst(){
		return sentinel.next.item;
	}

	public void addLast(int x){
		IntNode p = sentinel;
		while (p.next != null){
			p = p.next;
		}
		p.next = new IntNode(x,null);
		size++;
	}

	/**
		Here we used 2 size methods because we are in
		SLList class not IntNode class and can't make recursive method that 
		is called by IntNode object
	
	public static int size(IntNode p){
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
		SLList L = new SLList(15);
		L.addLast(10);	
		L.addLast(5);
		L.addFirst(20);	
		System.out.println(L.size());
	}
}