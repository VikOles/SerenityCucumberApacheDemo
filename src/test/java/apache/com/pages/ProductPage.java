package apache.com.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;

public class ProductPage extends NavigationBar {

    @FindBy(id = "productTitle")
    WebElementFacade productTitle;

    public String getProductName() {
        return productTitle.getText();
    }
}
