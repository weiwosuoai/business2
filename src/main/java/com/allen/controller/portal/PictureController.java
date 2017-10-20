package com.allen.controller.portal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 文件控制器
 * Created by Allen on 2017/9/15.
 */
@Controller
@RequestMapping("/file")
public class PictureController {

	private static final Log logger = LogFactory.getLog(PictureController.class);

	/**
	 * 文件下载
	 * @return
	 */
	@RequestMapping("/download")
	public String downloadFile(String filePath, HttpServletResponse response) {
		ServletOutputStream out = null;
		FileInputStream fis = null;
		try {
			String[] pathArr = filePath.split("/");
			response.setHeader("Content-disposition", "attachment;filename=" + pathArr[pathArr.length - 1]);
			response.setContentType("application/force-download");

			out = response.getOutputStream();
			fis = new FileInputStream(filePath);

			byte [] b = new byte[1024];
			int len;
			while ((len = fis.read(b)) != -1){
				out.write(b, 0, len);
			}
		} catch (Exception e) {
			logger.error("文件下载异常", e);
		} finally {
			if (out != null) {
				try {
					out.flush();
					out.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}

			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					logger.error("", e);
				}
			}
		}
		return null;
	}

}
