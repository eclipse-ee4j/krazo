package org.eclipse.krazo.test.convert;

import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.nio.file.Paths;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class AvailableConvertersIT {

    private static final String RESOURCES = "src/main/resources/convert/available";
    private static final String HTTP_RESOURCE = "resources/available-converter";

    @Deployment(testable = false, name = "available-converter")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.convert.available")
            .addView(Paths.get(RESOURCES)
                         .resolve("views/index.jsp")
                         .toFile(), "index.jsp")
            .addBeansXml()
            .build();
    }

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions().setRedirectEnabled(true);
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Test
    public void shortConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("short").getTextContent()));
    }

    @Test
    public void longConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("long").getTextContent()));
    }

    @Test
    public void integerConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("integer").getTextContent()));
    }

    @Test
    public void floatConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("float").getTextContent()));
    }

    @Test
    public void doubleConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("double").getTextContent()));
    }

    @Test
    public void bigIntegerConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("biginteger").getTextContent()));
    }

    @Test
    public void bigDecimalConverterRegistered() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + HTTP_RESOURCE);

        assertTrue(formatErrorMessage(Short.class), Boolean.valueOf(page.getElementById("bigdecimal").getTextContent()));
    }

    private static String formatErrorMessage(final Class<?> clazz) {
        return String.format("Could not lookup default converter for %s", clazz.getName());
    }
}
