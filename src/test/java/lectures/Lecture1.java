package lectures;


import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people
    
    
    //Imperative style
    List<Person> underage = new ArrayList<>();
    for (Person p : people) {
		if (p.getAge() <= 18) {
			underage.add(p);
		}
	}
    
    //SubList using Arrays
    List<Person> firstTen = Arrays.asList(Arrays.copyOfRange(underage.toArray(), 0, 10, Person[].class));
    //Using Lists
    List<Person> second = underage.subList(0, 10);
    
    System.out.println(underage);
    System.out.println(firstTen);
    System.out.println(second);
    
    //Functional style
    List<Person> underage2 = people.stream()
    		.filter(p -> p.getAge() <= 18)
    		.collect(Collectors.toList());
    System.out.println(underage2);
    //underage2.forEach(System.out::println);
    
    List<Person> firstTen2 = people.stream()
    		.filter(p -> p.getAge() <= 18)
    		.limit(10)
    		.collect(Collectors.toList());
    System.out.println(firstTen2);
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();

  }
  
}
