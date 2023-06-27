package apache.org.pages;

import apache.org.utils.CellPhoneCompatibility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;

public class SearchPage extends NavigationBar {
    @FindBy(id = "low-price")
    public WebElementFacade minPriceField;

    @FindBy(id = "high-price")
    public WebElementFacade maxPriceField;

    @FindBy(className = "a-button-input")
    public WebElementFacade priceGoButton;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElementFacade> products;

    public void setPrice(String minPrice, String maxPrice) {
        minPriceField.type(minPrice);
        maxPriceField.type(maxPrice);
        priceGoButton.click();
    }

    public void setSearchFilter(CellPhoneCompatibility cellPC) {
        By filterCheckBox = By.xpath(String
                .format("//input[@type='checkbox' and parent::label/parent::div[following-sibling::span[text()='%s']]]", cellPC.getValue()));
        WebElementFacade checkbox = $(filterCheckBox);
        WebElementFacade checkboxClickable = $(String.format("//div[following-sibling::span[text()='%s']]", cellPC.getValue()));
        if (!checkbox.isSelected()) {
            checkboxClickable.click();
        }
    }

    public String selectProduct(int productNumber) {
        WebElementFacade product = products.get(productNumber - 1);
        String productName = "";
        if (product.isCurrentlyEnabled()) {
            productName = product.getText();
            product.click();
        }
        return productName;
    }
}
