package amazon.com.pages;

import amazon.com.utils.CellPhoneCompatibility;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class SearchPage extends NavigationBar {
    private static final Logger log = LoggerFactory.getLogger(SearchPage.class);
    @FindBy(id = "low-price")
    public WebElementFacade minPriceField;

    @FindBy(id = "high-price")
    public WebElementFacade maxPriceField;

    @FindBy(className = "a-button-input")
    public WebElementFacade priceGoButton;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal']")
    public List<WebElementFacade> products;

    public void setPrice(String minPrice, String maxPrice) {
        log.info(String.format("Setting price range from %1s to %2s", minPrice, maxPrice));
        minPriceField.type(minPrice);
        maxPriceField.type(maxPrice);
        priceGoButton.click();
    }

    public void setSearchFilter(CellPhoneCompatibility cellPC) {
        log.info("Selecting filter " + cellPC.getValue());
        By filterCheckBox = By.xpath(String
                .format("//input[@type='checkbox' and parent::label/parent::div[following-sibling::span[text()='%s']]]", cellPC.getValue()));
        WebElementFacade checkbox = $(filterCheckBox);
        WebElementFacade checkboxClickable = $(String.format("//div[following-sibling::span[text()='%s']]", cellPC.getValue()));
        if (!checkbox.isSelected()) {
            checkboxClickable.click();
        }
    }

    public String selectProduct(int productNumber) {
        log.info("Selecting product at position " + productNumber);
        WebElementFacade product = products.get(productNumber - 1);
        String productName = "";
        if (product.isCurrentlyEnabled()) {
            productName = product.getText();
            product.click();
        }
        return productName;
    }
}
