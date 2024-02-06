package buteelt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyList {

	public static void main(String args[]) {
		List<String> list1= new ArrayList<String>();
		
		//add 
		list1.add("A");
		list1.add("I");
		
		//A I dund E 
		list1.add(1,"E");
		System.out.println(list1);
		
		List<String> list = new ArrayList<String>();
		list.add("O");
		list.add("U");
		
		//appending list elements to letters
		list1.addAll(list);
		System.out.println(list1);
		
		//clear empty list
		list.clear();
		
		//size
		System.out.println("list size = "+list1.size());
		
		//set 
		list1.set(2, "E");
		System.out.println(list1);
		
		//subList 
		list1.clear();list1.add("E"); list1.add("E");list1.add("I"); list1.add("O");
		list = list1.subList(0, 2);
		System.out.println("letters = "+list1+", list = "+list);
		list1.set(0, "A");
		System.out.println("letters = "+list1+", list = "+list);
		list.add("U");
		System.out.println("letters = "+list1+", list = "+list);
		
		list1.remove("I");
        System.out.println("I from list1: " + list1);
		
	}
}