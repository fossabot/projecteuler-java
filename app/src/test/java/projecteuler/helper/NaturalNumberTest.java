package projecteuler.helper;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Test.
 */
public class NaturalNumberTest {

  class TestInput {
    public NaturalNumber input;
    public int[] answer;
    public int cycles;

    TestInput(NaturalNumber input, int[] answer, int cycles) {
      this.input = input;
      this.answer = answer;
      this.cycles = cycles;
    }
  }

  @Test void divisors() {
    TestInput[] tests = {
      new TestInput(new NaturalNumber(1), new int[]{1}, 0),
      new TestInput(new NaturalNumber(2), new int[]{1, 2}, 1),
      new TestInput(new NaturalNumber(10), new int[]{1, 2, 5, 10}, 3),
      new TestInput(new NaturalNumber(16), new int[]{1, 2, 4, 8, 16}, 4)
    };

    for (TestInput testData : tests) {
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
