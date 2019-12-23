/**
 * 文件上传的工具类
 */
package com.tcmp.util;

import org.apache.commons.lang.math.RandomUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public class UploadUtil {
    /*文件上传的方法*/
    public static String upload(MultipartFile file,String path) throws IOException {
        String saveFileName=null;
        if (!file.isEmpty()) {
            String oldFileName=file.getOriginalFilename();
            String prefix=oldFileName.substring(oldFileName.lastIndexOf("."));
            saveFileName=System.currentTimeMillis()+ RandomUtils.nextInt(100000)+prefix;
            File targetFile=new File(path,saveFileName);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            file.transferTo(targetFile);
        }
        return saveFileName;
    }
}
