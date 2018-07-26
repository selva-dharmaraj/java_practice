package com.edu.selva.interview;

// Program to find best buying and selling days
import java.util.ArrayList;


/**
 * Solution structure.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 7/25/18
 */
class Interval {
  //~ Instance-fields --------------------------------------------------------------------------------------------------

  /** buy. */
  int buy;

  /** sell. */
  int sell;
}

/**
 * StockBuySell.
 *
 * @author   Selva Dharmaraj
 * @version  $Revision$, 7/25/18
 */
class StockBuySell {
  //~ Methods ----------------------------------------------------------------------------------------------------------

  /**
   * main.
   *
   * @param  args  - method parameter args
   */
  public static void main(String[] args) {
    StockBuySell stock = new StockBuySell();

    // stock prices on consecutive days
    // int[] price = { 100, 180, 260, 310, 40, 535, 695 };
    int[] price = { 100, 180, 260, 310, 40, 535, 695 };
    int   n     = price.length;

    // fucntion call
    stock.stockBuySell(price, n);
  }

  //~ ------------------------------------------------------------------------------------------------------------------

  /**
   * This function finds the buy sell schedule for maximum profit.
   *
   * @param  price  - method parameter price
   * @param  n      - method parameter n
   */
  void stockBuySell(int[] price, int n) {
    // Prices must be given for at least two days
    if (n == 1) return;

    int count = 0;

    // solution array
    ArrayList<Interval> sol = new ArrayList<Interval>();

    // Traverse through given price array
    int i = 0;

    while (i < (n - 1)) {
      // Find Local Minima. Note that the limit is (n-2) as we are
      // comparing present element to the next element.
      while ((i < (n - 1)) && (price[i + 1] <= price[i])) {
        i++;
      }

      // If we reached the end, break as no further solution possible
      if (i == (n - 1)) break;

      Interval e = new Interval();
      e.buy = i++;
      // Store the index of Minima

      // Find Local Maxima.  Note that the limit is (n-1) as we are
      // comparing to previous element
      while ((i < n) && (price[i] >= price[i - 1]))
        i++;

      // Store the index of maxima
      e.sell = i - 1;
      sol.add(e);

      // Increment number of buy/sell
      count++;
    } // end while

    // print solution
    if (count == 0) {
      System.out.println("There is no day when buying the stock "
            + "will make profit");
    } else {
      for (int j = 0; j < count; j++) {
        System.out.println("Buy on day: " + sol.get(j).buy
              + "        " + "Sell on day : " + sol.get(j).sell);
      }
    }

    return;
  } // end method stockBuySell
} // end class StockBuySell

// This code has been contributed by Mayank Jaiswal
