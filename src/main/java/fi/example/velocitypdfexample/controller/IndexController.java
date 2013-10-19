package fi.example.velocitypdfexample.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.w3c.dom.Document;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xml.sax.SAXException;

import com.lowagie.text.DocumentException;


@Controller
public class IndexController {

	@Autowired
	private VelocityEngine velocityEngine;
	
	@RequestMapping("/index.html")
	public String indexPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("title", "title value");
		model.addAttribute("heading", "heading value");
		model.addAttribute("greeting", "greeting value");
		return "index";
	}
	
	@RequestMapping("/index.pdf")
	public void indexPageAsPdf(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException, DocumentException {
    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocument(getDocument(), request.getRequestURL().toString());
    renderer.layout();
    OutputStream out = response.getOutputStream();
    renderer.createPDF(out);
	}
	
	private VelocityContext getVelocityContext() {
		VelocityContext context = new VelocityContext();
    context.put("title", "title value");
    context.put("heading", "heading value");
    context.put("greeting", "greeting value");
    return context;
	}
	
	private Document getDocument() {
		StringWriter w = new StringWriter();
    velocityEngine.mergeTemplate("index.vm", "UTF-8", getVelocityContext(), w );
		DocumentBuilder builder = null;
    try {
      builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    } catch (ParserConfigurationException e) {
      e.printStackTrace();
    }
    return parseDocument(builder, w);
	}
	
	private Document parseDocument(DocumentBuilder builder, StringWriter w) {
		try {
	    return builder.parse(new ByteArrayInputStream(w.toString().getBytes("UTF-8")));
    } catch (UnsupportedEncodingException e) {
	    e.printStackTrace();
    } catch (SAXException e) {
	    e.printStackTrace();
    } catch (IOException e) {
	    e.printStackTrace();
    }
		return builder.newDocument();
	}
}
