package heap;

import java.util.List;

public class Heap {

	List<Integer> l;
	int len;
	
	public Heap(List<Integer> l) {
		this.l = l;
		len = l.size()-1;
	}
	
	private void swap(int i, int j) {
		int tmp = l.get(i);
		l.set(i, l.get(j));
		l.set(j, tmp);
	}
	
	private int getParentIndex(int childIndex){
		return childIndex/2;
	}
	
	private int getLeftChildIndex(int parentIndex){
		return parentIndex*2;
	}
	
	private int getRightChildIndex(int parentIndex){
		return parentIndex*2+1;
	}
	
	public void insert(int x) {
		l.add(x);
		len++;
		int i=len;
		while(i>1) {
			if(l.get(i)>l.get(getParentIndex(i))) {
				swap(i, getParentIndex(i));
				i= getParentIndex(i);
			} else{
				break;
			}
		}
	}

	public void deleteRoot() {
		l.set(1, l.get(len));
		l.remove(len);
		len--;
		int i = 1;
		while(i<len) {
			Integer max = getMaxChildIndex(i);
			if(max==null) {
				break;
			}
			if(l.get(i)<l.get(max)) {
				swap(i, max);
				i = max;
			} else {
				break;
			}
		}
	}
	
	private Integer getMaxChildIndex(int i) {
		if(getLeftChildIndex(i) > len && getRightChildIndex(i)>len) {
			return null;
		} else if(getLeftChildIndex(i) > len) {
			return getRightChildIndex(i);
		} else if (getRightChildIndex(i)>len) {
			return getLeftChildIndex(i);
		} else {
			return l.get(getLeftChildIndex(i)) >= l.get(getRightChildIndex(i)) ? getLeftChildIndex(i) : getRightChildIndex(i);
		}
	}
	
	@Override
	public String toString() {
		if(len<2) {
			return "[]";
		}
		StringBuilder str = new StringBuilder();
		str.append("["+l.get(1));
		for(int i =2; i<=len; i++) {
			str.append(", "+l.get(i));
		}
		str.append("]");
		return str.toString();
	}
}
