package org.eclipse.krazo.test.convert;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import org.eclipse.krazo.binding.convert.MvcConverter;
import org.eclipse.krazo.test.convert.annotations.AnnotationDrivenConverter;
import org.eclipse.krazo.test.convert.type.AnswerToAllDoubleConverter;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.net.URL;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

@RunWith(Arquillian.class)
public class AnnotationDrivenConverterIT {

    private static final String RESOURCES = "src/main/resources/convert/annotations";

    @Deployment(testable = false, name = "convert-annotations")
    public static WebArchive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.convert.annotations")
            .addView(Paths.get(RESOURCES)
                         .resolve("views/index.jsp")
                         .toFile(), "index.jsp")
            .addView(Paths.get(RESOURCES)
                         .resolve("views/result.jsp")
                         .toFile(), "result.jsp")
            .addService(MvcConverter.class, AnnotationDrivenConverter.class)
            .addBeansXml()
            .build();
    }

    @ArquillianResource
    private URL baseURL;

    private WebClient webClient;

    @Before
    public void setUp() {
        webClient = new WebClient();
        webClient.getOptions()
            .setThrowExceptionOnFailingStatusCode(false);
        webClient.getOptions()
            .setRedirectEnabled(true);
    }

    @After
    public void tearDown() {
        webClient.close();
    }

    @Test
    public void testCorrectCustomConverterIsUsedForDoubleValue() throws Exception {
        final HtmlPage page1 = webClient.getPage(baseURL + "resources/converter-annotations");
        final HtmlForm form = (HtmlForm) page1.getElementById("form");
        final HtmlSubmitInput button = form.getInputByName("submit");

        final HtmlPage resultPage = button.click();

        final double result = Double.parseDouble(resultPage.getElementById("result").getTextContent());

        assertEquals(42.0D, result, 0);
    }
}
