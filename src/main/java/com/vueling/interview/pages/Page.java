package com.vueling.interview.pages;

import org.openqa.selenium.WebDriver;

public abstract class Page {

    protected WebDriver driver;

    public Page(WebDriver driver) {
	this.driver = driver;
    }

    public String getTitle() {
	return driver.getTitle();
    }

}
