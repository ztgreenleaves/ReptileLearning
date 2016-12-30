package ImgBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class CreateImage {
	static String spath;
	public static boolean createFolder(String path){
		File file = new File(path);
		setSpath(path);
		if (!file.exists()){
			file.mkdirs();
			System.out.println("Create file " + path + " is success!");
			
			return true;
		}
		return false;
	}
	public static boolean createImg(String imgUrl){
		imgUrl = "http:" + imgUrl;
		String imgName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
		File img = new File(spath + "/" + imgName);
		if (img.exists()){
			System.out.println(imgName + " has already existed!");
			return false;
		}
		try {
			OutputStream os = new FileOutputStream(img);
			InputStream in = null;
			URL url = new URL(imgUrl);
			in = url.openStream();
			byte[] reader = new byte[1024];
			while (true){
				int flag = in.read(reader);
				if (flag == -1)
					break;
				byte[] temp = new byte[flag];
				System.arraycopy(reader, 0, temp, 0, flag);
				os.write(temp);
			}
			System.out.println("Complete the picture named " + imgName);
			os.close();
			in.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ops, sth wrong!");
		return false;
	}
	public static void setSpath(String path) {
		CreateImage.spath = path;
	}
	
	
}
