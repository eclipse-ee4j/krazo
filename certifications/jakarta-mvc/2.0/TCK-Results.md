TCK Results
===========

As required by the
[Eclipse Foundation Technology Compatibility Kit License](https://www.eclipse.org/legal/tck.php),
following is a summary of the TCK results for releases of Jakarta MVC.

# Jakarta MVC 2.0 Certification Summary

- Product Name, Version and download URL (if applicable): 

  [Eclipse Krazo 2.0.0](https://eclipse-ee4j.github.io/krazo/downloads/2.0.0.html)

- Specification Name, Version and download URL: 

   [Jakarta MVC 2.0](https://jakarta.ee/specifications/mvc/2.0)

- TCK Version, digital SHA-256 fingerprint and download URL: 

  [Jakarta MVC TCK 2.0.0](https://download.eclipse.org/jakartaee/mvc/2.0/jakarta-mvc-tck-2.0.0.zip),
  SHA-256: `27a09b18169e46571898375d2eb1d05000301828c5d16dfc5d56e882690d55ed`

- Public URL of TCK Results Summary: 

  [TCK results summary](TCK-Results.html)

- Any Additional Specification Certification Requirements:

  None

- Java runtime used to run the implementation:

  - Testrun 1: OpenJDK Runtime Environment (AdoptOpenJDK)(build 1.8.0_265-b01)
  - Testrun 2: OpenJDK Runtime Environment AdoptOpenJDK (build 15+36)

- Summary of the information for the certification environment, operating system, cloud, ...:

  - 5.8.0-29-generic #31-Ubuntu x86_64 GNU/Linux
  - Testrun 1: Eclipse GlassFish 6.0.0-RC2
  - Testrun 2: WildFly 22.0.0.Alpha1

## Test results 

- [Testrun 1 (GlassFish 6)](#Summary1)
- [Testrun 2 (WildfFly 22)](#Summary2)

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta name="generator" content="Apache Maven Doxia Site Renderer 1.9.2" />
    <title>Surefire Report</title>
    <link rel="stylesheet" href="./css/maven-base.css" />
    <link rel="stylesheet" href="./css/maven-theme.css" />
    <link rel="stylesheet" href="./css/site.css" />
    <link rel="stylesheet" href="./css/print.css" media="print" />
  </head>
  <body class="composite">
    <div id="banner">
      <div class="clear">
        <hr/>
      </div>
    </div>
    <div id="breadcrumbs">
      <div class="xleft">
        <span id="publishDate">Last Published: 2020-11-20</span>
          &#xA0;| <span id="projectVersion">Version: 2.0.0</span>
      </div>
      <div class="xright">      </div>
      <div class="clear">
        <hr/>
      </div>
    </div>
    <div id="leftColumn">
      <div id="navcolumn">
      </div>
    </div>
    <div id="bodyColumn">
      <div id="contentBox">
<script type="application/javascript">
//<![CDATA[
function toggleDisplay(elementId) {
 var elm = document.getElementById(elementId + '-error');
 if (elm == null) {
  elm = document.getElementById(elementId + '-failure');
 }
 if (elm && typeof elm.style != "undefined") {
  if (elm.style.display == "none") {
   elm.style.display = "";
   document.getElementById(elementId + '-off').style.display = "none";
   document.getElementById(elementId + '-on').style.display = "inline";
  } else if (elm.style.display == "") {   elm.style.display = "none";
   document.getElementById(elementId + '-off').style.display = "inline";
   document.getElementById(elementId + '-on').style.display = "none";
  } 
 } 
 }
//]]>
</script><section>
<h2><a name="Summary1"></a>Summary GlassFish 6</h2><a name="Summary1"></a>
<p>[<a href="#Summary1">Summary</a>] [<a href="#Package_List1">Package List</a>] [<a href="#Test_Cases1">Test Cases</a>]</p><br />
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
<td>107.935</td></tr></table><br />
<p>Note: failures are anticipated and checked for with assertions while errors are unanticipated.</p><br /></section><section>
<h2><a name="Package_List1"></a>Package List</h2><a name="Package_List1"></a>
<p>[<a href="#Summary1">Summary</a>] [<a href="#Package_List1">Package List</a>] [<a href="#Test_Cases1">Test Cases</a>]</p><br />
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
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header">jakarta.mvc.tck.tests.security.csrf.header</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.707</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance">jakarta.mvc.tck.tests.application.inheritance</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.734</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify">jakarta.mvc.tck.tests.security.csrf.verify</a></td>
<td>16</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>8.52</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri">jakarta.mvc.tck.tests.mvc.uri</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.694</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype">jakarta.mvc.tck.tests.mvc.controller.mediatype</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.67</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm">jakarta.mvc.tck.tests.viewengine.algorithm</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>26.812</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool">jakarta.mvc.tck.tests.binding.bool</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.56</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject">jakarta.mvc.tck.tests.mvc.controller.inject</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.762</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models">jakarta.mvc.tck.tests.mvc.models</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.98</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.response">jakarta.mvc.tck.tests.mvc.response</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.721</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types">jakarta.mvc.tck.tests.binding.types</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.036</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send">jakarta.mvc.tck.tests.mvc.redirect.send</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.126</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base">jakarta.mvc.tck.tests.viewengine.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.417</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard">jakarta.mvc.tck.tests.i18n.standard</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.878</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi">jakarta.mvc.tck.tests.mvc.instances.cdi</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.536</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle">jakarta.mvc.tck.tests.mvc.instances.lifecycle</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.692</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context">jakarta.mvc.tck.tests.application.context</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.453</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.base">jakarta.mvc.tck.tests.binding.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.127</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access">jakarta.mvc.tck.tests.i18n.access</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.538</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation">jakarta.mvc.tck.tests.mvc.controller.annotation</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.043</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric">jakarta.mvc.tck.tests.binding.numeric</a></td>
<td>12</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>14.811</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception">jakarta.mvc.tck.tests.security.csrf.exception</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.336</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm">jakarta.mvc.tck.tests.i18n.algorithm</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.579</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope">jakarta.mvc.tck.tests.mvc.redirect.scope</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.095</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype">jakarta.mvc.tck.tests.mvc.controller.returntype</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.989</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.xss">jakarta.mvc.tck.tests.security.xss</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.237</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base">jakarta.mvc.tck.tests.security.csrf.base</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.654</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.events">jakarta.mvc.tck.tests.events</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.717</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app">jakarta.mvc.tck.tests.application.app</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.993</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy">jakarta.mvc.tck.tests.mvc.instances.proxy</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.518</td></tr></table><br />
<p>Note: package statistics are not computed recursively, they only sum up all of its testsuites numbers.</p><section>
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
<td>1.849</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest">CsrfCustomHeaderTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.858</td></tr></table></section><section>
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
<td>1.734</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest">CsrfVerifyImplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.917</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest">CsrfVerifyOffConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.704</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest">CsrfVerifyDefaultConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.045</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest">CsrfVerifyExplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.854</td></tr></table></section><section>
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
<td>1.694</td></tr></table></section><section>
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
<td>1.67</td></tr></table></section><section>
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
<td>26.812</td></tr></table></section><section>
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
<td>3.56</td></tr></table></section><section>
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
<td>1.762</td></tr></table></section><section>
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
<td>1.98</td></tr></table></section><section>
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
<td>1.721</td></tr></table></section><section>
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
<td>2.036</td></tr></table></section><section>
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
<td>2.126</td></tr></table></section><section>
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
<td>3.417</td></tr></table></section><section>
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
<td>1.878</td></tr></table></section><section>
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
<td>1.536</td></tr></table></section><section>
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
<td>1.692</td></tr></table></section><section>
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
<td>1.453</td></tr></table></section><section>
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
<td>3.127</td></tr></table></section><section>
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
<td>1.538</td></tr></table></section><section>
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
<td>2.043</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest">BindingBigDecimalTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.608</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest">BindingLongTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.229</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest">BindingIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.096</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest">BindingDoubleTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.12</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest">BindingFloatTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.16</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest">BindingBigIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.598</td></tr></table></section><section>
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
<td>2.336</td></tr></table></section><section>
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
<td>1.579</td></tr></table></section><section>
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
<td>2.095</td></tr></table></section><section>
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
<td>1.989</td></tr></table></section><section>
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
<td>2.237</td></tr></table></section><section>
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
<td>1.654</td></tr></table></section><section>
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
<td>2.717</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest">MvcAppWebXmlTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.481</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest">MvcAppAnnotationTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.512</td></tr></table></section><section>
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
<td>1.518</td></tr></table></section><br /></section><section>
<h2><a name="Test_Cases1"></a>Test Cases</h2><a name="Test_Cases1"></a>
<p>[<a href="#Summary1">Summary</a>] [<a href="#Package_List1">Package List</a>] [<a href="#Test_Cases1">Test Cases</a>]</p><section>
<h3><a name="EncodersTest"></a>EncodersTest</h3><a name="jakarta.mvc.tck.tests.security.xss.EncodersTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesJavaScript"></a>encodesJavaScript</td>
<td>0.319</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersInjectable"></a>encodersInjectable</td>
<td>0.196</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersAvailableFromEl"></a>encodersAvailableFromEl</td>
<td>0.026</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesHtml"></a>encodesHtml</td>
<td>0.22</td></tr></table></section><section>
<h3><a name="MvcAppWebXmlTest"></a>MvcAppWebXmlTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.183</td></tr></table></section><section>
<h3><a name="MvcEventsTest"></a>MvcEventsTest</h3><a name="jakarta.mvc.tck.tests.events.MvcEventsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundRenderView"></a>aroundRenderView</td>
<td>0.359</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundControllerEvents"></a>aroundControllerEvents</td>
<td>0.074</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.redirectEvent"></a>redirectEvent</td>
<td>0.057</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterControllerWithError"></a>afterControllerWithError</td>
<td>0.102</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterViewWithError"></a>afterViewWithError</td>
<td>0.18</td></tr></table></section><section>
<h3><a name="RedirectScopeTest"></a>RedirectScopeTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.sessionScope"></a>sessionScope</td>
<td>0.329</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.redirectScope"></a>redirectScope</td>
<td>0.084</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.requestScope"></a>requestScope</td>
<td>0.048</td></tr></table></section><section>
<h3><a name="BindingBigDecimalTest"></a>BindingBigDecimalTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitEmptyBigDecimal"></a>submitEmptyBigDecimal</td>
<td>0.445</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitValidBigDecimal"></a>submitValidBigDecimal</td>
<td>0.077</td></tr></table></section><section>
<h3><a name="BindingLongTest"></a>BindingLongTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitEmptyLong"></a>submitEmptyLong</td>
<td>0.43</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitValidLong"></a>submitValidLong</td>
<td>0.07</td></tr></table></section><section>
<h3><a name="SendRedirectTest"></a>SendRedirectTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathRedirectPrefix"></a>relativePathRedirectPrefix</td>
<td>0.179</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathResponse"></a>relativePathResponse</td>
<td>0.047</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.usesCorrectStatusCide"></a>usesCorrectStatusCide</td>
<td>0.046</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaRedirectPrefix"></a>redirectViaRedirectPrefix</td>
<td>0.051</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaResponse"></a>redirectViaResponse</td>
<td>0.048</td></tr></table></section><section>
<h3><a name="CsrfDefaultHeaderTest"></a>CsrfDefaultHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaForm"></a>submitInvalidTokenViaForm</td>
<td>0.242</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaForm"></a>submitValidTokenViaForm</td>
<td>0.114</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaHeader"></a>submitValidTokenViaHeader</td>
<td>0.037</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaHeader"></a>submitInvalidTokenViaHeader</td>
<td>0.041</td></tr></table></section><section>
<h3><a name="InheritanceTest"></a>InheritanceTest</h3><a name="jakarta.mvc.tck.tests.application.inheritance.InheritanceTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndSuperMethod"></a>annotationsOnControllerAndSuperMethod</td>
<td>0.192</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnSuperMethod"></a>annotationsOnlyOnSuperMethod</td>
<td>0.078</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnSuperClassAndInterfaceMethod"></a>annotationsOnSuperClassAndInterfaceMethod</td>
<td>0.022</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnControllerMethod"></a>annotationsOnlyOnControllerMethod</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndInterfaceMethod"></a>annotationsOnControllerAndInterfaceMethod</td>
<td>0.022</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnInterfaceMethod"></a>annotationsOnlyOnInterfaceMethod</td>
<td>0.108</td></tr></table></section><section>
<h3><a name="BindingIntegerTest"></a>BindingIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitValidInteger"></a>submitValidInteger</td>
<td>0.5</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitEmptyInteger"></a>submitEmptyInteger</td>
<td>0.086</td></tr></table></section><section>
<h3><a name="ViewEngineBaseTest"></a>ViewEngineBaseTest</h3><a name="jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineFacelets"></a>viewEngineFacelets</td>
<td>0.591</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineCustom"></a>viewEngineCustom</td>
<td>0.053</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineJsp"></a>viewEngineJsp</td>
<td>0.194</td></tr></table></section><section>
<h3><a name="ReturnTypeTest"></a>ReturnTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithNullEntity"></a>responseWithNullEntity</td>
<td>0.202</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithStringEntity"></a>responseWithStringEntity</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithoutViewAnnotation"></a>voidWithoutViewAnnotation</td>
<td>0.071</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringWithNullResult"></a>stringWithNullResult</td>
<td>0.029</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringReturnType"></a>stringReturnType</td>
<td>0.037</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithViewAnnotation"></a>voidWithViewAnnotation</td>
<td>0.034</td></tr></table></section><section>
<h3><a name="BindingBooleanTest"></a>BindingBooleanTest</h3><a name="jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFoobar"></a>submitBooleanAsFoobar</td>
<td>0.788</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsTrue"></a>submitBooleanAsTrue</td>
<td>0.142</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsEmpty"></a>submitBooleanAsEmpty</td>
<td>0.162</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFalse"></a>submitBooleanAsFalse</td>
<td>0.175</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsOn"></a>submitBooleanAsOn</td>
<td>0.09</td></tr></table></section><section>
<h3><a name="BindingDoubleTest"></a>BindingDoubleTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitEmptyDouble"></a>submitEmptyDouble</td>
<td>0.351</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitValidDouble"></a>submitValidDouble</td>
<td>0.068</td></tr></table></section><section>
<h3><a name="MediaTypeTest"></a>MediaTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.defaultMediaType"></a>defaultMediaType</td>
<td>0.183</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.customMediaType"></a>customMediaType</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="CsrfVerifyImplicitConfigTest"></a>CsrfVerifyImplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.258</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.161</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.069</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.046</td></tr></table></section><section>
<h3><a name="BindingTypesTest"></a>BindingTypesTest</h3><a name="jakarta.mvc.tck.tests.binding.types.BindingTypesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithHeaderParam"></a>bindingWithHeaderParam</td>
<td>0.23</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithFormParam"></a>bindingWithFormParam</td>
<td>0.038</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithCookieParam"></a>bindingWithCookieParam</td>
<td>0.046</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithQueryParam"></a>bindingWithQueryParam</td>
<td>0.03</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithMatrixParam"></a>bindingWithMatrixParam</td>
<td>0.036</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithPathParam"></a>bindingWithPathParam</td>
<td>0.026</td></tr></table></section><section>
<h3><a name="ViewEngineAlgorithmTest"></a>ViewEngineAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.relativeViewPath"></a>relativeViewPath</td>
<td>3.989</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.absoluteViewPath"></a>absoluteViewPath</td>
<td>0.095</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.overwriteBuiltinEngine"></a>overwriteBuiltinEngine</td>
<td>0.056</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.priorityOrderingCustomEngines"></a>priorityOrderingCustomEngines</td>
<td>0.077</td></tr></table></section><section>
<h3><a name="InjectProxyTest"></a>InjectProxyTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest.injectProxyIfRequired"></a>injectProxyIfRequired</td>
<td>0.202</td></tr></table></section><section>
<h3><a name="I18nAccessTest"></a>I18nAccessTest</h3><a name="jakarta.mvc.tck.tests.i18n.access.I18nAccessTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromView"></a>accessLocaleFromView</td>
<td>0.209</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromController"></a>accessLocaleFromController</td>
<td>0.023</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromViewEngine"></a>accessLocaleFromViewEngine</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="BindingBaseTest"></a>BindingBaseTest</h3><a name="jakarta.mvc.tck.tests.binding.base.BindingBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidationError"></a>submitValidationError</td>
<td>0.764</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitBindingError"></a>submitBindingError</td>
<td>0.093</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidValue"></a>submitValidValue</td>
<td>0.072</td></tr></table></section><section>
<h3><a name="UriBuildingTest"></a>UriBuildingTest</h3><a name="jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapPathParam"></a>mapPathParam</td>
<td>0.203</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.simpleUriViaEl"></a>simpleUriViaEl</td>
<td>0.027</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapQueryParam"></a>mapQueryParam</td>
<td>0.026</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingQueryParam"></a>encodingQueryParam</td>
<td>0.021</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapMatrixParam"></a>mapMatrixParam</td>
<td>0.025</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingMatrixParam"></a>encodingMatrixParam</td>
<td>0.028</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.supportsUriRef"></a>supportsUriRef</td>
<td>0.028</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingPathParam"></a>encodingPathParam</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="MvcAppAnnotationTest"></a>MvcAppAnnotationTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.192</td></tr></table></section><section>
<h3><a name="MvcContextTest"></a>MvcContextTest</h3><a name="jakarta.mvc.tck.tests.application.context.MvcContextTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextInjected"></a>testMvcContextInjected</td>
<td>0.171</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextScope"></a>testMvcContextScope</td>
<td>0.024</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessInformation"></a>testMvcContextAccessInformation</td>
<td>0.023</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessViaEl"></a>testMvcContextAccessViaEl</td>
<td>0.023</td></tr></table></section><section>
<h3><a name="I18nStandardTest"></a>I18nStandardTest</h3><a name="jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.multipleLocalesInAcceptLanguageHeader"></a>multipleLocalesInAcceptLanguageHeader</td>
<td>0.3</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.missingAcceptLanguageHeader"></a>missingAcceptLanguageHeader</td>
<td>0.038</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.singleLocaleInAcceptLanguageHeader"></a>singleLocaleInAcceptLanguageHeader</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="CsrfVerifyOffConfigTest"></a>CsrfVerifyOffConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.431</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.073</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.052</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.052</td></tr></table></section><section>
<h3><a name="BindingFloatTest"></a>BindingFloatTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitEmptyFloat"></a>submitEmptyFloat</td>
<td>0.365</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitValidFloat"></a>submitValidFloat</td>
<td>0.073</td></tr></table></section><section>
<h3><a name="ControllerAnnotationTest"></a>ControllerAnnotationTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerClass"></a>controllerClass</td>
<td>0.338</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerHybrid"></a>controllerHybrid</td>
<td>0.055</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerMethod"></a>controllerMethod</td>
<td>0.033</td></tr></table></section><section>
<h3><a name="CsrfCustomHeaderTest"></a>CsrfCustomHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitValidCustomTokenViaHeader"></a>submitValidCustomTokenViaHeader</td>
<td>0.287</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitInvalidCustomTokenViaHeader"></a>submitInvalidCustomTokenViaHeader</td>
<td>0.043</td></tr></table></section><section>
<h3><a name="ControllerLifecycleTest"></a>ControllerLifecycleTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest.controllerRequestScope"></a>controllerRequestScope</td>
<td>0.275</td></tr></table></section><section>
<h3><a name="CsrfCustomMapperTest"></a>CsrfCustomMapperTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest.customExceptionMapper"></a>customExceptionMapper</td>
<td>0.257</td></tr></table></section><section>
<h3><a name="I18nAlgorithmTest"></a>I18nAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.chainStopsForNonNullResult"></a>chainStopsForNonNullResult</td>
<td>0.229</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.highestPrioExecutedFirst"></a>highestPrioExecutedFirst</td>
<td>0.023</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.continueChainForNullResult"></a>continueChainForNullResult</td>
<td>0.022</td></tr></table></section><section>
<h3><a name="CsrfBaseTest"></a>CsrfBaseTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.tokenIsProvidedViaElAndResponseHeader"></a>tokenIsProvidedViaElAndResponseHeader</td>
<td>0.237</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.canInjectTokenIntoHiddenField"></a>canInjectTokenIntoHiddenField</td>
<td>0.032</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaContext"></a>csrfInstanceViaContext</td>
<td>0.024</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaEL"></a>csrfInstanceViaEL</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="CsrfVerifyDefaultConfigTest"></a>CsrfVerifyDefaultConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.253</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.143</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.05</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.068</td></tr></table></section><section>
<h3><a name="CdiControllerTest"></a>CdiControllerTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.controllerCdiInjection"></a>controllerCdiInjection</td>
<td>0.185</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.hybridCdiInjection"></a>hybridCdiInjection</td>
<td>0.029</td></tr></table></section><section>
<h3><a name="CsrfVerifyExplicitConfigTest"></a>CsrfVerifyExplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.241</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.139</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.049</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.057</td></tr></table></section><section>
<h3><a name="InjectParamsTest"></a>InjectParamsTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectQueryParam"></a>injectQueryParam</td>
<td>0.196</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectHeaderParam"></a>injectHeaderParam</td>
<td>0.04</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectFieldParam"></a>injectFieldParam</td>
<td>0.037</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPropertyParam"></a>injectPropertyParam</td>
<td>0.034</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPathParam"></a>injectPathParam</td>
<td>0.035</td></tr></table></section><section>
<h3><a name="BindingBigIntegerTest"></a>BindingBigIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitEmptyBigInteger"></a>submitEmptyBigInteger</td>
<td>0.425</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitValidBigInteger"></a>submitValidBigInteger</td>
<td>0.283</td></tr></table></section><section>
<h3><a name="BuiltinEngineModelTest"></a>BuiltinEngineModelTest</h3><a name="jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelJsp"></a>cdiModelJsp</td>
<td>0.209</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsFacelets"></a>mvcModelsFacelets</td>
<td>0.05</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelFacelets"></a>cdiModelFacelets</td>
<td>0.029</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsJsp"></a>mvcModelsJsp</td>
<td>0.027</td></tr></table></section><section>
<h3><a name="ResponseFeaturesTest"></a>ResponseFeaturesTest</h3><a name="jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingHeaders"></a>responseAllowsSettingHeaders</td>
<td>0.213</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingCacheControl"></a>responseAllowsSettingCacheControl</td>
<td>0.036</td></tr></table></section><br /></section>
      </div>
    </div>
    <div class="clear">
      <hr/>
    </div>
    <div id="footer">
      <div class="xright">
        Copyright &#169;      2017&#x2013;2020<a href="https://www.eclipse.org">Eclipse Foundation</a>.
.      </div>
      <div class="clear">
        <hr/>
      </div>
    </div>
    <div id="banner">
      <div class="clear">
        <hr/>
      </div>
    </div>
    <div id="breadcrumbs">
      <div class="xleft">
        <span id="publishDate">Last Published: 2020-11-20</span>
          &#xA0;| <span id="projectVersion">Version: 2.0.0</span>
      </div>
      <div class="xright">      </div>
      <div class="clear">
        <hr/>
      </div>
    </div>
    <div id="leftColumn">
      <div id="navcolumn">
      </div>
    </div>
    <div id="bodyColumn">
      <div id="contentBox">
<script type="application/javascript">
//<![CDATA[
function toggleDisplay(elementId) {
 var elm = document.getElementById(elementId + '-error');
 if (elm == null) {
  elm = document.getElementById(elementId + '-failure');
 }
 if (elm && typeof elm.style != "undefined") {
  if (elm.style.display == "none") {
   elm.style.display = "";
   document.getElementById(elementId + '-off').style.display = "none";
   document.getElementById(elementId + '-on').style.display = "inline";
  } else if (elm.style.display == "") {   elm.style.display = "none";
   document.getElementById(elementId + '-off').style.display = "inline";
   document.getElementById(elementId + '-on').style.display = "none";
  } 
 } 
 }
//]]>
</script><section>
<h2><a name="Summary2"></a>Summary WildFly 22</h2><a name="Summary2"></a>
<p>[<a href="#Summary2">Summary</a>] [<a href="#Package_List2">Package List</a>] [<a href="#Test_Cases2">Test Cases</a>]</p><br />
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
<td>118.487</td></tr></table><br />
<p>Note: failures are anticipated and checked for with assertions while errors are unanticipated.</p><br /></section><section>
<h2><a name="Package_List2"></a>Package List</h2><a name="Package_List2"></a>
<p>[<a href="#Summary2">Summary</a>] [<a href="#Package_List2">Package List</a>] [<a href="#Test_Cases2">Test Cases</a>]</p><br />
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
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header">jakarta.mvc.tck.tests.security.csrf.header</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>4.06</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.inheritance">jakarta.mvc.tck.tests.application.inheritance</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.255</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify">jakarta.mvc.tck.tests.security.csrf.verify</a></td>
<td>16</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>8.95</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.uri">jakarta.mvc.tck.tests.mvc.uri</a></td>
<td>8</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.294</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.mediatype">jakarta.mvc.tck.tests.mvc.controller.mediatype</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.033</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.viewengine.algorithm">jakarta.mvc.tck.tests.viewengine.algorithm</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>19.984</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.bool">jakarta.mvc.tck.tests.binding.bool</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.429</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.inject">jakarta.mvc.tck.tests.mvc.controller.inject</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.233</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.models">jakarta.mvc.tck.tests.mvc.models</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.79</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.response">jakarta.mvc.tck.tests.mvc.response</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.293</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.types">jakarta.mvc.tck.tests.binding.types</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.19</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.send">jakarta.mvc.tck.tests.mvc.redirect.send</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.591</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.viewengine.base">jakarta.mvc.tck.tests.viewengine.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>5.979</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.i18n.standard">jakarta.mvc.tck.tests.i18n.standard</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.231</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.cdi">jakarta.mvc.tck.tests.mvc.instances.cdi</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.089</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.lifecycle">jakarta.mvc.tck.tests.mvc.instances.lifecycle</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.891</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.context">jakarta.mvc.tck.tests.application.context</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.061</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.base">jakarta.mvc.tck.tests.binding.base</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>4.013</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.access">jakarta.mvc.tck.tests.i18n.access</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.926</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.annotation">jakarta.mvc.tck.tests.mvc.controller.annotation</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.545</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric">jakarta.mvc.tck.tests.binding.numeric</a></td>
<td>12</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>16.113</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.exception">jakarta.mvc.tck.tests.security.csrf.exception</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.69</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.i18n.algorithm">jakarta.mvc.tck.tests.i18n.algorithm</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.916</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.redirect.scope">jakarta.mvc.tck.tests.mvc.redirect.scope</a></td>
<td>3</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.896</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.mvc.controller.returntype">jakarta.mvc.tck.tests.mvc.controller.returntype</a></td>
<td>6</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.112</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.xss">jakarta.mvc.tck.tests.security.xss</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.257</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.base">jakarta.mvc.tck.tests.security.csrf.base</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.927</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.events">jakarta.mvc.tck.tests.events</a></td>
<td>5</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.419</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.application.app">jakarta.mvc.tck.tests.application.app</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.922</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.mvc.instances.proxy">jakarta.mvc.tck.tests.mvc.instances.proxy</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.398</td></tr></table><br />
<p>Note: package statistics are not computed recursively, they only sum up all of its testsuites numbers.</p><section>
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
<td>1.869</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest">CsrfCustomHeaderTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.191</td></tr></table></section><section>
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
<td>2.255</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest">CsrfVerifyImplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.363</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest">CsrfVerifyOffConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.537</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest">CsrfVerifyDefaultConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.013</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest">CsrfVerifyExplicitConfigTest</a></td>
<td>4</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.037</td></tr></table></section><section>
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
<td>2.294</td></tr></table></section><section>
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
<td>2.033</td></tr></table></section><section>
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
<td>19.984</td></tr></table></section><section>
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
<td>5.429</td></tr></table></section><section>
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
<td>2.233</td></tr></table></section><section>
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
<td>2.79</td></tr></table></section><section>
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
<td>2.293</td></tr></table></section><section>
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
<td>2.19</td></tr></table></section><section>
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
<td>2.591</td></tr></table></section><section>
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
<td>5.979</td></tr></table></section><section>
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
<td>2.231</td></tr></table></section><section>
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
<td>2.089</td></tr></table></section><section>
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
<td>1.891</td></tr></table></section><section>
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
<td>2.061</td></tr></table></section><section>
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
<td>4.013</td></tr></table></section><section>
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
<td>1.926</td></tr></table></section><section>
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
<td>3.545</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest">BindingBigDecimalTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.189</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingLongTest">BindingLongTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.686</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest">BindingIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest">BindingDoubleTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.489</td></tr>
<tr class="b">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest">BindingFloatTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.532</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest">BindingBigIntegerTest</a></td>
<td>2</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>3.217</td></tr></table></section><section>
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
<td>1.69</td></tr></table></section><section>
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
<td>1.916</td></tr></table></section><section>
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
<td>2.896</td></tr></table></section><section>
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
<td>2.112</td></tr></table></section><section>
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
<td>2.257</td></tr></table></section><section>
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
<td>1.927</td></tr></table></section><section>
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
<td>2.419</td></tr></table></section><section>
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
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest">MvcAppWebXmlTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>2.08</td></tr>
<tr class="a">
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"><figure><img src="images/icon_success_sml.gif" alt="" /></figure></a></td>
<td><a href="#jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest">MvcAppAnnotationTest</a></td>
<td>1</td>
<td>0</td>
<td>0</td>
<td>0</td>
<td>100%</td>
<td>1.842</td></tr></table></section><section>
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
<td>2.398</td></tr></table></section><br /></section><section>
<h2><a name="Test_Cases2"></a>Test Cases</h2><a name="Test_Cases2"></a>
<p>[<a href="#Summary2">Summary</a>] [<a href="#Package_List2">Package List</a>] [<a href="#Test_Cases2">Test Cases</a>]</p><section>
<h3><a name="EncodersTest"></a>EncodersTest</h3><a name="jakarta.mvc.tck.tests.security.xss.EncodersTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesJavaScript"></a>encodesJavaScript</td>
<td>0.117</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersInjectable"></a>encodersInjectable</td>
<td>0.08</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodersAvailableFromEl"></a>encodersAvailableFromEl</td>
<td>0.028</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.xss.EncodersTest.encodesHtml"></a>encodesHtml</td>
<td>0.27</td></tr></table></section><section>
<h3><a name="MvcAppWebXmlTest"></a>MvcAppWebXmlTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppWebXmlTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.201</td></tr></table></section><section>
<h3><a name="MvcEventsTest"></a>MvcEventsTest</h3><a name="jakarta.mvc.tck.tests.events.MvcEventsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundRenderView"></a>aroundRenderView</td>
<td>0.166</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.aroundControllerEvents"></a>aroundControllerEvents</td>
<td>0.057</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.redirectEvent"></a>redirectEvent</td>
<td>0.051</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterControllerWithError"></a>afterControllerWithError</td>
<td>0.203</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.events.MvcEventsTest.afterViewWithError"></a>afterViewWithError</td>
<td>0.014</td></tr></table></section><section>
<h3><a name="RedirectScopeTest"></a>RedirectScopeTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.sessionScope"></a>sessionScope</td>
<td>0.353</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.redirectScope"></a>redirectScope</td>
<td>0.172</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.scope.RedirectScopeTest.requestScope"></a>requestScope</td>
<td>0.079</td></tr></table></section><section>
<h3><a name="BindingBigDecimalTest"></a>BindingBigDecimalTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitEmptyBigDecimal"></a>submitEmptyBigDecimal</td>
<td>0.254</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigDecimalTest.submitValidBigDecimal"></a>submitValidBigDecimal</td>
<td>0.064</td></tr></table></section><section>
<h3><a name="BindingLongTest"></a>BindingLongTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingLongTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitEmptyLong"></a>submitEmptyLong</td>
<td>0.383</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingLongTest.submitValidLong"></a>submitValidLong</td>
<td>0.075</td></tr></table></section><section>
<h3><a name="SendRedirectTest"></a>SendRedirectTest</h3><a name="jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathRedirectPrefix"></a>relativePathRedirectPrefix</td>
<td>0.136</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.relativePathResponse"></a>relativePathResponse</td>
<td>0.042</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.usesCorrectStatusCide"></a>usesCorrectStatusCide</td>
<td>0.041</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaRedirectPrefix"></a>redirectViaRedirectPrefix</td>
<td>0.045</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.redirect.send.SendRedirectTest.redirectViaResponse"></a>redirectViaResponse</td>
<td>0.045</td></tr></table></section><section>
<h3><a name="CsrfDefaultHeaderTest"></a>CsrfDefaultHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaForm"></a>submitInvalidTokenViaForm</td>
<td>0.179</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaForm"></a>submitValidTokenViaForm</td>
<td>0.093</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitValidTokenViaHeader"></a>submitValidTokenViaHeader</td>
<td>0.042</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfDefaultHeaderTest.submitInvalidTokenViaHeader"></a>submitInvalidTokenViaHeader</td>
<td>0.033</td></tr></table></section><section>
<h3><a name="InheritanceTest"></a>InheritanceTest</h3><a name="jakarta.mvc.tck.tests.application.inheritance.InheritanceTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndSuperMethod"></a>annotationsOnControllerAndSuperMethod</td>
<td>0.161</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnSuperMethod"></a>annotationsOnlyOnSuperMethod</td>
<td>0.062</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnSuperClassAndInterfaceMethod"></a>annotationsOnSuperClassAndInterfaceMethod</td>
<td>0.03</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnControllerMethod"></a>annotationsOnlyOnControllerMethod</td>
<td>0.026</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnControllerAndInterfaceMethod"></a>annotationsOnControllerAndInterfaceMethod</td>
<td>0.027</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.inheritance.InheritanceTest.annotationsOnlyOnInterfaceMethod"></a>annotationsOnlyOnInterfaceMethod</td>
<td>0.093</td></tr></table></section><section>
<h3><a name="BindingIntegerTest"></a>BindingIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitValidInteger"></a>submitValidInteger</td>
<td>0.381</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingIntegerTest.submitEmptyInteger"></a>submitEmptyInteger</td>
<td>0.07</td></tr></table></section><section>
<h3><a name="ViewEngineBaseTest"></a>ViewEngineBaseTest</h3><a name="jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineFacelets"></a>viewEngineFacelets</td>
<td>0.521</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineCustom"></a>viewEngineCustom</td>
<td>0.058</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.base.ViewEngineBaseTest.viewEngineJsp"></a>viewEngineJsp</td>
<td>0.306</td></tr></table></section><section>
<h3><a name="ReturnTypeTest"></a>ReturnTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithNullEntity"></a>responseWithNullEntity</td>
<td>0.124</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.responseWithStringEntity"></a>responseWithStringEntity</td>
<td>0.039</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithoutViewAnnotation"></a>voidWithoutViewAnnotation</td>
<td>0.041</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringWithNullResult"></a>stringWithNullResult</td>
<td>0.05</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.stringReturnType"></a>stringReturnType</td>
<td>0.033</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.returntype.ReturnTypeTest.voidWithViewAnnotation"></a>voidWithViewAnnotation</td>
<td>0.026</td></tr></table></section><section>
<h3><a name="BindingBooleanTest"></a>BindingBooleanTest</h3><a name="jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFoobar"></a>submitBooleanAsFoobar</td>
<td>0.675</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsTrue"></a>submitBooleanAsTrue</td>
<td>0.113</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsEmpty"></a>submitBooleanAsEmpty</td>
<td>0.098</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsFalse"></a>submitBooleanAsFalse</td>
<td>0.082</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.bool.BindingBooleanTest.submitBooleanAsOn"></a>submitBooleanAsOn</td>
<td>0.079</td></tr></table></section><section>
<h3><a name="BindingDoubleTest"></a>BindingDoubleTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitEmptyDouble"></a>submitEmptyDouble</td>
<td>0.297</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingDoubleTest.submitValidDouble"></a>submitValidDouble</td>
<td>0.083</td></tr></table></section><section>
<h3><a name="MediaTypeTest"></a>MediaTypeTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.defaultMediaType"></a>defaultMediaType</td>
<td>0.173</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.mediatype.MediaTypeTest.customMediaType"></a>customMediaType</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="CsrfVerifyImplicitConfigTest"></a>CsrfVerifyImplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.296</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.1</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.084</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyImplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.063</td></tr></table></section><section>
<h3><a name="BindingTypesTest"></a>BindingTypesTest</h3><a name="jakarta.mvc.tck.tests.binding.types.BindingTypesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithHeaderParam"></a>bindingWithHeaderParam</td>
<td>0.163</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithFormParam"></a>bindingWithFormParam</td>
<td>0.043</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithCookieParam"></a>bindingWithCookieParam</td>
<td>0.041</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithQueryParam"></a>bindingWithQueryParam</td>
<td>0.052</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithMatrixParam"></a>bindingWithMatrixParam</td>
<td>0.05</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.types.BindingTypesTest.bindingWithPathParam"></a>bindingWithPathParam</td>
<td>0.031</td></tr></table></section><section>
<h3><a name="ViewEngineAlgorithmTest"></a>ViewEngineAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.relativeViewPath"></a>relativeViewPath</td>
<td>3.137</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.absoluteViewPath"></a>absoluteViewPath</td>
<td>0.056</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.overwriteBuiltinEngine"></a>overwriteBuiltinEngine</td>
<td>0.102</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.viewengine.algorithm.ViewEngineAlgorithmTest.priorityOrderingCustomEngines"></a>priorityOrderingCustomEngines</td>
<td>0.074</td></tr></table></section><section>
<h3><a name="InjectProxyTest"></a>InjectProxyTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.proxy.InjectProxyTest.injectProxyIfRequired"></a>injectProxyIfRequired</td>
<td>0.254</td></tr></table></section><section>
<h3><a name="I18nAccessTest"></a>I18nAccessTest</h3><a name="jakarta.mvc.tck.tests.i18n.access.I18nAccessTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromView"></a>accessLocaleFromView</td>
<td>0.162</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromController"></a>accessLocaleFromController</td>
<td>0.027</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.access.I18nAccessTest.accessLocaleFromViewEngine"></a>accessLocaleFromViewEngine</td>
<td>0.03</td></tr></table></section><section>
<h3><a name="BindingBaseTest"></a>BindingBaseTest</h3><a name="jakarta.mvc.tck.tests.binding.base.BindingBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidationError"></a>submitValidationError</td>
<td>0.644</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitBindingError"></a>submitBindingError</td>
<td>0.082</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.base.BindingBaseTest.submitValidValue"></a>submitValidValue</td>
<td>0.114</td></tr></table></section><section>
<h3><a name="UriBuildingTest"></a>UriBuildingTest</h3><a name="jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapPathParam"></a>mapPathParam</td>
<td>0.19</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.simpleUriViaEl"></a>simpleUriViaEl</td>
<td>0.035</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapQueryParam"></a>mapQueryParam</td>
<td>0.045</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingQueryParam"></a>encodingQueryParam</td>
<td>0.058</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.mapMatrixParam"></a>mapMatrixParam</td>
<td>0.031</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingMatrixParam"></a>encodingMatrixParam</td>
<td>0.033</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.supportsUriRef"></a>supportsUriRef</td>
<td>0.024</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.uri.UriBuildingTest.encodingPathParam"></a>encodingPathParam</td>
<td>0.03</td></tr></table></section><section>
<h3><a name="MvcAppAnnotationTest"></a>MvcAppAnnotationTest</h3><a name="jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.app.MvcAppAnnotationTest.testUrlSpaceViaAnnotation"></a>testUrlSpaceViaAnnotation</td>
<td>0.201</td></tr></table></section><section>
<h3><a name="MvcContextTest"></a>MvcContextTest</h3><a name="jakarta.mvc.tck.tests.application.context.MvcContextTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextInjected"></a>testMvcContextInjected</td>
<td>0.174</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextScope"></a>testMvcContextScope</td>
<td>0.025</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessInformation"></a>testMvcContextAccessInformation</td>
<td>0.026</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.application.context.MvcContextTest.testMvcContextAccessViaEl"></a>testMvcContextAccessViaEl</td>
<td>0.025</td></tr></table></section><section>
<h3><a name="I18nStandardTest"></a>I18nStandardTest</h3><a name="jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.multipleLocalesInAcceptLanguageHeader"></a>multipleLocalesInAcceptLanguageHeader</td>
<td>0.218</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.missingAcceptLanguageHeader"></a>missingAcceptLanguageHeader</td>
<td>0.046</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.standard.I18nStandardTest.singleLocaleInAcceptLanguageHeader"></a>singleLocaleInAcceptLanguageHeader</td>
<td>0.048</td></tr></table></section><section>
<h3><a name="CsrfVerifyOffConfigTest"></a>CsrfVerifyOffConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.246</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.069</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.053</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyOffConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.057</td></tr></table></section><section>
<h3><a name="BindingFloatTest"></a>BindingFloatTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitEmptyFloat"></a>submitEmptyFloat</td>
<td>0.268</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingFloatTest.submitValidFloat"></a>submitValidFloat</td>
<td>0.097</td></tr></table></section><section>
<h3><a name="ControllerAnnotationTest"></a>ControllerAnnotationTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerClass"></a>controllerClass</td>
<td>0.222</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerHybrid"></a>controllerHybrid</td>
<td>0.065</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.annotation.ControllerAnnotationTest.controllerMethod"></a>controllerMethod</td>
<td>0.047</td></tr></table></section><section>
<h3><a name="CsrfCustomHeaderTest"></a>CsrfCustomHeaderTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitValidCustomTokenViaHeader"></a>submitValidCustomTokenViaHeader</td>
<td>0.428</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.header.CsrfCustomHeaderTest.submitInvalidCustomTokenViaHeader"></a>submitInvalidCustomTokenViaHeader</td>
<td>0.089</td></tr></table></section><section>
<h3><a name="ControllerLifecycleTest"></a>ControllerLifecycleTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.lifecycle.ControllerLifecycleTest.controllerRequestScope"></a>controllerRequestScope</td>
<td>0.208</td></tr></table></section><section>
<h3><a name="CsrfCustomMapperTest"></a>CsrfCustomMapperTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.exception.CsrfCustomMapperTest.customExceptionMapper"></a>customExceptionMapper</td>
<td>0.128</td></tr></table></section><section>
<h3><a name="I18nAlgorithmTest"></a>I18nAlgorithmTest</h3><a name="jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.chainStopsForNonNullResult"></a>chainStopsForNonNullResult</td>
<td>0.176</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.highestPrioExecutedFirst"></a>highestPrioExecutedFirst</td>
<td>0.042</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.i18n.algorithm.I18nAlgorithmTest.continueChainForNullResult"></a>continueChainForNullResult</td>
<td>0.024</td></tr></table></section><section>
<h3><a name="CsrfBaseTest"></a>CsrfBaseTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.tokenIsProvidedViaElAndResponseHeader"></a>tokenIsProvidedViaElAndResponseHeader</td>
<td>0.139</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.canInjectTokenIntoHiddenField"></a>canInjectTokenIntoHiddenField</td>
<td>0.025</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaContext"></a>csrfInstanceViaContext</td>
<td>0.027</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.base.CsrfBaseTest.csrfInstanceViaEL"></a>csrfInstanceViaEL</td>
<td>0.023</td></tr></table></section><section>
<h3><a name="CsrfVerifyDefaultConfigTest"></a>CsrfVerifyDefaultConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.212</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.1</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.055</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyDefaultConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.053</td></tr></table></section><section>
<h3><a name="CdiControllerTest"></a>CdiControllerTest</h3><a name="jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.controllerCdiInjection"></a>controllerCdiInjection</td>
<td>0.14</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.instances.cdi.CdiControllerTest.hybridCdiInjection"></a>hybridCdiInjection</td>
<td>0.045</td></tr></table></section><section>
<h3><a name="CsrfVerifyExplicitConfigTest"></a>CsrfVerifyExplicitConfigTest</h3><a name="jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndInvalidToken"></a>submitFormWithAnnotationAndInvalidToken</td>
<td>0.161</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithAnnotationAndValidToken"></a>submitFormWithAnnotationAndValidToken</td>
<td>0.075</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndInvalidToken"></a>submitFormWithoutAnnotationAndInvalidToken</td>
<td>0.043</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.security.csrf.verify.CsrfVerifyExplicitConfigTest.submitFormWithoutAnnotationAndValidToken"></a>submitFormWithoutAnnotationAndValidToken</td>
<td>0.046</td></tr></table></section><section>
<h3><a name="InjectParamsTest"></a>InjectParamsTest</h3><a name="jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectQueryParam"></a>injectQueryParam</td>
<td>0.209</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectHeaderParam"></a>injectHeaderParam</td>
<td>0.056</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectFieldParam"></a>injectFieldParam</td>
<td>0.036</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPropertyParam"></a>injectPropertyParam</td>
<td>0.047</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.controller.inject.InjectParamsTest.injectPathParam"></a>injectPathParam</td>
<td>0.039</td></tr></table></section><section>
<h3><a name="BindingBigIntegerTest"></a>BindingBigIntegerTest</h3><a name="jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitEmptyBigInteger"></a>submitEmptyBigInteger</td>
<td>0.284</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.binding.numeric.BindingBigIntegerTest.submitValidBigInteger"></a>submitValidBigInteger</td>
<td>0.085</td></tr></table></section><section>
<h3><a name="BuiltinEngineModelTest"></a>BuiltinEngineModelTest</h3><a name="jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelJsp"></a>cdiModelJsp</td>
<td>0.264</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsFacelets"></a>mvcModelsFacelets</td>
<td>0.053</td></tr>
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.cdiModelFacelets"></a>cdiModelFacelets</td>
<td>0.053</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.models.BuiltinEngineModelTest.mvcModelsJsp"></a>mvcModelsJsp</td>
<td>0.044</td></tr></table></section><section>
<h3><a name="ResponseFeaturesTest"></a>ResponseFeaturesTest</h3><a name="jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest"></a>
<table border="1" class="bodyTable">
<tr class="a">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingHeaders"></a>responseAllowsSettingHeaders</td>
<td>0.182</td></tr>
<tr class="b">
<td><figure><img src="images/icon_success_sml.gif" alt="" /></figure></td>
<td><a name="TC_jakarta.mvc.tck.tests.mvc.response.ResponseFeaturesTest.responseAllowsSettingCacheControl"></a>responseAllowsSettingCacheControl</td>
<td>0.034</td></tr></table></section><br /></section>
      </div>
    </div>
    <div class="clear">
      <hr/>
    </div>
    <div id="footer">
      <div class="xright">
        Copyright &#169;      2017&#x2013;2020<a href="https://www.eclipse.org">Eclipse Foundation</a>.
.      </div>
      <div class="clear">
        <hr/>
      </div>
    </div>
  </body>
</html>
