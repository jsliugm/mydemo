package com.poi;

import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFShape;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class PowerPointTest {
    public static void main(String[] args) throws IOException {
        //creating a new empty slide show
        XMLSlideShow ppt = new XMLSlideShow();

        XSLFSlide slide1 = ppt.createSlide();
        XSLFSlide slide2 = ppt.createSlide();

        //creating an FileOutputStream object
        File file =new File("example1.pptx");
        FileOutputStream out = new FileOutputStream(file);

        //saving the changes to a file
        ppt.write(out);
        System.out.println("Presentation created successfully");
        out.close();
    }
    @Test
    public void test() throws Exception{
        //opening an existing slide show
        File file = new File("C:\\Users\\liuguangming\\Desktop\\刘雯君\\数学常见字2.pptx");
        FileInputStream inputstream=new FileInputStream(file);
        XMLSlideShow ppt = new XMLSlideShow(inputstream);
        //get slides
        List<XSLFSlide> slide = ppt.getSlides();

        XSLFSlide xslfSlide = ppt.createSlide();
        xslfSlide.importContent(slide.get(0));


        //getting the shapes in the presentation
//        System.out.println("Shapes in the presentation:");
//        for (int i = 0; i < slide.size(); i++){
//            List<XSLFShape> sh = slide.get(0).getShapes();
//            for (int j = 0; j < sh.size(); j++){
//                //name of the shape
//                System.out.println(sh.get(j).getShapeName());
//            }
//        }
        FileOutputStream out = new FileOutputStream(file);
        ppt.write(out);
        out.close();
    }
}
