package com.cs.interaction;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cs.data.LoginData;
import com.cs.data.SearchData;
import com.cs.exception.TestFailException;
import com.cs.page.BasePage;
import com.cs.page.LoginPage;
import com.cs.page.SearchPage;
import com.cs.util.Loader;
import com.cs.util.SnapshotUtil;

public class SearchInteraction extends SearchPage implements BasePage {

	private SearchData data;

	public SearchInteraction(WebDriver driver) {
		super(driver);
		this.data = Loader.suite.getSearchData();
	}

	@Override
	public void close() {

	}

	@Override
	public void openSite() {

		driver.get("https://jazz.net/search/");
	}
	
	public void search(){
		Interaction.inputValue(searchBox,data.getSearingValue());
		seachButton.click();
	}

	@Override
	public boolean isRedirectSuccess() throws TestFailException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOf(Message));
			return true;
		} catch (Exception e) {
			SnapshotUtil.snapshot(driver,"SearchPage");
			throw new TestFailException("We're sorry. We could not process your search request",e);
		}
	}
	
	

}
