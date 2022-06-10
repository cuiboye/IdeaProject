package com.example.demo;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

public class UploadUtil {
    //源文件名
    private String originalFilename;

    //源文件后缀名
    private String suffix;

    //存入数据库里的tomcat虚拟路径
    private String dbPath;

    //文件大小
    private long size;

    //实际存储路径
    private String realPath;

    /**
     * 文件上传工具类
     * @param attach
     * @param request
     * @param uploader 文件上传者
     * @return
     */
//    public boolean doUpload(MultipartFile attach, HttpServletRequest request, String uploader){
    public boolean doUpload(MultipartFile attach, String uploader){

        if(!attach.isEmpty()){
            originalFilename = attach.getOriginalFilename();
            System.out.println("==>上传的文件名："+originalFilename);

            suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
            System.out.println("==>上传的文件后缀名："+suffix);

            size = attach.getSize();
            System.out.println("==>上传文件的大小："+size);

            String currentFilename = System.currentTimeMillis()+ UUID.randomUUID().toString() + suffix;
            System.out.println("==>存储的上传文件名："+currentFilename);

            realPath = "/Users/wj/Desktop/4月考勤/"+uploader ;
            System.out.println("==>上传文件保存的真实路径："+realPath);

            File targetFile = new File(realPath, currentFilename);
            if(!targetFile.exists()){
                targetFile.mkdirs();
            }

            try{
                attach.transferTo(targetFile);
            }catch (Exception e){
                e.printStackTrace();
                return false;
            }
            realPath = realPath + "/" + currentFilename;
//            dbPath =  request.getContextPath() + "/" + uploader + "/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "/" + currentFilename;
            dbPath = "/" + uploader + "/" + currentFilename;
            return true;
        }else{
            return false;
        }
    }
    public String getUploadFile(){
        return dbPath;
    }
}
