package startek.service;

import java.io.File;

import javaxt.io.Image;

import org.springframework.stereotype.Service;

@Service
public class ImageHandler {

	public File resizeImage(int w,File file,File toFile) throws Exception{
		Image img = new Image(file);
		img.setWidth(w); 
		img.saveAs(toFile);
		return toFile;
	}

	public File cropImage(int w, int h,File file,File toFile)throws Exception {
		Image img = new Image(file);
		img.crop(0, 0, w, h);
		img.saveAs(toFile);
		return toFile;
	}

	public File cropSquareImage(int w, int h,File file,File toFile)throws Exception {
		Image img = new Image(file);
		img.crop(0, 0, w, h);
		img.saveAs(toFile);
		return toFile;
	}
	
	public Image getImage(File file) throws Exception{
		return new Image(file);
	}
}
