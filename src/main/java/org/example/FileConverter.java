package org.example;

import com.aspose.imaging.ColorPaletteHelper;
import com.aspose.imaging.Image;
import com.aspose.imaging.fileformats.tiff.enums.TiffCompressions;
import com.aspose.imaging.fileformats.tiff.enums.TiffExpectedFormat;
import com.aspose.imaging.fileformats.tiff.enums.TiffPhotometrics;
import com.aspose.imaging.imageoptions.TiffOptions;
import com.itextpdf.text.DocumentException;
import com.spire.pdf.PdfDocument;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;



public class FileConverter
{
    static PdfDocument pdfDocument = new PdfDocument();
    static File file;
    static File outputPath;
    static BufferedImage image;
    static BufferedImage outputImage2;

    /*
    * Here we taking the input as TIFF and storing the output into Image.
    * and later changing the properties of the output and storing it into the specified location.
    * */
    private static void resizeTiffFile(File outputPath) {
        try (Image image1 = Image.load(String.valueOf(outputPath)))
        {
            // Create an instance of TiffOptions for the resultant image
            System.out.println("Image color is .." + image1.getPalette());
            TiffOptions outputSettings = new TiffOptions(TiffExpectedFormat.Default);
            // Set BitsPerSample, Compression, Photometric mode and palette
            outputSettings.setBitsPerSample(new int[] { 8 });
            outputSettings.setCompression(TiffCompressions.Lzw);
            outputSettings.setPhotometric(TiffPhotometrics.Palette);
            outputSettings.setPalette(ColorPaletteHelper.create8Bit());
            image1.save("D://files//Converted2.tiff", outputSettings);
        }
    }

    /*
    * Here we are taking the file extension to convert it to Tiff.
    * also check that the file extension matches the corresponding  file extension and then  convert it to Tiff.
    * Once the file extension matches and conversion is complete we storing the file path in the in outputPath.
    * and finally sending that path to the reducer to resize the file.
    * */
    private static void convertToTiff(String extensionType) throws IOException, DocumentException {
        System.out.println("File Type is "+extensionType);
        if (extensionType.equals("pdf"))
        {
            outputPath = new File("D://files//Converted.tiff");
            boolean isProtected =PdfDocument.isPasswordProtected(String.valueOf(file));
            if (isProtected){
                System.out.println("The document is password protected.");
            }
            else {
                pdfDocument.loadFromFile(String.valueOf(file));
                pdfDocument.saveToTiff(String.valueOf(outputPath));
                System.out.println("File conversion completed.... ");
                resizeTiffFile(outputPath);
            }
        }
        else if ((extensionType.equals("jpeg")) || (extensionType.equals("JPEG")) || (extensionType.equals("png")) || (extensionType.equals("PNG"))
                || (extensionType.equals("gif")) || (extensionType.equals("GIF")) || (extensionType.equals("jpg")) || (extensionType.equals("JPG")))
        {
            outputPath = new File("D://files//Converted.tiff");
            ImageIO.write(image , "tiff", outputPath);
            System.out.println("File conversion completed.... "+outputPath);
            resizeTiffFile(outputPath);
        }
    }

    /*
    * Here we are taking the file name as string input to find its extension.
    * */
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
            file = new File("D://files//Adesh.jpg");
            image = ImageIO.read(file); //
            String extensionType = getExtension(file.getName());
            if ((extensionType.equals("jpeg")) || (extensionType.equals("JPEG")) || (extensionType.equals("png")) || (extensionType.equals("PNG"))
            || (extensionType.equals("gif")) || (extensionType.equals("GIF")) || (extensionType.equals("jpg")) || (extensionType.equals("JPG"))
            || (extensionType.equals("pdf")) || (extensionType.equals("PDF")))
            {
                convertToTiff(extensionType);
            }
            else {
                System.out.println("File Format not supported...");
            }
        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}
