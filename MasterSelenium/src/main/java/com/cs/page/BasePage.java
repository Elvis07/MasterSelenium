package com.cs.page;

import com.cs.exception.ParseResultException;

public interface BasePage {

	public void openSite();

	public void close();

	public boolean isRedirectSuccess() throws ParseResultException;
}
