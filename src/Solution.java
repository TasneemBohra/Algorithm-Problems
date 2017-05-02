import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
	public static void main(String[] args) {
		char task[] = new char[]{'C', 'C', 'C', 'B','B','A','C','C','C','C'};
		rearrangeTasks(task);
		for (int i = 0; i < task.length; i++ ) {
			System.out.print(task[i]+", ");
		}
	}
	
	 public static char[] rearrangeTasks(char[] tasks) {
		 //Get chars frequencies
		 int n = tasks.length;
		 HashMap<Character, Integer> map = new HashMap<>();
		 for (int i = 0; i < tasks.length; i++) {
			 map.put(tasks[i], map.containsKey(tasks[i]) ? map.get(tasks[i]) + 1 : 1);
		 }
		  
		 //Max heap
		 PriorityQueue<Task> heap = new PriorityQueue<>(new Comparator<Task>() {
			 @Override
			public int compare(Task o1, Task o2) {
				return o1.frequency - o2.frequency;
			}
		});
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			heap.offer(new Task(entry.getKey(), entry.getValue()));
		}
		
		//Get highest frequency in d
		int d = heap.peek().frequency;
		int i = 0;
		while (!heap.isEmpty()) {
			Task t = heap.poll();
			while (i < n && tasks[i] != '\0') i++;
			for (int j = i; j < t.frequency; j+=d) {
				tasks[j] = t.c;
				t.frequency --;
			}
			if (t.frequency > 0) {
				heap.offer(t);
			}
		}
		return tasks;
	 }
}

class Task {
	char c;
	int frequency;
	public Task(char c, int frequency) {
		this.c = c;
		this.frequency = frequency;
	}
}
