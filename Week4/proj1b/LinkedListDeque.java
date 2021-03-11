public class LinkedListDeque<T> implements Deque<T>{
	public class Node{
		public Node prev;
		public T item;
		public Node next;

		public Node(Node p, T i ,Node n){
			prev = p;
			item = i;
			next = n;
		}

		public Node geNodeRecursive(int index){
			if (index==0){
				return this;
			}
			return this.next.geNodeRecursive(index-1) ;
		}
	}

	private Node sentinel;
	private int size;

	@Override
	public void addFirst(T item){
		Node p = sentinel.next; //pointer to the old first item
		sentinel.next = new Node(sentinel,item,sentinel.next);
		p.prev = sentinel.next;//updates the prev pointer for the old first item
		size++;
	}

	@Override
	public void addLast(T item){
		sentinel.prev.next = new Node( sentinel.prev,item,sentinel );
		sentinel.prev = sentinel.prev.next;
		size++;
	}

	@Override
	public boolean isEmpty(){
		if(sentinel.next == sentinel){
			return true;
		}
		return false;
	}

	@Override
	public int size(){
		return size;
	}

	@Override
	public void printDeque(){
		for(int i=0 ; i<size ; i++){
			System.out.print(this.get(i));
		}
		System.out.println("");
	}

	@Override
	public T removeFirst(){
		if(this.isEmpty()){
			return null;
		}

		Node p = sentinel.next;//pointer to the item to be removed
		T removedItem = p.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;

		p.item = null;
		p.next = null;
		p.prev = null;
		return removedItem;
	}

	@Override
	public T removeLast(){
		if(this.isEmpty()){
			return null;
		}

		Node p = sentinel.prev;//pointer to the item to be removed
		T removedItem = p.item;
		sentinel.prev.prev.next = sentinel;
		sentinel.prev = sentinel.prev.prev;
		size--;

		p.item = null;
		p.next = null;
		p.prev = null;
		return removedItem;
	}

	@Override
	public T get(int index){
		if(this.isEmpty()){
			return null;
		}

		Node p = sentinel.next;
		for(int i=0 ; i<index ; i++){
			p = p.next;
		}
		return p.item;
	}

	public T getRecursive(int index){
		if (this.isEmpty()){
			return null;
		}
		return sentinel.next.geNodeRecursive(index).item;
	}

	public LinkedListDeque(){
		sentinel = new Node(null,null,null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = 0;
	}

	public LinkedListDeque(LinkedListDeque other){
		sentinel = new Node(null,null,null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		size = other.size();

		if(!other.isEmpty()){
			Node p = other.sentinel.next;
			while (p != other.sentinel){
				this.addLast(p.item);
				p = p.next;
			}
		}
		/*
		for(int i=0 ; i<other.size ; i++){
			this.addLast(other.get(i));
		}
		*/
	}
	
}