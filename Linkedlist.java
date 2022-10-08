public class Linkedlist{
	public static class TreeNode
	{
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data)
		{
			this.data=data;
		}
	}
 
	public static boolean search(TreeNode root,TreeNode nodeSearched)
	{
		if(root==null)
			return false;
		if(root.data== nodeSearched.data)
		{
			return true;
		}
		boolean result=false;
		if(root.data > nodeSearched.data)
			result=search(root.left,nodeSearched);
		else if(root.data < nodeSearched.data)
			result= search(root.right,nodeSearched);
		return result;
	}
 
	public static TreeNode minimumElement(TreeNode root)
	{
		if(root.left==null)
			return root;
		else
		{
			return minimumElement(root.left);
		}
	}
 
	public static TreeNode maximumElement(TreeNode root)
	{
		if(root.right==null)
			return root;
		else
		{
			return maximumElement(root.right);
		}
	}
	public static TreeNode insert(TreeNode root,TreeNode nodeInserted)
	{
		if(root==null)
		{
			root=nodeInserted;
			return root;
		}
 
		if(root.data > nodeInserted.data)
		{
			if(root.left==null)
				root.left=nodeInserted;
			else
				insert(root.left,nodeInserted);
		}
		else if(root.data < nodeInserted.data)
			if(root.right==null)
				root.right=nodeInserted;
			else
				insert(root.right,nodeInserted);
		return root;
	} 
 
	public static void inOrder(TreeNode root)
	{
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" ");
		inOrder(root.right);
	}
	public static void main(String[] args)
	{
 
		TreeNode rootNode=createBinarySearchTree();
		System.out.println("Minimum element : "+minimumElement(rootNode).data);
		System.out.println("Maximum element : "+maximumElement(rootNode).data);
 
	}  

}
