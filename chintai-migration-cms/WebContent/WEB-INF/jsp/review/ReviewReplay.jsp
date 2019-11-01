<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="返信入力" />
<c:set var="view" value="${ReviewReplayView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
<script type="text/javascript">
<!--
  function joinDate(){
    var thisForm = document.forms[0];
    var vacantDate = thisForm.vacantYear.value;
    if(thisForm.vacantMonth.value.length == 1){
        vacantDate += '0';
    }
    vacantDate += thisForm.vacantMonth.value;
    if(thisForm.vacantDay.value.length == 1){
        vacantDate += '0';
    }
    vacantDate += thisForm.vacantDay.value;

    var lastConfirmDate = thisForm.lastConfirmYear.value;
    if(thisForm.lastConfirmMonth.value.length == 1){
        lastConfirmDate += '0';
    }
    lastConfirmDate += thisForm.lastConfirmMonth.value;
    if(thisForm.lastConfirmDay.value.length == 1){
        lastConfirmDate += '0';
    }
    lastConfirmDate += thisForm.lastConfirmDay.value;

    thisForm.vacantYmd.value = vacantDate;
    thisForm.lastConfirmYmd.value = lastConfirmDate;
    thisForm.submit();
  }

 addEvent('load', window, function(){document.getElementsByName('shinchikuFlg')[0].focus();});
-->
</script>
  <div class="popup_layout">
    <div class="topic_path">
      <c:set var="roomKey" value="${param.roomKey}" />
      <html:link action="/review/ReviewBukkenInfo" paramId="roomKey" paramName="roomKey">
        物件詳細
      </html:link>&gt;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
   <!-- 物件情報 -->
    <p class="section_header">物件情報</p>
      <%@ include file="parts/ReplyBukkenInfoPart.jsp" %>
    <html:form action="review/ReviewReplayConfirm.do"  onsubmit="joinDate();">
      <!-- 店舗情報 -->
      <p class="section_header">物件確認入力内容</p>
      <table class="type_detail" style="margin-bottom: 0ex;">
        <colgroup>
          <col span="1"  width="10%">
          <col span="1"  width="20%">
          <col span="1"  width="70%">
        </colgroup>
        <tr>
          <th colspan="2" class="text-left">お問い合せ番号</th>
          <td><c:out value="${view.uketsukeCd}" /></td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">管理コード</th>
          <td><c:out value="${view.kanriCd}" /></td>
        </tr>
        <tr>
          <th rowspan="2" class="text-left">物件名</th>
          <th class="text-left">名前</th>
          <td><c:out value="${view.bkName}" /></td>
        </tr>
        <tr>
          <th class="text-left">フリガナ</th>
          <td><c:out value="${view.bkKana}" /></td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">空室となった年月日又は空室予定日<br>(新築の場合は完成年月日)</th>
          <td>
            <c:choose>
              <c:when test="${view.shinchikuFlg eq '1'}">
                <label><input type="checkbox" name="shinchikuFlg" value="1" checked>新築</label><br>
              </c:when>
              <c:otherwise>
                <label><input type="checkbox" name="shinchikuFlg" value="1">新築</label><br>
              </c:otherwise>
            </c:choose>
            <input type="text" name="vacantYear" maxlength="4" size="4" value="${view.vacantYear}">年&nbsp;
            <input type="text" name="vacantMonth" maxlength="2" size="2" value="${view.vacantMonth}">月&nbsp;
            <input type="text" name="vacantDay" maxlength="2" size="2" value="${view.vacantDay}" >日&nbsp;
          </td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">最終条件確認年月日<span class="caution">*</span></th>
          <td>
            <input type="text" name="lastConfirmYear" maxlength="4" size="4" value="${view.lastConfirmYear}">年&nbsp;
            <input type="text" name="lastConfirmMonth" maxlength="2" size="2" value="${view.lastConfirmMonth}">月&nbsp;
            <input type="text" name="lastConfirmDay" maxlength="2" size="2" value="${view.lastConfirmDay}">日&nbsp;
          </td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">処理内容<span class="caution">*</span></th>
          <td>
            <c:choose>
              <c:when test="${view.syoriKbn eq '1'}">
                <label><input type="radio" name="syoriKbn" value="1" checked>物件をWEBから削除する。</label><br>
              </c:when>
              <c:otherwise>
                <label><input type="radio" name="syoriKbn" value="1">物件をWEBから削除する。</label><br>
              </c:otherwise>
            </c:choose>
            <c:choose>
              <c:when test="${view.syoriKbn eq '2'}">
                <label><input type="radio" name="syoriKbn" value="2" checked>CRSから修正データを再発信する。（物件はWEBから非公開になります。）</label><br>
              </c:when>
              <c:otherwise>
                <label><input type="radio" name="syoriKbn" value="2">CRSから修正データを再発信する。（物件はWEBから非公開になります。）</label><br>
              </c:otherwise>
            </c:choose>
            <c:choose>
              <c:when test="${view.syoriKbn eq '3'}">
                <label><input type="radio" name="syoriKbn" value="3" checked>問題なし</label>
              </c:when>
              <c:otherwise>
                <label><input type="radio" name="syoriKbn" value="3">問題なし</label>
              </c:otherwise>
            </c:choose>
          </td>
        </tr>
        <tr>
          <th colspan="2" class="text-left">その他ご意見など</th>
          <td><textarea name="bikou" cols="50" rows="5"><c:out value="${view.bikou}" /></textarea></td>
        </tr>
      </table>
      <span class="caution">*&nbsp;：必須項目</span>
      <p>
        <input type="hidden" name="updDt"      value="${view.updDt}">
        <input type="hidden" name="kanriUpdDt" value="${view.kanriUpdDt}">
        <input type="hidden" name="warningCd"  value="${view.warningCd}">
        <input type="hidden" name="updDt"      value="${view.updDt}">
        <input type="hidden" name="kanriCd" value="${view.kanriCd}">
        <input type="hidden" name="vacantYmd" value="">
        <input type="hidden" name="lastConfirmYmd" value="" >
        <input type="hidden" name="roomKey"      value="${param.roomKey}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="javascript:location.href='ReviewBukkenInfo.do?roomKey=${param.roomKey}'">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>