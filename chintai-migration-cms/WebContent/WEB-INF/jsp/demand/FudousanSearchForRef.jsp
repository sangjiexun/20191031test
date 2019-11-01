<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産会社検索" />
<c:set var="view"  value="${FudousanSearchView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--

 function selectFudousan(fudousanName,fudousanCd){

   try{
     opener.document.forms[0].fudousanName.value = fudousanName;
     opener.document.forms[0].fudousanCd.value = fudousanCd;
     self.close();
   } catch(e) {
     self.close();
   }
 }

 function page(offSet){
    document.forms[0].offSet.value  = offSet;
    _submit('FudousanSearchForRefPaging.do');
 }

addEvent('load', window, function(){document.getElementsByName('fudousanCd')[0].focus();});
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
      <c:out value="${msg}" />
    </html:messages>

    <p class="section_header">検索条件</p>
      <html:form action="demand/FudousanSearchForRef">
      <table class="type_searchbox">
        <tr>
          <td>不動産会社コード</td>
          <td>
            <input type="text" name="fudousanCd" maxlength="5" size="10" value="${view.fudousanCd}">
           </td>
        </tr>
        <tr>
          <td>不動産会社名</td>
          <td>
            <input type="text" name="fudousanName" maxlength="30" size="30" value="${fn:escapeXml(view.fudousanName)}">
          </td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="offSet" value="">
        <input type="submit" value="検索">
        <input type="reset" value="クリア">
      </p>
      </html:form>

    <c:if test="${not empty view.detailList}">
    <c:set var="helper" value="${view}"/>
      <p class="section_header">検索結果</p>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list">
        <colgroup>
          <col width="15%"/>
          <col width="30%"/>
          <col width="50%"/>
          <col width="5%"/>
        </colgroup>
        <tr>
          <th>不動産会社<br>コード</th>
          <th>不動産会社名</th>
          <th>住所</th>
          <th>選択</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <tr>
            <td><c:out value="${detail.fudousanCd}" /></td>
            <td align="left"><c:out value="${detail.fudousanName}" /></td>
            <td align="left"><c:out value="${detail.prefName}" /><c:out value="${detail.address1}" /><c:out value="${detail.address2}" /></td>
            <td>
              <input type="button" value="選択" onclick="selectFudousan('${fn:escapeXml(detail.fudousanName)}','${detail.fudousanCd}');">
            </td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
