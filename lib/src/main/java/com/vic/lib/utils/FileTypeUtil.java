package com.vic.lib.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FileTypeUtil {
    public static final HashMap<String, String> mFileTypes = new HashMap<String, String>();
    static {
        // images
        mFileTypes.put("FFD8FFE", "jpg");
        mFileTypes.put("89504E47", "png");
        mFileTypes.put("47494638", "gif");
        mFileTypes.put("49492A00", "tif");
        mFileTypes.put("424D", "bmp");
        mFileTypes.put("41433130", "dwg");
        mFileTypes.put("38425053", "psd");
        mFileTypes.put("7B5C727466", "rtf");
        mFileTypes.put("3C3F786D6C", "xml");
        mFileTypes.put("68746D6C3E", "html");
        mFileTypes.put("44656C69766572792D646174653A", "eml");
        mFileTypes.put("D0CF11E0", "doc");
        mFileTypes.put("5374616E64617264204A", "mdb");
        mFileTypes.put("252150532D41646F6265", "ps");
        mFileTypes.put("255044462D312E", "pdf");
        mFileTypes.put("504B0304", "docx");
        mFileTypes.put("52617221", "rar");
        mFileTypes.put("57415645", "wav");
        mFileTypes.put("41564920", "avi");
        mFileTypes.put("2E524D46", "rm");
        mFileTypes.put("000001BA", "mpg");
        mFileTypes.put("000001B3", "mpg");
        mFileTypes.put("6D6F6F76", "mov");
        mFileTypes.put("3026B2758E66CF11", "asf");
        mFileTypes.put("4D546864", "mid");
        mFileTypes.put("1F8B08", "gz");
        mFileTypes.put("4D5A9000", "exe/dll");
        mFileTypes.put("75736167", "txt");
    }

   public static String getFileType(String filePath) {
        FileInputStream is = null;
        String value = null;
        try {
            is = new FileInputStream(filePath);
            byte[] b = new byte[15];

            is.read(b, 0, b.length);
            value = bytesToHexString(b);
        } catch (Exception e) {
        } finally {
            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
        }
        return switchType(value);
    }

    public final static String switchType(String header)
    {
        if(header!=null) {
            Iterator<Map.Entry<String, String>> entryiterator = mFileTypes.entrySet().iterator();
            while (entryiterator.hasNext()) {
                Map.Entry<String, String> entry = entryiterator.next();
                String headerKey = entry.getKey();
                if (header.toUpperCase().startsWith(headerKey)) {
                    return entry.getValue();
                }
            }
        }
        return "";
    }


    private static String bytesToHexString(byte[] src) {
        StringBuilder builder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        String hv;
        for (int i = 0; i < src.length; i++) {
            hv = Integer.toHexString(src[i] & 0xFF).toUpperCase();
            if (hv.length() < 2) {
                builder.append(0);
            }
            builder.append(hv);
        }
        return builder.toString();
    }
}