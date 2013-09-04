package dgascon;
/**
 * 
 */


import dgascon.MergeSort;
import dgascon.HeapSort;
import dgascon.BinaryTree;
import dgascon.AdjacencyList;

/**
 * @author dgascon
 * 
 * Some code to help brush up on sorts and traversals
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int sortTest[] = {10, 10, 10, 12, 5, 6, 12, 800, 96345, 1588, 234859, -1, 1200, 99999};
		
		int mergeSortedArray[] = MergeSort.sort(sortTest);
		System.out.println("=========== Merge Sort ==========");
		for ( int x : mergeSortedArray) {
			System.out.println(x);
		}
		
		int heapSortedArray[] = HeapSort.sort(sortTest);
		System.out.println("=========== Heap Sort ==========");
		for ( int x : heapSortedArray) {
			System.out.println(x);
		}
		
		BinaryTree testTree = new BinaryTree();
		
		testTree.insert(15);
		testTree.insert(20);
		testTree.insert(10);
		
		System.out.println(testTree.toString());
		
		Heap testHeap = new Heap(sortTest, false);
		
		System.out.println("Min heap: " + testHeap.toString());
		
		testHeap = new Heap(sortTest, true);
		
		System.out.println("Max heap: " + testHeap.toString());
		
		AdjacencyList adjacency = new AdjacencyList();
		adjacency.setupGrid(100);
		
		System.out.print(adjacency.areNodesConnected(0, 9) + "\n");

	}
	
	

}
