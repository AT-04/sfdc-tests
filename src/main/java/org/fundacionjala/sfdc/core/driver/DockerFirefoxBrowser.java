package org.fundacionjala.sfdc.core.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.sfdc.core.Env;

/**
 * DockerChromeBrowser class that implements IBrowsers.
 */
public class DockerFirefoxBrowser implements IBrowser {

    private static final Logger LOGGER = LogManager.getLogger();

    /**
     * Default Constructor.
     */
    public DockerFirefoxBrowser() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(Env.getInstance().getDockerUrl()), firefoxCapabilities);

        } catch (MalformedURLException e) {
            LOGGER.error(e.getMessage());
            throw new RuntimeException();
        }
        return driver;
    }
}