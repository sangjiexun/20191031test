/*
 * $Id: SessionSearchCondition.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2007/09/06  BGT)児島       新規作成
 *
 */
package net.chintai.backend.sysadmin.common.session;

import java.io.Serializable;

/**
 * セッションに保持する検索パラメータを識別するための<br>
 * マーカーインターフェース。<br>
 * 検索パラメータBeanは、必要ならばこのインターフェースを<br>
 * インプリメントします。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public interface SessionSearchCondition extends Serializable {
}
