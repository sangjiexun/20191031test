<%@ page contentType="text/html;charset=UTF-8" language="Java"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件検索" />
<c:set var="view"  value="${ReviewBukkenSearchView}"/>
<%@ include file="../parts/ContentsHeader.jsp"%>
<%@ include file="../parts/ContentsSidebar.jsp"%>
<script type="text/javascript">
<!--
  function joinDate(){
    var thisForm = document.forms[0];
    var sDate = thisForm.fromYear.value + thisForm.fromMonth.value + thisForm.fromDay.value;
    var eDate = thisForm.toYear.value + thisForm.toMonth.value + thisForm.toDay.value;
    thisForm.sendDtFrom.value = sDate;
    thisForm.sendDtTo.value = eDate;

    thisForm.fieldCheck.value = thisForm.shopCd.value
                              + thisForm.bkCd.value
                              + thisForm.uketsukeCd.value
                              + thisForm.shinsaStartDtFrom.value
                              + thisForm.shinsaStartDtTo.value
                              + thisForm.bkKanri.value;
  }

  function page(offSet){
    var thisForm = document.forms[0];
    thisForm.offSet.value=offSet;

    joinDate();
    _submit('ReviewBukkenSearchPaging.do');
 }

 addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});
-->
</script>
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp"%>
<div class="main_layout">
<div class="topic_path">
  <html:link action="/Index.do">トップページ </html:link>&gt;
  ${title}
</div>
<h1>${title}</h1>
<html:errors />
<html:messages id ="msg" message="true" header="info.header" footer="info.footer">
  <c:out value="${msg}"/>
</html:messages>
<html:form action="/review/ReviewBukkenSearch" onsubmit="joinDate();" method="get">
<!-- 物件・店舗情報から検索 -->
<p class="section_header">物件・店舗情報から検索</p>
<table class="type_searchbox">
  <tr>
    <td>店舗コード</td>
    <td>
      <input type="text" name="shopCd" value="${view.shopCd}" size="9" maxlength="9">&nbsp;
      物件コード <input type="text" name="bkCd" value="${view.bkCd}" size="17" maxlength="15">&nbsp;
      部屋連番 <input type="text" name="roomNo" value="${view.roomNo}" size="3" maxlength="4">&nbsp;
      号室 <input type="text" name="roomCd" size="12" maxlength="60" value="${fn:escapeXml(param.roomCd)}" />
    </td>
  </tr>
  <tr>
    <td>物件管理コード&nbsp;&nbsp;</td>
    <td colspan="7">
      <input type="text" name="bkKanri" size="35" maxlength="30" value="${param.bkKanri}" />
    </td>
  </tr>
  <tr>
    <td>お問い合せ番号&nbsp;</td>
    <td colspan="7"><input name="uketsukeCd" type="text" size="40" maxlength="40" value="${fn:escapeXml(view.uketsukeCd)}"></td>
  </tr>
  <tr>
    <td>都道府県</td>
    <td colspan="7"><chintai:Todofuken name="prefCd" fixValue="${view.prefCd}"/></td>
  </tr>
  <tr>
    <td>物件名／物件名カナ</td>
    <td colspan="7">
      <input type="text" name="bkName" size="40" maxlength="120" value="${fn:escapeXml(param.bkName)}" />
      <c:choose>
      <c:when test="${param.searchType != '1'}">
        <label><input type="radio" name="searchType" value="0" checked/>前方一致</label>
        <label><input type="radio" name="searchType" value="1"  />部分一致</label><br>
      </c:when>
      <c:otherwise>
        <label><input type="radio" name="searchType" value="0" />前方一致</label>
        <label><input type="radio" name="searchType" value="1" checked/>部分一致</label><br>
      </c:otherwise>
      </c:choose>
      ※「物件名／物件名カナ」で検索する場合、「店舗コード」にも入力してください。<br>
      ※部分一致の場合、検索結果表示に数分以上かかることがあります。
    </td>
  </tr>
  <tr>
    <td>会社名/事務所名</td>
    <td colspan="7"><input type="text" name="companyBumon" maxlength="400" size="40" value="${fn:escapeXml(view.companyBumon)}">&nbsp;
      状態
      <chintai:PropertyOptions name="shopStatus"
                               nameKey="STATUS_NAME"
                               valueKey="STATUS_VALUE"
                               fixValue="${view.shopStatus}"/>
    </td>
  </tr>
</table>

