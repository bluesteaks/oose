public class a3{
	public static void main(String[] args){
		Tree t=new Tree(new Node("+"));
		t.root.left=new Node("1");
		t.root.right=new Node("*");
		t.root.right.left=new Node("2");
		t.root.right.right=new Node("3");

		t.inorder(new PrintAction());
		System.out.println();

		CountAction c=new CountAction();
		t.inorder(c);
		System.out.println(c.oneSucc+" "+c.twoSucc);
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