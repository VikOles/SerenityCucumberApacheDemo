package amazon.com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@DefaultUrl("https://www.amazon.com/")
public class NavigationBar extends PageObject {
    private static final Logger log = LoggerFactory.getLogger(NavigationBar.class);
    @FindBy(id = "twotabsearchtextbox")
    public WebElementFacade searchField;


    public void launchApplication() {
        log.info("Launching the application.");
        open();
    }

    public void searchProduct(String searchItem) {
        log.info("Searching for product " + searchItem);
        searchField
                .type(searchItem)
                .sendKeys(Keys.ENTER);
    }

}
