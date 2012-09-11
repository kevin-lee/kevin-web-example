package com.lckymn.kevin.example.web.servlet;

import static com.lckymn.kevin.example.web.WebConstants.*;
import static com.lckymn.kevin.example.web.WebUtil.*;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lckymn.kevin.example.web.beans.Item;
import com.lckymn.kevin.example.web.beans.ShoppingCart;
import com.lckymn.kevin.example.web.dataaccess.ItemDao;
import com.lckymn.kevin.example.web.dataaccess.impl.MockItemDaoImpl;

/**
 * NOTE: What this example is not a best practice. It just gives you an idea of how to create a shopping cart and use
 * session.
 *
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public class TestServlet extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  // It is not good to use a DAO object in the Servlet.
  private ItemDao itemDao;

  public TestServlet()
  {
    this.itemDao = new MockItemDaoImpl();
  }

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
      IOException
  {
    doPost(request, response);
  }

  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException,
      IOException
  {
    final String action = request.getParameter("action");
    if (null == action || action.isEmpty())
    {
      request.setAttribute(MESSAGE, "Unknown request");
      if (!forwardToPrevious(request, response))
      {
        forwardTo(JSP_ERROR, request, response);
      }
    }
    else if ("viewAllItems".equals(action))
    {
      final List<Item> itemList = itemDao.getAllItems();
      request.setAttribute("itemList", itemList);
      forwardTo(JSP_ITEM_LIST, request, response);
    }
    else if (action.toLowerCase()
        .contains(SHOPPING_CART.toLowerCase()))
    {
      final HttpSession session = request.getSession();
      ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute(SHOPPING_CART);
      if (null == shoppingCart)
      {
        shoppingCart = new ShoppingCart();
        session.setAttribute(SHOPPING_CART, shoppingCart);
      }
      if ("addToShoppingCart".equals(action))
      {
        final String itemId = request.getParameter("itemId");
        // The input values should be validated.
        final Long id = Long.valueOf(itemId);

        final Item item = itemDao.findItemById(id);
        if (null == item)
        {
          request.setAttribute(MESSAGE, "Item not found");
          forwardTo(JSP_ITEM_LIST, request, response);
          return;
        }

        shoppingCart.addItem(item);
        forwardTo(JSP_SHOPPING_CART, request, response);
      }
      else if ("viewShoppingCart".equals(action))
      {
        forwardTo(JSP_SHOPPING_CART, request, response);
      }
      else
      {
        request.setAttribute(MESSAGE, "Unsupoorted action");
        if (!forwardToPrevious(request, response))
        {
          forwardTo(JSP_ERROR, request, response);
        }
      }
    }
    else
    {
      request.setAttribute(MESSAGE, "Unsupoorted action");
      if (!forwardToPrevious(request, response))
      {
        forwardTo(JSP_ERROR, request, response);
      }
    }
  }
}
