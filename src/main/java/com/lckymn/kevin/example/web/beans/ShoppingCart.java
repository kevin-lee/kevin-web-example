package com.lckymn.kevin.example.web.beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public class ShoppingCart
{
  private Map<Long, LineItem> itemIdToLineItemMap;

  public ShoppingCart()
  {
    this.itemIdToLineItemMap = new LinkedHashMap<Long, LineItem>();
  }

  public LineItem addItem(final Item item)
  {
    final LineItem lineItem = itemIdToLineItemMap.get(item.getId());
    return null == lineItem ? putItem(item, 1) : putItem(item, lineItem.getQuantity() + 1);
  }

  public LineItem putItem(final Item item, final int quantity)
  {
    LineItem lineItem = itemIdToLineItemMap.get(item.getId());
    if (null == lineItem)
    {
      lineItem = new LineItem(item, quantity);
      itemIdToLineItemMap.put(item.getId(), lineItem);
    }
    else
    {
      lineItem.setQuantity(quantity);
    }
    return lineItem;
  }

  public List<LineItem> getAllLineItems()
  {
    final List<LineItem> lineItems = new ArrayList<LineItem>(itemIdToLineItemMap.values());
    Collections.sort(lineItems);
    return lineItems;
  }

  public boolean isEmpty()
  {
    return itemIdToLineItemMap.isEmpty();
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("ShoppingCart [itemIdToLineItemMap=")
        .append(itemIdToLineItemMap)
        .append("]")
        .toString();
    /* @formatter:on */
  }

}
