package fractionalKnapsack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
	static List<Item> items;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		long capacity = Long.parseLong(bReader.readLine().substring(10)); 
		long itemsCount = Long.parseLong(bReader.readLine().substring(7));
		items = new LinkedList<>();
		
		for (int i = 0; i < itemsCount; i++) {
			String[] input = bReader.readLine().split(" -> ");
			Double price = Double.parseDouble(input[0]); 
			double weight = Double.parseDouble(input[1]); 
			Item currentItem = new Item(price, weight);
			items.add(currentItem);
		}

		bReader.close();
		
		Collections.sort(items, new ItemRatioComp());
 		Map<Item, Double> takenItems = chooseItems(capacity);
 		
 		double totalPrice = 0;
 		
 		for (Map.Entry<Item, Double> kvp : takenItems.entrySet()) {
 			Item curreItem = kvp.getKey();
 			double percent = kvp.getValue();
 			
 			totalPrice += percent * curreItem.getPrice();
 			
 			System.out.print(String.format("Take %s%% of ",
				percent == 1 ? String.format("%d", (int)(percent * 100)) : String.format("%.2f", percent * 100)
			));
 			
 			System.out.println(curreItem);
		}
 		
 		System.out.println(String.format("Total price: %.2f", totalPrice));
	}
	
	private static Map<Item, Double> chooseItems(long capacity) {
		Map<Item, Double> takenItems = new LinkedHashMap<>();
		
		for (Item item : items) {
			double currentWeight = item.getWeight();
			if (currentWeight <= capacity) {
				takenItems.put(item, 1d);
				capacity -= currentWeight;
			} else {
				long possibleWeight = capacity;
				double possiblePercent = possibleWeight / currentWeight;
				takenItems.put(item, possiblePercent);
				capacity = 0;
			}
			
			if (capacity <= 0) {
				break;
			}
		}
		
		return takenItems;
	}

	private static class Item {
		private Double price;
		private Double weight;
		
		public Item(Double price, Double weight) {
			setPrice(price);
			setWeight(weight);
		}
		
		public Double getPrice() {
			return price;
		}
		
		public Double getWeight() {
			return weight;
		}
		
		public void setPrice(double price) {
			this.price = price;
		}
		
		public void setWeight(double weight) {
			this.weight = weight;
		}
		
		public Double calcRatio() {
			return getPrice() / getWeight();
		}
		
		@Override
		public String toString() {
			return String.format("item with price %.2f and weight %.2f", 
					getPrice(),
					getWeight());
		}
	}
	
	static class ItemRatioComp implements Comparator<Item>{
		 
	    @Override
	    public int compare(Item i1, Item i2) {
	        return i2.calcRatio().compareTo(i1.calcRatio());
	    }
	}
}