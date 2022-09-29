package com.TssCommerce.TssInvoice.Testing;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.HorizontalAlignment;
import com.itextpdf.layout.property.TextAlignment;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import static com.itextpdf.kernel.color.Color.*;
import static com.itextpdf.layout.border.Border.NO_BORDER;
import static com.itextpdf.layout.border.Border.SOLID;
import static com.itextpdf.layout.property.TextAlignment.*;
import static com.itextpdf.layout.property.TextAlignment.LEFT;
import static com.itextpdf.layout.property.TextAlignment.RIGHT;

public class GeneratedPdf2 {
    public static void main(String[] args) throws FileNotFoundException, MalformedURLException {
        ///the path for the pdf
        String path = "invoice.pdf";
        /// the pdf writer will generate a pdf in the path
        PdfWriter pdfWriter = new PdfWriter(path);
        ///Pdf Document -> main entry point to manipulate pdf
        PdfDocument pdfDocument = new PdfDocument(pdfWriter);
        pdfDocument.setDefaultPageSize(PageSize.A4);

        /// create a document to manipulate the pdf doc
        Document document = new Document(pdfDocument);

        //define the size of the two cols at the top
        float rightColumn = 285f;
        float leftColumn = rightColumn + 150f;
        float thirdPage = 190f;
        float fullPage = 570f;
        Paragraph lineJump = new Paragraph("\n");
        String imageFile = "C:/Users/GHOST/Desktop/TSS-Commerce/TssInvoice/src/main/resources/static/tssLogo.jpg";
        Border grayBorderThick = new SolidBorder(GRAY,2f);
        Border grayBorderSlim = new SolidBorder(GRAY,1f);
        Color tssLogo = new DeviceRgb(9,63,110);;

        ///defining the first header !
        float twoColumnHeaderwidth[]={leftColumn,rightColumn};
        float leftColumnwidth[]={leftColumn};
        float rightColumnwidth[]={rightColumn/2};
        float twoColumnSplitWidth[]={fullPage/2,fullPage/2};
        float productsColumnSplitWidth[]={fullPage/2,fullPage/10,fullPage/5,fullPage/5};
        float ballanceCollumnSplitTotal[]={(float) (fullPage*0.6),(float) (fullPage*0.4)};
        float ballanceCollumnSplitRight[]={fullPage/5,fullPage/5};
        float total=0;

        Table tableHeader = new Table(twoColumnHeaderwidth);
        tableHeader.addCell(new Cell()
                .add("INVOICE")
                .setFontSize(30f)
                .setBold()
                .setBorder(NO_BORDER)
                .setTextAlignment(LEFT)
                .setPaddingTop(25f)
                .setPaddingLeft(5f)
                .setFontColor(GRAY)
                .setBorderBottom(grayBorderThick));
        // Creating an ImageData object
        ImageData data = ImageDataFactory.create(imageFile);
        // Creating an Image object
        Image img = new Image(data);
        //Set the image
        tableHeader.addCell(new Cell()
                .add(img
                                .scaleAbsolute(150f,80f)
                                .setHorizontalAlignment(HorizontalAlignment.RIGHT))
                .setBorder(NO_BORDER)
                .setBorderBottom(grayBorderThick));

        document.add(tableHeader);
        document.add(lineJump);
        //Setting The company inofrmation table
        Table tableCompanyAndInvoiceInformation = new Table(twoColumnHeaderwidth);
        //Setting up the left nested table
        Table nestedLefttableCompanyAndInvoiceInformation = new Table(leftColumnwidth);
        nestedLefttableCompanyAndInvoiceInformation.addCell(new Cell().add("<Your Company Name>").setFontSize(11f).setBorder(NO_BORDER));
        nestedLefttableCompanyAndInvoiceInformation.addCell(new Cell().add("<123 Street Address>").setFontSize(11f).setBorder(NO_BORDER));
        nestedLefttableCompanyAndInvoiceInformation.addCell(new Cell().add("<City, State, Zip/Post Code>").setFontSize(11f).setBorder(NO_BORDER));
        nestedLefttableCompanyAndInvoiceInformation.addCell(new Cell().add("<Phone Number, Email>").setFontSize(11f).setBorder(NO_BORDER));
        tableCompanyAndInvoiceInformation.addCell(new Cell().add(nestedLefttableCompanyAndInvoiceInformation).setBorder(NO_BORDER));
        //Setting up the right nested table
        Table nestedRighttableCompanyAndInvoiceInformation = new Table(rightColumnwidth);
        nestedRighttableCompanyAndInvoiceInformation.addCell(new Cell().add("DATE").setFontSize(11f).setBorder(NO_BORDER).setTextAlignment(CENTER));
        nestedRighttableCompanyAndInvoiceInformation.addCell(new Cell().add("<Date>").setFontSize(11f).setBorder(NO_BORDER).setTextAlignment(CENTER));
        nestedRighttableCompanyAndInvoiceInformation.addCell(new Cell().add("INVOICE NO.").setFontSize(11f).setBorder(NO_BORDER).setTextAlignment(CENTER));
        nestedRighttableCompanyAndInvoiceInformation.addCell(new Cell().add("<Invoice no.>").setFontSize(11f).setBorder(NO_BORDER).setTextAlignment(CENTER));
        tableCompanyAndInvoiceInformation.addCell(new Cell().add(nestedRighttableCompanyAndInvoiceInformation).setPaddingLeft(30f).setBorder(NO_BORDER));
        document.add(tableCompanyAndInvoiceInformation);
        document.add(lineJump);

        //Setting BuillTo and shippment table
        Table tableBillAndShippment = new Table(twoColumnSplitWidth);
        tableBillAndShippment.addCell(new Cell().add("BILL TO").setFontSize(11f).setBold().setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        tableBillAndShippment.addCell(new Cell().add("SHIP TO").setFontSize(11f).setBold().setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        tableBillAndShippment.addCell(new Cell().add("<Contact Name>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Name / Dept>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Client Company Name>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Client Company Name>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Address>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Address>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Phone>").setFontSize(11f).setBorder(NO_BORDER));
        tableBillAndShippment.addCell(new Cell().add("<Phone>").setFontSize(11f).setBorder(NO_BORDER));
        document.add(tableBillAndShippment);
        document.add(lineJump);

        ///Add the product table
        Table productsTable = new Table(productsColumnSplitWidth);
        productsTable.addCell(new Cell().add("Description").setFontSize(11f).setBold().setFontColor(WHITE).setBackgroundColor(tssLogo).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        productsTable.addCell(new Cell().add("Quantity").setFontSize(11f).setBold().setFontColor(WHITE).setBackgroundColor(tssLogo).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        productsTable.addCell(new Cell().add("unit Price").setFontSize(11f).setBold().setFontColor(WHITE).setBackgroundColor(tssLogo).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        productsTable.addCell(new Cell().add("Total").setFontSize(11f).setBold().setFontColor(WHITE).setBackgroundColor(tssLogo).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        //testing with static imputs
        String discriptionsList[]={"product1","product2","product3","product4"};
        Integer QteList[]={1,1,2,4};
        float UnitPriceList[]={100f,150f,540f,30f};
        for(int i = 0; i<4; i++){
            productsTable.addCell(new Cell().add(discriptionsList[i]).setFontSize(11f));
            productsTable.addCell(new Cell().add(String.valueOf(QteList[i])).setFontSize(11f));
            productsTable.addCell(new Cell().add(String.valueOf(UnitPriceList[i])).setFontSize(11f));
            productsTable.addCell(new Cell().add(String.valueOf(UnitPriceList[i]*QteList[i])).setFontSize(11f));
            total+=UnitPriceList[i]*QteList[i];
        }
        document.add(productsTable);

        ///Add the Balance
        float totalTax= (float) (total*0.07);
        float shipping = 8f;
        float discount = 0;

        Table BalanceTableTotal = new Table(ballanceCollumnSplitTotal);
        Table nestedBalanceTable = new Table(ballanceCollumnSplitRight);
        nestedBalanceTable.addCell(new Cell().add("SUBTOTAL").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add(String.valueOf(total)).setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        nestedBalanceTable.addCell(new Cell().add("DISCOUNT").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add(String.valueOf(discount)).setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        nestedBalanceTable.addCell(new Cell().add("TAXRATE").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add("7%").setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        nestedBalanceTable.addCell(new Cell().add("TOTAL TAX").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add(String.valueOf(totalTax)).setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        nestedBalanceTable.addCell(new Cell().add("SHIPPING").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add(String.valueOf(shipping)).setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        nestedBalanceTable.addCell(new Cell().add("BALANCE DUE").setFontSize(11f).setBorder(NO_BORDER));
        nestedBalanceTable.addCell(new Cell().add(String.valueOf(total+totalTax+shipping-discount)+" DT").setFontSize(11f).setBorder(NO_BORDER).setBorderBottom(grayBorderSlim));
        BalanceTableTotal.addCell(new Cell().add("").setBorder(NO_BORDER));
        BalanceTableTotal.addCell(new Cell().add(nestedBalanceTable).setBorder(NO_BORDER));
        document.add(BalanceTableTotal);



        document.close();
    }
}
