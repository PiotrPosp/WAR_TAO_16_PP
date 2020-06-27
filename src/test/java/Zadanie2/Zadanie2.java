package Zadanie2;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;



public class Zadanie2 {

    private WebDriver driver;
    int pausa = 1000;
//następuje otwarcie okna przeglądarki
    @Given("^User  logs in to his account$")
    public void userLogsInToHisAccount() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
//następuje przejście do strony https://prod-kurs.coderslab.pl/
        driver.get("https://prod-kurs.coderslab.pl/index.php");
        Thread.sleep(pausa);
//następuje kliknięcie w pole SingIn
        WebElement SingIn = driver.findElement(By.xpath("//span[contains(@class,'hidden-sm-down')]"));
        Thread.sleep(pausa);
        SingIn.click();
        Thread.sleep(pausa);
//następuje logowanie do konta użytkownika na podstawie loginu i hasła z poprzedniego zadania
        WebElement email = driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("pio.tes95@o2.pl");
        Thread.sleep(pausa);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("Dostep123!!");
        Thread.sleep(pausa);
//następuje kliknięcie w pole signin
        WebElement ok = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
        ok.click();
        Thread.sleep(pausa);

    }

//w polu wyszukaj wpisuje Hummingbird Printed Sweater
    @When("^User type Hummingbird Printed Sweater in the search field$")
    public void userTypeHummingbirdPrintedSweaterInTheSearchField() throws Throwable {
        WebElement element = driver.findElement(By.xpath("//*[@name='s']"));
        element.clear();
        Thread.sleep(pausa);
        element.sendKeys("Hummingbird printed sweater");
        element.submit();
        Thread.sleep(pausa);

    }

//następuje wybranie Hummingbird Printed Sweater
    @And("^User choose Hummingbird Printed Sweater$")
    public void userChooseHummingbirdPrintedSweater() throws Throwable {
        WebElement sweater = driver.findElement(By.xpath("//*[@class='thumbnail-container']"));
        Thread.sleep(pausa);
        sweater.click();
        Thread.sleep(pausa);

    }

//zostaje wybrany rozmiar M w zakładce Size
    @And("^User selects size M$")
    public void userSelectsSizeM() throws InterruptedException {
        WebElement size = driver.findElement(By.xpath("/html/body/main/section/div/div/section/div[1]/div[2]/div[2]/div[2]/form/div[1]/div/select/option[2]"));
        size.click();
        Thread.sleep(pausa);

    }

//zostaje wybrana ilość 5 szt w polu Quantity
    @And("^User selects the number of pieces 5$")
    public void userSelectsTheNumberOfPiecesPcs() throws InterruptedException {
        WebElement ilosc= driver.findElement(By.name("qty"));
        ilosc.click();
        Thread.sleep(700);
        ilosc.sendKeys(Keys.BACK_SPACE);
        Thread.sleep(700);
        ilosc.sendKeys("5");
        Thread.sleep(700);

    }

//następuje dodanie produktów do koszyka po przez kliknięcie  to Card
    @And("^User adds the product to the basket$")
    public void userAddsTheProductToTheBasket() throws InterruptedException {
        WebElement AddtoCart = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary add-to-cart')]"));
        AddtoCart.click();
        Thread.sleep(pausa);

    }

//następuje przejście do opcji checkout
    @And("^User goes to the checkout option$")
    public void userGoesToTheCheckoutOption() throws InterruptedException {
        WebElement Checkout = driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a/i"));
        Checkout.click();
        Thread.sleep(pausa);

        WebElement ProceedCheckout = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"));
        ProceedCheckout.click();
        Thread.sleep(pausa);

    }

//następuje wybranie i potwierdzenie adresu
    @And("^User confirms the address$")
    public void userConfirmsTheAddress() throws InterruptedException {
        WebElement addres= driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/div[2]/button"));
        addres.submit();
        Thread.sleep(pausa);

    }

//zostaje wybrana metoda odbioru PrestaShop z opcji shipping method
    @And("^User selects the PrestaShop collection method from the shipping method option$")
    public void userSelectsThePrestaShopCollectionMethodFromTheShippingMethodOption() throws Throwable {
        WebElement Shippingmethod= driver.findElement(By.xpath("//*[@id=\"checkout-delivery-step\"]/h1"));
        Shippingmethod.click();
        Thread.sleep(pausa);

        WebElement PrestalShop= driver.findElement(By.xpath("//*[@id='delivery_option_1']"));
        PrestalShop.submit();
        Thread.sleep(pausa);

    }

//następuje przejście do opcji payment
    @And("^User goes to the payment option$")
    public void userGoesToThePaymentOption() throws InterruptedException {
        WebElement Payment= driver.findElement(By.xpath("//*[@id='checkout-payment-step']/h1"));
        Payment.click();
        Thread.sleep(pausa);

    }

//następuje wybranie metody odbioru Pay by Check
    @And("^User chooses the Pay by Check pickup method$")
    public void userChoosesThePayByCheckPickupMethod() throws InterruptedException {
        WebElement PayByCheck= driver.findElement(By.xpath("//*[@id='payment-option-1']"));
        PayByCheck.click();
        Thread.sleep(pausa);

    }

//następuje akceptacja regulaminu poprzez zatwierdzenie pola checkbox
    @And("^User accepts the regulations$")
    public void userAcceptsTheRegulations() throws InterruptedException {
        WebElement TermsofService= driver.findElement(By.xpath("//*[@id='conditions_to_approve[terms-and-conditions]']"));
        TermsofService.click();
        Thread.sleep(pausa);

    }

//zamówienie zostaje zatwierdzone
    @And("^User approves the order$")
    public void userApprovesTheOrder() throws InterruptedException {
        WebElement Order= driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button"));
        Order.click();
        Thread.sleep(pausa);

    }

//zostaje wykonany screenshot z potwierdzeniem zamówienia i kwotą
    @Then("^User takes a screenshot with the order confirmation and the amount$")
    public void userTakesAScreenshotWithTheOrderConfirmationAndTheAmount() throws IOException {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("screenshot.png"));


    }

}
