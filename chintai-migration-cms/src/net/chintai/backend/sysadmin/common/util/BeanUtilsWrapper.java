/*
 * $Id: BeanUtilsWrapper.java 4125 2009-03-05 07:20:05Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者         内容
 * ---------------------------------------------------------
 * 2009/03/03     BGT)李昊燮     新規作成
 *
 */
package net.chintai.backend.sysadmin.common.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;


/**
 * Commons BeanUtilsのラッパークラス。<br>
 * 完全なラッパーではなく、良く利用するメソッドのみラップしている。
 *
 * @author Lee Hosup
 * @version $Revision: 4125 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class BeanUtilsWrapper {

    /**
     * 外部からのインスタンス化はできません。
     */
    private BeanUtilsWrapper() {
    }

    /**
     * {@link BeanUtils#copyProperties(Object, Object)} のラッパー。
     *
     * @param dest
     *            コピー先Bean
     * @param orig
     *            コピー元Bean
     */
    public static void copyProperties(Object dest, Object orig) {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
