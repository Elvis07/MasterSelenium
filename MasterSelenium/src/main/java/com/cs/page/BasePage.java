package com.cs.page;

import com.cs.exception.TestFailException;

public interface BasePage {

	public void openSite();

	public void close();

	public boolean isRedirectSuccess() throws TestFailException;
}
