import java.lang.*;
import java.util.*;

public class TreeNode<Key, Value>
{
	public Key key;
	public Value value;
	public TreeNode<Key, Value> left, right;
	
	public TreeNode(Key key, Value value, TreeNode<Key, Value> left, TreeNode<Key, Value> right){
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}
}