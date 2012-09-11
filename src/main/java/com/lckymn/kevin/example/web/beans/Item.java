package com.lckymn.kevin.example.web.beans;

import java.math.BigDecimal;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public class Item implements Comparable<Item>
{
  private Long id;
  private String name;
  private BigDecimal price;

  public Item()
  {
  }

  public Item(final Long id, final String name, final BigDecimal price)
  {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(final Long id)
  {
    this.id = id;
  }

  public String getName()
  {
    return name;
  }

  public void setName(final String name)
  {
    this.name = name;
  }

  public BigDecimal getPrice()
  {
    return price;
  }

  public void setPrice(final BigDecimal price)
  {
    this.price = price;
  }

  @Override
  public int hashCode()
  {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    return result;
  }

  @Override
  public boolean equals(final Object item)
  {
    if (this == item)
    {
      return true;
    }
    if (!(item instanceof Item))
    {
      return false;
    }
    final Item that = (Item) item;
    /* @formatter:off */
    return this.name == that.getName() ||
              (null != this.name && this.name.equals(that.getName()));
    /* @formatter:on */
  }

  @Override
  public int compareTo(final Item item)
  {
    return this.name.compareTo(item.getName());
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("Item [id=")
        .append(id)
        .append(", name=")
        .append(name)
        .append(", price=")
        .append(price)
        .append("]")
        .toString();
    /* @formatter:on */
  }

}
