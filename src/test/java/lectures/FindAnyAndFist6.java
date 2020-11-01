package lectures;


import com.google.common.collect.Lists;
import java.util.Arrays;
import java.util.function.Predicate;
import org.junit.Test;

public class FindAnyAndFist6 {

  final Predicate<Integer> numbersLessThan10 = n -> n > 5 && n < 10;

  //Non-Deterministic
  @Test
  public void findAny() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    int i = Arrays.stream(numbers).filter(numbersLessThan10).findAny().get();
    
    System.out.println(i);

  }

  //Deterministic
  @Test
  public void findFirst() throws Exception {
    Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    
    int i = Arrays.stream(numbers).filter(numbersLessThan10).findFirst().get();
    
    System.out.println(i);
  }
}

