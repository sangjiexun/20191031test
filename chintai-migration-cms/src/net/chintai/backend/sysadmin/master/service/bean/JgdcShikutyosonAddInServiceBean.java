/*
 * $Id: JgdcShikutyosonAddInServiceBean.java 4535 2011-11-04 05:46:53Z e-ishii $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2011/06/20     BGT)大原       新規作成
 *
 */
package net.chintai.backend.sysadmin.master.service.bean;

import java.io.InputStream;


/**
 * ZIPファイルアップロード機能用ServiceBean
 *
 * @author OOHARA Takashi
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class JgdcShikutyosonAddInServiceBean {

    /** ファイル名 */
	String fileName;

	/** 入力ストリーム */
	InputStream inputStream;

	/**
	 * ファイル名を取得します。
	 * @return ファイル名
	 */
    public String getFileName() {
        return fileName;
    }

    /**
     * ファイル名を設定します。
     * @param fileName ファイル名
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * 入力ストリームを取得します。
     * @return 入力ストリーム
     */
    public InputStream getInputStream() {
        return inputStream;
    }

    /**
     * 入力ストリームを設定します。
     * @param inputStream 入力ストリーム
     */
    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

}
