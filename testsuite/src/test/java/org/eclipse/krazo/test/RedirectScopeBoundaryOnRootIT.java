package org.eclipse.krazo.test;

import static org.junit.Assert.assertEquals;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.net.URL;
import java.nio.file.Paths;
import org.eclipse.krazo.test.util.WebArchiveBuilder;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class RedirectScopeBoundaryOnRootIT {

    private static final String WEB_INF_SRC = "src/main/resources/redirectboundaryonroot/";

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

    @Deployment(testable = false, name = "redirectboundaryonroot")
    public static Archive createDeployment() {
        return new WebArchiveBuilder()
            .addPackage("org.eclipse.krazo.test.redirectboundaryonroot")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/a.jsp").toFile(), "a.jsp")
            .addView(Paths.get(WEB_INF_SRC).resolve("views/b.jsp").toFile(), "b.jsp")
            .addBeansXml()
            .build();
    }

    @Test
    public void redirectFromAToADisplaysMessage() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "/a");

        final HtmlForm form = page.getFormByName("toAForm");

        final HtmlPage redirectedPage = form.getButtonByName("submit").click();

        final DomElement result = redirectedPage.getElementById("result");

        assertEquals("Redirect to A!", result.getTextContent());
    }

    @Test
    public void redirectFromAToBDisplaysMessage() throws Exception {
        final HtmlPage page = webClient.getPage(baseURL + "/a");

        final HtmlForm form = page.getFormByName("toBForm");

        final HtmlPage redirectedPage = form.getButtonByName("submit").click();

        final DomElement result = redirectedPage.getElementById("result");

        assertEquals("Redirect to B!", result.getTextContent());
    }
}
