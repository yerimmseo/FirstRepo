package swing.quiz;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class S03_KakaoImageButton extends JButton {

	public static final int RYON = 0;
	public static final int APEACH = 1;
	public static final int MUJI = 2;
	public static final int TUBE = 3;
	
	private static HashMap<Integer, Image> btn_images = new HashMap<>();
	
	static {
		try {
			BufferedImage src = ImageIO.read(new File("./data/kakao.jpg"));
			
//			int crop_width = src.getWidth() / 2 - 44;
//			int crop_height = src.getHeight() / 2 - 43;
			
			// BufferedImage¿« getSubimage(x, y, width, height);
			btn_images.put(RYON, src.getSubimage(0, 0, src.getWidth() / 2, src.getHeight() / 2));
			btn_images.put(APEACH, src.getSubimage(src.getWidth() / 2, 0, src.getWidth() / 2, src.getHeight() / 2));
			btn_images.put(MUJI, src.getSubimage(0, src.getHeight() / 2, src.getWidth() / 2, src.getHeight() / 2));
			btn_images.put(TUBE, src.getSubimage(src.getWidth() / 2, src.getHeight() / 2, src.getWidth() / 2, src.getHeight() / 2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public S03_KakaoImageButton(int picture, int x, int y, int width, int height) {
		setIcon(new ImageIcon(
				btn_images.get(picture)
					.getScaledInstance(width, height, Image.SCALE_SMOOTH)));
		setBounds(x, y, width, height);
	}
	
	
//	public S03_KakaoImageButton() {
//		setLayout(null);
//		
//		JButton btn1 = new JButton();
//		JButton btn2 = new JButton();
//		JButton btn3 = new JButton();
//		JButton btn4 = new JButton();
//		
//		btn1.setBounds(50, 50, 150, 150);
//		btn2.setBounds(250, 50, 150, 150);
//		btn3.setBounds(50, 250, 150, 150);
//		btn4.setBounds(250, 250, 150, 150);
//				
//		File imageFile = new File("./data/kakao.jpg");
//		BufferedImage bufferedImage = null;
//		try {
//			bufferedImage = ImageIO.read(imageFile);
//			BufferedImage crop_image1 = bufferedImage.getSubimage(0, 0, 150, 150);
//			BufferedImage crop_image2 = bufferedImage.getSubimage(170, 0, 150, 150);
//			BufferedImage crop_image3 = bufferedImage.getSubimage(0, 167, 150, 150);
//			BufferedImage crop_image4 = bufferedImage.getSubimage(170, 167, 150, 150);
//			File pathFile1 = new File("./data/crop1.jpg");
//			File pathFile2 = new File("./data/crop2.jpg");
//			File pathFile3 = new File("./data/crop3.jpg");
//			File pathFile4 = new File("./data/crop4.jpg");
//			ImageIO.write(crop_image1, "jpg", pathFile1);
//			ImageIO.write(crop_image2, "jpg", pathFile2);
//			ImageIO.write(crop_image3, "jpg", pathFile3);
//			ImageIO.write(crop_image4, "jpg", pathFile4);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		btn1.setIcon(new ImageIcon("./data/crop1.jpg"));
//		btn2.setIcon(new ImageIcon("./data/crop2.jpg"));
//		btn3.setIcon(new ImageIcon("./data/crop3.jpg"));
//		btn4.setIcon(new ImageIcon("./data/crop4.jpg"));
//		
//		add(btn1);
//		add(btn2);
//		add(btn3);
//		add(btn4);
//		
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		setSize(470, 500);
//		setLocation(1000, 50);
//		setVisible(true);
//	}

	public static void main(String[] args) {
//		new S03_KakaoImageButton();
	}
	
}
