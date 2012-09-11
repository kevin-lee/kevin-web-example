package com.lckymn.kevin.example.web;

import static com.lckymn.kevin.example.web.WebConstants.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Kevin Lee
 * @version 0.0.1 (2012-09-10)
 */
public final class WebUtil
{
	private WebUtil()
	{
	}

	public static void forwardTo(final String destination, final HttpServletRequest request,
  	final HttpServletResponse response) throws ServletException, IOException
	{
  request.getRequestDispatcher(destination)
    .forward(request, response);
	}

	public static void redirectTo(final String destination, final HttpServletResponse response) throws IOException
	{
  response.sendRedirect(destination);
	}

	/**
	 * Forward the request to the referrer getting from the header ("Referer"). It doesn't forward if the referrer and the
	 * requestURI are the same.
	 *
	 * @param request
	 * @param response
	 * @return true if the referrer is found and it's forwarded to the referrer. false otherwise.
	 * @throws ServletException
	 * @throws IOException
	 */
	public static boolean forwardToPrevious(final HttpServletRequest request, final HttpServletResponse response)
  	throws ServletException, IOException
	{
  final String referrer = request.getHeader(REFERRER);
  if (null == referrer)
  {
  	return false;
  }
  final String contextPath = request.getContextPath();
  if (referrer.contains(contextPath))
  {
  	/* @formatter:off */
  	final String previousPage = referrer.substring(referrer
                                        .indexOf(contextPath) +
                                        contextPath.length());
  	final String requestUri = request.getRequestURI();
  	final String requestUriWithoutContextPath =
    requestUri.contains(contextPath) ?
      requestUri.substring(requestUri
                	.indexOf(contextPath) +
                	contextPath.length()) :
      requestUri;
  	/* @formatter:on */
  	if (requestUriWithoutContextPath.equals(previousPage))
  	{
    return false;
  	}
  	request.getRequestDispatcher(previousPage)
    	.forward(request, response);
  	return true;
  }
  return false;
	}
}
