package org.example;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.spire.pdf.PdfDocument;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageResize {
    public static void main(String[] args) {
        System.out.println("File Reading");
        try {
            File file = new File("D://Image//RDPD.jpeg");
            BufferedImage image = ImageIO.read(file);
//            ImageIO.write(image , "BMP", new File("D://Image//RDPD3.BMP"));    //Converting File type.
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}



/*

package org.example;

        import com.spire.pdf.PdfDocument;

        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;
        import java.util.Arrays;
        import javax.imageio.ImageIO;

public class App
{
    static PdfDocument pdfDocument = new PdfDocument();
    public static void main( String[] args )
    {
        try {
            File file = new File("D://Image//Outliers.jpeg");
            System.out.println(file.getName());
            BufferedImage image = ImageIO.read(file);

            String type = getExtension(file.getName());
            convertToTiff(type);
            if (type.equals("pdf")){
                pdfDocument.loadFromFile("D://Image//java.pdf");
                pdfDocument.saveToTiff("D://Image//javaTiff.tiff");
            } else if ((type.equals("jpeg") || type.equals("png") || type.equals("jpeg"))) {
                System.out.println("File type is");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

    private static void convertToTiff(String type) {
        if (type.equals("pdf")){
            pdfDocument.loadFromFile("D://Image//java - Copy.pdf");
            pdfDocument.saveToTiff("D://Image//javaTiff2.tiff");
        } else if (type.equals("jpeg, png, gif")) {
            System.out.println("File type is");
        }
    }

    private static String getExtension(String fileName) {
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        System.out.println("File Extension " +extension);
        return extension;
    }

}*/

/*package org.example;

        import com.itextpdf.text.DocumentException;
        import com.itextpdf.text.pdf.PdfReader;
        import com.itextpdf.text.pdf.PdfStamper;
        import com.spire.pdf.PdfDocument;
        import java.awt.image.BufferedImage;
        import java.io.*;
        import javax.imageio.ImageIO;


public class App
{
    static PdfDocument pdfDocument = new PdfDocument();
    static File file;
    static BufferedImage image;

    private static void sizeReduce(String extensionType) throws IOException, DocumentException {
        if (extensionType.equals("pdf"))
        {
            PdfReader reader = new PdfReader(new FileInputStream(file));
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("D://files//EMP1.pdf"));
            int total = reader.getNumberOfPages() + 1;
            for ( int i=1; i<total; i++) {
                reader.setPageContent(i + 1, reader.getPageContent(i + 1));
            }
            stamper.setFullCompression();
            stamper.close();
        }
        else if ((extensionType.equals("jpeg")) || (extensionType.equals("JPEG")) || (extensionType.equals("png")) || (extensionType.equals("PNG"))
                || (extensionType.equals("gif")) || (extensionType.equals("GIF")) || (extensionType.equals("jpg")) || (extensionType.equals("JPG")))
        {
            ImageIO.write(image , "tiff", new File("D://files//Normal_people.tiff"));
            System.out.println("File conversion completed....");
        }
    }

    private static void convertToTiff(String type) throws IOException, DocumentException {
        System.out.println("File Type is "+type);
        if (type.equals("pdf"))
        {
            pdfDocument.loadFromFile("D://files//java.pdf");

            *//*pdfDocument.getFileInfo().setIncrementalUpdate(false); //Disable incremental update
            pdfDocument.setCompressionLevel(PdfCompressionLevel.Best); //Set the compression level to best
            for (int i = 0; i < pdfDocument.getPages().getCount(); i++) {
                PdfPageBase page = pdfDocument.getPages().get(i);
                PdfImageInfo[] images = page.getImagesInfo();
                if (images != null && images.length > 0) {
                    for (int j = 0; j < images.length; j++) {
                        PdfImageInfo image = images[j];
                        PdfBitmap bp = new PdfBitmap(image.getImage());
                        bp.setQuality(1);
                        page.replaceImage(j, bp);
                    }
                }
            }
            pdfDocument.saveToFile("D://files//EMP.pdf");
            pdfDocument.close();*//*
            pdfDocument.saveToTiff("D://files//java2.tiff");
        }
        else if ((type.equals("jpeg")) || (type.equals("JPEG")) || (type.equals("png")) || (type.equals("PNG"))
                || (type.equals("gif")) || (type.equals("GIF")) || (type.equals("jpg")) || (type.equals("JPG")))
        {
            ImageIO.write(image , "tiff", new File("D://files//Normal_people.tiff"));
            System.out.println("File conversion completed....");
        }
    }

    private static String getExtension(String fileName) {
        String extension = "";
        int index = fileName.lastIndexOf('.');
        if (index > 0) {
            extension = fileName.substring(index + 1);
        }
        return extension;
    }

    public static void main( String[] args )
    {
        System.out.println("Converter....");

        try {
            file = new File("D://files//java.pdf");
            image = ImageIO.read(file); //
            String extensionType = getExtension(file.getName());
            if ((extensionType.equals("jpeg")) || (extensionType.equals("JPEG")) || (extensionType.equals("png")) || (extensionType.equals("PNG"))
                    || (extensionType.equals("gif")) || (extensionType.equals("GIF")) || (extensionType.equals("jpg")) || (extensionType.equals("JPG"))
                    || (extensionType.equals("pdf")) || (extensionType.equals("PDF")))
            {
                sizeReduce(extensionType);
                convertToTiff(extensionType);
            }
            else {
                System.out.println("File Format now supported...");
            }

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}*/


