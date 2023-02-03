package org.example;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.spire.pdf.PdfDocument;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class FileConverter
{
    static PdfDocument pdfDocument = new PdfDocument();
    static File file;
    static BufferedImage image;
    static  BufferedImage outputImage2;

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
            String outputImagePath2 = "D://files//Marksheet2.jpg";
            double percent = 0.5;
//            BufferedImage image = ImageIO.read(new File(outputImagePath2));
            resizeImage(image, outputImagePath2, percent);
        }
    }

    private static void resizeImage(BufferedImage image, String outputImagePath2, double percent) throws IOException {
        int scaledWidth = (int) (image.getWidth() * percent);
        int scaledHeight = (int) (image.getHeight() * percent);
        resize(image, outputImagePath2, scaledWidth, scaledHeight);
    }

    private static void resize(BufferedImage image, String outputImagePath2, int scaledWidth, int scaledHeight) throws IOException {
        BufferedImage outputImage = new BufferedImage(scaledWidth,
                scaledHeight, image.getType());
        // scales the input image to the output image
        Graphics2D g2d = outputImage.createGraphics();
        g2d.drawImage(image, 0, 0, scaledWidth, scaledHeight, null);
        g2d.dispose();
        // extracts extension of output file
        String formatName = outputImagePath2.substring(outputImagePath2.lastIndexOf(".") + 1);
        // writes to output file
        ImageIO.write(outputImage, formatName, new File(outputImagePath2));
        File newFile = new File(outputImagePath2);
        System.out.println("OutputImage "+newFile);
        outputImage2 = ImageIO.read(newFile);
    }


    private static void convertToTiff(String type) throws IOException, DocumentException {
        System.out.println("File Type is "+type);
        if (type.equals("pdf"))
        {
            pdfDocument.loadFromFile("D://files//java.pdf");
            pdfDocument.saveToTiff("D://files//java2.tiff");
            System.out.println("File conversion completed....");
        }
        else if ((type.equals("jpeg")) || (type.equals("JPEG")) || (type.equals("png")) || (type.equals("PNG"))
                || (type.equals("gif")) || (type.equals("GIF")) || (type.equals("jpg")) || (type.equals("JPG")))
        {
            ImageIO.write(outputImage2 , "tiff", new File("D://files//marks.tiff"));
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
            file = new File("D://files//Marksheet.jpg");
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
}
