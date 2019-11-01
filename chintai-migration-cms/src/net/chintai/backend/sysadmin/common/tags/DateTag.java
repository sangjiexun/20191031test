/*
 * $Id: DateTag.java 4349 2009-08-25 09:00:10Z lee-hosup $
 * ---------------------------------------------------------
 * 更新日      更新者       内容
 * ---------------------------------------------------------
 * 2007/07/31  BGT)李昊燮   新規作成
 * 2007/08/01  BGT)児島     リファクタリング実施
 * 2007/08/02  BGT)児島     リファクタリング実施
 * 2007/08/02  BGT)李昊燮   fixValue処理追加
 * 2007/10/30  BGT)李昊燮   fixValue及びtodayFixが設定されている場合も空白を選択できるように修正
 */
package net.chintai.backend.sysadmin.common.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import net.chintai.backend.sysadmin.common.tags.datetype.CustomYearType;
import net.chintai.backend.sysadmin.common.tags.datetype.DateTypeContext;
import net.chintai.backend.sysadmin.common.tags.datetype.DayType;
import net.chintai.backend.sysadmin.common.tags.datetype.HourType;
import net.chintai.backend.sysadmin.common.tags.datetype.MinuteType;
import net.chintai.backend.sysadmin.common.tags.datetype.MonthType;
import net.chintai.backend.sysadmin.common.tags.datetype.SecondType;
import net.chintai.backend.sysadmin.common.tags.datetype.YearType;

import org.apache.commons.lang.StringUtils;

public class DateTag extends TagSupport {

    private static final long serialVersionUID = 8946344728946935550L;

    /** ドロップダウンリストの名前 */
    private String name;

    /**
     * ドロップダウンリストのタイプ。<br>
     * 年/月/日/時 のいずれかを設定します。
     */
    private String type;

    /**
     * デフォルト値フラグ。<br>
     * 現在時刻をデフォルト値として設定したい場合に "true" を設定します。
     */
    private String todayFix;

    /**
     * デフォルト値。<br>
     * この値が設定されていない場合は、システムのデフォルト値が適用されます。
     */
    private String fixValue;

    /**
     * 必須フラグ。<br>
     * この値が設定されると、空白選択不可になります。
     */
    private String required;

    /**
     * 年度プルダウン生成時の開始年度を指定。<br>
     * この値が設定されていない場合は、システム設定ファイルの設定値が開始年度になります。
     */
    private String startYear;

    /**
     * 年度プルダウン生成時の補正値。<br>
     * この値が設定されと、年度プルダウンの最終年度を補正値ほど増やします。
     */
    private String addYear;

    /**
     * ドロップダウンリストを作成します。
     * @see javax.servlet.jsp.tagext.TagSupport#doStartTag()
     */
    public int doStartTag() throws JspException {

        // 適切な日付タイプ型を設定
        DateTypeContext context = new DateTypeContext();
        if (type.equals("year")) {
            if (StringUtils.isEmpty(addYear) && StringUtils.isEmpty(startYear)){
                context.setDateType(new YearType());
            } else {
                context.setDateType(new CustomYearType(startYear, addYear));
            }
        } else if (type.equals("month")) {
            context.setDateType(new MonthType());
        } else if (type.equals("day")) {
            context.setDateType(new DayType());
        } else if (type.equals("time")) {
            context.setDateType(new HourType());
        } else if (type.equals("minute")) {
            context.setDateType(new MinuteType());
        } else if (type.equals("second")) {
            context.setDateType(new SecondType());
        }

        String[] values = context.getDropDownListValues();

        // タグの中身を作成
        StringBuilder content = new StringBuilder();

        if (StringUtils.isNotEmpty(fixValue)) {
            content.append(getFixedContent(values, fixValue));
        } else if (todayFix != null && todayFix.equals("true")) {
            String fix = context.getPresentDate();
            content.append(getFixedContent(values, fix));
        } else {
            content.append(getContent(values));
        }

        // jsp への書き出し
        try {
            pageContext.getOut().print(content.toString());
            return SKIP_BODY;
        } catch (IOException e) {
            throw new JspException(e);
        }
    }

    /**
     * デフォルト値なしのドロップダウンリスト HTML タグを作成します。
     * @param values
     * @return
     */
    private String getContent(String[] values) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n\t<select name=\"" + name + "\">\r\n");
        if(StringUtils.isEmpty(required) || !(required.equals("true"))){
            sb.append("\t\t<option value=\"\" ></option>\r\n");
        }
        for (int i = 0; i < values.length; i++) {
            sb.append("\t\t<option value=\"" + values[i] + "\">" + Integer.parseInt(values[i]) + "</option>\r\n");
        }
        sb.append("\t</select>");
        return sb.toString();
    }

    /**
     * デフォルト値を現在日付に設定した<br>
     * ドロップダウンリスト HTML タグを作成します。
     * @param values
     * @param fix
     * @return
     */
    private String getFixedContent(String[] values, String fix) {
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n\t<select name=\"" + name + "\">\r\n");
        if(StringUtils.isEmpty(required) || !(required.equals("true"))){
            sb.append("\t\t<option value=\"\" ></option>\r\n");
        }
        for (int i = 0; i < values.length; i++) {
            if (Integer.parseInt(values[i]) == Integer.parseInt(fix)) {
                sb.append("\t\t<option value=\"" + values[i] + "\" selected=\"selected\">"
                        + Integer.parseInt(values[i]) + "</option>\r\n");
            } else {
                sb.append("\t\t<option value=\"" + values[i] + "\">" + Integer.parseInt(values[i]) + "</option>\r\n");
            }
        }
        sb.append("\t</select>");
        return sb.toString();
    }

    /**
     * デフォルト値フラグを設定します。
     * @param todayFix
     */
    public void setTodayFix(String todayFix) {
        this.todayFix = todayFix;
    }

    /**
     * 名前を設定します。
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 日付タイプを設定します。
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * fixValueを設定する
     * @param fixValue
     */
    public void setFixValue(String fixValue) {
        this.fixValue = fixValue;
    }

    /**
    * 必須フラグ。<br>を設定します。
    * @param required 必須フラグ。<br>
    */
    public void setRequired(String required) {
        this.required = required;
    }

    /**
     * 年度プルダウン生成時の開始年度を指定。<br>を設定します。
     * @param startYear 年度プルダウン生成時の開始年度を指定。<br>
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     * 年度プルダウン生成時の補正値。<br>を設定します。
     * @param addYear 年度プルダウン生成時の補正値。<br>
     */
    public void setAddYear(String addYear) {
        this.addYear = addYear;
    }
}
