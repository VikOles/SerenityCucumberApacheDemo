package apache.com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Keys;

@DefaultUrl("https://www.amazon.com/")
public class NavigationBar extends PageObject {
    @FindBy(id = "twotabsearchtextbox")
    public WebElementFacade searchField;


    public void invoke() {
        open();
    }

    public void searchProduct(String searchItem) {
        searchField
                .type(searchItem)
                .sendKeys(Keys.ENTER);
    }

}