<!-- 審査情報から検索 -->
<p class="section_header">審査情報から検索</p>
<table class="type_searchbox">
  <tr>
    <th class="text-left">警告日</th>
    <td>
      <chintai:DateTag name="fromYear"  type="year"  fixValue="${view.fromYear}"/>年
      <chintai:DateTag name="fromMonth" type="month" fixValue="${view.fromMonth}"/>月
      <chintai:DateTag name="fromDay"   type="day"   fixValue="${view.fromDay}"/>日 ～
      <chintai:DateTag name="toYear"    type="year"  fixValue="${view.toYear}"/>年
      <chintai:DateTag name="toMonth"   type="month" fixValue="${view.toMonth}"/>月
      <chintai:DateTag name="toDay"     type="day"   fixValue="${view.toDay}"/>日
    </td>
  </tr>
  <tr>
    <th class="text-left">平均家賃基準該当物件</th>
    <td>
      <c:choose>
        <c:when test="${not empty view.warningCd01statusKbn01 or not empty param.chkFlg}">
          <label><input type="checkbox" name="warningCd01statusKbn01" value="1" checked/>返信なし</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd01statusKbn01" value="1" />返信なし</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd01statusKbn02}">
          <label><input type="checkbox" name="warningCd01statusKbn02" value="1" checked/>返信有り(非公開)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd01statusKbn02" value="1" />返信有り(非公開)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd01statusKbn03}">
          <label><input type="checkbox" name="warningCd01statusKbn03" value="1" checked/>返信有り(問題なし)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd01statusKbn03" value="1" />返信有り(問題なし)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd01statusKbn04}">
          <label><input type="checkbox" name="warningCd01statusKbn04" value="1" checked/>未送信</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd01statusKbn04" value="1" />未送信</label>
        </c:otherwise>
      </c:choose>
    </td>
  </tr>
  <tr>
    <th class="text-left">連続掲載該当物件</th>
    <td>
      <c:choose>
        <c:when test="${not empty view.warningCd02statusKbn01 or not empty param.chkFlg}">
          <label><input type="checkbox" name="warningCd02statusKbn01" value="1" checked/>返信なし</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd02statusKbn01" value="1" />返信なし</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd02statusKbn02}">
          <label><input type="checkbox" name="warningCd02statusKbn02" value="1" checked/>返信有り(非公開)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd02statusKbn02" value="1" />返信有り(非公開)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd02statusKbn03}">
          <label><input type="checkbox" name="warningCd02statusKbn03" value="1" checked/>返信有り(問題なし)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd02statusKbn03" value="1" />返信有り(問題なし)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd02statusKbn04}">
          <label><input type="checkbox" name="warningCd02statusKbn04" value="1" checked/>未送信</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd02statusKbn04" value="1" />未送信</label>
        </c:otherwise>
      </c:choose>
    </td>
  </tr>
  <tr>
    <th class="text-left">連続掲載かつ問合せ数該当物件</th>
    <td>
      <c:choose>
        <c:when test="${not empty view.warningCd03statusKbn01 or not empty param.chkFlg}">
          <label><input type="checkbox" name="warningCd03statusKbn01" value="1" checked/>返信なし</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd03statusKbn01" value="1" />返信なし</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd03statusKbn02}">
          <label><input type="checkbox" name="warningCd03statusKbn02" value="1" checked/>返信有り(非公開)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd03statusKbn02" value="1" />返信有り(非公開)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd03statusKbn03}">
          <label><input type="checkbox" name="warningCd03statusKbn03" value="1" checked/>返信有り(問題なし)</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd03statusKbn03" value="1" />返信有り(問題なし)</label>
        </c:otherwise>
      </c:choose>
      <c:choose>
        <c:when test="${not empty view.warningCd03statusKbn04}">
          <label><input type="checkbox" name="warningCd03statusKbn04" value="1" checked/>未送信</label>
        </c:when>
        <c:otherwise>
          <label><input type="checkbox" name="warningCd03statusKbn04" value="1" />未送信</label>
        </c:otherwise>
      </c:choose>
    </td>
  </tr>
</table>

<!-- 掲載日数から検索 -->
<p class="section_header">掲載日数から検索</p>
<table class="type_searchbox">
  <tr>
    <th>連続掲載日数&nbsp;</th>
    <td>
      <input type="text" name="shinsaStartDtFrom" maxlength="4" size="3" value="${view.shinsaStartDtFrom}"/>
      日間&nbsp;～&nbsp;
      <input type="text" name="shinsaStartDtTo" maxlength="4" size="3"  value="${view.shinsaStartDtTo}"/>
      日間&nbsp;
    </td>
    <td>
      ※　「連続掲載日数」を指定した場合、掲載停止物件は抽出されません。
    </td>
  </tr>
</table>

<br>
<p>
  <input type="hidden" name="sendDtFrom">
  <input type="hidden" name="sendDtTo">
  <input type="hidden" name="fieldCheck">
  <input type="hidden" name="offSet">
  <input type="submit" value="検索">
  <input type="reset" value="クリア">
  <br>
