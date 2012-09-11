package com.lckymn.kevin.example.web.beans;

import java.math.BigDecimal;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public class LineItem implements Comparable<LineItem>
{
  private Item item;

  private int quantity;

  public LineItem()
  {
  }

  public LineItem(final Item item, final int quantity)
  {
    this.item = item;
    this.quantity = quantity;
  }

  public Item getItem()
  {
    return item;
  }

  public void setItem(final Item item)
  {
    this.item = item;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final int quantity)
  {
    this.quantity = quantity;
  }

  public BigDecimal getLineTotal()
  {
    return item.getPrice()
        .multiply(new BigDecimal(quantity));
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((item == null) ? 0 : item.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object orderedItem)
  {
    if (this == orderedItem)
    {
      return true;
    }
    if (!(orderedItem instanceof LineItem))
    {
      return false;
    }
    final LineItem that = (LineItem) orderedItem;
    /* @formatter:off */
    return this.item == that.getItem() ||
            (null != this.item && this.item.equals(that.getItem()));
    /* @formatter:on */
  }

  @Override
  public int compareTo(final LineItem lineItem)
  {
    return this.item.compareTo(lineItem.getItem());
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("LineItem [item=")
        .append(item)
        .append(", quantity=")
        .append(quantity)
        .append("]")
        .toString();
    /* @formatter:on */
  }

}
