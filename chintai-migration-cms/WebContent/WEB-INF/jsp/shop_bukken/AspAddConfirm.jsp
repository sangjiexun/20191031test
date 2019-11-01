<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産ASP設定情報登録"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${AspAddConfirmView.shopCd}"/></c:url>">
        店舗・契約詳細
      </a>&gt;
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${AspAddConfirmView.shopCd}"/></c:url>">
        不動産ASP設定情報
      </a>&gt;
        ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header">店舗コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${AspAddConfirmView.company}" />
          <c:if test="${not empty AspAddConfirmView.company and not empty AspAddConfirmView.bumon}"> / </c:if>
          <c:out value="${AspAddConfirmView.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${AspAddConfirmView.shopCd}"/></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${AspAddConfirmView.password}"/></td>
      </tr>
    </table>

    <p class="section_header">登録内容確認(基本情報)</p>
    <html:form action="/shop_bukken/AspAddCommit" method="post" onsubmit="disableSubmit(this)">
      <table class="type_detail">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th>タイトル表示用</th>
          <td><c:out value="${AspAddConfirmView.title}" /></td>
        </tr>
        <tr>
          <th>画面レイアウト</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="${AspAddConfirmView.layout}"/>
          </td>
        </tr>
        <tr>
          <th>セレクトボックスタイプ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="${AspAddConfirmView.selectBoxType}"/>
          </td>
        </tr>
        <tr>
          <th>テンプレートカラー</th>
          <td>
            <c:if test = "${AspAddConfirmView.templateColor == 'gray' }">
              <span style="color:#759F94">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspAddConfirmView.templateColor}"/>
            </c:if>
            <c:if test = "${AspAddConfirmView.templateColor == 'yellow' }">
              <span style="color:#F79400">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspAddConfirmView.templateColor}"/>
            </c:if>
            <c:if test = "${AspAddConfirmView.templateColor == 'purple' }">
              <span style="color:#6868FF">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspAddConfirmView.templateColor}"/>
            </c:if>
            <c:if test = "${AspAddConfirmView.templateColor == 'kimidori' }">
              <span style="color:#84C146">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspAddConfirmView.templateColor}"/>
            </c:if>
            <c:if test = "${AspAddConfirmView.templateColor == 'red' }">
              <span style="color:#FF2020">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspAddConfirmView.templateColor}"/>
            </c:if>
          </td>
        </tr>
        <tr>
          <th>検索条件付加項目</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="${AspAddConfirmView.searchItem}"/>
          </td>
        </tr>
        <tr>
          <th>会社ロゴ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_LOGO_FLG_NAME" valueKey="SHOPBUKKEN_ASP_LOGO_FLG_VALUE" code="${AspAddConfirmView.logoFlg}"/>
            <c:if test="${AspAddConfirmView.imgUrlPath != null}">
              <br><img src="${pageContext.request.contextPath}${AspAddConfirmView.imgUrlPath}${AspAddConfirmView.imgFileNm}">
            </c:if>
          </td>
        </tr>
        <tr>
          <th>個人情報保護方針</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_POLICY_FLG_NAME" valueKey="SHOPBUKKEN_ASP_POLICY_FLG_VALUE" code="${AspAddConfirmView.policyFlg}"/>
            <br>
            ${AspAddConfirmView.policyUrl}
          </td>
        </tr>
      </table>

      <p class="section_header">登録内容確認(エリア設定)</p>
      <p>検索対象のエリア、およびその表示順です。</p>
      <table class="type_asp_areaview">
        <tr>
          <th>対象の都道府県</th>
          <th>表示順</th>
        </tr>
        <c:forEach items="${AspAddConfirmView.prefList}" var="prefList" varStatus="i">
          <tr>
            <td>
              <c:out value="${prefList.prefName}"></c:out>
            </td>
            <td>
              <c:out value="${prefList.prefSortKey}"></c:out>
            </td>
          </tr>
        </c:forEach>
      </table>
      <p class="section_header">登録内容確認(沿線設定)</p>
      <p>沿線の表示順です。</p>
      <table class="type_asp_areaview">
        <tr>
          <th>沿線</th>
          <th>表示順</th>
        </tr>
        <c:forEach items="${AspAddConfirmView.ensenTypeList}" var="ensenTypeList" varStatus="i">
          <tr>
            <td>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="${ensenTypeList.ensenCd}"/>
            </td>
            <td>
              <c:out value="${i.count}"></c:out>
            </td>
          </tr>
        </c:forEach>
      </table>
      <p>
        <input type="hidden" name="shopCd" value="${fn:escapeXml(AspAddConfirmView.shopCd)}">
        <input type="hidden" name="company" value="${fn:escapeXml(AspAddConfirmView.company)}">
        <input type="hidden" name="bumon" value="${fn:escapeXml(AspAddConfirmView.bumon)}">
        <input type="hidden" name="password" value="${fn:escapeXml(AspAddConfirmView.password)}">
        <input type="hidden" name="title" value="${fn:escapeXml(AspAddConfirmView.title)}">
        <input type="hidden" name="layout" value="${fn:escapeXml(AspAddConfirmView.layout)}">
        <input type="hidden" name="selectBoxType" value="${fn:escapeXml(AspAddConfirmView.selectBoxType)}">
        <input type="hidden" name="templateColor" value="${fn:escapeXml(AspAddConfirmView.templateColor)}">
        <input type="hidden" name="searchItem" value="${fn:escapeXml(AspAddConfirmView.searchItem)}">
        <input type="hidden" name="logoFlg" value="${fn:escapeXml(AspAddConfirmView.logoFlg)}">
        <input type="hidden" name="imgRealPath" value="${fn:escapeXml(AspAddConfirmView.imgRealPath)}">
        <input type="hidden" name="imgUrlPath" value="${fn:escapeXml(AspAddConfirmView.imgUrlPath)}">
        <input type="hidden" name="imgFileNm" value="${fn:escapeXml(AspAddConfirmView.imgFileNm)}">
        <input type="hidden" name="imgKbn" value="${fn:escapeXml(AspAddConfirmView.imgKbn)}">
        <input type="hidden" name="imgFileType" value="${fn:escapeXml(AspAddConfirmView.imgFileType)}">
        <input type="hidden" name="policyFlg" value="${fn:escapeXml(AspAddConfirmView.policyFlg)}">
        <input type="hidden" name="policyUrl" value="${fn:escapeXml(AspAddConfirmView.policyUrl)}">
        <input type="hidden" name="imgId" value="${fn:escapeXml(AspAddConfirmView.imgId)}">
        <input type="hidden" name="aspShopStatus" value="0">
        <input type="hidden" name="shopKanriUpdDt" value="${fn:escapeXml(AspAddConfirmView.shopKanriUpdDt)}">
        <c:forEach items="${AspAddConfirmView.prefList}" var="prefList" varStatus="i">
          <input type="hidden" name="pref${prefList.prefCd}" value="${fn:escapeXml(prefList.prefSortKey)}">
        </c:forEach>
        <c:forEach items="${AspAddConfirmView.ensenTypeList}" var="ensenTypeList" varStatus="i">
          <input type="hidden" name="ensenCd${ensenTypeList.ensenCd}" value="${fn:escapeXml(ensenTypeList.ensenSortKey)}">
          <input type="hidden" name="ensenType${i.count}" value="${fn:escapeXml(ensenTypeList.ensenCd)}">
        </c:forEach>
        <input type="submit" value="登録" name="commit">
        <input type="button" value="戻る" onClick="_submit('AspAddConfirmBack.do');">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
