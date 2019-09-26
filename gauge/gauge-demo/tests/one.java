package tests;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class one {

    private WebDriver driver = new ChromeDriver();

    @Step("打开 <chrome>")
    public void test(String chrome) {
        driver.get(chrome);
    }

    @Step("选择<search_input> 填写词语 <word>")
    public void aa(String search_input, String word) {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Cheese!");
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());
    }

    @Step("看见页面显示<text>")
    public void bb(String text) {
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());

        //Close the browser
        driver.quit();
    }
}
