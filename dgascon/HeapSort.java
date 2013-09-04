package dgascon;


public class HeapSort {
	
	static public int[] sort (int [] values) {
		int [] sortedList = values.clone();
		heapify(sortedList);

		System.out.println(" ");
		for (int endIdx = values.length -1; endIdx > 0; endIdx--) {
			swap(sortedList, endIdx, 0);
			siftDown(sortedList, 0, endIdx - 1);
		}
		return sortedList;
		
	}
	
	static private void heapify (int [] values) {
		int startIdx = (values.length - 2) /2;
		
		while ( startIdx >= 0 ) {
			siftDown(values, startIdx, values.length -1);
			startIdx -= 1;
		}
	}
	
	static private void siftDown(int [] values, int startIdx, int endIdx) {
		int rootIdx = startIdx;
		
		while ( rootIdx * 2 + 1 <= endIdx ) {
			int childIdx = rootIdx * 2 + 1;
			int swapIdx = rootIdx;
			if ( values[swapIdx] < values[childIdx] ) {
				swapIdx = childIdx;
			}
			if ( childIdx + 1 <= endIdx && values[swapIdx] < values[childIdx + 1]) {
				swapIdx = childIdx + 1;
			}
			if ( swapIdx != rootIdx) {
				swap(values, rootIdx, swapIdx);
				rootIdx = swapIdx;
			}
			else {
				return;
			}
		}
		
	}
	
	static private void swap(int [] values, int firstIdx, int secondIdx) {
		if ( firstIdx < values.length && secondIdx < values.length ) {
			int temp = values[firstIdx];
			values[firstIdx] = values[secondIdx];
			values[secondIdx] = temp;
		}
	}

}
