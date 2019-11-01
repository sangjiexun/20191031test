<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件枠・リスティング枠メンテナンス" />
<c:set var="view" value="${TorihikisakiWakuMaintenanceView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p id="mess">
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    </p>
    <p class="section_header">CSV ファイルダウンロード</p>
    <form action="TorihikisakiWakuMaintenanceDownload.do" method="post" name="checkFrom">
     <table class="type_searchbox">
        <tr>
          <td>担当支社</td>
          <td>
            <chintai:ShisyaInfo name="shisyaCd" fixValue="${view.shisyaCd}"/>
          </td>
        </tr>
        <tr>
          <td>取引先コード</td>
          <td>
            <input type="text" name="torihikisakiCd1" maxlength="5" size="6" value="${view.torihikisakiCd1}">
            &nbsp;－&nbsp;
            <input type="text" name="torihikisakiCd2" maxlength="4" size="5" value="${view.torihikisakiCd2}">
          </td>
        </tr>
        <tr>
          <td>不動産会社名</td>
          <td><input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(view.fudousanName)}"></td>
        </tr>
      </table>

      <p>
        <input type="submit" name="download" value="ダウンロード" onclick="return check()">
        <input type="reset" name="reset" value="クリア">
      </p>
    </form>

    <p class="section_header">CSV ファイルアップロード</p>
    <form action="TorihikisakiWakuMaintenanceUpload.do" method="post" enctype="multipart/form-data">
      <p><input type="file" name="uploadFile" size="50" ></p>
      <p><input type="button" name="upload" value="アップロード" onclick="uploadDisabled();"></p>
    </form>

  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>



<script type="text/javascript">
<!--

function errorMsgCheck(){
    var dom_obj = document.getElementById("mess");

    if (dom_obj != null){

        var dom_obj_parent = dom_obj.parentNode;

        for (var i =dom_obj_parent.childNodes.length-1; i>=0; i--) {

            var child = dom_obj_parent.childNodes[i];

            if (child.className == "notify") {
                dom_obj_parent.removeChild(child);
                break;
            }
        }
    }

}

function check(){

    var flag = 0;

    //画面のエラーメッセージ削除処理
    errorMsgCheck();

    //検索条件が未入力の場合確認ダイアログを表示させる
    if (document.checkFrom.shisyaCd.value == "" &&
        document.checkFrom.torihikisakiCd1.value == "" &&
        document.checkFrom.torihikisakiCd2.value == "" &&
        document.checkFrom.fudousanName.value == ""){

        flag = 1;

    }
    if(flag){

        return confirm('「担当支社」、「取引先コード」、「不動産会社名」 を指定しない\n場合、大量のデータがダウンロードされます。よろしいですか？');

    }
    else{

        return true ;

    }


}

function uploadDisabled(){
	// アップロードボタンが押下されたら、ボタンを無効にする
    var thisForm = document.forms[1];

	thisForm.upload.disabled = true;

	thisForm.submit();
}


// -->
</script>
