package com.lckymn.kevin.example.web.dataaccess.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lckymn.kevin.example.web.beans.Item;
import com.lckymn.kevin.example.web.dataaccess.ItemDao;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public class MockItemDaoImpl implements ItemDao
{
	private Map<Long, Item> itemMap;

	public MockItemDaoImpl()
	{
		this.itemMap = new HashMap<Long, Item>();
		itemMap.put(1L, new Item(1L, "Product A", new BigDecimal("10.50")));
		itemMap.put(2L, new Item(2L, "Product B", new BigDecimal("100.00")));
		itemMap.put(3L, new Item(3L, "Product C", new BigDecimal("1.50")));
		itemMap.put(4L, new Item(4L, "Product D", new BigDecimal("14.99")));
		itemMap.put(5L, new Item(5L, "Product E", new BigDecimal("9.99")));
	}

	@Override
	public List<Item> getAllItems()
	{
		return Collections.unmodifiableList(new ArrayList<Item>(itemMap.values()));
	}

	@Override
	public Item findItemById(final Long id)
	{
		return itemMap.get(id);
	}
}
