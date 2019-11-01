<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件検索" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});
</script>
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
    <p class="section_header">物件情報から検索</p>
    <html:form method="get" action="/shop_bukken/BukkenCodeSearch.do">
    <table class="type_searchbox">
      <tr>
        <td>店舗コード</td>
        <td>
          <input type="text" name="shopCd" size="9" maxlength="9" value="${param.shopCd}" />
        </td>
        <td>物件コード</td>
        <td>
          <input type="text" name="bkCd" size="17" maxlength="15" value="${param.bkCd}" />
        </td>
        <td>部屋連番</td>
        <td>
          <input type="text" name="roomNo" size="3" maxlength="4" value="${param.roomNo}" />
        </td>
        <td>号室</td>
        <td>
          <input type="text" name="roomCd" size="12" maxlength="60" value="${param.roomCd}" />
        </td>
      </tr>
      <tr>
        <td>物件管理コード&nbsp;&nbsp;</td>
        <td colspan="7">
          <input type="text" name="bkKanri" size="35" maxlength="30" value="${param.bkKanri}" />
        </td>
      </tr>
      <tr>
        <td>お問い合せ番号</td>
        <td colspan="7">
          <input type="text" name="uketukeCd" size="40" maxlength="40" value="${param.uketukeCd}" />
        </td>
      </tr>
      <tr>
        <td>物件名／物件名カナ</td>
        <td colspan="7">
          <input type="text" name="bkName" size="40" maxlength="120" value="${param.bkName}" />
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
        <td>
          <html:submit value="検索" />
          <html:reset value="クリア" />
        </td>
      </tr>
    </table>
          ※「店舗コード」、「物件コード」、「物件管理コード」、「お問い合せ番号」、「物件名／物件名カナと店舗コード」項目のいずれかに入力してください。
    </html:form>
    <c:if test="${BukkenListView.bukkenList != null}">
    <c:if test="${BukkenListView.count != 0}">
    <!-- 検索結果 -->
    <p class="section_header">検索結果</p>
    <table class="type_list">
      <colgroup>
      </colgroup>
      <tr>
        <th>お問い合せ番号</th>
        <th>管理コード</th>
        <th>物件名称<br>カナ</th>
        <th>会社名<br>事務所名<br>店舗メールアドレス</th>
        <th>掲載状態<br>管理最終更新日時</th>
        <th>入稿状態<br>最終入稿登録日時</th>
        <th>最終フロント反映日時</th>
      </tr>
      <c:forEach items="${BukkenListView.bukkenList}" var="bukken">
      <tr>
        <td>
          <c:out value="${bukken.uketukeCd}" />
        </td>
        <td>
          <html:link action="/shop_bukken/BukkenInfo.do" target="_blank">
          <html:param name="roomKey" value="${bukken.roomKey}" />
          <c:out value="${bukken.shopCd}" />-<c:out value="${bukken.bkCd}" />-<c:out value="${bukken.roomNo}" />
          </html:link>
        </td>
        <td>
          <c:out value="${bukken.bkName}" /><br>
          <c:out value="${bukken.bkKana}" />
        </td>
        <td>
          <c:out value="${bukken.company}" /><br>
          <c:out value="${bukken.bumon}" /><br>
          <c:if test="${bukken.email1 != null}">
            <c:out value="${bukken.email1}" />(<chintai:CodePrint nameKey="EMAIL_USE_KBN_NAME" valueKey="EMAIL_USE_KBN_VALUE" code="${bukken.emailUseKbn1}" />)
            <c:set var="kaigyoFlg" value="true"></c:set>
          </c:if>
          <c:if test="${bukken.email2 != null}">
            <c:if test="${kaigyoFlg eq 'true'}"><br></c:if>
            <c:out value="${bukken.email2}" />(<chintai:CodePrint nameKey="EMAIL_USE_KBN_NAME" valueKey="EMAIL_USE_KBN_VALUE" code="${bukken.emailUseKbn2}" />)
            <c:set var="kaigyoFlg" value="true"></c:set>
          </c:if>
          <c:if test="${bukken.email3 != null}">
            <c:if test="${kaigyoFlg eq 'true'}"><br></c:if>
            <c:out value="${bukken.email3}" />(<chintai:CodePrint nameKey="EMAIL_USE_KBN_NAME" valueKey="EMAIL_USE_KBN_VALUE" code="${bukken.emailUseKbn3}" />)
            <c:set var="kaigyoFlg" value="true"></c:set>
          </c:if>
          <c:if test="${bukken.email4 != null}">
            <c:if test="${kaigyoFlg eq 'true'}"><br></c:if>
            <c:out value="${bukken.email4}" />(<chintai:CodePrint nameKey="EMAIL_USE_KBN_NAME" valueKey="EMAIL_USE_KBN_VALUE" code="${bukken.emailUseKbn4}" />)
            <c:set var="kaigyoFlg" value="true"></c:set>
          </c:if>
          <c:if test="${bukken.email5 != null}">
            <c:if test="${kaigyoFlg eq 'true'}"><br></c:if>
            <c:out value="${bukken.email5}" />(<chintai:CodePrint nameKey="EMAIL_USE_KBN_NAME" valueKey="EMAIL_USE_KBN_VALUE" code="${bukken.emailUseKbn5}" />)
            <c:set var="kaigyoFlg" value="true"></c:set>
          </c:if>
          <c:set var="kaigyoFlg" value="false"></c:set>
        </td>
        <td>
          <c:if test="${bukken.ctStopDt != null && bukken.ablStopDt != null}">停止</c:if>
          <c:if test="${bukken.ctStopDt == null || bukken.ablStopDt == null}">通常</c:if>
          <br>
          <c:out value="${bukken.bukkenAdminUpdDt}" />
        </td>
        <td>
          <chintai:CodePrint nameKey="INS_KBN_NAME" valueKey="INS_KBN_VALUE" code="${bukken.insKbn}" /><br>
          <c:out value="${bukken.insDt}" />
        </td>
        <td>
          <c:out value="${bukken.updDt}" />
        </td>
      </tr>
      </c:forEach>
    </table>
    </c:if>
    </c:if>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>