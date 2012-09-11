package com.lckymn.kevin.example.web.dataaccess;

import java.util.List;

import com.lckymn.kevin.example.web.beans.Item;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public interface ItemDao
{
  List<Item> getAllItems();

  Item findItemById(Long id);
}
