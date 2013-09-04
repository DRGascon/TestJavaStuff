package dgascon;

public class Heap {

	public Heap (int [] values, Boolean maxOrdered) {
		this.maxOrdered = maxOrdered;
		heapedValues = values.clone();
		makeHeap(values);
	}
	
	public String toString() {
		String outString = new String("");
		for ( int value : heapedValues) {
			outString += " " + value + " "; 
		}
		return outString;
	}
	
	private void makeHeap (int [] values) {
		
		// Keep traversing up the list
		for(int lastParentNode = ((values.length-2)/2); lastParentNode >= 0; lastParentNode--) {
			if(lastParentNode == 0) {
				@SuppressWarnings("unused")
				int i = 0;
			}
			siftDown(lastParentNode);
		}
		
	}
	/**
	 * Traverse down the heap, swapping out children nodes with parents if they're greater
	 * @param startNodeIdx
	 */
	private void siftDown(int startNodeIdx) {
		int currentNodeIdx = startNodeIdx;
		
		while ( currentNodeIdx * 2 + 1 < heapedValues.length ) {
			int leftChildIdx = currentNodeIdx * 2 + 1;
			int rightChildIdx = leftChildIdx + 1;
			int nodeToSwap = currentNodeIdx;
			if (shouldSwapChildAndParent(leftChildIdx, nodeToSwap)) {
				nodeToSwap = leftChildIdx;
			}
			if (rightChildIdx < heapedValues.length && 
					shouldSwapChildAndParent(rightChildIdx, nodeToSwap)) {
				nodeToSwap = rightChildIdx;
			}
			if ( nodeToSwap != currentNodeIdx ) {
				swap(currentNodeIdx, nodeToSwap);
				currentNodeIdx = nodeToSwap;
			}
			else {
				return;
			}
		}
	}
	
	private Boolean shouldSwapChildAndParent(int childIdx, int parentIdx) {
		return maxOrdered ? heapedValues[parentIdx] < heapedValues[childIdx] :
			heapedValues[parentIdx] > heapedValues[childIdx];
	}
	private void swap(int firstIdx, int secondIdx) {
		if ( firstIdx >= heapedValues.length || secondIdx >= heapedValues.length ) {
			return;
		}
		heapedValues[firstIdx] ^= heapedValues[secondIdx];
		heapedValues[secondIdx] ^= heapedValues[firstIdx];
		heapedValues[firstIdx] ^= heapedValues[secondIdx];
	}
	private int [] heapedValues;
	private Boolean maxOrdered;
}
