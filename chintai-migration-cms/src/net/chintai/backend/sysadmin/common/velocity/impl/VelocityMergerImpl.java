/*
 * $Id: VelocityMergerImpl.java 3570 2007-12-14 08:55:47Z t-kojima $
 * ---------------------------------------------------------
 * 更新日       更新者        内容
 * ---------------------------------------------------------
 * 2007/09/25   BGT)児島      新規作成
 *
 */
package net.chintai.backend.sysadmin.common.velocity.impl;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Map.Entry;

import net.chintai.backend.sysadmin.common.velocity.VelocityMerger;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.io.Resource;

/**
 * VelocityMerger の実装クラス。
 * 
 * @author KOJIMA Takanori
 * @version $Revision: 3570 $
 * Copyright: (C) CHINTAI Corporation All Right Reserved.
 */
public class VelocityMergerImpl implements VelocityMerger {

    private Map<String, Object> toolBox;

    private Resource configLocation;

    /** 統合チーム用メニューテンプレート */
    private String templateMenuForTogo;

    /** 広告チーム用メニューテンプレート */
    private String templateMenuForAd;

    /**
     * コンストラクター
     * @param configLocation
     * @param checkDependancyEnabled
     */
    public VelocityMergerImpl(Resource configLocation, boolean checkDependancyEnabled) {
        Properties properties = null;

        // テンプレートファイルパスを記述した設定ファイルの読み込み
        if (configLocation != null) {
            properties = new Properties();
            try {
                properties.load(configLocation.getInputStream());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        // 依存性チェック
        BeanWrapper beanWrapper = new BeanWrapperImpl(this);
        Set<String> check = new HashSet<String>();

        if (properties != null) {
            for (Entry<Object, Object> entry : properties.entrySet()) {
                beanWrapper.setPropertyValue((String) entry.getKey(), entry.getValue());
                check.add((String) entry.getKey());
            }
        }

        if (checkDependancyEnabled) {
            PropertyDescriptor[] pds = beanWrapper.getPropertyDescriptors();

            for (int i = 0; i < pds.length; i++) {
                if (pds[i].getWriteMethod() != null) {
                    boolean isSimple = BeanUtils.isSimpleProperty(pds[i].getPropertyType());

                    if (isSimple && !check.contains(pds[i].getName())) {
                        throw new RuntimeException(pds[i].getName()
                                + " : Set this property value or disable dependency checking for this bean and "
                                + configLocation.getFilename());
                    }
                }
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.velocity.VelocityMerger#merge(java.lang.String,
     *      java.util.Map)
     */
    public String merge(String templatePath, Map<String, Object> map) {

        VelocityContext velocityContext = new VelocityContext(map);

        for (String key : toolBox.keySet()) {
            velocityContext.put(key, toolBox.get(key));
        }

        StringWriter stringWriter = new StringWriter();

        try {
            Template template = Velocity.getTemplate(templatePath);
            template.merge(velocityContext, stringWriter);
            stringWriter.flush();

            return stringWriter.toString();

        } catch (ResourceNotFoundException e) {
            throw new RuntimeException(e);
        } catch (ParseErrorException e) {
            throw new RuntimeException(e);
        } catch (MethodInvocationException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (stringWriter != null) {
                try {
                    stringWriter.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.velocity.VelocityMerger#mergeTemplateMenuForAd(java.util.Map)
     */
    public String mergeTemplateMenuForAd(Map<String, Object> map) {
        return merge(templateMenuForAd, map);
    }

    /*
     * (非 Javadoc)
     * @see net.chintai.backend.sysadmin.common.velocity.VelocityMerger#mergeTemplateMenuForTogo(java.util.Map)
     */
    public String mergeTemplateMenuForTogo(Map<String, Object> map) {
        return merge(templateMenuForTogo, map);
    }

    /**
     * 初期化を行います。
     * @throws Exception
     */
    public void initialize() throws Exception {
        Properties properties = null;

        if (configLocation != null) {
            properties = new Properties();
            properties.load(configLocation.getInputStream());
        }

        if (properties == null) {
            Velocity.init();
        } else {
            Velocity.init(properties);
        }
    }

    /**
     * 後処理を行います。
     */
    public void dispose() {
    }

    /**
     * toolBoxを取得します。
     * @return toolBox
     */
    public Map<String, Object> getToolBox() {
        return toolBox;
    }

    /**
     * toolBoxを設定します。
     * @param toolBox toolBox
     */
    public void setToolBox(Map<String, Object> toolBox) {
        this.toolBox = toolBox;
    }

    /**
     * configLocationを取得します。
     * @return configLocation
     */
    public Resource getConfigLocation() {
        return configLocation;
    }

    /**
     * configLocationを設定します。
     * @param configLocation configLocation
     */
    public void setConfigLocation(Resource configLocation) {
        this.configLocation = configLocation;
    }

    /**
     * 統合チーム用メニューテンプレートを取得します。
     * @return 統合チーム用メニューテンプレート
     */
    public String getTemplateMenuForTogo() {
        return templateMenuForTogo;
    }

    /**
     * 統合チーム用メニューテンプレートを設定します。
     * @param templateMenuForTogo 統合チーム用メニューテンプレート
     */
    public void setTemplateMenuForTogo(String templateMenuForTogo) {
        this.templateMenuForTogo = templateMenuForTogo;
    }

    /**
     * 広告チーム用メニューテンプレートを取得します。
     * @return 広告チーム用メニューテンプレート
     */
    public String getTemplateMenuForAd() {
        return templateMenuForAd;
    }

    /**
     * 広告チーム用メニューテンプレートを設定します。
     * @param templateMenuForAd 広告チーム用メニューテンプレート
     */
    public void setTemplateMenuForAd(String templateMenuForAd) {
        this.templateMenuForAd = templateMenuForAd;
    }
}
