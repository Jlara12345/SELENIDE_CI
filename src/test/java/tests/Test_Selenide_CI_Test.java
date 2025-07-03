package tests;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.codeborne.selenide.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test_Selenide_CI_Test {

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void test() {
	     WebDriverManager.chromedriver().setup();
	        
	        
	        ChromeOptions options = new ChromeOptions();

	        // Cabecera de un navegador real (moderna y válida)
	        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
	                "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/125.0.0.0 Safari/537.36");
	        

	        DesiredCapabilities capabilities = new DesiredCapabilities();
	        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
	        
	        
	        Configuration.browserCapabilities = capabilities;
	        Configuration.browser = "chrome";
	        
	        Configuration.browser = "chrome";
	        Configuration.headless = false; // true si estás en CI o sin entorno gráfico
	        
	        //Instruccion para maximizar el navegador
	       // Configuration.startMaximized = true;
	        
	        System.out.println("HEADLESS: " + Configuration.headless);
	        System.out.println("DISPLAY: " + System.getenv("DISPLAY"));
	        
	        open("https://www.google.com/");
	        sleep(10000);
	        $("[name='q']").setValue("FES Acatlan").pressEnter();
	        
	        sleep(10000);
	}

}
