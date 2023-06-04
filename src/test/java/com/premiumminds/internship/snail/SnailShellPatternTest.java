package com.premiumminds.internship.snail;

import static org.junit.Assert.assertArrayEquals;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2023.
 */
@RunWith(JUnit4.class)
public class SnailShellPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public SnailShellPatternTest() {
  };

  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 }, { 8, 9, 4 }, { 7, 6, 5 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    assertArrayEquals(result, expected);
  }

  //------[[ Test 2 ]]------
  @Test
  public void My1stTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3 },
                       { 4, 5, 6 },
                       { 7, 8, 9 }};
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 6, 9, 8, 7, 4, 5 };
    assertArrayEquals(result, expected);
  }

  //------[[ Test 3 ]]------
  @Test
  public void My2ndTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 1 },
                       { 4, 5, 6, 4 },
                       { 7, 8, 9, 7 },
                       { 7, 8, 9, 7 } };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 1, 4, 7, 7, 9,
                       8, 7, 7, 4, 5, 6, 9, 8 };
    assertArrayEquals(result, expected);
  }

  //------[[ Test 4 ]]------
  @Test
  public void My3rdTest()
      throws InterruptedException, ExecutionException, TimeoutException {
    int[][] matrix = { { 1, 2, 3, 4, 7, 3, 2, 9 },
                       { 12, 15, 17, 30, 28, 21, 24, 8 },
                       { 11, 16, 22, 2, 4, 0, 31, 50 },
                       { 44, 17, 40, 30, 39, 32, 11, 8 },
                       { 1, 3, 51, 27, 37, 47, 48, 38},
                       { 28, 18, 9, 19, 29, 49, 39, 61},
                       { 60, 51, 41, 31, 11, 21, 1, 63},
                       { 43, 53, 33, 13, 23, 22, 21, 20} };
    Future<int[]> count = new SnailShellPattern().getSnailShell(matrix);
    int[] result = count.get(10, TimeUnit.SECONDS);
    int[] expected = { 1, 2, 3, 4, 7, 3, 2, 9,
                       8, 50, 8, 38, 61, 63, 20, 21,
                       22, 23, 13, 33, 53, 43, 60, 28,
                       1, 44, 11, 12, 15, 17, 30, 28,
                       21, 24, 31, 11, 48, 39, 1, 21,
                       11, 31, 41, 51, 18, 3, 17, 16,
                       22, 2, 4, 0, 32, 47, 49, 29,
                       19, 9, 51, 40, 30, 39, 37, 27 };
    assertArrayEquals(result, expected);
  }
}
