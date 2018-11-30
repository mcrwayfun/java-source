package com.mcrwayfun.core;

import org.apache.commons.lang3.StringUtils;
import org.jodconverter.DocumentConverter;
import org.jodconverter.LocalConverter;
import org.jodconverter.document.DefaultDocumentFormatRegistry;
import org.jodconverter.document.DocumentFormat;
import org.jodconverter.office.LocalOfficeManager;
import org.jodconverter.office.OfficeException;
import org.jodconverter.office.OfficeManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * @author mcrwayfun
 * @version 1.0
 * @description
 * @date Created in 2018/11/29
 */
public class JobConverter {

    public static final Logger log = LoggerFactory.getLogger(JobConverter.class);

    private OfficeManager officeManager;

    private DocumentConverter converter;

    /**
     * 构造函数
     *
     * @param officeHome libreoffice安装目录，若使用默认安装则传空
     */
    public JobConverter(String officeHome, String workingDir) {
        if (officeHome == null)
            officeHome = "";
        if(workingDir == null)
            workingDir = "";

        this.officeManager = LocalOfficeManager.builder()
                .officeHome(officeHome)
                .workingDir(workingDir)
                .build();
        this.converter = LocalConverter.make(officeManager);
    }


    public void InputStream2Pdf(InputStream ins, DocumentFormat insFormat, OutputStream ous) throws OfficeException {

        try {
            officeManager.start();
            converter
                    .convert(ins)
                    .as(insFormat)
                    .to(ous)
                    .as(DefaultDocumentFormatRegistry.PDF)
                    .execute();
        } catch (OfficeException e) {
            throw e;
        } finally {
            officeManager.stop();
        }
    }

    public void File2Pdf(String source, String desc) throws OfficeException {
        try {
            File sourceFile = new File(source);
            File descFile = new File(desc);
            officeManager.start();
            converter
                    .convert(sourceFile)
                    .to(descFile).execute();
        } catch (OfficeException e) {
            throw e;
        } finally {
            officeManager.stop();
        }
    }
}
