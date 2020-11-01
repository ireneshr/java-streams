package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class FilterandMap5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();

    List<Car> filtered = cars.stream()
    		.filter(c-> c.getPrice() < 20000)
    		.collect(Collectors.toList());
    
//    filtered.forEach(System.out::println);
//    System.out.println(filtered.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    
    List<PersonDTO> p2 = people.stream().map(p -> 
    	new PersonDTO(p.getId(), p.getFirstName(), p.getAge())
    ).collect(Collectors.toList());
    
    List<PersonDTO> p3 = people.stream().map(PersonDTO::map).collect(Collectors.toList());
    
    Function<Person, PersonDTO> function = 
    		p -> new PersonDTO(p.getId(), p.getFirstName(), p.getAge());
    List<PersonDTO> p4 = people.stream().map(function).collect(Collectors.toList());
    
//    p2.forEach(System.out::println);
    assertThat(p2).hasSize(1000);

  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
	  
	  ImmutableList<Car> cars = MockData.getCars();

	   Double avg = cars.stream().mapToDouble(c -> c.getPrice()).average().getAsDouble();
	   System.out.println(avg);
	  
  }
  
}
