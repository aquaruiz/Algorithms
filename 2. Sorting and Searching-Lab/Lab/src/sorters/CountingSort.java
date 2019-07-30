package sorters;

import java.util.Map;
import java.util.TreeMap;
import java.util.function.Consumer;

public class CountingSort <T extends Comparable<T>> implements Consumer<T[]> {
	private Map<T, Integer> auxArr;
	
	@Override
	public void accept(T[] arr) {
		this.auxArr = new TreeMap<T, Integer>();
		
		for (int i = 0; i < arr.length; i++) {
			T itemT = arr[i];
			if (auxArr.containsKey(itemT)) {
				Integer count = auxArr.get(itemT);
				count++;
				auxArr.put(itemT, count);
			} else {
				auxArr.put(itemT, 1);
			}
		}
		
		int index = 0;
		for (Map.Entry<T, Integer> kvp : auxArr.entrySet()) {
			for (int i = 0; i < kvp.getValue(); i++) {
				arr[index] = kvp.getKey();
				index++;
			}
		}
	}
}