<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ情報検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors header="errors.header" suffix="errors.suffix" footer="errors.footer" />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
    <p class="section_header">検索条件</p>
    <html:form action="shop_inquiry/InquiryRecentSearch.do" method="get" onsubmit="bottomDisabled()">
      <input type="hidden" name="offSet" />
      <input type="hidden" name="insDtFrom" />
      <input type="hidden" name="insDtTo" />
      <input type="hidden" name="searchFlg" />
      <table>
        <tr>
          <td>店舗コード</td>
          <td class="left"><input type="text" name="shopCd" value="${InquiryRecentListView.shopCd}" size="20" maxlength="9"></td>
          <td>会社名/事務所名</td>
          <td class="left"><input type="text" name="companyBumonName" value="${InquiryRecentListView.companyBumonName}" size="20" maxlength="400"></td>
        </tr>
        <tr>
          <td>問い合せID</td>
          <td colspan="3" class="left"><input type="text" name="inqId" value="${InquiryRecentListView.inqId}" size="25" maxlength="16"></td>
        </tr>
        <tr>
          <td rowspan="1">キーワード</td>
          <td colspan="3">
			<c:choose>
				<c:when test="${(empty InquiryRecentListView.keywordSchool) or (InquiryRecentListView.keywordSchool eq '0') }">
          			<c:set var="keywordChecked" value="checked" />
					<c:set var="schoolChecked" value="" />
          		</c:when>
          		<c:otherwise>
          			<c:set var="keywordChecked" value="" />
					<c:set var="schoolChecked" value="checked" />
          		</c:otherwise>
          	</c:choose>
          	<table>
              <tr>
              	<td>
              		<input type="text" name="keyword" value="${InquiryRecentListView.keyword}" size="50" maxlength="250" style="width:350">
              	</td>
              	<td>
              		<chintai:PropertyOptions name="keywordMode" nameKey="AND_OR_NAME" valueKey="AND_OR_VALUE" fixValue="${InquiryRecentListView.keywordMode}"/>
              	</td>
              </tr>
            </table>
           </td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td colspan="3">
            <font color="#003399" class="small">※キーワードを複数指定する場合はスペースで区切って下さい。</font><br>
          </td>
        </tr>
        <tr>
          <td>問い合せ種類</td>
          <td colspan="3" rowspan="2">
            <table>
              <colgroup>
                <col width="28%">
                <col width="15%">
                <col width="25%">
                <col width="15%">
                <col width="17%">
              </colgroup>
              <tr>
                <td><chintai:MstInquiryKbn name="inqFlg" inqKbnColName="INQ_FLG" fixValue="${InquiryRecentListView.inqFlg}"/></td>
                <td>問い合せ元</td>
                <td><chintai:MstInquiryKbn name="sysFlg" inqKbnColName="SYS_FLG" fixValue="${InquiryRecentListView.sysFlg}" /></td>
                <td style="text-align: right;">サイト種別</td>
                <td><chintai:MstInquiryKbn name="siteType" inqKbnColName="SITE_TYPE" fixValue="${InquiryRecentListView.siteType}" /></td>
              </tr>
              <tr>
                <td><chintai:MstInquiryKbn name="refFlg" inqKbnColName="REF_FLG" fixValue="${InquiryRecentListView.refFlg}" /></td>
                <td>処理</td>
                <td><chintai:MstInquiryKbn name="inquiryStatus" inqKbnColName="INQUIRY_STATUS" fixValue="${InquiryRecentListView.inquiryStatus}" /></td>
                <td>　</td>
                <td>　</td>
              </tr>
            </table>
          </td>
        </tr>

        <tr>
          <td>閲覧状況</td>
        </tr>
        <tr>
          <td>問い合せ日時</td>

          <td colspan="3">
            <chintai:DateTag name="fromYear" type="year" fixValue="${InquiryRecentListView.fromYear}"/>年
           	<chintai:DateTag name="fromMonth" type="month" fixValue="${InquiryRecentListView.fromMonth}"/>月
            <chintai:DateTag name="fromDay" type="day" fixValue="${InquiryRecentListView.fromDay}"/>日
            <chintai:DateTag name="fromTime" type="time" fixValue="${InquiryRecentListView.fromTime}"/>時 から
            <chintai:DateTag name="toYear" type="year" fixValue="${InquiryRecentListView.toYear}"/>年
            <chintai:DateTag name="toMonth" type="month" fixValue="${InquiryRecentListView.toMonth}"/>月
            <chintai:DateTag name="toDay" type="day" fixValue="${InquiryRecentListView.toDay}"/>日
            <chintai:DateTag name="toTime" type="time" fixValue="${InquiryRecentListView.toTime}"/>時 まで
          </td>
        </tr>
      </table>

      <!-- 出力方法 -->
      <p class="section_header">検索結果の出力方法</p>
      <table>
        <tr>
          <td>
            並替え項目
            <chintai:PropertyOptions name="orderByItem" nameKey="ORDER_ITEM_NAME" valueKey="ORDER_ITEM_VALUE" fixValue="${InquiryRecentListView.orderByItem}" />
            順序
            <chintai:PropertyOptions name="orderBy" nameKey="ORDER_BY_NAME" valueKey="ORDER_BY_VALUE" fixValue="${InquiryRecentListView.orderBy}" />
            表示件数
            <c:choose>
              <c:when test="${InquiryRecentListView.cnt == 0}">
                <chintai:PropertyOptions name="cnt" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="50" />
              </c:when>
              <c:otherwise>
                <chintai:PropertyOptions name="cnt" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="${InquiryRecentListView.cnt}" />
              </c:otherwise>
            </c:choose>
            出力先
            <chintai:PropertyOptions name="outputMode" fixValue="${InquiryRecentListView.outputMode}" nameKey="DISPLAY_TYPE_NAME" valueKey="DISPLAY_TYPE_VALUE"/>

        </tr>
        <tr>
          <td>
            <input type="submit" value="検索" onclick="search();">
            <input type="reset" value="クリア" onclick="resetSysFlg();">
          </td>
        </tr>
      </table>
    </html:form>


    <c:if test="${not empty InquiryRecentListView.inquiryList}">
    <c:set var="helper" value="${InquiryRecentListView}"/>

    <!-- 検索結果 -->
    <p class="section_header">検索結果</p>
    <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    <table class="type_list_nomargin">
      <colgroup>
      </colgroup>
      <tr>
        <th>店舗コード<br>会社名<br>事務所名</th>
        <th>問い合せ日時<br>問い合せID</th>
        <th>問い合せ種類<br>問い合せ元</th>
        <th>サイト種別</th>
        <th>閲覧状況<br>処理状況 </th>
        <th>最終更新日時</th>
      </tr>
      <c:forEach items="${InquiryRecentListView.inquiryList}" var="inquiry">

      <tr>
        <td class="left">
          <html:link action="/shop_bukken/ShopInfo" target="_blank">
            <html:param name="shopCd" value="${inquiry.shopCd}" />
            ${inquiry.shopCd}
          </html:link><br>
          <c:choose>
            <c:when test="${not empty inquiry.company}">${inquiry.company}</c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
          <br>
          <c:choose>
            <c:when test="${not empty inquiry.bumon}">${inquiry.bumon}</c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
        </td>
        <td>
          <c:out value="${inquiry.insDt}" /><br>
          <c:choose>
            <c:when test="${not empty inquiry.inqId}">
              <html:link action="/shop_inquiry/InquiryRecentInfo">
                <html:param name="inqId" value="${inquiry.inqId}" />
                ${inquiry.inqId}
              </html:link>
            </c:when>
            <c:otherwise>--</c:otherwise>
          </c:choose>
        </td>
        <td>
          <c:out value="${inquiry.inqFlgName}" /><br>
          <c:out value="${inquiry.sysFlgName}" /><br>
        </td>
        <td>
          <c:out value="${inquiry.siteTypeName}" />
        </td>
        <td>
          <c:out value="${inquiry.refFlgName}" /><br>
          <c:out value="${inquiry.inquiryStatusName}" />
        </td>
        <td>
          <c:out value="${inquiry.updDt}" />
        </td>
      </tr>
      </c:forEach>

    </table>
    <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<script type="text/javascript">
