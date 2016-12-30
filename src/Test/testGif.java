package Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class testGif {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String imgUrl = "http://ww3.sinaimg.cn/thumb180/005Zeabmgw1fauxkax2crg308c093u0x.gif";
		String spath = "e:/";
		
		String imgName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
		File img = new File(spath + "/" + imgName);
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
