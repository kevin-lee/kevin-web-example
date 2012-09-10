package com.lckymn.kevin.example.web;

import static com.lckymn.kevin.example.web.WebConstants.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class WebConstants
{
	public static final String FORWARD_REQUEST = "javax.servlet.forward.request_uri";

	public static final String ACTION = "action";
	public static final String SHOPPING_CART = "shoppingCart";
	public static final String MESSAGE = "message";

	public static final String JSP_ERROR = "error.jsp";
	public static final String JSP_ITEM_LIST = "list.jsp";
	public static final String JSP_SHOPPING_CART = "cart.jsp";

	private WebConstants()
	{
	}
}
