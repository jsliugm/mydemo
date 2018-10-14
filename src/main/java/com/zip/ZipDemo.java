package com.zip;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Enumeration;

public class ZipDemo {

	ZipFile zipFile = null;
	private int readedBytes;
	private byte[] buf;
	private int bufSize;

	public ZipDemo() {
		this(512);
	}

	public ZipDemo(int size) {
		this.bufSize = bufSize;
		this.buf = new byte[this.bufSize];
	}

	public void unzip(String unZipfileName) {
	/*	FileOutputStream fileOut;
		File file;
		InputStream inputStream;

		try {
			this.zipFile = new ZipFile(unZipfileName);

			for (Enumeration entries = this.zipFile.getEntries(); entries
					.hasMoreElements();) {
				ZipEntry entry = (ZipEntry) entries.nextElement();
				file = new File(entry.getName());

				if (entry.isDirectory()) {
					file.mkdirs();
				} else {
					// 如果指定文件的目录不存在,则创建之.
					File parent = file.getParentFile();
					if (!parent.exists()) {
						parent.mkdirs();
					}

					inputStream = zipFile.getInputStream(entry);

					fileOut = new FileOutputStream(file);
					while ((this.readedBytes = inputStream.read(this.buf)) > 0) {
						fileOut.write(this.buf, 0, this.readedBytes);
					}
					fileOut.close();

					inputStream.close();
				}
			}
			this.zipFile.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	*/}

	public static void main(String[] args) throws Exception {
		String path = "d:\\ziptest\\123.zip";
		ZipFile zipFile = new ZipFile(path);
		for (Enumeration entries = zipFile.getEntries(); entries
				.hasMoreElements();) {
			ZipEntry entry = (ZipEntry) entries.nextElement();
			System.out.println(entry.getName());
			InputStream is = zipFile.getInputStream(entry);
			BufferedInputStream bis = new BufferedInputStream(is);
			ByteArrayOutputStream baos= new ByteArrayOutputStream();
			byte[] bytes = new byte[1024];
			int i =0;
			while((i=bis.read(bytes))!=-1){
				baos.write(bytes, 0, i);
			}
			//System.out.println(baos.toString("gbk"));
			//FileOutputStrea
			//String ss = baos.toString("gbk");
			//ss = ss.replaceAll(",,","aaaa,aaa");
			//System.out.println(ss);
			ZipOutputStream zos = new ZipOutputStream(baos);
			
			
		}
	}
}
