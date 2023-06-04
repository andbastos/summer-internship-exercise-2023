package com.premiumminds.internship.snail;

import java.util.concurrent.Future;
import java.util.concurrent.CompletableFuture;

/**
 * Created by aamado on 05-05-2023.
 */
class SnailShellPattern implements ISnailShellPattern {

  // number of rows & columns
  int n;

  // vec is the array that will be returned with the solution
  int vec[];

  /* r is the current position on matrix
  *  c is the current position on matrix
  *  k is the current position on vec array */
  int r;
  int c;
  int k;

  // matrix limits variables
  // these limits are updated as we move forward on the path
  int lim_right;
  int lim_down;
  int lim_left;
  int lim_up;

  // r_end & c_end are the indexes of the last cell to read
  int r_end, c_end;

  /**
   * Method to get snailshell pattern
   *
   * @param matrix matrix of numbers to go through
   * @return order array of values thar represent a snail shell pattern
   */
  public Future<int[]> getSnailShell(int[][] matrix) {

    CompletableFuture<int[]> future = new CompletableFuture<>();

    n = matrix.length;

    // checking if matrix is empty
    if (n == 0) {

      future.complete(new int[0]);

      return future;
    }

    vec = new int[n*n];

    r = 0;
    c = -1;
    k = -1;

    lim_right = n;
    lim_down = n;
    lim_left = -1;
    lim_up = 0;

    /* As n is even or odd, r_end & c_end can be solved
    *  by the following formulas */
    if (n % 2 == 0){

      r_end = n/2;
      c_end = n/2 - 1;

    } else {

      r_end = c_end = (n-1)/2;
    }

    /* cycle where path is build: finish when current position
    *  on matrix corresponds to the last cell */
    while ( !((r == r_end) && (c == c_end)) ){

      right(matrix);

      down(matrix);

      left(matrix);

      up(matrix);

    }

    future.complete(vec);

    return future;

  }

  // moving right
  void right(int [][] mat){

    while ( (c+1) < lim_right){

      c++;
      k++;
      vec[k] = mat[r][c];
    }

    lim_right--;
  }

  // moving down
  void down(int [][] mat){

    while ( (r+1) < lim_down){

      r++;
      k++;
      vec[k] = mat[r][c];
    }

    lim_down--;
  }

  // moving left
  void left(int [][] mat){

    while ( (c-1) > lim_left){

      c--;
      k++;
      vec[k] = mat[r][c];
    }

    lim_left++;
  }

  // moving up
  void up(int [][] mat){

    while ( (r-1) > lim_up){

      r--;
      k++;
      vec[k] = mat[r][c];
    }

    lim_up++;
  }

}
