package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test.
 */
public class NaturalNumberTest {

  class NaturalNumberDivisorsInput {
    public NaturalNumber input;
    public int[] answer;
    public int cycles;

    NaturalNumberDivisorsInput(NaturalNumber input, int[] answer, int cycles) {
      this.input = input;
      this.answer = answer;
      this.cycles = cycles;
    }
  }

  class NaturalNumberValueInput {
    public NaturalNumber input;
    public int answer;

    NaturalNumberValueInput(NaturalNumber input, int answer) {
      this.input = input;
      this.answer = answer;
    }
  }

  @Test void value() {
    NaturalNumberValueInput[] tests = {
      new NaturalNumberValueInput(new NaturalNumber(1), 1),
      new NaturalNumberValueInput(new NaturalNumber(2), 2),
      new NaturalNumberValueInput(new NaturalNumber(10), 10),
      new NaturalNumberValueInput(new NaturalNumber(16), 16)
    };

    for (NaturalNumberValueInput testData : tests) {
      assertEquals(
          testData.answer,
          testData.input.get_value(),
          String.format(
              "NaturalNumber(%d).get_value() must be => %d",
              testData.answer,
              testData.answer
          )
      );
    }
  }

  @Test void divisors() {
    NaturalNumberDivisorsInput[] tests = {
      new NaturalNumberDivisorsInput(new NaturalNumber(1), new int[]{1}, 0),
      new NaturalNumberDivisorsInput(new NaturalNumber(2), new int[]{1, 2}, 1),
      new NaturalNumberDivisorsInput(new NaturalNumber(10), new int[]{1, 2, 5, 10}, 3),
      new NaturalNumberDivisorsInput(new NaturalNumber(16), new int[]{1, 2, 4, 8, 16}, 4)
    };

    for (NaturalNumberDivisorsInput testData : tests) {
      assertArrayEquals(
          testData.answer,
          testData.input.divisors(),
          String.format(
              "NaturalNumber(%d).divisors() must be => %s",
              testData.input.get_value(),
              testData.answer
          )
      );
      assertEquals(
          testData.cycles,
          testData.input.get_divisors_cycles(),
          String.format(
              "NaturalNumber(%d).divisors() cycles must be => %d",
              testData.input.get_value(),
              testData.cycles
          )
      );
    }
  }

}
