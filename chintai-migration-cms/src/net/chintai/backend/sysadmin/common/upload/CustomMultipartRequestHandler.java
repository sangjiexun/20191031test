package net.chintai.backend.sysadmin.common.upload;

import java.security.InvalidParameterException;

import javax.servlet.http.HttpServletRequest;

import net.chintai.backend.sysadmin.common.util.InvalidParameterChecker;

import org.apache.commons.fileupload.FileItem;
import org.apache.struts.upload.CommonsMultipartRequestHandler;

public class CustomMultipartRequestHandler extends CommonsMultipartRequestHandler {
	protected void addTextParameter(HttpServletRequest request, FileItem item) {
		final String fn = item.getFieldName();
		if (InvalidParameterChecker.judge(fn)) {
			final StringBuilder message = new StringBuilder();
			message.append("FormFileにClassLoaderを読み込む可能性がある値が指定されました。").append("指定された値:{").append(fn).append("}");
			throw new InvalidParameterException("不正なリクエストです。[" + message + "]");
		}
		super.addTextParameter(request, item);
	}

	protected void addFileParameter(FileItem item) {
		final String fn = item.getFieldName();
		if (InvalidParameterChecker.judge(fn)) {
			final StringBuilder message = new StringBuilder();
			message.append("FormFileにClassLoaderを読み込む可能性がある値が指定されました。").append("指定された値:{").append(fn).append("}");
			throw new InvalidParameterException("不正なリクエストです。[" + message + "]");
		}
		super.addFileParameter(item);
	}
}
