package bestLecturesSchedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	static List<Lecture> lectures = new ArrayList<>();
	static List<Lecture> schedule = new ArrayList<>();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(bReader.readLine().substring(10));

		for (int i = 0; i < num; i++) {
			String[] input = bReader.readLine().split(": ");
			int[] times = Arrays.stream(input[1].split(" - ")).mapToInt(Integer::parseInt).toArray();
			
			Lecture currentLecture = new Lecture(input[0], times[0], times[1]);
			lectures.add(currentLecture);
		}
		
		List<Lecture> possibleLectures = lectures.stream().filter(l -> l.startTime >= 0).collect(Collectors.toList());
		
		while (possibleLectures.size() > 0) {
			Collections.sort(possibleLectures, new SorterByStartTime());
			Lecture choosenLecture = possibleLectures.get(0);
			int currentTime = choosenLecture.endTime;
			
			schedule.add(choosenLecture);
			
			possibleLectures = lectures.stream().filter(l -> l.startTime >= currentTime).collect(Collectors.toList());
		}
		
		System.out.println(String.format("Lectures (%d):", schedule.size()));
		schedule.stream().forEach(System.out::println);
	}
	
	public static class SorterByStartTime implements Comparator<Lecture> {
		
		@Override
		public int compare(Lecture o1, Lecture o2) {
			return o1.endTime - o2.endTime;
		}
	}
	
	public static class Lecture {
		private String name;
		private int startTime;
		private int endTime;
		
		public Lecture() {
		}
		
		public Lecture(String name, int start, int end) {
			setName(name);
			setStartTime(start);
			setEndTime(end);
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public int getStartTime() {
			return startTime;
		}
		
		public int getEndTime() {
			return endTime;
		}
		
		public void setStartTime(int startTime) {
			this.startTime = startTime;
		}
		
		public void setEndTime(int endTime) {
			this.endTime = endTime;
		}
		
		@Override
		public String toString() {
			return String.format("%d-%d -> %s", 
						startTime,
						endTime,
						name
					);
		}
	}
}