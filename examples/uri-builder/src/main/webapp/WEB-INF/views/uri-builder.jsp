<%@ page contentType="text/html;charset=utf-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>UriBuilder examples</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/krazo.css"/>
</head>
<body>
<div class="container">

    <h1>UriBuilder</h1>

    <p>
        Hardcoding URIs in a template can be awkward.
        The MVC specification provides methods to generate URIs from <code>@Path</code>,
        <code>@PathParam</code>, <code>@QueryParam</code> and <code>@MatrixParam</code> annotations.
        It can be used from a template but also from Java code.
    </p>

    <h2>Simple URLs without parameters</h2>

    <p>Given following controller:</p>

    <pre><code>@Controller
@Path("uri-builder")
public class UriBuilderController {

    @GET
    @UriRef("some-ref")
    public String get() {
        return "uri-builder.jsp";
    }

}</code></pre>

    <p>A controller method to build the URI for can be referenced in two ways.</p>

    <p>
        First you can use the <a href="https://github.com/mvc-spec/mvc-spec/blob/master/api/src/main/java/javax/mvc/annotation/UriRef.java">UriRef</a>
        annotation to define a symbolic name for a controller method.
        To do so just place the annotation on the controller method and specify the name in the value attribute as shown in the controller above.
    </p>

    <p>Now you can generate the corresponding URI using a simple EL expression like this:</p>

    <pre>
        \${mvc.uri('some-ref')}<br />
        &lt!-- <span id="uri-ref">${mvc.uri('some-ref')}</span> --&gt
    </pre>

    <p class="note">
        <strong>Note:</strong> You should use <code>UriRef</code> only on one method if you have the same URI-template
        but multiple controller methods for different HTTP verbs.
    </p>

    <p>
        But you don't have to use <code>UriRef</code> annotation.
        You can also reference a controller method with the simple class name of your
        controller and the method name seperated by a '#':
    </p>

    <pre>
        \${mvc.uri('UriBuilderController#get')}<br />
        &lt!-- <span id="method-ref">${mvc.uri('UriBuilderController#get')}</span> --&gt;
    </pre>

    <p>Please note that this only works if the simple class name is not ambiguous.</p>

    <h2>Specifying parameters</h2>

    <p>
        The first section described how to link to controller methods without any parameters.
        But in real world application most controller methods will use
        parameters which you need to specify when creating the URI.
    </p>

    <p>See the following controller as an example:</p>

    <pre><code>@Controller
@Path("parameters")
public class ParameterController {

    @GET
    @Path("path/{p1}/{p2}")
    @UriRef("path-params")
    public String pathParams(@PathParam("p1") String p1, @PathParam("p2") long p2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("query")
    @UriRef("query-params")
    public String queryParams(@QueryParam("q1") String q1, @QueryParam("q2") long q2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("matrix")
    @UriRef("matrix-params")
    public String matrixParams(@MatrixParam("m1") String m1, @MatrixParam("m2") long m2) {
        return "uri-builder.jsp";
    }

    @GET
    @Path("bean/{p}")
    @UriRef("bean-params")
    public String beanParams(@BeanParam BeanParams params) {
        return "uri-builder.jsp";
    }

    static class BeanParams {

        @PathParam("p")
        private String p;

        @QueryParam("q")
        private String q;

        @MatrixParam("m")
        private long m;

    }

}</code></pre>

    <p>
        To set path parameters when building an URI, you have to provide a map containing the values for each parameter.
        Please note that you will have to set all path parameters because path parameters are required for the URI:
    </p>

    <pre>
        \${mvc.uri('path-params', {'p1': 'baz', 'p2': 4711})}<br />
        &lt!-- <span id="path-params">${mvc.uri('path-params', {'p1': 'baz', 'p2': 4711})}</span> --&gt;
    </pre>

    <p>You can also set query parameter values using a map:</p>

    <pre>
        \${mvc.uri('query-params', {'q1': 'foo', 'q2': 42})}<br />
        &lt!-- <span id="query-params">${mvc.uri('query-params', {'q1': 'foo', 'q2': 42})}</span> --&gt;
    </pre>

    <p>And also matrix parameters:</p>

    <pre>
        \${mvc.uri('matrix-params', {'m1': 'foo', 'm2': 42})}<br />
        &lt!-- <span id="matrix-params">${mvc.uri('matrix-params', {'m1': 'foo', 'm2': 42})}</span> --&gt;
    </pre>

    <p>
        The type of the parameter is automatically infered from the corresponding annotations on your controller.
        This means you can just specify the values by name and you don't have to care about the type of the parameter.
        This also works with <code>@BeanParam</code> parameters.
    </p>

    <pre>
        \${mvc.uri('bean-params', {'p': 'foo', 'm': 42, 'q': 'bar'})}<br />
        &lt!-- <span id="bean-params">${mvc.uri('bean-params', {'p': 'foo', 'm': 42, 'q': 'bar'})}</span> --&gt;
    </pre>

</div>

</body>
</html>
