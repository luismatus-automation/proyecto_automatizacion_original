package definitions;

import configs.WebDriverManager;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;

import javax.imageio.ImageIO;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class Hooks
{
    @BeforeAll
    public static void before_all()
    {
        if(WebDriverManager.driver != null) {
            File folder = new File("src/test/resources/screenshots");
            if (folder.exists() && folder.isDirectory()) {
                File[] files = folder.listFiles();
                for (File file : files) {
                    if (file.isFile()) {
                        file.delete();
                    }
                }
            } else {
                System.out.println("La carpeta de screenshots no existe.");
            }
        }
    }

    @AfterStep
    public static void captureScreenshotAfterStep(Scenario scenario)
    {
        if(WebDriverManager.driver != null)
        {
            if (ExpectedConditions.alertIsPresent().apply(WebDriverManager.driver) != null) {
                captureAlertScreenshot(scenario);
                return;
            }

            System.out.println("tomando captura");
            String nombreScenario = scenario.getName();
            try {
                byte[] screenshot = ((TakesScreenshot) WebDriverManager.driver).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", nombreScenario);
            } catch (org.openqa.selenium.UnhandledAlertException e) {
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void captureAlertScreenshot(Scenario scenario)
    {
        try {
            Rectangle screenBounds = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
            BufferedImage screenshot = new Robot().createScreenCapture(screenBounds);
            ByteArrayOutputStream image = new ByteArrayOutputStream();
            ImageIO.write(screenshot, "png", image);
            scenario.attach(image.toByteArray(), "image/png", scenario.getName() + " - alerta");
        } catch (AWTException | IOException e) {
            e.printStackTrace();
        }
    }
}
