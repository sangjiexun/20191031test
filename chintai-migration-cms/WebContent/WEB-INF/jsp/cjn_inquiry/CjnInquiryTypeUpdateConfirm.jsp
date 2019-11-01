<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ種別編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('update')[0].focus();});

</script>
<c:set var="view" value="${CjnInquiryTypeUpdateView}" scope="page" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeInfo">
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        問い合せ種別詳細
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <p class="section_header">編集内容確認</p>
    <table class="type_detail_pre">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">タイトル</th>
        <td><c:out value="${view.inqTitle}" /></td>
      </tr>
      <tr>
        <th class="text-left">説明文</th>
        <td><c:out value="${view.inqComment}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せURL</th>
        <td><c:out value="${view.inqUrl}" /></td>
      </tr>
      <tr>
        <th class="text-left">表示用タイトル</th>
        <td><c:out value="${view.dispTitle}" /></td>
      </tr>
      <tr>
        <th class="text-left">表示用ソートキー</th>
        <td><c:out value="${view.dispSortKey}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せグループ</th>
        <td>
          <chintai:CodePrint code="${view.inqGroupType}"
              nameKey="CJN_INQ_GROUP_TYPE_NAME"
              valueKey="CJN_INQ_GROUP_TYPE_VALUE" />
        </td>
      </tr>
      <tr>
        <th height="80" class="text-left">管理メモ</th>
        <td><chintai:filter changeNL2BR="true"><c:out value="${view.adminNote}" /></chintai:filter></td>
      </tr>
    </table>

    <html:form method="post" action="/cjn_inquiry/CjnInquiryTypeUpdateCommit" onsubmit="disableSubmit(this)">
      <p>
        <input type="hidden" name="cjnInqKindSeq" value="${view.cjnInqKindSeq}">
        <input type="hidden" name="inqTitle" value="${fn:escapeXml(view.inqTitle)}">
        <input type="hidden" name="inqComment" value="${fn:escapeXml(view.inqComment)}">
        <input type="hidden" name="inqUrl" value="${view.inqUrl}">
        <input type="hidden" name="dispTitle" value="${fn:escapeXml(view.dispTitle)}">
        <input type="hidden" name="dispSortKey" value="${fn:escapeXml(view.dispSortKey)}">
        <input type="hidden" name="inqGroupType" value="${fn:escapeXml(view.inqGroupType)}">
        <input type="hidden" name="adminNote" value="${fn:escapeXml(view.adminNote)}">
        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="submit" name="update" value="更新">
        <input type="button" name="back" value="戻る" onClick="_submit('CjnInquiryTypeUpdatePageBack.do')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
