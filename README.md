velocitypdfexample
==================

This is a small project which only shows how to use Velocity, 
iText 2.0.8 and Flying Saucer to use the same page for making both 
html and pdf. There is also a small pdfbox test for testing pdf content.

Usage
------
git clone https://github.com/jelinden/velocitypdfexample.git<br/>
cd velocitypdfexample<br/>
mvn jetty:run

go to:<br/>
<a href="http://localhost:8080/velocitypdfexample/index.html">http://localhost:8080/velocitypdfexample/index.html</a><br/>
<a href="http://localhost:8080/velocitypdfexample/index.pdf">http://localhost:8080/velocitypdfexample/index.pdf</a>

Viewable at heroku
------------------
<a href="https://velocitypdfexample.herokuapp.com/index.html">https://velocitypdfexample.herokuapp.com/index.html</a><br/>
<a href="https://velocitypdfexample.herokuapp.com/index.pdf">https://velocitypdfexample.herokuapp.com/index.pdf</a>

Pdfbox test
-----------
<a href="https://github.com/jelinden/velocitypdfexample/blob/master/src/test/java/fi/example/velocitypdfexample/pdf/PdfContentTest.java">PdfContentTest</a>