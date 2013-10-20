package fi.example.velocitypdfexample.pdf;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.junit.Before;
import org.junit.Test;

public class PdfContentTest {
	private String pdfText;
	
	@Before
	public void stripPdf() throws IOException {
		URL url = new URL("https://velocitypdfexample.herokuapp.com/index.pdf"); 
		PDDocument pdfDocument = PDDocument.load(url);
	  pdfText = getPdfTextFromUrl(pdfDocument);
	}
	
	@Test
	public void mainPdfTextIsCorrect() {
		assertTrue(pdfText.contains("heading value"));
		assertTrue(pdfText.contains("What is Lorem Ipsum?"));
		assertTrue(pdfText.contains("Where does it come from?"));
	}
	
	private String getPdfTextFromUrl(PDDocument document) throws IOException {
		try {
	  	 return new PDFTextStripper().getText(document);
    } finally {
	      document.close();
	   }
	}
}
