package examples;import java.util.Queue;import java.util.concurrent.ArrayBlockingQueue;/** * SharePortfolio.java A class for recording the purchase and sale of shares, and for computing the share profit or loss. * * @author Frank M. Carrano * @version 2.0 */public class SharePortfolio {  private Queue<SharePurchase> portfolio;  private static int MAX_SHARES = 10000;  public SharePortfolio() {    portfolio = new ArrayBlockingQueue<SharePurchase>(MAX_SHARES);  }  /**   * Task: Records a stock purchase in the portfolio.   *   * @param sharesBought the number of shares purchased   * @param pricePerShare the price per share   */  public void buy(int sharesBought, double pricePerShare) {    for (; sharesBought > 0; sharesBought--) {      SharePurchase purchase = new SharePurchase(pricePerShare);      portfolio.offer(purchase);    } // end for  }  /**   * Task: Removes from the portfolio any shares that were sold and computes the capital gain or loss.   *   * @param sharesSold the number of shares sold   * @param pricePerShare the price per share   * @return the capital gain (loss)   */  public double sell(int sharesSold, double pricePerShare) {    double saleAmount = sharesSold * pricePerShare;    double totalCost = 0;    while (sharesSold > 0) {      SharePurchase share = portfolio.poll();      double shareCost = share.getCostPerShare();      totalCost = totalCost + shareCost;      sharesSold--;    } // end while    return saleAmount - totalCost; // profit or loss  }}