<!--
function joinDate(){
	var thisForm = document.forms[0];
	thisForm.insDtFrom.value = thisForm.fromYear.value + thisForm.fromMonth.value + thisForm.fromDay.value + thisForm.fromTime.value;
	thisForm.insDtTo.value = thisForm.toYear.value + thisForm.toMonth.value + thisForm.toDay.value + thisForm.toTime.value;
}

function page(offSet){
	document.forms[0].offSet.value=offSet;
	_submit('InquiryRecentSearchPaging.do');
}

function search(){
	var thisForm = document.forms[0];
	thisForm.offSet.value="";
	thisForm.searchFlg.value="search"
	joinDate();
}

function bottomDisabled() {
	var thisForm = document.forms[0];
	if(thisForm.outputMode.value == 'gamen') {
		disableSubmit(thisForm);
	}
}

function checkSysFlg() {
	var thisForm = document.forms[0];
	var sysFlg = thisForm.sysFlg.value;
	// alert ("form:" + sysFlg) ;
	if ( sysFlg == '2') {
		//thisForm.carrierType.disabled = false;
	} else {
		//thisForm.carrierType.disabled = true;
	}


	for(i = 0; i < thisForm.keywordSchool.length; i++) {
		if(thisForm.keywordSchool[i].checked) {
			var val = thisForm.keywordSchool[i].value;

			if(val == '0') {
				disabledSchool();
			} else {
				disabledKeyword();
			}
		}
	}

}

function resetSysFlg() {
	var thisForm = document.forms[0];
	thisForm.sysFlg.value = "${InquiryRecentListView.sysFlg}";
	// alert ("view:" + thisForm.sysFlg.value) ;
	checkSysFlg();
}

function disabledSchool() {
	var thisForm = document.forms[0];
	thisForm.schoolName.disabled = true;
	thisForm.schoolMode.disabled = true;
	thisForm.keyword.disabled = false;
	thisForm.keywordMode.disabled = false;

}
function disabledKeyword() {
	var thisForm = document.forms[0];
	thisForm.schoolName.disabled = false;
	thisForm.schoolMode.disabled = false;
	thisForm.keyword.disabled = true;
	thisForm.keywordMode.disabled = true;

}


addEvent('load', window, checkSysFlg);
addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});

//-->
</script>

<%@ include file="../parts/ContentsFooter.jsp" %>