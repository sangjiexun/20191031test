<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先情報更新" />
<c:set var="view"  value="${TorihikisakiUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
 var newWin;

 function openFudousanSearch() {
   newWin = window.open("","FudousanSearchForUpdate", "width=800,height=600,scrollbars=yes,toolbar=no,menubar=no,resizable=yes,status=yes");
   newWin.document.location.href="FudousanSearchForRefPage.do";
 }

 function closeChildWindow(){
  try{
    if(newWin) { // newWinがObjectだったら以下を実行
      newWin.window.close()
    };
  }catch(e){
  }
 }


addEvent('load', window, function(){document.getElementsByName('referBut')[0].focus();});
-->
</script>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="demand/TorihikisakiInfo.do" paramId="torihikisakiSeq" paramName="view" paramProperty="torihikisakiSeq">取引先詳細</html:link>
      &gt;<c:out value="${title}"></c:out>
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">取引先情報</p>

    <html:form action="demand/TorihikisakiUpdateConfirm" onsubmit="closeChildWindow();">
    <div class="add_form">
      <div class="add_form_title">不動産会社名<span class="caution">*</span></div>
      <div class="annotation">参照ボタンクリック後に表示される不動産会社検索画面から不動産会社を選択します。</div>
      <div class="form_space">
        <input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(view.fudousanName)}" style="background-color:#CCCCCC" readonly>
        <input type="button" name="referBut" value="参照" onclick="openFudousanSearch();">
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">取引先名<span class="caution">*</span></div>
      <div class="annotation">取引先名を記述します。</div>
      <div class="form_space">
        <input type="text" name="torihikisakiName" maxlength="60" size="50" value="${fn:escapeXml(view.torihikisakiName)}">
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">住所</div>
      <div class="annotation">取引先住所を設定します。</div>
      <div class="form_space">
        〒<input type="text" name="zipCd1" maxlength="3" size="3" value="${view.zipCd1}">－<input type="text" name="zipCd2" maxlength="4" size="4" value="${view.zipCd2}">(半角)<br>
        <chintai:Todofuken name="prefCd" fixValue="${view.prefCd}"/>
        <span class="caution">*</span><br>
        <input type="text" name="address1" maxlength="60" size="50" value="${fn:escapeXml(view.address1)}"><span class="caution">*</span>(市区町村名、番地)<br>
        <input type="text" name="address2" maxlength="51" size="50" value="${fn:escapeXml(view.address2)}">(ビル名等)
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">電話番号</div>
       <div class="annotation">電話番号を記述します。</div>
      <div class="form_space">
        <input type="text" name="tel" maxlength="13" size="13" value="${view.tel}">(半角)例：03-973-4587
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">FAX番号</div>
      <div class="annotation">FAX番号を記述します。</div>
      <div class="form_space">
        <input type="text" name="fax" maxlength="13" size="13" value="${view.fax}">(半角)例：03-973-4587
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">担当者名</div>
      <div class="annotation">担当者名を記述します。</div>
      <div class="form_space">
        <input type="text" name="tantou" maxlength="25" size="25" value="${fn:escapeXml(view.tantou)}">
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">取引担当支社<span class="caution">*</span></div>
      <div class="annotation">取引担当支社を選択します。変更を行った場合、登録済みの契約情報がクリアされ再登録となります。</div>
      <div class="form_space">
        <chintai:ShisyaInfo name="shisyaCd" fixValue="${view.shisyaCd}"/>
      </div>
    </div>

   <div class="add_form">
     <input type="hidden" name="fudousanCd"      value="${view.fudousanCd}">
     <input type="hidden" name="oldFudousanCd"   value="${view.oldFudousanCd}">
     <input type="hidden" name="torihikisakiCd"  value="${view.torihikisakiCd}">
     <input type="hidden" name="torihikisakiSeq" value="${view.torihikisakiSeq}">
     <input type="hidden" name="updDt"           value="${view.updDt}">
     <input type="submit" value="確認画面へ" >
     <input type="button" value="戻る" onClick="_submit('TorihikisakiInfo.do')">
   </div>
   </html:form>

  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>