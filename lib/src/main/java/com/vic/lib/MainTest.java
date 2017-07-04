package com.vic.lib;

import com.vic.lib.test.BaseTest;
import com.vic.lib.test.KotLin;
import com.vic.lib.test.StringReverse;
import com.vic.lib.utils.FileTypeUtil;

import java.io.File;

public class MainTest {

    public static void main(String[] args) {
        BaseTest test = new KotLin();
        test.doTest();
    }

    public void loopFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File tmpFile : files) {
                if (file.isDirectory()) {
                    loopFile(tmpFile);
                } else {
                    isPng(tmpFile);
                }
            }
        } else {
            isPng(file);
        }
    }

    public void isPng(File file) {
        String path = file.getAbsolutePath();
//        if(path.endsWith("png")){
        String fileType = FileTypeUtil.getFileType(path);
        if (null == fileType || !fileType.equalsIgnoreCase("png")) {
            System.out.println(path);
        }
//        }
    }

    public void t3() {
        File file = new File("C:\\worksapce\\Eclite5006\\AndroidEcLite43\\app\\src\\main\\res");
        loopFile(file);
    }
}
