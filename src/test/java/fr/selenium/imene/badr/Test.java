package fr.selenium.imene.badr;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.TestCase;

public class Test extends TestCase {
	private static final String URL = "http://www.fr.jal.co.jp/frl/en/";
	private static final String PATH_CHROME_DRIVER = "C:\\chromedriver.exe";
	public static WebDriver driver;

//    @Test
	public static void firstTest() {

		System.setProperty("webdriver.chrome.driver", PATH_CHROME_DRIVER);
		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(URL);

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// pausa(3);

		// driver.findElement(By.linkText("/world/common_rn/img/btn_continue_en.gif"));
		// driver.findElement(By.partilaLinkText("javascript:void(0);"));
		driver.findElements(By.cssSelector("#JS_ciBox_contents img")).get(1).click();
		// driver.findElement(By.className("mdl_icon mdl_icon_close")).click();

		String villeDepartChoisi = "Nice";
		Select s = new Select(driver.findElement(By.id("mdlDepLocation1")));
		s.selectByVisibleText(villeDepartChoisi);

		// Départ :

		driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")).click();

		Select s1 = new Select(driver.findElement(By.id("DEPARTURE_DATE_1_MONTH")));
		s1.selectByValue("12");
		driver.findElement(By.id("DEPARTURE_DATE_1_DAY")).click();
		// retour:
		driver.findElement(By.id("DEPARTURE_DATE_2_MONTH")).click();
		driver.findElement(By.id("DEPARTURE_DATE_2_DAY")).click();

		// search
		driver.findElement(By.id("mdlFormSubmit")).click();

		// le vol de depart
		// String departureFlightNumber1a = "";
		// driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();
		// WebElement e0 = driver.findElement(By.cssSelector("#flightNumber-0-0
		// .flight-identifier"));
		// departureFlightNumber1a = e0.getText();
		// System.out.println(departureFlightNumber1a);

		System.out.println(LocalDateTime.now());
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier")));
		} catch (TimeoutException e) {

			System.out.println("On a pas trouve l element : " + LocalDateTime.now());
		}

		if (driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier")).isDisplayed()) {
			System.out.println("le flight number s'affiche");
		} else {
			System.out.println("le flight number s'affiche Pas.Onclick pour l'afficher");
			driver.findElements(By.cssSelector(".medium-pattern.mb1.p5")).get(0).click();
		}
		String depart = "";
		WebElement e0 = driver.findElement(By.cssSelector("#flightNumber-0-0 .flight-identifier"));
		depart = e0.getText();
		System.out.println(depart);

		System.out.println("ville de dépapart allee:");
		String a = driver.findElement(By.className("departure")).getText();
		System.out.println(a);
		System.out.println("ville d'arrivée:");
		String b = driver.findElement(By.id("bound-arrival-0")).getText();
		System.out.println(b);
		System.out.println("le prix reservation:");
		String z = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(z);

		// continue
		driver.findElement(By.id("continueButton")).click();

		//  Select forms d'informations 
		
		Select s2 = new Select(driver.findElement(By.id("0-title")));
		s2.selectByValue("MR");
		driver.findElement(By.id("0-last-name")).sendKeys("Badreddine");
		driver.findElement(By.id("0-first-name")).sendKeys("Imene");
		driver.findElement(By.id("0-middle-name")).sendKeys("chikaoui");

		driver.findElement(By.id("0-gender")).sendKeys("Female");
		driver.findElement(By.id("0-birth-date-day")).sendKeys("09");
		driver.findElement(By.id("0-birth-date-month")).sendKeys("05");

		
		//Find Informations 
		s = new Select(driver.findElement(By.id("0-birth-date-year")));
		s.selectByVisibleText("1984");
		driver.findElement(By.id("0-passport-number")).sendKeys("R5694395");
		s = new Select(driver.findElement(By.id("0-issuing-country")));
		s.selectByVisibleText("France");
		s = new Select(driver.findElement(By.id("0-validity-day")));
		s.selectByVisibleText("05");
		s = new Select(driver.findElement(By.id("0-validity-month")));
		s.selectByVisibleText("04");
		s = new Select(driver.findElement(By.id("0-validity-year")));
		s.selectByVisibleText("2024");
		s = new Select(driver.findElement(By.id("0-nationality")));
		s.selectByVisibleText("French");
		s = new Select(driver.findElement(By.id("0-membership-select")));
		s.selectByVisibleText("Air France");
		driver.findElement(By.id("0-membership-input")).sendKeys("3698512586");

