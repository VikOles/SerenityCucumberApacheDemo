package apache.com.steps;

import apache.com.pages.NavigationBar;
import apache.com.pages.ProductPage;
import apache.com.pages.SearchPage;
import apache.com.utils.CellPhoneCompatibility;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.And;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.Assert;

import java.util.List;


public class SearchStepDefinitions extends PageObject {
    String productName;


    @FindBy(xpath = "//div[@id='filters']//span[@class='a-list-item']")
    public List<WebElementFacade> filters;


    NavigationBar navigationBar;
    ProductPage productPage;
    SearchPage searchPage;


    //input[@type='checkbox' and parent::label//following-sibling::span]


    @Given("open page")
    public void invokeApp() {
        navigationBar.invoke();
    }

    @Given("search for {string}")
    public void searchProduct(String searchItem) {
        navigationBar.searchProduct(searchItem);
    }

    @And("Set price from {string} to {string}")
    public void setPrice(String minPrice, String maxPrice) {
        searchPage.setPrice(minPrice, maxPrice);
    }

    @ParameterType("APPLE_IPHONE|GOOGLE|LG|SAMSUNG")
    public CellPhoneCompatibility CellPC(String cellPC) {
        return CellPhoneCompatibility.valueOf(cellPC);
    }

    @And("Select filter {CellPC}")
    public void setFilter(CellPhoneCompatibility cellPC) {
        searchPage.setSearchFilter(cellPC);
    }

    @When("Select {int} product")
    public void selectProduct(int productNumber) {
        productName = searchPage.selectProduct(productNumber);
    }

    @Then("Product page opened")
    public void checkProductPage() {
        String actualProductName = productPage.getProductName();
        Assert.assertEquals("Product was not matching", productName, actualProductName);
    }

}
