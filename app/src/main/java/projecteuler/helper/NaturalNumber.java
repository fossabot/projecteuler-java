package projecteuler.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

/**
 * Divisors, Prime factors...
 */
public class NaturalNumber {

  static Logger logger = projecteuler.util.CustomLogger.getLogger();

  private Integer num = 0;
  // private Integer prime = null;

  private Integer __cyclesOfDivisors = 0;

  public NaturalNumber(int _num) {
    this.num = _num;
  }

  public int get_value() {
    return this.num;
  }

  /**
   * Divisors.
   *
   * @return list of divisors
   */
  public int[] divisors() {

    // divisors collector
    List<Integer> divisorsList = new ArrayList<Integer>();

    int targetNaturalNumber = Math.abs(this.num);

    if (targetNaturalNumber == 1) {
      divisorsList.add(1);
    } else {
      logger.fine(String.format("Find divisors of %d", targetNaturalNumber));

      int i = 1;
      int top = targetNaturalNumber;
      while (i <= top) {

        if (0 == targetNaturalNumber % i) {
          divisorsList.add(i);
          if (top > i) {
            divisorsList.add(top);
          }
        }

        i += 1;
        top = (int) Math.floor(targetNaturalNumber / i);
      }

      this.__cyclesOfDivisors = i - 1;
    }

    logger.fine(
        String.format("collected divisors %s in %d cycles", divisorsList, __cyclesOfDivisors)
    );

    // Sorting the list of integers using sort() method
    Collections.sort(divisorsList);

    // Arraylist of Integer to Array of Integer
    Integer[] divisors = divisorsList.toArray(new Integer[divisorsList.size()]);

    // Array of Integer to Array of int
    final int[] out = new int[divisors.length];
    Arrays.setAll(out, j -> divisors[j]);
    return out;
  }

  /**
   * Amount of cycles to caclculate divisors.
   */
  public int get_divisors_cycles() {
    logger.fine(
        String.format("Getting divisors cycles of %d: %d", this.num, this.__cyclesOfDivisors)
    );
    return this.__cyclesOfDivisors;
  }
}
