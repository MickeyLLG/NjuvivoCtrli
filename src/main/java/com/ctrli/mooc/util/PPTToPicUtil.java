package com.ctrli.mooc.util;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTextParagraph;
import org.apache.poi.xslf.usermodel.XSLFTextRun;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

public class PPTToPicUtil {


    /**
     * 根据PPT名称和存放路径来转换图片
     * @param pptFilename PPT文件名
     * @param toPath 存放路径
     * @return 转换了多少张图片
     */
    public static int savePPTtoImage(String pptFilename,String toPath){
        // 新建PPT对象
        File ppt = new File(pptFilename);
        // 新建路径对象
        File imgPath = new File(toPath);
        // 转换
        return doPPT2007toImage(ppt,imgPath);
    }

    private static int doPPT2007toImage(File pptFile,File imgFile) {
        FileInputStream is = null ;
        int imgCount = 0;
        try {
            is = new FileInputStream(pptFile);
            XMLSlideShow xmlSlideShow = new XMLSlideShow(is);
            is.close();
            // 获取大小
            Dimension pgsize = xmlSlideShow.getPageSize();
            List<XSLFSlide> slides;
            // 获取幻灯片
            slides = xmlSlideShow.getSlides();
            imgCount = slides.size();
            for (int i = 0 ; i < slides.size() ; i++) {
                List<XSLFShape> shapes;
                // 解决乱码问题
                shapes = slides.get(i).getShapes();
                for (XSLFShape shape : shapes) {
                    if (shape instanceof XSLFTextShape) {
                        XSLFTextShape sh = (XSLFTextShape) shape;
                        List<XSLFTextParagraph> textParagraphs = sh.getTextParagraphs();
                        for (XSLFTextParagraph xslfTextParagraph : textParagraphs) {
                            List<XSLFTextRun> textRuns = xslfTextParagraph.getTextRuns();
                            for (XSLFTextRun xslfTextRun : textRuns) {
                                xslfTextRun.setFontFamily("宋体");
                            }
                        }
                    }
                }
                //根据幻灯片大小生成图片
                BufferedImage img = new BufferedImage(pgsize.width,pgsize.height, BufferedImage.TYPE_INT_RGB);
                Graphics2D graphics = img.createGraphics();
                graphics.setPaint(Color.white);
                graphics.fill(new Rectangle2D.Float(0, 0, pgsize.width,pgsize.height));
                // 最核心的代码
                slides.get(i).draw(graphics);
                //图片将要存放的路径
                String absolutePath = imgFile.getAbsolutePath()+"/"+ (i + 1) + ".jpg";
                File jpegFile = new File(absolutePath);
                // 图片路径存放
                //list.add((i + 1) + ".jpg");
                //如果图片存在，则不再生成
                if (jpegFile.exists()) {
                    continue;
                }
                // 这里设置图片的存放路径和图片的格式(jpeg,png,bmp等等),注意生成文件路径
                FileOutputStream out = new FileOutputStream(jpegFile);
                // 写入到图片中去
                ImageIO.write(img, "jpeg", out);
                out.close();
            }
            //System.out.print("PPT转换成图片 成功！");
            //log.error("PPT转换成图片 成功！");
            return imgCount;
        }
        catch (Exception e) {
            e.printStackTrace();
            //System.out.print("PPT转换成图片 发生异常！");
            // log.error("PPT转换成图片 发生异常！", e);
        }
        return imgCount;
    }
    public static void main(String[] args) {
        PPTToPicUtil.savePPTtoImage("/home/zekdot/moocres/test1.pptx","/home/zekdot/moocres");
        List<String> list = new ArrayList<String>();
    }

}