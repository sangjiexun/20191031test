/*
 * $Id: CryptUtil.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/20   BGT)児島      新規作成
 * 2007/10/04   BGT)児島      Blowfish による暗号化、複合化ロジックを実装
 * 2007/10/11   BGT)児島      共通鍵を設定
 * 2007/11/12   BGT)児島      Base64 による符号化を間にかますよう修正
 */
package net.chintai.backend.sysadmin.common.util;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import net.chintai.backend.sysadmin.common.exception.SystemException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * 暗号化ユーティリティクラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public final class CryptUtil {

    /** 共通鍵 */
    private static final String C_COMMON_KEY = "fG12hDa0jR";

    /**
     * 外部からのインスタンス化はできません。
     */
    private CryptUtil() {
    }

    /**
     * Blowfish アルゴリズムを用いて暗号化文字列を生成します。<br>
     * 共通鍵は内部の設定値を用います。
     * @param text 暗号化対象文字列
     * @return 暗号化後文字列
     */
    public static String blowfishEncrypt(String text) {
        return blowfishEncrypt(C_COMMON_KEY, text);
    }

    /**
     * Blowfish アルゴリズムを用いて暗号化文字列を生成します。<br>
     * 暗号化後の文字列は Base64 にてエンコードされます。
     * @param commonKey 共通鍵
     * @param text 暗号化対象文字列
     * @return 暗号化後文字列
     */
    public static String blowfishEncrypt(String commonKey, String text) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(commonKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encrypted = cipher.doFinal(text.getBytes());

            return new String(Base64.encodeBase64(encrypted));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (InvalidKeyException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (IllegalBlockSizeException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (BadPaddingException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        }
    }

    /**
     * Base64, Blowfish アルゴリズムを用いて暗号化文字列を復号します。<br>
     * 共通鍵は内部の設定値を用います。
     * @param text 暗号化された文字列
     * @return 復号化後文字列
     */
    public static String blowfishDecrypt(String text) {
        return blowfishDecrypt(C_COMMON_KEY, text);
    }

    /**
     * Blowfish アルゴリズムを用いて暗号化文字列を復号します。
     * @param commonKey 共通鍵
     * @param text 暗号化された文字列
     * @return 復号化後文字列
     */
    public static String blowfishDecrypt(String commonKey, String text) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(commonKey.getBytes(), "Blowfish");
            Cipher cipher = Cipher.getInstance("Blowfish");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decrypted = cipher.doFinal(Base64.decodeBase64(text.getBytes()));

            return new String(decrypted);

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (NoSuchPaddingException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (InvalidKeyException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (IllegalBlockSizeException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        } catch (BadPaddingException e) {
            throw new SystemException("FETAL.M.SYSTEM.0001", e);
        }
    }

    /**
     * MD5 アルゴリズムを用いてメッセージダイジェストを生成します。
     * @param source 暗号化する文字列
     * @return メッセージダイジェストの文字列
     */
    public static String md5digest(String source) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] binary = source.getBytes();
            md.update(binary);
            return new String(Hex.encodeHex(md.digest()));

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

}
