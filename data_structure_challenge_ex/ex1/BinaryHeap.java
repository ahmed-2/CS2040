import java.util.*;

// Ahmed implementation of max heap

public class BinaryHeap {
  private HashMap<Integer,Integer> A;
  private int BinaryHeapSize;

  BinaryHeap() {
    A = new HashMap<Integer,Integer>();
    BinaryHeapSize = 0;
  }

  BinaryHeap(int[] array) {
    CreateHeap(array);
  }

  int parent(int i) { return i>>1; } // shortcut for i/2, round down
  
  int left(int i) { return i<<1; } // shortcut for 2*i
  
  int right(int i) { return (i<<1) + 1; } // shortcut for 2*i + 1
  
  void shiftUp(int i) {
    while (i > 1 && A.get(parent(i)) < A.get(i)) {
      int temp = A.get(i);
      A.replace(i, A.get(parent(i)));
      A.replace(parent(i), temp);
      i = parent(i);
    }
  }

  void Insert(int val) {
    BinaryHeapSize++;
    if (BinaryHeapSize >= A.size())
      A.put(BinaryHeapSize, val);
    else
      A.replace(BinaryHeapSize, val);
    shiftUp(BinaryHeapSize);
  }

  void shiftDown(int i) {
    while (i <= BinaryHeapSize) {
      int maxV = A.get(i), max_id = i;

      // compare value of this node with its left subtree, if possible
      if (left(i) <= BinaryHeapSize && maxV < A.get(left(i))) { 
        maxV = A.get(left(i));
        max_id = left(i);
      }
      // now compare with its right subtree, if possible
      if (right(i) <= BinaryHeapSize && maxV < A.get(right(i))) {
        maxV = A.get(right(i)); // can remove this statement since biggest value already found, i.e
                                // maxV no longer needed
        max_id = right(i);
      }
  
      if (max_id != i) {
        int temp = A.get(i);
        A.replace(i, A.get(max_id));
        A.replace(max_id, temp);
        i = max_id;
      }
      else
        break;
    }
  }
  
  // Question: what happens if heap is empty?
  int ExtractMax() {
  	int maxV = A.get(1);    
      
    A.replace(1, A.get(BinaryHeapSize));
    A.remove(BinaryHeapSize);
    BinaryHeapSize--; // virtual decrease
    shiftDown(1);
    
    return maxV;
  }
  
  void UpdateKey(int i, int j) {
    int n = search(1, i);
    A.replace(n, j);
    if (j > i) {
      shiftUp(n);
    } else {
      shiftDown(n);
    }
  } 
  
  int search(int x, int y) {
    if (A.get(x).equals(y)) {
      return x;
    }
    if (left(x) <= BinaryHeapSize && y <= A.get(left(x))) {
      int l = search(left(x), y);
      if (l != 0) {
        return l;
      }
    }
    if (right(x) <= BinaryHeapSize && y <= A.get(right(x))) {
      int r = search(right(x), y);
      return r;
    }
    return 0;
  }

  void CreateHeapSlow(int[] arr) { // the O(N log N) version, array arr is 0-based
    A = new HashMap<Integer,Integer>();
    for (int i = 1; i <= arr.length; i++)
      Insert(arr[i-1]);
  }
  
  void CreateHeap(int[] arr) { // the O(N) version, array arr is 0-based
    BinaryHeapSize = arr.length;
    int x = 1;
    A = new HashMap<Integer,Integer>();
    for (int i = 1; i <= BinaryHeapSize; i++) // copy the content
      A.put(x++, arr[i-1]);
    for (int i = parent(BinaryHeapSize); i >= 1; i--)
      shiftDown(i);
  }
  
  HashMap<Integer,Integer> HeapSort(int[] arr) { // array arr is 0-based
    CreateHeap(arr);
    int N = arr.length;
    for (int i = 1; i <= N; i++)
      A.replace(N-i+1, ExtractMax());
    return A; // ignore the first index 0
  }
  
  int size() { return BinaryHeapSize; }
  
  boolean isEmpty() { return BinaryHeapSize == 0; }
}
