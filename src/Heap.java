import java.util.ArrayList;
import java.util.List;


public class Heap extends Bordure{
	public List heap;

	public Heap() {
		heap = new ArrayList();
	}

	public void ajouter(Sommet s) {
		heap.add(s);
		pushUp(heap.size()-1);
	}

	public Sommet recupMin() {
		if (heap.size() > 0) {
			swap(0, heap.size()-1);
			Object result = heap.remove(heap.size()-1);
			pushDown(0);
			return (Sommet) result;
		} else {
			return null;
		}
	}

	public Object getFirst() {
		return heap.get(0);
	}

	public Object get(int index) {
		return heap.get(index);
	}

	public int size() {
		return heap.size();
	}

	protected boolean isGreaterOrEqual(int first, int last){
		return ((Sommet)heap.get(first)).distance < ((Sommet)heap.get(last)).distance;
	}

	protected int parent(int i) {
		return (i - 1) / 2;
	}

	protected int left(int i) {
		return 2 * i + 1;
	}

	protected int right(int i) {
		return 2 * i + 2;
	}

	protected void swap(int i, int j) {
		Object tmp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, tmp);
	}

	public void pushDown(int i) {
		int left = left(i);
		int right = right(i);
		int largest = i;

		if (left < heap.size() && !isGreaterOrEqual(largest, left)) {
			largest = left;
		}
		if (right < heap.size() && !isGreaterOrEqual(largest, right)) {
			largest = right;
		}

		if (largest != i) {
			swap(largest, i);
			pushDown(largest);
		}
	}

	public void pushUp(int i) {
		while (i > 0 && !isGreaterOrEqual(parent(i), i)) {
			swap(parent(i), i);
			i = parent(i);
		}
	}

	public String toString() {
		StringBuffer s = new StringBuffer("Heap:\n");
		int rowStart = 0;
		int rowSize = 1;
		for (int i = 0; i < heap.size(); i++) {
			if (i == rowStart+rowSize) {
				s.append('\n');
				rowStart = i;
				rowSize *= 2;
			}
			s.append(get(i));
			s.append(" ");
		}
		return s.toString();
	}

	
	@Override
	void initialiser(int n, int C) {
		

	}


	@Override
	void supprimer(Sommet s) {
		// TODO Auto-generated method stub

	}

	@Override
	boolean estVide() {
		return heap.size() == 0;
	}



}
