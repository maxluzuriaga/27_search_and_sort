import java.util.*;
import java.io.*;

public class MergeSort {
	
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("bible.txt"));
			ArrayList<String> arr = new ArrayList<String>();
			
			while (br.ready()) {
				String line = br.readLine();
				
				line = line.replace(".", "");
				line = line.replace(",", "");
				line = line.replace(":", "");
				line = line.replace(";", "");
				line = line.replace("?", "");
				line = line.replace(".", "");
				
				ArrayList<String> temp = new ArrayList<String>(Arrays.asList(line.split(" ")));
				arr.addAll(temp);
			}
			
			System.out.println(arr);
			System.out.println(merge_sort(arr));
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}
	
	public static ArrayList<String> merge_sort(ArrayList<String> list) {
		if(list.size() <= 1) {
			return list;
		} else {
			ArrayList<String> left;
			ArrayList<String> right;
			int size = list.size() / 2;
			
			if((list.size() % 2) == 0) {
				left = new ArrayList<String>(size);
				right = new ArrayList<String>(size);
			} else {
				left = new ArrayList<String>(size);
				right = new ArrayList<String>(size + 1);
			}
			
			for(int i = 0; i<size; i++) {
				left.add(list.get(i));
			}
			
			for(int i = size; i<(list.size()); i++) {
				right.add(list.get(i));
			}
			
			left = merge_sort(left);
			right = merge_sort(right);
			
			return merge(left, right);
		}
	}
	
	public static ArrayList<String> merge(ArrayList<String> left, ArrayList<String> right) {
		ArrayList<String> result = new ArrayList<String>(left.size() + right.size());
		
		while((left.size() > 0) || (right.size() > 0)) {
			if((left.size() > 0) && (right.size() > 0)) {
				if(left.get(0).toLowerCase().compareTo(right.get(0).toLowerCase()) <= 0) {
					result.add(left.get(0));
					left.remove(0);
				} else {
					result.add(right.get(0));
					right.remove(0);
				}
			} else if(left.size() > 0) {
				result.add(left.get(0));
				left.remove(0);
			} else if(right.size() > 0) {
				result.add(right.get(0));
				right.remove(0);
			}
		}
		
		return result;
	}
	
}