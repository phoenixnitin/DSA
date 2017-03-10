import java.lang.*;
import java.util.*;


class DuplicateKeyException extends Exception{
	DuplicateKeyException(){
		System.out.println("Duplicate Entry Found");
	}
}

public class BSTree<Key extends Comparable<Key>, Value>
{
	TreeNode<Key,Value> _root;
	int height = 0;
	int n;

	/**
	* Constructor.
	*/
	public BSTree()
	{
	_root = null;
	}
	/**
	* Public insert method exposed to clients.
	* @param newKey : the key to insert to the tree
	* @param newValue : the value to insert to the tree
	**/

	private boolean lessthan(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) < 0;
    }

    private boolean equivalent(Comparable k1, Comparable k2) {
        return k1.compareTo(k2) == 0;
    }



	public void insert(Key newKey, Value newValue) throws DuplicateKeyException
	{
	//TODO
		if(newKey == null)
			throw new IllegalArgumentException("Key is null");
		if(_root == null)
			_root = new TreeNode(newKey, newValue, null, null);
		else
		{	
			if(equivalent(newKey, _root.key))
				throw new DuplicateKeyException();
			if(lessthan(newKey, _root.key))
				insert(_root.left, newKey, newValue);
			else 
				insert(_root.right, newKey, newValue);
		};
	};
	private void insert(TreeNode<Key,Value> node, Key newKey, Value newValue) throws DuplicateKeyException{
		if(newKey == null)
			throw new IllegalArgumentException("Key is null");
		if(node == null)
			node = new TreeNode(newKey, newValue, null, null);
		else
		{	
			if(equivalent(newKey, _root.key))
				throw new DuplicateKeyException();
			if(lessthan(newKey, _root.key))
				insert(node.left, newKey, newValue);
			else
				insert(node.right, newKey, newValue);
		};
	};
	/**
	* Public get method exposed to clients.
	* @param searchKey : the key to search for in the tree
	* @return the value corresponding to the key given; null if key is not in the tree.
	**/
	public Value valueOf(Key searchKey)
	{
		if(_root == null)
			System.out.println("Tree is empty");
		else
			if(equivalent(searchKey, _root.key))
				return _root.value;
			if(lessthan(searchKey, _root.key))
				return search(_root.left, searchKey);
			else
				return search(_root.right, searchKey);
	};

	private Value search(TreeNode<Key,Value> node, Key searchKey){
		if(node == null)
			System.out.println("Tree is empty");
		else
			if(equivalent(searchKey, node.key))
				return node.value;
			if(lessthan(searchKey, node.key))
				return search(node.left, searchKey);
			else
				return search(node.right, searchKey);
	};
	/**
	* Public method for getting the minimum node from the tree.
	* @return node with the min key in the tree
	**/
	public TreeNode<Key,Value> getMinNode()
	{
		if(_root == null)
			System.out.println("Tree is empty");
		else
			if( _root.left == null)
				return _root;
			else
				return getminnode(_root.left);
		return null;
	};
	private TreeNode<Key,Value> getminnode(TreeNode<Key,Value> node){
		if( node.left == null)
			return node;
		else
			return getminnode(node.left);
	}
	/**
	* Public method for getting the maximum node from the tree.
	* @return node with the max key in the tree.
	**/
	public TreeNode<Key,Value> getMaxNode()
	{
		if(_root == null)
			System.out.println("Tree is empty");
		else
			if( _root.right == null)
				return _root;
			else
				return getmaxnode(_root.right);
		return null;
	};
	private TreeNode<Key,Value> getmaxnode(TreeNode<Key,Value> node){
		if( node.right == null)
			return node;
		else
			return getminnode(node.right);
	}
	/**
	* Public method for getting the median node from the tree.
	* @return node with the median key in the tree.
	**/
	/*public TreeNode<Key,Value> getMedianNode()
	{
	//TODO
	};
	/**
	* Public method for getting the height of the tree.
	* @return the int size of the tree.
	**/
	public int height()
	{
		return height;
	};
	/**
	* Public method for getting the size of the tree.
	* @return the int size of the tree.
	**/
	/*public int size()
	{
		
	};
	/**
	* Public method for getting the utilisation of the tree.
	*
	* The number computed is the fraction
	* (number of keys in the current tree) / (max number of keys that can ←
	* stored in a tree of the same height).
	*
	* @return the int size of the tree.
	**/
	/*public double utilisation()
	{
	//TODO
	};
	/**
	* Public delete method exposed to clients; it deletes the node containing the searchKey.
	* It implements the SYMMETRIC Hibbard deletion algorithm.
	* @param searchKey : the key to delete
	**/
	/*public void delete(Key searchKey)
	{
	//TODO
	};
	/**
	* @return a string with a multi-line representation of the tree.
	**/

	/*public String prettyPrint()
	{
	return prettyPrintMultilineTreeWithRoot(_root, "");
	}

	public String prettyPrintMultilineTreeWithRoot(TreeNode<Key,Value> node, String prefix){

	};

	private String prettyPrintTreeWithRoot(TreeNode<Key,Value> node, String prefix)
	{
	//TODO
	};*/
}