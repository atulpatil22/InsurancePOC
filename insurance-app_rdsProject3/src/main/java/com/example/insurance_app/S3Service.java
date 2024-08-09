package com.example.insurance_app;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts.FontName;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

@Service
public class S3Service {
    @Value("${application.bucket.name}")
    private String bucketName;

    public byte[] generatePdf(Map<String, String> data) throws IOException {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            PdfWriter writer = new PdfWriter(baos);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);
            //PdfFont font = PdfFontFactory.createFont(Standard14Fonts.FontName.HELVETICA_BOLD);
            FontName font_name_3v= Standard14Fonts.getMappedFontName("HELVETICA_BOLD");
            //   PDFont pdfFont=  new PDType1Font(font_name_3v.HELVETICA_BOLD);
            PdfFont font = PdfFontFactory.createFont(String.valueOf(font_name_3v.HELVETICA_BOLD));
            for (Map.Entry<String, String> entry : data.entrySet()) {
                // PDFont pdfFont = new PDType1Font(font_name_3v.HELVETICA_BOLD);
                document.add(new Paragraph(new Text(entry.getKey() + ": " + entry.getValue()).setFont(font)));
            }
            document.close();
            return baos.toByteArray();
        }
    }
}
