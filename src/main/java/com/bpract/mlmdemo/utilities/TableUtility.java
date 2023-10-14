package com.bpract.mlmdemo.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//search users from list(filter)
public class TableUtility {
	public void searchInUserTicketTable(WebElement mytable, WebDriver driver, String value) {
		List<WebElement> r_table = mytable.findElements(By.tagName("tr"));
		String b_xpath = "//*[@name=\"all-tickets\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.contains(value)){
				String celtxt=driver.findElement(By.xpath("//*[@name=\"all-tickets\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("The subject of ticket created is :" + celtxt);
				break;
				}
			}
		}
	
	public void searchInAdminToolsDocument(WebElement mydoctable, WebDriver driver,String docName) {
		List<WebElement> r_table = mydoctable.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"tools-documents\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.contains(docName)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"tools-documents\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new document created is :" + celtxt);
				break;
				}
			}
	}
//	example:multiple data search
	public void searchInAdminTicketDashboard(WebElement myTickettable, WebDriver driver,String ticketUserName, String ticketSubject) {
		List<WebElement> r_table = myTickettable.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"ticket-table\"]/tbody/tr[";
		String a_xpath = "]/td[5]";
		String c_xpath = "]/td[3]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String ns = driver.findElement(By.xpath(b_xpath + r + c_xpath)).getText();
			if(ns.contains(ticketUserName)){
				String celtxt1=driver.findElement(By.xpath("//table[@name=\"ticket-table\"]/tbody/tr["+r+"]/td[3]")).getText();
				System.out.println("New ticket is created for the user :" + celtxt1);
				break;
				}
			}
		for (int s = 1;s <= rs_c; s++) {
			String n = driver.findElement(By.xpath(b_xpath + s + a_xpath)).getText();
			if(n.contains(ticketSubject)){
				String celtxt2=driver.findElement(By.xpath("//table[@name=\"ticket-table\"]/tbody/tr["+s+"]/td[5]")).getText();
				System.out.println("And subject of new ticket is :" + celtxt2);
				break;
				}
			}
	}
//	ticket department 
	public void searchInAdminTicketDepartment(WebElement myTktDepartment, WebDriver driver,String departmentName) {
		List<WebElement> r_table = myTktDepartment.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"department-table\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.contains(departmentName)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"department-table\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new department created is :" + celtxt);
				break;
				}
			}
	}
//	admin ticket category search
	public void searchInAdminTicketCategory(WebElement myTktCategory, WebDriver driver,String categoryName) {
		List<WebElement> r_table = myTktCategory.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"category-table\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.contains(categoryName)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"category-table\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new category created is :" + celtxt);
				break;
				}
			}
	}
//	admin faq category search
	public void searchInAdminFaqCategory(WebElement myFaqCategory, WebDriver driver,String faqCategoryName) {
		List<WebElement> r_table = myFaqCategory.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"faq-category\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(faqCategoryName)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"faq-category\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new faq category created is :" + celtxt);
				break;
				}
			}
	}
//	admin faq  search
	public void searchInAdminFaq(WebElement myFaq, WebDriver driver,String faq) {
		List<WebElement> r_table = myFaq.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"faq-table\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(faq)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"faq-table\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new faq  created is :" + celtxt);
				return;
				}
			}
		System.out.println("Faq not found");
	}
//	article category
	public void searchInAdminArticleCategory(WebElement myArticleCategory, WebDriver driver,String articleCategory) {
		List<WebElement> r_table = myArticleCategory.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"category-table\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(articleCategory)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"category-table\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new article Category created is :" + celtxt);
				return;
				}
			}
		System.out.println("article category not found!!");
	}
//	create article
	public void searchInAdminArticle(WebElement myArticle, WebDriver driver,String article) {
		List<WebElement> r_table = myArticle.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"article-table\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(article)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"article-table\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new article  created is :" + celtxt);
				return;
				}
			}
		System.out.println("article  not found!!");
	}
//	create blog category
	public void searchInAdminBlogCategory(WebElement myBlogCategory, WebDriver driver,String blogCategory) {
		List<WebElement> r_table = myBlogCategory.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"name-category\"]/tbody/tr[";
		String a_xpath = "]/td[2]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(blogCategory)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"name-category\"]/tbody/tr["+r+"]/td[2]")).getText();
				System.out.println("new blogCategory  created is :" + celtxt);
				return;
				}
			}
		System.out.println("blogCategory  not found!!");
	}
//	create Private blog
	public void searchInAdminBlog(WebElement myBlog, WebDriver driver,String blog) {
		List<WebElement> r_table = myBlog.findElements(By.tagName("tr"));
		String b_xpath = "//table[@name=\"published-table\"]/tbody/tr[";
		String a_xpath = "]/td[3]";
		int rs_c = r_table.size();
		for (int r = 1;r <= rs_c; r++) {
			String n = driver.findElement(By.xpath(b_xpath + r + a_xpath)).getText();
			if(n.equals(blog)){
				String celtxt=driver.findElement(By.xpath("//table[@name=\"published-table\"]/tbody/tr["+r+"]/td[3]")).getText();
				System.out.println("new blog created is :" + celtxt);
				return;
				}
			}
		System.out.println("blog not found!!");
	}
	
}
