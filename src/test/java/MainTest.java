import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MainTest {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    public void testHomePageLoads() {
        driver.get("http://localhost:8081");

        assertEquals("Kubernetes + Docker", driver.getTitle());
        assertTrue(driver.getPageSource().contains(
            "Hello from Docker and Kubernetes!"));
    }

    @Test
    public void testApplicationMessage() {
        driver.get("http://localhost:8081");

        assertTrue(driver.getPageSource().contains(
            "This application is running inside a Kubernetes pod."));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
