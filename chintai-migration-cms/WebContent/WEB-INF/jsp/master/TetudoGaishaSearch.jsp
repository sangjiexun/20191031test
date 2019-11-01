<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="鉄道会社検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>
<script type="text/javascript">
function page(offSet){
    document.forms[0].offSet.value = offSet;
	_submit('TetudoGaishaSearchPaging.do');
}
</script>

<c:set var="view" value="${TetudoGaishaSearchView}" />

<!-- メイン -->
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/master/RosenIndex.do">沿線･駅メンテナンス </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">検索条件設定</p>
    <html:form action="/master/TetudoGaishaSerach.do" method="get">
      <table class="type_searchbox">
        <tr>
          <td>
            鉄道会社番号
          </td>
          <td>
            <input type="text" name="railwaycoNo" size="5" maxlength="5" value="${param.railwaycoNo}">
          </td>
        </tr>
        <tr>
          <td>
            鉄道会社名称
          </td>
          <td>
            <input type="text" name="railwaycoName" size="15" maxlength="64" value="${param.railwaycoName}">
          </td>
        </tr>
        <tr>
          <td>
            配布停止
          </td>
          <td>
            <chintai:PropertyOptions name="delKbn" fixValue="${view.delKbn}" nameKey="TETUDOGAISHA_DELKBN_NAME" valueKey="TETUDOGAISHA_DELKBN_VALUE"/>
          </td>
        </tr>
      </table>
      <tr>
        <p class="section_header">検索結果の出力方法</p>
        <td>
          <table class="type_searchbox">
            <tr>
              <td>
                ソートキー
              </td>
              <td>
                <chintai:PropertyOptions name="dispSortKey" fixValue="${view.dispSortKey}" nameKey="TETUDOGAISHA_SORT_KEY_NAME" valueKey="TETUDOGAISHA_SORT_KEY_VALUE"/>
              </td>
              <td>
                順序
              </td>
              <td>
                <chintai:PropertyOptions name="orderBy" fixValue="${view.orderBy}" nameKey="ORDER_BY_NAME" valueKey="ORDER_BY_VALUE"/>
              </td>
              <td>
                表示件数
              </td>
              <td>
                <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="${view.displayNum}"/>
              </td>
              <td>
                出力先
              </td>
              <td>
                <chintai:PropertyOptions name="outputMode" fixValue="${view.outputMode}" nameKey="TETUDOGAISHA_OUTPUT_NAME" valueKey="TETUDOGAISHA_OUTPUT_VALUE"/>
              </td>
            </tr>
          </table>
        </td>
      </tr>
      <p>
        <input type="hidden" name="offSet">
        <input type="submit" value="検索">
        <input type="reset" value="クリア">
      </p>
    </html:form>

    <!-- 検索結果 -->
    <c:if test="${not empty TetudoGaishaSearchView.tetudoGaishaSearchList}">
      <p class="section_header">検索結果</p>
      <c:set var="helper" value="${TetudoGaishaSearchView}"/>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list_nomargin">
        <colgroup>
          <col width="30%">
          <col width="40%">
          <col width="15%">
          <col width="15%">
        </colgroup>
        <tr>
          <th>鉄道会社番号</th>
          <th>鉄道会社名称<br>かな</th>
          <th>ソートキー</th>
          <th>配布停止</th>
        </tr>
        <c:forEach items="${TetudoGaishaSearchView.tetudoGaishaSearchList}" var="tetudoGaishaSearchList" varStatus="i">
          <tr>
            <td class="center">${tetudoGaishaSearchList.railwaycoNo}</td>
            <td class="center">${tetudoGaishaSearchList.railwaycoName}<br>${tetudoGaishaSearchList.railwaycoKana}</td>
            <td class="center">${tetudoGaishaSearchList.railwaycoSeq}</td>
            <td class="center">
              <c:if test="${tetudoGaishaSearchList.delKbn == 1}">○</c:if>
            </td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>