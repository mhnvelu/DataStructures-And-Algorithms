# DataStructures-And-Algorithms

## Trees
- A Tree is data structure composed of nodes.
- Each tree has a root vertex.
- The root vertex has zero or more child nodes.
- Each child vertex has zero or more child nodes and so on.
- The Tree cannot contain cycles.
- Nodes may or may not be in a particular order.
- Nodes can have any data types as values and they may or may not have links back to their parent
 nodes.

### Trees Vs Binary Trees
- Binary tree is a tree in which each vertex has up to 2 children.
- Not all trees are binary trees.
- A vertex is called a 'leaf' if it has no children.

### Binary Tree Vs Binary Search Tree
- A Binary Search Tree is a binary tree in which every vertex fits a specific ordering property.
- all left descendents <= n < all right descendents. This must be true for each vertex n.
- The definition of Binary Search Tree can vary slightly:
    - Tree cannot have duplicate values.
    - Duplicate values will be on the right or can be on either side.

### Balanced Vs Unbalanced
- Balanced tree doesn't mean the left and right subtrees are exactly the same size.
- Think it as something like "not terribly imbalanced". Its balanced enough to ensure o(log n) 
times for insert and find.
- It can be defined to be a tree such that the heights of the 2 subtrees of any node never differ
 by more than one
- 2 Common types of balanced trees:
    - Red-Black Trees
    - AVL trees
    
### Complete Binary Trees
- Complete Binary Tree is a binary tree in which every level of the tree is fully filled, except 
may be the last level. To the extent that last level is filled, it is filled left to right.

### Full Binary Trees
- Full Binary Tree is a binary tree in which every vertex has either 0 or 2 children, No nodes have
 only one child.
 
### Perfect Binary Trees
- Perfect Binary Tree is one that is both full and complete. All leaf nodes will be at the same 
level and this level has the maximum number of nodes.

### Notes
- A node’s height is the number of edges to its most distant leaf node
- A node’s depth is the number of edges back up to the root
- The root always has a depth of 0 while leaf nodes always have a height of 0
- Tree as a whole, its depth and height are both the root height.
- Height or depth for any node can be done using breadth-first search (BFS)
- In recursive algorithms, we should make sure that base cases as well as null cases are well 
handled
- Inorder traversal on Binary Tree may result in sorted values if it is BST