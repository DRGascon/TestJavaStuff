package dgascon;


public class MergeSort {
	
	static public int[] sort(int [] values) {
		
		if ( 1 < values.length ) {
			int [] leftList = new int [values.length / 2];
			int rightListSize = values.length % 2 == 0 ? values.length / 2 : values.length / 2 +1;
			int [] rightList = new int [rightListSize];
			for ( int x = 0; x < values.length / 2; x++) {
				leftList[x] = values[x];
			}
			for ( int x = 0; x < rightListSize; x++) {
				rightList[x] = values[x + values.length/2];
			}
			leftList = sort(leftList);
			rightList = sort(rightList);
			return merge(leftList, rightList);
		}
		else {
			return values;
		}
	}
	
	static private int[] merge(int [] leftValues, int [] rightValues) {
		int [] mergedList = new int [leftValues.length + rightValues.length];
		int leftIdx =0;
		int rightIdx = 0;
		int mergedIdx = 0;
		while (leftIdx < leftValues.length || rightIdx < rightValues.length) {
			if ( leftIdx < leftValues.length && rightIdx < rightValues.length ) {
				if (leftValues[leftIdx] < rightValues[rightIdx]) {
					mergedList[mergedIdx++] = leftValues[leftIdx++];
				}
				else  {
					mergedList[mergedIdx++] = rightValues[rightIdx++];
				}
			}
			else if (leftIdx < leftValues.length) {
				while (leftIdx < leftValues.length) {
					mergedList[mergedIdx++] = leftValues[leftIdx++];
				}
			}
			else if (rightIdx < rightValues.length) {
				while (rightIdx < rightValues.length) {
					mergedList[mergedIdx++] = rightValues[rightIdx++];
				}
			}
		}
		return mergedList;
		
	}

}
