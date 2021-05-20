TCK Results
===========

As required by the
[Eclipse Foundation Technology Compatibility Kit License](https://www.eclipse.org/legal/tck.php),
following is a summary of the TCK results for releases of Jakarta MVC.

# Jakarta MVC 2.0.1 Certification Summary

- Organization Name ("Organization") and, if applicable, URL:
  - [Eclipse Foundation](https://eclipse.org)
- Product Name, Version and download URL (if applicable):
  - [Eclipse Krazo 2.0.1](https://eclipse-ee4j.github.io/krazo/downloads/2.0.1.html)
- Specification Name, Version and download URL:
  - [Jakarta MVC 2.0](https://jakarta.ee/specifications/mvc/2.0)
- TCK Version, digital SHA-256 fingerprint and download URL:
  - [Jakarta MVC TCK 2.0.0](https://download.eclipse.org/jakartaee/mvc/2.0/jakarta-mvc-tck-2.0.0.zip)
  - SHA-256: `27a09b18169e46571898375d2eb1d05000301828c5d16dfc5d56e882690d55ed`
- Public URL of TCK Results Summary:
  - [https://eclipse-ee4j.github.io/krazo/certifications/jakarta-mvc/2.0.1/TCK-Results.html](https://eclipse-ee4j.github.io/krazo/certifications/jakarta-mvc/2.0.1/TCK-Results.html)
- Any Additional Specification Certification Requirements:
  - None
- Java runtime used to run the implementation:
  - OpenJDK Runtime Environment (build 1.8.0_292-b10)
- Summary of the information for the certification environment, operating system, cloud, ...:
  - Linux 5.11.18-200.fc33.x86_64 GNU/Linux
  - OpenJDK Runtime Environment (build 1.8.0_292-b10)
  - Testrun 1: Eclipse GlassFish 6.0.0
  - Testrun 2: WildFly 23.0.2.Final


## Test results

- [Testrun 1 (Eclipse GlassFish 6.0.0)](#testrun-1)
- [Testrun 2 (WildFly 23.0.2.Final)](#testrun-2)

<section>
<h2><a name="testrun-1"></a>Eclipse GlassFish 6.0.0</h2></section><section>
<h2><a name="Summary"></a>Summary</h2><a name="Summary"></a>
<p>[<a href="#Summary">Summary</a>] [<a href="#Package_List">Package List</a>] [<a href="#Test_Cases">Test Cases</a>]</p><br />
<table border="1" class="bodyTable">
<tr class="a">
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td>132</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>40.096</td></tr></table><br />
<p>Note: failures are anticipated and checked for with assertions while errors are unanticipated.</p><br /></section><section>
<h2><a name="Package_List"></a>Package List</h2><a name="Package_List"></a>
<p>[<a href="#Summary">Summary</a>] [<a href="#Package_List">Package List</a>] [<a href="#Test_Cases">Test Cases</a>]</p><br />
<table border="1" class="bodyTable">
<tr class="a">
<th>Package</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance">jakarta.mvc.tck.tests.application.inheritance</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.827</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify">jakarta.mvc.tck.tests.security.csrf.verify</a></td>
<td>16</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>4.046</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header">jakarta.mvc.tck.tests.security.csrf.header</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.94</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri">jakarta.mvc.tck.tests.mvc.uri</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.687</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype">jakarta.mvc.tck.tests.mvc.controller.mediatype</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.715</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm">jakarta.mvc.tck.tests.viewengine.algorithm</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.828</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool">jakarta.mvc.tck.tests.binding.bool</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.613</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject">jakarta.mvc.tck.tests.mvc.controller.inject</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.724</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models">jakarta.mvc.tck.tests.mvc.models</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.737</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.response">jakarta.mvc.tck.tests.mvc.response</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.66</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types">jakarta.mvc.tck.tests.binding.types</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.786</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base">jakarta.mvc.tck.tests.viewengine.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.333</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send">jakarta.mvc.tck.tests.mvc.redirect.send</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.755</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi">jakarta.mvc.tck.tests.mvc.instances.cdi</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.695</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard">jakarta.mvc.tck.tests.i18n.standard</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.687</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle">jakarta.mvc.tck.tests.mvc.instances.lifecycle</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.658</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context">jakarta.mvc.tck.tests.application.context</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.894</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.base">jakarta.mvc.tck.tests.binding.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.192</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access">jakarta.mvc.tck.tests.i18n.access</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.68</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation">jakarta.mvc.tck.tests.mvc.controller.annotation</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.835</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric">jakarta.mvc.tck.tests.binding.numeric</a></td>
<td>12</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.502</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm">jakarta.mvc.tck.tests.i18n.algorithm</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.921</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception">jakarta.mvc.tck.tests.security.csrf.exception</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.621</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope">jakarta.mvc.tck.tests.mvc.redirect.scope</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.789</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype">jakarta.mvc.tck.tests.mvc.controller.returntype</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.81</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.xss">jakarta.mvc.tck.tests.security.xss</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.789</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base">jakarta.mvc.tck.tests.security.csrf.base</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.821</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.events">jakarta.mvc.tck.tests.events</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.492</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app">jakarta.mvc.tck.tests.application.app</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.417</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy">jakarta.mvc.tck.tests.mvc.instances.proxy</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.642</td></tr></table><br />
<p>Note: package statistics are not computed recursively, they only sum up all of its testsuites numbers.</p><section>
<h3><a name="jakarta.mvc.tck.tests.application.inheritance"></a>jakarta.mvc.tck.tests.application.inheritance</h3><a name="jakarta.mvc.tck.tests.application.inheritance"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance.InheritanceTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.inheritance.InheritanceTest">InheritanceTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.827</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.verify"></a>jakarta.mvc.tck.tests.security.csrf.verify</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest">CsrfVerifyOffConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.293</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest">CsrfVerifyImplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.951</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest">CsrfVerifyExplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.981</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest">CsrfVerifyDefaultConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.821</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.header"></a>jakarta.mvc.tck.tests.security.csrf.header</h3><a name="jakarta.mvc.tck.tests.security.csrf.header"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest">CsrfDefaultHeaderTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.988</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest">CsrfCustomHeaderTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.952</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.uri"></a>jakarta.mvc.tck.tests.mvc.uri</h3><a name="jakarta.mvc.tck.tests.mvc.uri"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest">UriBuildingTest</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.687</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype"></a>jakarta.mvc.tck.tests.mvc.controller.mediatype</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest">MediaTypeTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.715</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm"></a>jakarta.mvc.tck.tests.viewengine.algorithm</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest">ViewEngineAlgorithmTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.828</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.bool"></a>jakarta.mvc.tck.tests.binding.bool</h3><a name="jakarta.mvc.tck.tests.binding.bool"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest">BindingBooleanTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.613</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject"></a>jakarta.mvc.tck.tests.mvc.controller.inject</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest">InjectParamsTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.724</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.models"></a>jakarta.mvc.tck.tests.mvc.models</h3><a name="jakarta.mvc.tck.tests.mvc.models"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest">BuiltinEngineModelTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.737</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.response"></a>jakarta.mvc.tck.tests.mvc.response</h3><a name="jakarta.mvc.tck.tests.mvc.response"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest">ResponseFeaturesTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.66</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.types"></a>jakarta.mvc.tck.tests.binding.types</h3><a name="jakarta.mvc.tck.tests.binding.types"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types.BindingTypesTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.types.BindingTypesTest">BindingTypesTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.786</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.viewengine.base"></a>jakarta.mvc.tck.tests.viewengine.base</h3><a name="jakarta.mvc.tck.tests.viewengine.base"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest">ViewEngineBaseTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.333</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send"></a>jakarta.mvc.tck.tests.mvc.redirect.send</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest">SendRedirectTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.755</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi"></a>jakarta.mvc.tck.tests.mvc.instances.cdi</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest">CdiControllerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.695</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.standard"></a>jakarta.mvc.tck.tests.i18n.standard</h3><a name="jakarta.mvc.tck.tests.i18n.standard"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest">I18nStandardTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.687</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle"></a>jakarta.mvc.tck.tests.mvc.instances.lifecycle</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest">ControllerLifecycleTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.658</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.application.context"></a>jakarta.mvc.tck.tests.application.context</h3><a name="jakarta.mvc.tck.tests.application.context"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context.MvcContextTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.context.MvcContextTest">MvcContextTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.894</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.base"></a>jakarta.mvc.tck.tests.binding.base</h3><a name="jakarta.mvc.tck.tests.binding.base"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.base.BindingBaseTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.base.BindingBaseTest">BindingBaseTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.192</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.access"></a>jakarta.mvc.tck.tests.i18n.access</h3><a name="jakarta.mvc.tck.tests.i18n.access"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access.I18nAccessTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.access.I18nAccessTest">I18nAccessTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.68</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation"></a>jakarta.mvc.tck.tests.mvc.controller.annotation</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest">ControllerAnnotationTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.835</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.numeric"></a>jakarta.mvc.tck.tests.binding.numeric</h3><a name="jakarta.mvc.tck.tests.binding.numeric"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest">BindingIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.059</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest">BindingBigIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.982</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest">BindingLongTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.838</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest">BindingBigDecimalTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.877</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest">BindingFloatTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.864</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest">BindingDoubleTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.882</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.algorithm"></a>jakarta.mvc.tck.tests.i18n.algorithm</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest">I18nAlgorithmTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.921</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.exception"></a>jakarta.mvc.tck.tests.security.csrf.exception</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest">CsrfCustomMapperTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.621</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope"></a>jakarta.mvc.tck.tests.mvc.redirect.scope</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest">RedirectScopeTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.789</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype"></a>jakarta.mvc.tck.tests.mvc.controller.returntype</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest">ReturnTypeTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.81</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.xss"></a>jakarta.mvc.tck.tests.security.xss</h3><a name="jakarta.mvc.tck.tests.security.xss"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.xss.EncodersTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.xss.EncodersTest">EncodersTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.789</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.base"></a>jakarta.mvc.tck.tests.security.csrf.base</h3><a name="jakarta.mvc.tck.tests.security.csrf.base"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest">CsrfBaseTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.821</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.events"></a>jakarta.mvc.tck.tests.events</h3><a name="jakarta.mvc.tck.tests.events"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.events.MvcEventsTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.events.MvcEventsTest">MvcEventsTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.492</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.application.app"></a>jakarta.mvc.tck.tests.application.app</h3><a name="jakarta.mvc.tck.tests.application.app"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest">MvcAppAnnotationTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.672</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest">MvcAppWebXmlTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.745</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy"></a>jakarta.mvc.tck.tests.mvc.instances.proxy</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest">InjectProxyTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.642</td></tr></table></section><br /></section><section>
<h2><a name="Test_Cases"></a>Test Cases</h2><a name="Test_Cases"></a>
<p>[<a href="#Summary">Summary</a>] [<a href="#Package_List">Package List</a>] [<a href="#Test_Cases">Test Cases</a>]</p><section>
<h3><a name="ViewEngineAlgorithmTest"></a>ViewEngineAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.relativeViewPath"></a>relativeViewPath</td>
<td>1.307</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.absoluteViewPath"></a>absoluteViewPath</td>
<td>0.025</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.overwriteBuiltinEngine"></a>overwriteBuiltinEngine</td>
<td>0.025</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.priorityOrderingCustomEngines"></a>priorityOrderingCustomEngines</td>
<td>0.021</td></tr></table></section><section>
<h3><a name="ViewEngineBaseTest"></a>ViewEngineBaseTest</h3><a name="jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineFacelets"></a>viewEngineFacelets</td>
<td>0.209</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineCustom"></a>viewEngineCustom</td>
<td>0.021</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineJsp"></a>viewEngineJsp</td>
<td>0.106</td></tr></table></section><section>
<h3><a name="BindingBooleanTest"></a>BindingBooleanTest</h3><a name="jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFoobar"></a>submitBooleanAsFoobar</td>
<td>0.564</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsTrue"></a>submitBooleanAsTrue</td>
<td>0.039</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsEmpty"></a>submitBooleanAsEmpty</td>
<td>0.04</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFalse"></a>submitBooleanAsFalse</td>
<td>0.043</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsOn"></a>submitBooleanAsOn</td>
<td>0.045</td></tr></table></section><section>
<h3><a name="BindingBaseTest"></a>BindingBaseTest</h3><a name="jakarta.mvc.tck.tests.binding.base.BindingBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidationError"></a>submitValidationError</td>
<td>0.328</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitBindingError"></a>submitBindingError</td>
<td>0.028</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidValue"></a>submitValidValue</td>
<td>0.028</td></tr></table></section><section>
<h3><a name="BindingIntegerTest"></a>BindingIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitValidInteger"></a>submitValidInteger</td>
<td>0.265</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitEmptyInteger"></a>submitEmptyInteger</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="BindingBigIntegerTest"></a>BindingBigIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitEmptyBigInteger"></a>submitEmptyBigInteger</td>
<td>0.207</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitValidBigInteger"></a>submitValidBigInteger</td>
<td>0.028</td></tr></table></section><section>
<h3><a name="BindingLongTest"></a>BindingLongTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitEmptyLong"></a>submitEmptyLong</td>
<td>0.191</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitValidLong"></a>submitValidLong</td>
<td>0.028</td></tr></table></section><section>
<h3><a name="BindingBigDecimalTest"></a>BindingBigDecimalTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitEmptyBigDecimal"></a>submitEmptyBigDecimal</td>
<td>0.186</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitValidBigDecimal"></a>submitValidBigDecimal</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="BindingFloatTest"></a>BindingFloatTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitEmptyFloat"></a>submitEmptyFloat</td>
<td>0.212</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitValidFloat"></a>submitValidFloat</td>
<td>0.03</td></tr></table></section><section>
<h3><a name="BindingDoubleTest"></a>BindingDoubleTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitEmptyDouble"></a>submitEmptyDouble</td>
<td>0.195</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitValidDouble"></a>submitValidDouble</td>
<td>0.026</td></tr></table></section><section>
<h3><a name="BindingTypesTest"></a>BindingTypesTest</h3><a name="jakarta.mvc.tck.tests.binding.types.BindingTypesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithHeaderParam"></a>bindingWithHeaderParam</td>
<td>0.122</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithFormParam"></a>bindingWithFormParam</td>
<td>0.016</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithCookieParam"></a>bindingWithCookieParam</td>
<td>0.014</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithQueryParam"></a>bindingWithQueryParam</td>
<td>0.013</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithMatrixParam"></a>bindingWithMatrixParam</td>
<td>0.013</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithPathParam"></a>bindingWithPathParam</td>
<td>0.015</td></tr></table></section><section>
<h3><a name="RedirectScopeTest"></a>RedirectScopeTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.sessionScope"></a>sessionScope</td>
<td>0.135</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.redirectScope"></a>redirectScope</td>
<td>0.03</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.requestScope"></a>requestScope</td>
<td>0.021</td></tr></table></section><section>
<h3><a name="SendRedirectTest"></a>SendRedirectTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathRedirectPrefix"></a>relativePathRedirectPrefix</td>
<td>0.075</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathResponse"></a>relativePathResponse</td>
<td>0.013</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.usesCorrectStatusCide"></a>usesCorrectStatusCide</td>
<td>0.016</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaRedirectPrefix"></a>redirectViaRedirectPrefix</td>
<td>0.019</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaResponse"></a>redirectViaResponse</td>
<td>0.02</td></tr></table></section><section>
<h3><a name="ReturnTypeTest"></a>ReturnTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithNullEntity"></a>responseWithNullEntity</td>
<td>0.098</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithStringEntity"></a>responseWithStringEntity</td>
<td>0.014</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithoutViewAnnotation"></a>voidWithoutViewAnnotation</td>
<td>0.025</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringWithNullResult"></a>stringWithNullResult</td>
<td>0.016</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringReturnType"></a>stringReturnType</td>
<td>0.016</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithViewAnnotation"></a>voidWithViewAnnotation</td>
<td>0.013</td></tr></table></section><section>
<h3><a name="MediaTypeTest"></a>MediaTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.defaultMediaType"></a>defaultMediaType</td>
<td>0.124</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.customMediaType"></a>customMediaType</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ControllerAnnotationTest"></a>ControllerAnnotationTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerClass"></a>controllerClass</td>
<td>0.178</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerHybrid"></a>controllerHybrid</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerMethod"></a>controllerMethod</td>
<td>0.013</td></tr></table></section><section>
<h3><a name="InjectParamsTest"></a>InjectParamsTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectQueryParam"></a>injectQueryParam</td>
<td>0.106</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectHeaderParam"></a>injectHeaderParam</td>
<td>0.019</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectFieldParam"></a>injectFieldParam</td>
<td>0.016</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPropertyParam"></a>injectPropertyParam</td>
<td>0.015</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPathParam"></a>injectPathParam</td>
<td>0.015</td></tr></table></section><section>
<h3><a name="BuiltinEngineModelTest"></a>BuiltinEngineModelTest</h3><a name="jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelJsp"></a>cdiModelJsp</td>
<td>0.101</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsFacelets"></a>mvcModelsFacelets</td>
<td>0.021</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelFacelets"></a>cdiModelFacelets</td>
<td>0.012</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsJsp"></a>mvcModelsJsp</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ResponseFeaturesTest"></a>ResponseFeaturesTest</h3><a name="jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingHeaders"></a>responseAllowsSettingHeaders</td>
<td>0.096</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingCacheControl"></a>responseAllowsSettingCacheControl</td>
<td>0.017</td></tr></table></section><section>
<h3><a name="ControllerLifecycleTest"></a>ControllerLifecycleTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest.controllerRequestScope"></a>controllerRequestScope</td>
<td>0.136</td></tr></table></section><section>
<h3><a name="CdiControllerTest"></a>CdiControllerTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.controllerCdiInjection"></a>controllerCdiInjection</td>
<td>0.101</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.hybridCdiInjection"></a>hybridCdiInjection</td>
<td>0.012</td></tr></table></section><section>
<h3><a name="InjectProxyTest"></a>InjectProxyTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest.injectProxyIfRequired"></a>injectProxyIfRequired</td>
<td>0.101</td></tr></table></section><section>
<h3><a name="UriBuildingTest"></a>UriBuildingTest</h3><a name="jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapPathParam"></a>mapPathParam</td>
<td>0.109</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.simpleUriViaEl"></a>simpleUriViaEl</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapQueryParam"></a>mapQueryParam</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingQueryParam"></a>encodingQueryParam</td>
<td>0.012</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapMatrixParam"></a>mapMatrixParam</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingMatrixParam"></a>encodingMatrixParam</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.supportsUriRef"></a>supportsUriRef</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingPathParam"></a>encodingPathParam</td>
<td>0.014</td></tr></table></section><section>
<h3><a name="InheritanceTest"></a>InheritanceTest</h3><a name="jakarta.mvc.tck.tests.application.inheritance.InheritanceTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndSuperMethod"></a>annotationsOnControllerAndSuperMethod</td>
<td>0.108</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnSuperMethod"></a>annotationsOnlyOnSuperMethod</td>
<td>0.061</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnSuperClassAndInterfaceMethod"></a>annotationsOnSuperClassAndInterfaceMethod</td>
<td>0.013</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnControllerMethod"></a>annotationsOnlyOnControllerMethod</td>
<td>0.013</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndInterfaceMethod"></a>annotationsOnControllerAndInterfaceMethod</td>
<td>0.014</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnInterfaceMethod"></a>annotationsOnlyOnInterfaceMethod</td>
<td>0.056</td></tr></table></section><section>
<h3><a name="MvcAppAnnotationTest"></a>MvcAppAnnotationTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.104</td></tr></table></section><section>
<h3><a name="MvcAppWebXmlTest"></a>MvcAppWebXmlTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.122</td></tr></table></section><section>
<h3><a name="MvcContextTest"></a>MvcContextTest</h3><a name="jakarta.mvc.tck.tests.application.context.MvcContextTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextInjected"></a>testMvcContextInjected</td>
<td>0.11</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextScope"></a>testMvcContextScope</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessInformation"></a>testMvcContextAccessInformation</td>
<td>0.01</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessViaEl"></a>testMvcContextAccessViaEl</td>
<td>0.019</td></tr></table></section><section>
<h3><a name="I18nAlgorithmTest"></a>I18nAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.chainStopsForNonNullResult"></a>chainStopsForNonNullResult</td>
<td>0.106</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.highestPrioExecutedFirst"></a>highestPrioExecutedFirst</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.continueChainForNullResult"></a>continueChainForNullResult</td>
<td>0.01</td></tr></table></section><section>
<h3><a name="I18nAccessTest"></a>I18nAccessTest</h3><a name="jakarta.mvc.tck.tests.i18n.access.I18nAccessTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromView"></a>accessLocaleFromView</td>
<td>0.104</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromController"></a>accessLocaleFromController</td>
<td>0.012</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromViewEngine"></a>accessLocaleFromViewEngine</td>
<td>0.012</td></tr></table></section><section>
<h3><a name="I18nStandardTest"></a>I18nStandardTest</h3><a name="jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.multipleLocalesInAcceptLanguageHeader"></a>multipleLocalesInAcceptLanguageHeader</td>
<td>0.101</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.missingAcceptLanguageHeader"></a>missingAcceptLanguageHeader</td>
<td>0.013</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.singleLocaleInAcceptLanguageHeader"></a>singleLocaleInAcceptLanguageHeader</td>
<td>0.024</td></tr></table></section><section>
<h3><a name="MvcEventsTest"></a>MvcEventsTest</h3><a name="jakarta.mvc.tck.tests.events.MvcEventsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundRenderView"></a>aroundRenderView</td>
<td>0.219</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundControllerEvents"></a>aroundControllerEvents</td>
<td>0.034</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.redirectEvent"></a>redirectEvent</td>
<td>0.035</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterControllerWithError"></a>afterControllerWithError</td>
<td>0.053</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterViewWithError"></a>afterViewWithError</td>
<td>0.146</td></tr></table></section><section>
<h3><a name="CsrfVerifyOffConfigTest"></a>CsrfVerifyOffConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.307</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.05</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.048</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.04</td></tr></table></section><section>
<h3><a name="CsrfVerifyImplicitConfigTest"></a>CsrfVerifyImplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.134</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.063</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.021</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="CsrfVerifyExplicitConfigTest"></a>CsrfVerifyExplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.114</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.065</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.023</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.027</td></tr></table></section><section>
<h3><a name="CsrfVerifyDefaultConfigTest"></a>CsrfVerifyDefaultConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.116</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.074</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.054</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.039</td></tr></table></section><section>
<h3><a name="CsrfDefaultHeaderTest"></a>CsrfDefaultHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaForm"></a>submitInvalidTokenViaForm</td>
<td>0.137</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaForm"></a>submitValidTokenViaForm</td>
<td>0.073</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaHeader"></a>submitValidTokenViaHeader</td>
<td>0.018</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaHeader"></a>submitInvalidTokenViaHeader</td>
<td>0.016</td></tr></table></section><section>
<h3><a name="CsrfCustomHeaderTest"></a>CsrfCustomHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitValidCustomTokenViaHeader"></a>submitValidCustomTokenViaHeader</td>
<td>0.17</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitInvalidCustomTokenViaHeader"></a>submitInvalidCustomTokenViaHeader</td>
<td>0.017</td></tr></table></section><section>
<h3><a name="CsrfBaseTest"></a>CsrfBaseTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.tokenIsProvidedViaElAndResponseHeader"></a>tokenIsProvidedViaElAndResponseHeader</td>
<td>0.1</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.canInjectTokenIntoHiddenField"></a>canInjectTokenIntoHiddenField</td>
<td>0.01</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaContext"></a>csrfInstanceViaContext</td>
<td>0.01</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaEL"></a>csrfInstanceViaEL</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="CsrfCustomMapperTest"></a>CsrfCustomMapperTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest.customExceptionMapper"></a>customExceptionMapper</td>
<td>0.125</td></tr></table></section><section>
<h3><a name="EncodersTest"></a>EncodersTest</h3><a name="jakarta.mvc.tck.tests.security.xss.EncodersTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesJavaScript"></a>encodesJavaScript</td>
<td>0.103</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersInjectable"></a>encodersInjectable</td>
<td>0.048</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersAvailableFromEl"></a>encodersAvailableFromEl</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesHtml"></a>encodesHtml</td>
<td>0.12</td></tr></table></section><br /></section>
      </div>
    </div>


<section>
<h2><a name="testrun-2"></a>WildFly 23.0.2.Final</h2></section><section>
<h2><a name="Summary-2"></a>Summary</h2><a name="Summary-2"></a>
<p>[<a href="#Summary-2">Summary</a>] [<a href="#Package_List-2">Package List</a>] [<a href="#Test_Cases-2">Test Cases</a>]</p><br />
<table border="1" class="bodyTable">
<tr class="a">
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td>132</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>28.079</td></tr></table><br />
<p>Note: failures are anticipated and checked for with assertions while errors are unanticipated.</p><br /></section><section>
<h2><a name="Package_List-2"></a>Package List</h2><a name="Package_List-2"></a>
<p>[<a href="#Summary-2">Summary</a>] [<a href="#Package_List-2">Package List</a>] [<a href="#Test_Cases-2">Test Cases</a>]</p><br />
<table border="1" class="bodyTable">
<tr class="a">
<th>Package</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance-2">jakarta.mvc.tck.tests.application.inheritance</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.552</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify-2">jakarta.mvc.tck.tests.security.csrf.verify</a></td>
<td>16</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.053</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header-2">jakarta.mvc.tck.tests.security.csrf.header</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.951</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri-2">jakarta.mvc.tck.tests.mvc.uri</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.523</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype-2">jakarta.mvc.tck.tests.mvc.controller.mediatype</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.528</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm-2">jakarta.mvc.tck.tests.viewengine.algorithm</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.552</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool-2">jakarta.mvc.tck.tests.binding.bool</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.09</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject-2">jakarta.mvc.tck.tests.mvc.controller.inject</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.597</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models-2">jakarta.mvc.tck.tests.mvc.models</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.548</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.response-2">jakarta.mvc.tck.tests.mvc.response</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.472</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types-2">jakarta.mvc.tck.tests.binding.types</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.619</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base-2">jakarta.mvc.tck.tests.viewengine.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.072</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send-2">jakarta.mvc.tck.tests.mvc.redirect.send</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.548</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi-2">jakarta.mvc.tck.tests.mvc.instances.cdi</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.529</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard-2">jakarta.mvc.tck.tests.i18n.standard</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.448</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle-2">jakarta.mvc.tck.tests.mvc.instances.lifecycle</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.481</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context-2">jakarta.mvc.tck.tests.application.context</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.452</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.base-2">jakarta.mvc.tck.tests.binding.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.939</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access-2">jakarta.mvc.tck.tests.i18n.access</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.444</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation-2">jakarta.mvc.tck.tests.mvc.controller.annotation</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.582</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric-2">jakarta.mvc.tck.tests.binding.numeric</a></td>
<td>12</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>4.2</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm-2">jakarta.mvc.tck.tests.i18n.algorithm</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.456</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception-2">jakarta.mvc.tck.tests.security.csrf.exception</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.439</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope-2">jakarta.mvc.tck.tests.mvc.redirect.scope</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.561</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype-2">jakarta.mvc.tck.tests.mvc.controller.returntype</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.565</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.xss-2">jakarta.mvc.tck.tests.security.xss</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.527</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base-2">jakarta.mvc.tck.tests.security.csrf.base</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.465</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.events-2">jakarta.mvc.tck.tests.events</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.561</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app-2">jakarta.mvc.tck.tests.application.app</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.867</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy-2">jakarta.mvc.tck.tests.mvc.instances.proxy</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.458</td></tr></table><br />
<p>Note: package statistics are not computed recursively, they only sum up all of its testsuites numbers.</p><section>
<h3><a name="jakarta.mvc.tck.tests.application.inheritance-2"></a>jakarta.mvc.tck.tests.application.inheritance</h3><a name="jakarta.mvc.tck.tests.application.inheritance-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance.InheritanceTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.inheritance.InheritanceTest-2">InheritanceTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.552</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.verify-2"></a>jakarta.mvc.tck.tests.security.csrf.verify</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest-2">CsrfVerifyOffConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.513</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest-2">CsrfVerifyImplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.514</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest-2">CsrfVerifyExplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.519</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest-2">CsrfVerifyDefaultConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.507</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.header-2"></a>jakarta.mvc.tck.tests.security.csrf.header</h3><a name="jakarta.mvc.tck.tests.security.csrf.header-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest-2">CsrfDefaultHeaderTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.493</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest-2">CsrfCustomHeaderTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.458</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.uri-2"></a>jakarta.mvc.tck.tests.mvc.uri</h3><a name="jakarta.mvc.tck.tests.mvc.uri-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest-2">UriBuildingTest</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.523</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype-2"></a>jakarta.mvc.tck.tests.mvc.controller.mediatype</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest-2">MediaTypeTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.528</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm-2"></a>jakarta.mvc.tck.tests.viewengine.algorithm</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest-2">ViewEngineAlgorithmTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.552</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.bool-2"></a>jakarta.mvc.tck.tests.binding.bool</h3><a name="jakarta.mvc.tck.tests.binding.bool-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest-2">BindingBooleanTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.09</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject-2"></a>jakarta.mvc.tck.tests.mvc.controller.inject</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest-2">InjectParamsTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.597</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.models-2"></a>jakarta.mvc.tck.tests.mvc.models</h3><a name="jakarta.mvc.tck.tests.mvc.models-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest-2">BuiltinEngineModelTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.548</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.response-2"></a>jakarta.mvc.tck.tests.mvc.response</h3><a name="jakarta.mvc.tck.tests.mvc.response-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest-2">ResponseFeaturesTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.472</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.types-2"></a>jakarta.mvc.tck.tests.binding.types</h3><a name="jakarta.mvc.tck.tests.binding.types-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types.BindingTypesTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.types.BindingTypesTest-2">BindingTypesTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.619</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.viewengine.base-2"></a>jakarta.mvc.tck.tests.viewengine.base</h3><a name="jakarta.mvc.tck.tests.viewengine.base-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest-2">ViewEngineBaseTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.072</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send-2"></a>jakarta.mvc.tck.tests.mvc.redirect.send</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest-2">SendRedirectTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.548</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi-2"></a>jakarta.mvc.tck.tests.mvc.instances.cdi</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest-2">CdiControllerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.529</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.standard-2"></a>jakarta.mvc.tck.tests.i18n.standard</h3><a name="jakarta.mvc.tck.tests.i18n.standard-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest-2">I18nStandardTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.448</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle-2"></a>jakarta.mvc.tck.tests.mvc.instances.lifecycle</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest-2">ControllerLifecycleTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.481</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.application.context-2"></a>jakarta.mvc.tck.tests.application.context</h3><a name="jakarta.mvc.tck.tests.application.context-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context.MvcContextTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.context.MvcContextTest-2">MvcContextTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.452</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.base-2"></a>jakarta.mvc.tck.tests.binding.base</h3><a name="jakarta.mvc.tck.tests.binding.base-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.base.BindingBaseTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.base.BindingBaseTest-2">BindingBaseTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.939</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.access-2"></a>jakarta.mvc.tck.tests.i18n.access</h3><a name="jakarta.mvc.tck.tests.i18n.access-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access.I18nAccessTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.access.I18nAccessTest-2">I18nAccessTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.444</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation-2"></a>jakarta.mvc.tck.tests.mvc.controller.annotation</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest-2">ControllerAnnotationTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.582</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.binding.numeric-2"></a>jakarta.mvc.tck.tests.binding.numeric</h3><a name="jakarta.mvc.tck.tests.binding.numeric-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest-2">BindingIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.683</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest-2">BindingBigIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.775</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest-2">BindingLongTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.744</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest-2">BindingBigDecimalTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.686</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest-2">BindingFloatTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.661</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest-2">BindingDoubleTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.651</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.i18n.algorithm-2"></a>jakarta.mvc.tck.tests.i18n.algorithm</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest-2">I18nAlgorithmTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.456</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.exception-2"></a>jakarta.mvc.tck.tests.security.csrf.exception</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest-2">CsrfCustomMapperTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.439</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope-2"></a>jakarta.mvc.tck.tests.mvc.redirect.scope</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest-2">RedirectScopeTest</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.561</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype-2"></a>jakarta.mvc.tck.tests.mvc.controller.returntype</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest-2">ReturnTypeTest</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.565</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.xss-2"></a>jakarta.mvc.tck.tests.security.xss</h3><a name="jakarta.mvc.tck.tests.security.xss-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.xss.EncodersTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.xss.EncodersTest-2">EncodersTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.527</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.security.csrf.base-2"></a>jakarta.mvc.tck.tests.security.csrf.base</h3><a name="jakarta.mvc.tck.tests.security.csrf.base-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest-2">CsrfBaseTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.465</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.events-2"></a>jakarta.mvc.tck.tests.events</h3><a name="jakarta.mvc.tck.tests.events-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.events.MvcEventsTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.events.MvcEventsTest-2">MvcEventsTest</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.561</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.application.app-2"></a>jakarta.mvc.tck.tests.application.app</h3><a name="jakarta.mvc.tck.tests.application.app-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest-2">MvcAppAnnotationTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.429</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest-2">MvcAppWebXmlTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.438</td></tr></table></section><section>
<h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy-2"></a>jakarta.mvc.tck.tests.mvc.instances.proxy</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<th></th>
<th>Class</th>
<th>Tests</th>
<th>Errors</th>
<th>Failures</th>
<th>Skipped</th>
<th>Success Rate</th>
<th>Time</th></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest-2"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest-2">InjectProxyTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>0.458</td></tr></table></section><br /></section><section>
<h2><a name="Test_Cases-2"></a>Test Cases</h2><a name="Test_Cases-2"></a>
<p>[<a href="#Summary-2">Summary</a>] [<a href="#Package_List-2">Package List</a>] [<a href="#Test_Cases-2">Test Cases</a>]</p><section>
<h3><a name="ViewEngineAlgorithmTest-2"></a>ViewEngineAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.relativeViewPath-2"></a>relativeViewPath</td>
<td>1.05</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.absoluteViewPath-2"></a>absoluteViewPath</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.overwriteBuiltinEngine-2"></a>overwriteBuiltinEngine</td>
<td>0.026</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.priorityOrderingCustomEngines-2"></a>priorityOrderingCustomEngines</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="ViewEngineBaseTest-2"></a>ViewEngineBaseTest</h3><a name="jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineFacelets-2"></a>viewEngineFacelets</td>
<td>0.205</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineCustom-2"></a>viewEngineCustom</td>
<td>0.021</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineJsp-2"></a>viewEngineJsp</td>
<td>0.051</td></tr></table></section><section>
<h3><a name="BindingBooleanTest-2"></a>BindingBooleanTest</h3><a name="jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFoobar-2"></a>submitBooleanAsFoobar</td>
<td>0.229</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsTrue-2"></a>submitBooleanAsTrue</td>
<td>0.049</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsEmpty-2"></a>submitBooleanAsEmpty</td>
<td>0.038</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFalse-2"></a>submitBooleanAsFalse</td>
<td>0.031</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsOn-2"></a>submitBooleanAsOn</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="BindingBaseTest-2"></a>BindingBaseTest</h3><a name="jakarta.mvc.tck.tests.binding.base.BindingBaseTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidationError-2"></a>submitValidationError</td>
<td>0.192</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitBindingError-2"></a>submitBindingError</td>
<td>0.041</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidValue-2"></a>submitValidValue</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="BindingIntegerTest-2"></a>BindingIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitValidInteger-2"></a>submitValidInteger</td>
<td>0.126</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitEmptyInteger-2"></a>submitEmptyInteger</td>
<td>0.032</td></tr></table></section><section>
<h3><a name="BindingBigIntegerTest-2"></a>BindingBigIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitEmptyBigInteger-2"></a>submitEmptyBigInteger</td>
<td>0.13</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitValidBigInteger-2"></a>submitValidBigInteger</td>
<td>0.036</td></tr></table></section><section>
<h3><a name="BindingLongTest-2"></a>BindingLongTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingLongTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitEmptyLong-2"></a>submitEmptyLong</td>
<td>0.102</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitValidLong-2"></a>submitValidLong</td>
<td>0.028</td></tr></table></section><section>
<h3><a name="BindingBigDecimalTest-2"></a>BindingBigDecimalTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitEmptyBigDecimal-2"></a>submitEmptyBigDecimal</td>
<td>0.12</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitValidBigDecimal-2"></a>submitValidBigDecimal</td>
<td>0.027</td></tr></table></section><section>
<h3><a name="BindingFloatTest-2"></a>BindingFloatTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitEmptyFloat-2"></a>submitEmptyFloat</td>
<td>0.104</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitValidFloat-2"></a>submitValidFloat</td>
<td>0.03</td></tr></table></section><section>
<h3><a name="BindingDoubleTest-2"></a>BindingDoubleTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitEmptyDouble-2"></a>submitEmptyDouble</td>
<td>0.117</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitValidDouble-2"></a>submitValidDouble</td>
<td>0.04</td></tr></table></section><section>
<h3><a name="BindingTypesTest-2"></a>BindingTypesTest</h3><a name="jakarta.mvc.tck.tests.binding.types.BindingTypesTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithHeaderParam-2"></a>bindingWithHeaderParam</td>
<td>0.072</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithFormParam-2"></a>bindingWithFormParam</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithCookieParam-2"></a>bindingWithCookieParam</td>
<td>0.012</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithQueryParam-2"></a>bindingWithQueryParam</td>
<td>0.012</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithMatrixParam-2"></a>bindingWithMatrixParam</td>
<td>0.014</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithPathParam-2"></a>bindingWithPathParam</td>
<td>0.014</td></tr></table></section><section>
<h3><a name="RedirectScopeTest-2"></a>RedirectScopeTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.sessionScope-2"></a>sessionScope</td>
<td>0.089</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.redirectScope-2"></a>redirectScope</td>
<td>0.025</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.requestScope-2"></a>requestScope</td>
<td>0.018</td></tr></table></section><section>
<h3><a name="SendRedirectTest-2"></a>SendRedirectTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathRedirectPrefix-2"></a>relativePathRedirectPrefix</td>
<td>0.047</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathResponse-2"></a>relativePathResponse</td>
<td>0.016</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.usesCorrectStatusCide-2"></a>usesCorrectStatusCide</td>
<td>0.014</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaRedirectPrefix-2"></a>redirectViaRedirectPrefix</td>
<td>0.014</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaResponse-2"></a>redirectViaResponse</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ReturnTypeTest-2"></a>ReturnTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithNullEntity-2"></a>responseWithNullEntity</td>
<td>0.071</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithStringEntity-2"></a>responseWithStringEntity</td>
<td>0.013</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithoutViewAnnotation-2"></a>voidWithoutViewAnnotation</td>
<td>0.017</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringWithNullResult-2"></a>stringWithNullResult</td>
<td>0.014</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringReturnType-2"></a>stringReturnType</td>
<td>0.017</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithViewAnnotation-2"></a>voidWithViewAnnotation</td>
<td>0.016</td></tr></table></section><section>
<h3><a name="MediaTypeTest-2"></a>MediaTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.defaultMediaType-2"></a>defaultMediaType</td>
<td>0.062</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.customMediaType-2"></a>customMediaType</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ControllerAnnotationTest-2"></a>ControllerAnnotationTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerClass-2"></a>controllerClass</td>
<td>0.076</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerHybrid-2"></a>controllerHybrid</td>
<td>0.02</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerMethod-2"></a>controllerMethod</td>
<td>0.013</td></tr></table></section><section>
<h3><a name="InjectParamsTest-2"></a>InjectParamsTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectQueryParam-2"></a>injectQueryParam</td>
<td>0.064</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectHeaderParam-2"></a>injectHeaderParam</td>
<td>0.012</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectFieldParam-2"></a>injectFieldParam</td>
<td>0.02</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPropertyParam-2"></a>injectPropertyParam</td>
<td>0.015</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPathParam-2"></a>injectPathParam</td>
<td>0.014</td></tr></table></section><section>
<h3><a name="BuiltinEngineModelTest-2"></a>BuiltinEngineModelTest</h3><a name="jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelJsp-2"></a>cdiModelJsp</td>
<td>0.08</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsFacelets-2"></a>mvcModelsFacelets</td>
<td>0.019</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelFacelets-2"></a>cdiModelFacelets</td>
<td>0.013</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsJsp-2"></a>mvcModelsJsp</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ResponseFeaturesTest-2"></a>ResponseFeaturesTest</h3><a name="jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingHeaders-2"></a>responseAllowsSettingHeaders</td>
<td>0.071</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingCacheControl-2"></a>responseAllowsSettingCacheControl</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="ControllerLifecycleTest-2"></a>ControllerLifecycleTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest.controllerRequestScope-2"></a>controllerRequestScope</td>
<td>0.096</td></tr></table></section><section>
<h3><a name="CdiControllerTest-2"></a>CdiControllerTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.controllerCdiInjection-2"></a>controllerCdiInjection</td>
<td>0.068</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.hybridCdiInjection-2"></a>hybridCdiInjection</td>
<td>0.013</td></tr></table></section><section>
<h3><a name="InjectProxyTest-2"></a>InjectProxyTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest.injectProxyIfRequired-2"></a>injectProxyIfRequired</td>
<td>0.075</td></tr></table></section><section>
<h3><a name="UriBuildingTest-2"></a>UriBuildingTest</h3><a name="jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapPathParam-2"></a>mapPathParam</td>
<td>0.061</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.simpleUriViaEl-2"></a>simpleUriViaEl</td>
<td>0.017</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapQueryParam-2"></a>mapQueryParam</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingQueryParam-2"></a>encodingQueryParam</td>
<td>0.014</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapMatrixParam-2"></a>mapMatrixParam</td>
<td>0.015</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingMatrixParam-2"></a>encodingMatrixParam</td>
<td>0.015</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.supportsUriRef-2"></a>supportsUriRef</td>
<td>0.012</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingPathParam-2"></a>encodingPathParam</td>
<td>0.012</td></tr></table></section><section>
<h3><a name="InheritanceTest-2"></a>InheritanceTest</h3><a name="jakarta.mvc.tck.tests.application.inheritance.InheritanceTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndSuperMethod-2"></a>annotationsOnControllerAndSuperMethod</td>
<td>0.067</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnSuperMethod-2"></a>annotationsOnlyOnSuperMethod</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnSuperClassAndInterfaceMethod-2"></a>annotationsOnSuperClassAndInterfaceMethod</td>
<td>0.013</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnControllerMethod-2"></a>annotationsOnlyOnControllerMethod</td>
<td>0.012</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndInterfaceMethod-2"></a>annotationsOnControllerAndInterfaceMethod</td>
<td>0.012</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnInterfaceMethod-2"></a>annotationsOnlyOnInterfaceMethod</td>
<td>0.027</td></tr></table></section><section>
<h3><a name="MvcAppAnnotationTest-2"></a>MvcAppAnnotationTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest.testUrlSpaceViaAnnotation-2"></a>testUrlSpaceViaAnnotation</td>
<td>0.071</td></tr></table></section><section>
<h3><a name="MvcAppWebXmlTest-2"></a>MvcAppWebXmlTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest.testUrlSpaceViaAnnotation-2"></a>testUrlSpaceViaAnnotation</td>
<td>0.067</td></tr></table></section><section>
<h3><a name="MvcContextTest-2"></a>MvcContextTest</h3><a name="jakarta.mvc.tck.tests.application.context.MvcContextTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextInjected-2"></a>testMvcContextInjected</td>
<td>0.056</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextScope-2"></a>testMvcContextScope</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessInformation-2"></a>testMvcContextAccessInformation</td>
<td>0.012</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessViaEl-2"></a>testMvcContextAccessViaEl</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="I18nAlgorithmTest-2"></a>I18nAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.chainStopsForNonNullResult-2"></a>chainStopsForNonNullResult</td>
<td>0.058</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.highestPrioExecutedFirst-2"></a>highestPrioExecutedFirst</td>
<td>0.01</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.continueChainForNullResult-2"></a>continueChainForNullResult</td>
<td>0.009</td></tr></table></section><section>
<h3><a name="I18nAccessTest-2"></a>I18nAccessTest</h3><a name="jakarta.mvc.tck.tests.i18n.access.I18nAccessTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromView-2"></a>accessLocaleFromView</td>
<td>0.054</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromController-2"></a>accessLocaleFromController</td>
<td>0.01</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromViewEngine-2"></a>accessLocaleFromViewEngine</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="I18nStandardTest-2"></a>I18nStandardTest</h3><a name="jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.multipleLocalesInAcceptLanguageHeader-2"></a>multipleLocalesInAcceptLanguageHeader</td>
<td>0.053</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.missingAcceptLanguageHeader-2"></a>missingAcceptLanguageHeader</td>
<td>0.009</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.singleLocaleInAcceptLanguageHeader-2"></a>singleLocaleInAcceptLanguageHeader</td>
<td>0.009</td></tr></table></section><section>
<h3><a name="MvcEventsTest-2"></a>MvcEventsTest</h3><a name="jakarta.mvc.tck.tests.events.MvcEventsTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundRenderView-2"></a>aroundRenderView</td>
<td>0.063</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundControllerEvents-2"></a>aroundControllerEvents</td>
<td>0.018</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.redirectEvent-2"></a>redirectEvent</td>
<td>0.019</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterControllerWithError-2"></a>afterControllerWithError</td>
<td>0.043</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterViewWithError-2"></a>afterViewWithError</td>
<td>0.026</td></tr></table></section><section>
<h3><a name="CsrfVerifyOffConfigTest-2"></a>CsrfVerifyOffConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndInvalidToken-2"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.079</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndValidToken-2"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.022</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndInvalidToken-2"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.019</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndValidToken-2"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.02</td></tr></table></section><section>
<h3><a name="CsrfVerifyImplicitConfigTest-2"></a>CsrfVerifyImplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndInvalidToken-2"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.068</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndValidToken-2"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.04</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken-2"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.018</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndValidToken-2"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.02</td></tr></table></section><section>
<h3><a name="CsrfVerifyExplicitConfigTest-2"></a>CsrfVerifyExplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndInvalidToken-2"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.065</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndValidToken-2"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.035</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken-2"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.02</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndValidToken-2"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.023</td></tr></table></section><section>
<h3><a name="CsrfVerifyDefaultConfigTest-2"></a>CsrfVerifyDefaultConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndInvalidToken-2"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.074</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndValidToken-2"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.032</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndInvalidToken-2"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.019</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndValidToken-2"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.02</td></tr></table></section><section>
<h3><a name="CsrfDefaultHeaderTest-2"></a>CsrfDefaultHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaForm-2"></a>submitInvalidTokenViaForm</td>
<td>0.062</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaForm-2"></a>submitValidTokenViaForm</td>
<td>0.032</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaHeader-2"></a>submitValidTokenViaHeader</td>
<td>0.014</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaHeader-2"></a>submitInvalidTokenViaHeader</td>
<td>0.013</td></tr></table></section><section>
<h3><a name="CsrfCustomHeaderTest-2"></a>CsrfCustomHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitValidCustomTokenViaHeader-2"></a>submitValidCustomTokenViaHeader</td>
<td>0.067</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitInvalidCustomTokenViaHeader-2"></a>submitInvalidCustomTokenViaHeader</td>
<td>0.017</td></tr></table></section><section>
<h3><a name="CsrfBaseTest-2"></a>CsrfBaseTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.tokenIsProvidedViaElAndResponseHeader-2"></a>tokenIsProvidedViaElAndResponseHeader</td>
<td>0.063</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.canInjectTokenIntoHiddenField-2"></a>canInjectTokenIntoHiddenField</td>
<td>0.011</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaContext-2"></a>csrfInstanceViaContext</td>
<td>0.011</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaEL-2"></a>csrfInstanceViaEL</td>
<td>0.011</td></tr></table></section><section>
<h3><a name="CsrfCustomMapperTest-2"></a>CsrfCustomMapperTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest.customExceptionMapper-2"></a>customExceptionMapper</td>
<td>0.059</td></tr></table></section><section>
<h3><a name="EncodersTest-2"></a>EncodersTest</h3><a name="jakarta.mvc.tck.tests.security.xss.EncodersTest-2"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesJavaScript-2"></a>encodesJavaScript</td>
<td>0.05</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersInjectable-2"></a>encodersInjectable</td>
<td>0.022</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersAvailableFromEl-2"></a>encodersAvailableFromEl</td>
<td>0.01</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesHtml-2"></a>encodesHtml</td>
<td>0.088</td></tr></table></section><br /></section>
      </div>
    </div>


