package com.ctrli.mooc.utiltest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.*;

/**
 * 文件处理小工具
 */
public class FileUtil {

    /**
     * 保存一个文件
     *
     * @param file     文件
     * @param filename 　文件名
     * @param path     　路径
     * @return 保存是否成功
     */
    public static boolean saveFile(MultipartFile file, String filename, String path) {
        FileOutputStream out = null;
        if (null == file || file.isEmpty()) {
            return false;
        } else {
            try {
                //获得二进制流并输出
                byte[] f = file.getBytes();
                out = new FileOutputStream(path + filename);
                out.write(f);
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            } finally {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

    /**
     * 根据文件名和路径读取文件字节数组
     *
     * @param filename 文件名
     * @param path     路径
     * @return
     */
    public static byte[] readPic(String filename, String path) {
        FileInputStream fis = null;//文件输入流
        File file = new File(path + filename);//获取文件
        try {
            fis = new FileInputStream(file);  //打开文件输入流
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        if (fis != null) {
            try {
                int size = fis.available();//获取文件大小
                byte data[] = new byte[size];
                fis.read(data); //读数据
                fis.close();
                return data;//返回数组
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }
    public static MultipartFile getFile(String filename) {
        FileItem fileItem = createFileItem(filename);
        MultipartFile mfile = new CommonsMultipartFile(fileItem);
        return mfile;
    }

    private static FileItem createFileItem(String filePath)
    {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        String textFieldName = "textField";
        int num = filePath.lastIndexOf(".");
        String extFile = filePath.substring(num);
        org.apache.commons.fileupload.FileItem item = factory.createItem(textFieldName, "text/plain", true,
                "MyFileName" + extFile);
        File newfile = new File(filePath);
        int bytesRead = 0;
        byte[] buffer = new byte[8192];
        try
        {
            FileInputStream fis = new FileInputStream(newfile);
            OutputStream os = item.getOutputStream();
            while ((bytesRead = fis.read(buffer, 0, 8192))
                    != -1)
            {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            fis.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return item;
    }

//    public static MultipartFile getFile(String filename) throws IOException {
//        File file = new File(filename);
//        FileItem fileItem = new DiskFileItem(file.getName(), Files.probeContentType(file.toPath()),false,file.getName(),(int)file.length(),file.getParentFile());
//        byte[] buffer = new byte[4096];
//        int n;
//        try (InputStream inputStream = new FileInputStream(file); OutputStream os = fileItem.getOutputStream()){
//            while ( (n = inputStream.read(buffer,0,4096)) != -1){
//                os.write(buffer,0,n);
//            }
//            //也可以用IOUtils.copy(inputStream,os);
//            MultipartFile multipartFile = new CommonsMultipartFile(fileItem);
//            System.out.println(multipartFile.getName());
//            return multipartFile;
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return null;
//    }
    public static void main(String args[]){
        MultipartFile mf = FileUtil.getFile("/home/zekdot/桌面/区块链/第五章 区块链架构 - 2 以太坊.pptx");
        try {
            System.out.println(mf.getBytes().length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileUtil.saveFile(mf,"test.pptx","/home/zekdot/桌面/区块链/");
    }
}
