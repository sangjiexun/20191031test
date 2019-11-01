<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産会社メンテナンス" />
<c:set var="view"  value="${FudousanSearchView}" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
<!--
 function page(offSet){
    document.forms[0].offSet.value  = offSet;
    _submit('FudousanSearchPaging.do');
 }

addEvent('load', window, function(){document.getElementsByName('fudousanCd')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link>&gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}" />
    </html:messages>

      <p><html:link action="/demand/FudousanRegisterPage.do">&gt;&gt; 新しい不動産会社を登録する</html:link>

      <p class="section_header">検索条件</p>
      <html:form action="/demand/FudousanSearch" method="get">
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
      <html:form action="/demand/FudousanDeleteConfirm" method="post">
        <table class="type_list">
          <colgroup>
            <col width="15%"/>
            <col width="30%"/>
            <col width="50%"/>
            <col width="5%"/>
          </colgroup>
          <tr>
            <th>不動産会社コード</th>
            <th>不動産会社名</th>
            <th>住所</th>
            <th>削除</th>
          </tr>
          <c:forEach items="${view.detailList}" var="detail">
            <tr>
              <td>
                <html:link action="demand/FudousanInfoPage" paramId="fudousanCd" paramName="detail" paramProperty="fudousanCd" target="_blank">
                  <c:out value="${detail.fudousanCd}" />
                </html:link>
              </td>
              <td align="left"><c:out value="${detail.fudousanName}" /></td>
              <td align="left"><c:out value="${detail.prefName}" /><c:out value="${detail.address1}" /><c:out value="${detail.address2}" /></td>
              <td>
                <c:choose>
                  <c:when test="${detail.delFlg ne '0'}">
                    -
                  </c:when>
                  <c:otherwise>
                    <c:choose>
                      <c:when test="${detail.delKbn eq 'checked'}">
                        <input type="checkbox" name="fudousanCd" value="${detail.fudousanCd}" checked="checked">
                      </c:when>
                      <c:otherwise>
                        <input type="checkbox" name="fudousanCd" value="${detail.fudousanCd}">
                      </c:otherwise>
                    </c:choose>
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
          </c:forEach>
        </table>
        <p class="under_table"><input type="submit" value="チェックした不動産会社を削除"></p>
      </html:form>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
