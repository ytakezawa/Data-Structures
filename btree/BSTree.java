package btree;

import btree.BinTree.Node;

public class BSTree <E extends Comparable<E>> extends BinTree<E> {
	private E deletedElement;
	
	//constructor
	BSTree(){
		super();
	}
	
	BSTree(E data){
		super(data);
	}
	
	BSTree(E data, BSTree<E>leftTree, BSTree<E>rightTree){
		root = new Node<E>(data,leftTree.root,rightTree.root);
	}
	
	//method
	public boolean isEmpty() {
		return root ==null;
	}
	
	private boolean find (E key, Node<E> n) {
		if (n == null) {
			return false;
		}else {
			int comparison = n.data.compareTo(key);
			if (comparison == 0) {
				return true;
			}else {
				if (comparison <0) {
					return find(key, n.right);
				}else {
					return find(key, n.left);
				}
			}
		}
	}
	
	public boolean find(E key) {
		return find(key,root);
	}
	
	
	private Node<E> add(E key, Node<E> n) {
		if (n == null) {
			return new Node<E>(key);
		}else {
			int comparison = n.data.compareTo(key);
			if (comparison == 0) {
				throw new IllegalArgumentException();
			}else {
				if (comparison <0) {
					n.right = add(key, n.right);
					return n;
				}else {
					n.left = add(key, n.left);
					return n;
				}
			}
		}
	}
	
	public void add(E key) {
		root = add(key, root);
	}
	
	
	private E max(Node<E> n) {
		if (n.right ==null) {
			return n.data;
		}
		return max(n.right);
	}
	
	public E max() {
		if (root == null) {
			throw new IllegalStateException();
		}
		return max(root);
	}
	
	
	
	
	public E removeMax() {
		if (root == null) {
			throw new IllegalStateException();
		}else {
			if (root.right == null) {
				E temp = root.data;
				root = root.left;
				return temp;
			}else {
				Node<E> current = root;
				while (current.right.right != null) {
					current = current.right;
				}
				E temp = current.right.data;
				current.right = current.right.left;
				return temp;
			}
		}
		
	}
	
	
	private E findAndRemoveMax(Node<E> n) {
		if (n.right.right == null) {
			E temp = n.right.data;
			n.right = n.right.left;
			return temp;
		}else {
			findAndRemoveMax( n.right);
		}
		return deletedElement;
	}
	
	private Node<E> remove (E key, Node<E> n){
		if (n == null) {
			deletedElement = null;
			return null;
		}else {
			int comparison = n.data.compareTo(key);
			if (comparison < 0) {
				n.right = remove(key, n.right);
				return n;
			}else {
				if (comparison > 0) {
					n.left = remove(key, n.left);
					return n;
				}else {	//key = n.data;
					//three = left child is null, right child is null, both are not null
					if (n.left == null) { //case1
						deletedElement = n.data;
						return n.right;
					}else {
						if (n.right == null) { //case2
							deletedElement = n.data;
							return n.left;
						}else { //case3
							if (n.left.right == null) {//case 3a
								n.data = n.left.data;
								n.left = n.left.left;
								return n;
							}else {//case 3b
								E temp = findAndRemoveMax(n.left);
								n.data = temp;
								return n;
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * removes a key from the tree, the key is assumed to not have null keys
	 * @param key
	 * @return
	 */
	public E remove(E key) {
		if (root == null) {
			return null;
		}else {
			root = remove(key, root);
			return deletedElement;
		}
	}
	
	
	
//	public static void main(String[] args) {
//		BSTree<Integer> t1 = new BSTree<Integer>(23,new BSTree<Integer>(12),new BSTree<Integer>(27));
//		BSTree<Integer> t2 = new BinTree<Integer>(72,new BinTree<Integer>(43),new BinTree<Integer>());
//		BinTree<Integer> t = new BinTree<Integer>(34,t1,t2);
//		
//		System.out.println(t);
//		System.out.println(t.height());
//		System.out.println(t.noOfNodes());
//		System.out.println(t.isLeaf());
//		System.out.println((new BinTree<Integer>(4)).isLeaf());
//		System.out.println(t.isFull());
//		System.out.println(t.noOfLeaves());
//	}
}
