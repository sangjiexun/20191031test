<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗情報詳細" />
<c:set var="view"  value="${ShopBindUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 var newWin;

 function openTorihikisakiSearch() {
   newWin = window.open("","TorihikisakiSearch", "width=900,height=600,scrollbars=yes,toolbar=no,menubar=no,resizable=yes,status=yes");
   newWin.document.location.href="TorihikisakiSearchForBindPage.do";
 }

 function closeChildWindow(){
  try{
    if(newWin) { // newWinがObjectだったら以下を実行
      newWin.window.close()
    };
  }catch(e){
  }
 }
addEvent('load', window, function(){document.getElementsByName('displayTorihikisakiLsit')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">${title}</p>
    <table class="type_detail">
        <colgroup>
          <col width="20%">
          <col width="30%">
          <col width="20%">
          <col width="30%">
        </colgroup>
        <tr>
          <th>店舗コード</th>
          <td><c:out value="${view.shopCd}" /></td>
          <th>地区コード</th>
          <td><c:out value="${view.areaCd}" /></td>
        </tr>
        <tr>
          <th>会社名</th>
          <td><c:out value="${view.company}" /></td>
          <th>事務所名</th>
          <td><c:out value="${view.bumon}" /></td>
        </tr>
        <tr>
          <th rowspan="3">住所</th>
          <td colspan="3">
            <c:if test="${not empty view.zip}">
              〒<c:out value="${view.zip}"/>
            </c:if>&nbsp;
          </td>
        </tr>
        <tr>
          <td colspan="3"><c:out value="${view.address1}" />&nbsp;</td>
        </tr>
        <tr>
          <td colspan="3"><c:out value="${view.address2}" />&nbsp;</td>
        </tr>
        <tr>
          <th>メールアドレス</th>
          <td><c:out value="${view.email}" /></td>
          <th>担当者</th>
          <td><c:out value="${view.tantou}" /></td>
        </tr>
        <tr>
          <th>電話番号</th>
          <td><c:out value="${view.tel}" /></td>
          <th>FAX番号</th>
          <td><c:out value="${view.fax}" /></td>
        </tr>
      </table>

      <p class="section_header">紐付先情報</p>
      <html:form action="demand/ShopBindUpdateConfirm" onsubmit="closeChildWindow();">
        <div class="add_form">
          <div class="add_form_title">取引先コード<span class="caution">*</span></div>
          <div class="annotation">取引先コードを設定します。取引先一覧表示ボタンクリック後に表示される取引先検索画面より取引先を選択してください。</div>
          <div class="form_space">
            <input type="text" name="torihikisakiCd" maxlength="12" size="11" value="${view.torihikisakiCd}" style="background-color:#CCCCCC" readonly>
            <input type="button" name="displayTorihikisakiLsit" value="取引先一覧表示" onclick="openTorihikisakiSearch();">
          </div>
        </div>

        <div class="add_form">
          <div class="add_form_title">取引先名<span class="caution">*</span></div>
          <div class="annotation">取引先コードに対応した取引先名を表示します。</div>
          <div class="form_space">
            <input type="text" name="torihikisakiName"  size="60"  value="${fn:escapeXml(view.torihikisakiName)}" style="background-color:#CCCCCC" readonly>
          </div>
        </div>

      <p>
        <input type="hidden" name="shopCd"          value="${param.shopCd}">
        <input type="hidden" name="updDt"           value="${view.updDt}">
        <input type="hidden" name="torihikisakiSeq" value="${view.torihikisakiSeq}">
        <input type="submit" value="確認画面へ">
      </p>
      </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
