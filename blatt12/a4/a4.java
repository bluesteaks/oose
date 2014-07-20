public class a4{
	public static void main(String[] args){
		Tree t=new Tree(new Node(3));
		t.root.left=new Node(1);
		t.root.right=new Node(4);
		t.root.right.left=new Node(2);
		t.root.right.right=new Node(5);

		t.inorder(new PrintAction());

		isSearchTree s=new isSearchTree();
		t.inorder(s);
		System.out.println(s.isIt);

		t.insertSorted(20);
		t.inorder(new PrintAction());
		s=new isSearchTree();
		t.inorder(s);
		System.out.println(s.isIt);

		t.find(21);
	}
}

class Node{
	public Node left;
	public Node right;
	public Object data;

	public Node(Object a){
		data=a;
		left=right=null;
	}
}

class Tree{
	public Node root;

	public Tree(){root=null;}

	public Tree(Node rn){root=rn;}

	public boolean isEmpty(){
		return (root==null);
	}

	public void inorder(NodeActionInterface p){
		if(root==null)
			return;

		Tree leftTree=new Tree(root.left);
		Tree rightTree=new Tree(root.right);

		leftTree.inorder(p);
		p.action(root);
		rightTree.inorder(p);
	}

	public void insertSorted(int n){
		if(root.left != null && (Integer)root.left.data > n){
			Tree leftTree=new Tree(root.left);
			leftTree.insertSorted(n);
		}

		if(root.right != null && (Integer)root.right.data <= n){
			Tree rightTree=new Tree(root.right);
			rightTree.insertSorted(n);
		}

		if(root.left==null && n<(Integer)root.data)
			root.left=new Node(n);

		if(root.right==null && n>=(Integer)root.data)
			root.right=new Node(n);

	}

	public void find(int n){
		if(root==null){
			System.out.println(n+" not found.");
			return;
		}

		if((Integer)root.data==n)
			System.out.println("Found "+n);

		if((Integer)root.data>n){
			Tree leftTree=new Tree(root.left);
			leftTree.find(n);
		}

		if((Integer)root.data<n){
			Tree rightTree=new Tree(root.right);
			rightTree.find(n);
		}
	}
}

interface NodeActionInterface {
public void action(Node n);
}

class PrintAction implements NodeActionInterface{
	public void action(Node n){
		System.out.print(n.data);
	}
}

class CountAction implements NodeActionInterface{
	int oneSucc;
	int twoSucc;

	public void action(Node n){
		if((n.left==null)^(n.right==null))
			oneSucc++;
		if((n.left!=null) && (n.right!=null))
			twoSucc++;
	}
}

class isSearchTree implements NodeActionInterface{
	boolean isIt=true;
	int before=Integer.MIN_VALUE;

	public void action(Node n){
		if((Integer)n.data<=before)
			isIt=false;
	}
}