package com.vic.lib.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
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
            System.out.println("file header="+value);
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

    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    public static void copyFile(File srcFile, File destFile)throws IOException{
        if(!srcFile.exists()){
            throw new IllegalArgumentException("文件:"+srcFile+"不存在");
        }
        if(!srcFile.isFile()){
            throw new IllegalArgumentException(srcFile+"不是文件");
        }
        FileInputStream in = new FileInputStream(srcFile);
        FileOutputStream out = new FileOutputStream(destFile);
        byte[] buf = new byte[8*1024];
        int b ;
        int i = 0;
        String header =
        "0000001C667479706D7034320000000069736F6D617663316D703432000159B26D6F6F760000006C6D76686400000000D5B719C9D5B719C900000258000379000001000001000000000000000000000000010000000000000000000000000000000100000000000000000000000000004000000000000000000000000000000000000000000000000000000000000003";
        byte[] headerBytes = hexStringToByte(header);
        int read = in.read(buf, 0, 144);
        out.write(headerBytes,0,144);
        out.flush();
        while((b = in.read(buf,0,buf.length))!=-1){
            out.write(buf,0,b);
            if(i==0) {
                System.out.println(bytesToHexString(Arrays.copyOfRange(buf,0,144)));
                i++;
            }
            out.flush();//最好加上
        }

        System.out.println("--------------------------------------");
        in.close();
        out.close();
    }


    /**
     * byte数组中取int数值，本方法适用于(低位在前，高位在后)的顺序，和和intToBytes（）配套使用
     *
     * @param src
     *            byte数组
     * @param offset
     *            从数组的第offset位开始
     * @return int数值
     */
    public static int bytesToInt(byte[] src, int offset) {
        int value;
        value = (int) ((src[offset] & 0xFF)
                | ((src[offset+1] & 0xFF)<<8)
                | ((src[offset+2] & 0xFF)<<16)
                | ((src[offset+3] & 0xFF)<<24));
        return value;
    }
}