		// contact informations
		
		s = new Select(driver.findElement(By.id("phone1-phone-type-0")));
		s.selectByVisibleText("Mobile");
		s = new Select(driver.findElement(By.id("phone1-phone-country-0")));
		s.selectByVisibleText("France (33)");
		driver.findElement(By.id("phone1-phone-number-0")).sendKeys("0666399313");
		driver.findElement(By.id("email-guest-address")).sendKeys("tot.hato@gmail.com");
		driver.findElement(By.id("email-confirm-new")).sendKeys("tot.hato@gmail.com");

		// continue bounton
		driver.findElement(By.id("continueButton")).click();
		// contfirm bonton
		driver.findElement(By.id("continueButton-PCOF")).click();
		driver.findElement(By.id("seatContinue")).click();

		String c = driver.findElement(By.id("flightNumber-0-0")).getText();
		System.out.println(c);

		String d = driver.findElement(By.id("segmentOriginDate-0-0")).getText();
		System.out.println(d);

		System.out.println("ville de depart retour:");
		String e = driver.findElement(By.id("originLocation-1")).getText();

		System.out.println(e);
		System.out.println("ville d'arrivée:");
		String f = driver.findElement(By.id("destinationLocation-1")).getText();
		System.out.println(f);
		System.out.println("le prix finale");
		String z1 = driver.findElement(By.id("sidebarPriceSummaryTotalPrice")).getText();
		System.out.println(z1);

		// AssertEquals
		assertEquals("les prix sont egaux", z, z1);
		assertEquals(villeDepartChoisi, f);
		assertEquals("Ville arrivee et depart", b, e);
		assertTrue(c.contains("BA341"));

		// payment bouton
		driver.findElement(By.id("purchaseButton")).click();

		// driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");
		// s = new Select(driver.findElement(By.id("expiration-month-id")));
		// s.selectByVisibleText("12");
		// s = new Select(driver.findElement(By.id("expiration-year-id")));
		// s.selectByVisibleText("2019");
		// s = new Select(driver.findElement(By.id("CCname")));
		// s.selectByVisibleText("IMENE BADREDDINE");
		// driver.findElement(By.id("sec-code")).sendKeys("123");
		// driver.findElement(By.id("continueButton")).click();

		driver.findElement(By.id("CCnb")).sendKeys("4012888888881881");
		driver.findElement(By.id("expiration-month-id")).sendKeys("12");
		driver.findElement(By.id("expiration-month-id")).sendKeys("2019");

		driver.findElement(By.id("CCname")).sendKeys("IMENE BADREDDINE");
		driver.findElement(By.id("sec-code")).sendKeys("123");
		try {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.cssSelector("#flightNumber-0-0 .flight-identifier")));
		} catch (TimeoutException y) {

			System.out.println("J'ai bien trouve ton eelment: " + LocalDateTime.now());
			System.out.println("Je n'ai pas trouve ton element  : " + LocalDateTime.now());

		}
		driver.findElement(By.id("continueButton")).click();
		driver.findElement(By.id("action-buttons")).click();
		// excercice recuperer

		// WebElement element = driver.findElement(By.id("mdlDepLocation1"));
		// Actions actions = new Actions ( driver);
		// actions.moveToElement(element).click().build().perform();

		// if (a.equals(e))
		// {
		// System.out.println("youuppppppiiiiiiiiii");
		// }

	}

	private static void waitForThePage() {
		// TODO Auto-generated method stub

	}

	private static void pausa(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();

		}
	}
}