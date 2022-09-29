package com.TssCommerce.TssInvoice.Testing;

import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;

import static com.itextpdf.layout.border.Border.*;
import static com.itextpdf.layout.property.TextAlignment.*;

public class GeneratedPdf {
   public static  void main(String[] args) throws FileNotFoundException {
       ///the path for the pdf
        String path ="invoice.pdf";
        /// the pdf writer will generate a pdf in the path
        PdfWriter pdfWriter = new PdfWriter(path);
        ///Pdf Document -> main entry point to manipulate pdf
       PdfDocument pdfDocument = new PdfDocument(pdfWriter);
       pdfDocument.setDefaultPageSize(PageSize.A4);

       /// create a document to manipulate the pdf doc
       Document document = new Document(pdfDocument);

       //define the size of the two cols at the top
       float twocol = 285f;
       float twocol150 = twocol +150f;
       float threecol = 190f;
       Paragraph onesp = new Paragraph("\n");

       //we need to define the col width in an array
       float twocolumnWidth[] = {twocol150,twocol};
       float fullWidth[]={threecol*3};

       //Create the table
       Table table = new Table(twocolumnWidth);

       ///adding a cell (col) to the table that we defined
       //in the versions sup to 7.04 we don't have add(string)
       table.addCell(new Cell().add("INVOICE").setFontSize(20f).setBorder(NO_BORDER).setBold());

       //the 2nd cell has 4 elments so we create a nested table with 2x2
       Table nestedTable = new Table(new float[]{twocol/2,twocol/2});
       nestedTable.addCell(getHeaderTextCell("Invoice No."));
       nestedTable.addCell(getHeaderCellValue("RK35678"));
       nestedTable.addCell(getHeaderTextCell("Invoice Date"));
       nestedTable.addCell(getHeaderCellValue("09/13/2022"));
       //add the nested table in a cell
       table.addCell(new Cell().add(nestedTable).setBorder(NO_BORDER));
       //after defining the table width array of 2 ; if we add third cell it returns the the line <<under invoice>>
       //Adding the line === adding table with border
       //Create a custom border
       Border grayBorder = new SolidBorder(Color.GRAY,2f);
       Table divider = new Table(fullWidth);
       divider.setBorder(grayBorder);


       //Add the table to the doc
       document.add(table);
       document.add(onesp);
       document.add(divider);
       document.add(onesp);

       //Create the mid information table of two

       Table twoColTable = new Table(twocolumnWidth);
       twoColTable.addCell(getBillingandShippingCell("Billing Information"));
       twoColTable.addCell(getBillingandShippingCell("Shipping Information"));
       document.add(twoColTable.setMarginBottom(12f));

       Table twoColTable2 = new Table(twocolumnWidth);
       twoColTable2.addCell(getCell10left("Company",true));
       twoColTable2.addCell(getCell10left("Name",true));
       twoColTable2.addCell(getCell10left("Coding Error",false));
       twoColTable2.addCell(getCell10left("Coding",false));
       document.add(twoColTable2);

       Table twoColTable3 = new Table(twocolumnWidth);
       twoColTable3.addCell(getCell10left("Name",true));
       twoColTable3.addCell(getCell10left("Address",true));
       twoColTable3.addCell(getCell10left("Arlyn cccc",false));
       twoColTable3.addCell(getCell10left("987 road dunno,\n in the country of freaking no",false));
       document.add(twoColTable3);


       document.close();

    }

    static Cell getHeaderTextCell(String textValue)
    {
        return new Cell().add(textValue).setBold().setBorder(NO_BORDER).setTextAlignment(RIGHT);
    }

    static Cell getHeaderCellValue(String textValue)
    {
        return new Cell().add(textValue).setBorder(NO_BORDER).setTextAlignment(LEFT);

    }
    static Cell getBillingandShippingCell(String textValue)
    {
        return new Cell().add(textValue).setBold().setFontSize(12f).setBorder(NO_BORDER).setTextAlignment(LEFT);

    }
    static Cell getCell10left(String textValue,Boolean isBold)
    {
        Cell myCell = new Cell().add(textValue).setFontSize(10f).setBorder(NO_BORDER).setTextAlignment(LEFT);
        return isBold ? myCell.setBold():myCell;
    }
}
