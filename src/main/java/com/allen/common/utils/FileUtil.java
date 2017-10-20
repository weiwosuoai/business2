package com.allen.common.utils;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.StringBufferInputStream;

public class FileUtil {
	
	/**
	 * 保存文件
	 * @param stream
	 * @param path
	 * @param fileName
	 */
	public static void saveFileFromInputStream(InputStream stream, String path, String fileName) throws Exception {
		FileOutputStream out = new FileOutputStream(path + File.separator + fileName);
		byte[] buffer = new byte[1024 * 1024];
		int bytesum = 0;
		int byteread = 0;
		while ((byteread = stream.read(buffer)) != -1) {
			bytesum += byteread;
			out.write(buffer, 0, byteread);
			out.flush();
		}
		out.close();
		stream.close();
	}
	
	public void strToFile(String str, String newfile) {
		byte[] buffer = new byte[1024];
		StringBufferInputStream inputStream = new StringBufferInputStream(str);
		try {
			File nf = new File(newfile);
			if (!nf.getParentFile().exists())
				nf.getParentFile().mkdirs();
			BufferedOutputStream bos = new BufferedOutputStream(
					new FileOutputStream(nf));
			int v;
			while ((v = inputStream.read(buffer)) != -1) {
				bos.write(buffer, 0, v);
			}
			inputStream.close();
			bos.close();
		} catch (Exception e) {
		}
	}

	/** 
     * 文件转化为字节数组 
     *  
     * @param file 
     * @return 
     */  
    public static byte[] getBytesFromFile(File file) {  
        byte[] ret = null;  
        try {  
            if (file == null) {  
                // log.error("helper:the file is null!");  
                return null;  
            }  
            FileInputStream in = new FileInputStream(file);  
            ByteArrayOutputStream out = new ByteArrayOutputStream(1024);  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = in.read(b)) != -1) {  
                out.write(b, 0, n);  
            }  
            in.close();  
            out.close();  
            ret = out.toByteArray();  
        } catch (Exception e) {  
            // log.error("helper:get bytes from file process error!");  
            e.printStackTrace();  
        }  
        return ret;  
    } 
    
    /**
     * 递归删除目录下的所有文件及子目录下所有文件
     * @param dir 将要删除的文件目录
     * @return boolean Returns "true" if all deletions were successful.
     *                 If a deletion fails, the method stops attempting to
     *                 delete and returns "false".
     */
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            //递归删除目录中的子目录下
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // 目录此时为空，可以删除
        return dir.delete();
    }
	
}
