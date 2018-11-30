package com.mcrwayfun;

import com.mcrwayfun.core.JobConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.office.OfficeException;

import java.io.*;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/29
 */
public class TestConverter {

    private static final String DESC = "src/main/resources/desc";

    public static void main(String[] args) {
        testFile2Pdf();
        // testInputStream2Pdf();
    }

    public static void testInputStream2Pdf() {
        JobConverter jobConverter = new JobConverter(null,"F:\\download\\workingDir");
        String source = "src/main/resources/source/1.png";
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(source));
            String outPutPath = DESC + File.separator + System.currentTimeMillis() + ".pdf";
            OutputStream ous = new FileOutputStream(new File(outPutPath));
            jobConverter.InputStream2Pdf(fileInputStream, DefaultDocumentFormatRegistry.PNG, ous);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }

    public static void testFile2Pdf() {
        JobConverter jobConverter = new JobConverter(null,null);
        String source = "src/main/resources/source/1.png";
        try {
            String outPutPath = DESC + File.separator + System.currentTimeMillis() + ".pdf";
            jobConverter.File2Pdf(source, outPutPath);
        } catch (OfficeException e) {
            e.printStackTrace();
        }
    }
}
