/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;

/**
 *
 * @author Dell Inpriron 5515
 */
public class ImageUtils {
        public static void createBarCodeImage(String image_name, String myString) {
        try {

            Code128Bean code128 = new Code128Bean();
            code128.setHeight(15f);
            code128.setModuleWidth(0.3);
            code128.setQuietZone(10);
            code128.doQuietZone(true);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, "image/x-png", 300, BufferedImage.TYPE_BYTE_BINARY, false, 0);
            code128.generateBarcode(canvas, myString);
            canvas.finish();

            //write to png file
            FileOutputStream fos = new FileOutputStream("img\\BarCode\\" + image_name + ".png");
            fos.write(baos.toByteArray());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static ImageIcon resizeImg(ImageIcon icon, JLabel lbl) {
//        ImageIcon icon = new ImageIcon("img/" + folder + "/" + imgName);
        Image image = icon.getImage();
        ImageIcon resizedImg = new ImageIcon(image.getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_SMOOTH));
        return resizedImg;
    }
    public static ImageIcon read(String folder, String fileName) {
        File path = new File("img/" + folder, fileName);
        return new ImageIcon(path.getAbsolutePath());
    }
    
}
