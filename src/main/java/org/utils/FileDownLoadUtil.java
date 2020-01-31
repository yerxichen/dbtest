package org.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author 作者 :陈曦
 * @date 创建时间:2017年4月17日 下午2:18:41
 * @version 1.0
 * @parameter
 * @since
 * @return
 */
public class FileDownLoadUtil {


	/**
	 * 把从服务器获得图片的输入流InputStream写到本地磁盘
	 * @param saveName 保存名称
	 * @param picUrl 图片URL
	 * @param savePath 保存地址
	 */
	public static void  saveImageToDisk(String saveName, String picUrl, String savePath) {
		
		//目录如果不存在就新建目录
		File f = new File(savePath);
        if (!f.exists())  
            f.mkdirs();  
        
		// 把从服务器获得图片的输入流InputStream写到本地磁盘
		InputStream inputStream = getInputStream(picUrl);
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream("E:\\servermedia\\" + savePath + "\\" + saveName + ".m4a");
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}

	}

	/**
	 * 从服务器获得一个输入流
	 * 
	 * @param pic
	 * @return
	 */
	public static InputStream getInputStream(String pic) {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;

		try {
			URL url = new URL(pic);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			// 设置网络连接超时时间
			httpURLConnection.setConnectTimeout(3000);
			// 设置应用程序要从网络连接读取数据
			httpURLConnection.setDoInput(true);

			httpURLConnection.setRequestMethod("GET");
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				// 从服务器返回一个输入流
				inputStream = httpURLConnection.getInputStream();

			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return inputStream;

	}
}