※「店舗コード」、「物件コード」、「物件管理コード」、「お問い合せ番号」、「連続掲載日数」、「物件名／物件名カナと店舗コード」項目のいずれかに入力を行ってください。
</p>


<c:if test="${not empty ReviewBukkenSearchView.bukkenList}">
<p class="section_header">検索結果</p>
<c:set var="helper" value="${ReviewBukkenSearchView}"/>
<%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
  <table class="type_list_nomargin">
      <colgroup>
      <col width="16%"/>
      <col width="11%"/>
      <col width="9%"/>
      <col width="10%"/>
      <col width="8%"/>
      <col width="5%"/>
      <col width="9%"/>
      <col width="6%"/>
      <col width="5%"/>
      <col width="3%"/>
      <col width="9%"/>
      <col width="3%"/>
      <col width="9%"/>
    </colgroup>
    <tr>
      <th rowspan="2" >管理コード<br>状態</th>
      <th rowspan="2" >お問い合せ<br>番号</th>
      <th rowspan="2" >店舗コード<br>状態</th>
      <th rowspan="2">会社名<br>事務所名</th>
      <th rowspan="2">CHINTAI掲載<br>エイブル掲載<br>連動元</th>
      <th rowspan="2">連絡<br>方法</th>
      <th rowspan="2">物件対象外<br>設定</th>
      <th rowspan="2">CHINTAI<br>NET<br>掲載状態</th>
      <th rowspan="2">連続<br>掲載日数</th>
      <th colspan="2">初回審査状態</th>
      <th colspan="2">定期審査状態</th>
    </tr>
    <tr>
      <th>警告<br>対象</th>
      <th>返信<br>内容</th>
      <th>警告<br>対象</th>
      <th>返信<br>内容</th>
    </tr>
    <c:forEach items="${ReviewBukkenSearchView.bukkenList}" var="detail">
    <tr>
      <td>
        <html:link action="/review/ReviewBukkenInfo" target="_blank" paramId="roomKey" paramName="detail" paramProperty="roomKey">
          <c:out value="${detail.kanriCd}" />
        </html:link><br>
          <c:if test="${detail.ctStopDt != null && detail.ablStopDt != null}">停止</c:if>
          <c:if test="${detail.ctStopDt == null || detail.ablStopDt == null}">通常</c:if>
        </td>
      <td><c:out value="${detail.uketsukeCd}" /></td>
      <td>
        <html:link action="/review/ReviewShopInfo" target="_blank" paramId="shopCd" paramName="detail" paramProperty="shopCd">
          <c:out value="${detail.shopCd}" />
        </html:link><br>
        <chintai:CodePrint code="${detail.shopStatus}" nameKey="WEB_SHOP_STATUS_NAME" valueKey="WEB_SHOP_STATUS_VALUE"/>
      </td>
      <td class="left"><c:out value="${detail.company}" /><br><c:out value="${detail.bumon}" /></td>
      <td>
        <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${detail.ctStatus}"/><br>
        <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${detail.ablStatus}"/><br>
       <c:out value="${detail.rendoName}" />
      </td>
      <td>
        <chintai:CodePrint code="${detail.fmKbn}" nameKey="WEB_FM_KBN_NAME" valueKey="WEB_FM_KBN_VALUE"/>
      </td>
      <td>
        初回審査 <chintai:CodePrint code="${detail.syokaiShinsaSkipFlg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
        定期審査 <chintai:CodePrint code="${detail.teikiShinsaSkipFlg}"  nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/><br>
        自動削除 <chintai:CodePrint code="${detail.autoDelSkipFlg}"      nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/>
      </td>
      <td>
        <c:if test="${detail.changeSourceKbn == '2' && detail.ctStopDt != null}">停止</c:if>
        <c:if test="${detail.changeSourceKbn != '2' || detail.ctStopDt == null}">通常</c:if>
      </td>
      <td>
        <c:out value="${detail.elapsedDays}"/>
        <c:if test="${not empty detail.elapsedDays}">日</c:if>
      </td>
      <td><c:out escapeXml="false" value="${detail.syokaiWarningCd}"></c:out></td>
      <td><c:out escapeXml="false" value="${detail.syokaiSyoriKbn}"></c:out></td>
      <td><c:out escapeXml="false" value="${detail.teikiWarningCd}"></c:out></td>
      <td><c:out escapeXml="false" value="${detail.teikiSyoriKbn}"></c:out></td>
    </tr>
    </c:forEach>
  </table>
<%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
</c:if>
</html:form>
</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp"%>