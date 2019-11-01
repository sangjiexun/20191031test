<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ情報追加"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('groupshopCd')[0].focus();});
</script>

<c:set value="${AspShopInfoView}" var="view"/>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        店舗・契約詳細
      </a> &gt;
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
      不動産ASP設定情報</a> &gt;
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
          <c:out value="${AspShopInfoView.company}" />
          <c:if test="${not empty AspShopInfoView.company and not empty AspShopInfoView.bumon}"> / </c:if>
          <c:out value="${AspShopInfoView.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${AspShopInfoView.shopCd}"/></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${AspShopInfoView.password}"/></td>
      </tr>
    </table>


    <p class="section_header">基本設定</p>
    <table class="type_detail">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th>タイトル表示用</th>
          <td><c:out value="${view.title}" /></td>
        </tr>
        <tr>
          <th>画面レイアウト</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="${view.layout}"/>
          </td>
        </tr>
        <tr>
          <th>セレクトボックスタイプ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="${view.selectBoxType}"/>
          </td>
        </tr>
        <tr>
          <th>テンプレートカラー</th>
          <td>
            <c:if test = "${view.templateColor == 'gray' }">
              <span style="color:#759F94">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${view.templateColor}"/>
            </c:if>
            <c:if test = "${view.templateColor == 'yellow' }">
              <span style="color:#F79400">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${view.templateColor}"/>
            </c:if>
            <c:if test = "${view.templateColor == 'purple' }">
              <span style="color:#6868FF">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${view.templateColor}"/>
            </c:if>
            <c:if test = "${view.templateColor == 'kimidori' }">
              <span style="color:#84C146">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${view.templateColor}"/>
            </c:if>
            <c:if test = "${view.templateColor == 'red' }">
              <span style="color:#FF2020">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${view.templateColor}"/>
            </c:if>
          </td>
        </tr>
        <tr>
          <th>検索条件付加項目</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="${view.searchItem}"/>
          </td>
        </tr>
        <tr>
          <th>会社ロゴ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_LOGO_FLG_NAME" valueKey="SHOPBUKKEN_ASP_LOGO_FLG_VALUE" code="${view.logoFlg}"/>
          </td>
        </tr>
        <tr>
          <th>個人情報保護方針</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_POLICY_FLG_NAME" valueKey="SHOPBUKKEN_ASP_POLICY_FLG_VALUE" code="${view.policyFlg}"/>
            <c:if test="${view.policyFlg != '0'}"><br/><c:out value="${view.policyUrl}" ></c:out></c:if>
          </td>
        </tr>
        <tr>
          <th>不動産ASP状態</th>
          <td>
            <c:if test="${view.aspShopStatus == '1'}"><font color="#FF3333"></c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_ASP_SHOP_STATUS_VALUE" code="${view.aspShopStatus}"/>
            <c:if test="${view.aspShopStatus == '1'}"></font></c:if>
          </td>
        </tr>
        <tr>
          <th>登録日時</th>
          <td>${view.insDt}</td>
        </tr>
        <tr>
          <th>最終更新日時</th>
          <td>${view.updDt}</td>
        </tr>
      </table>

    <p class="section_header">店舗の追加</p>
    <html:form  action="/shop_bukken/AspGroupAddConfirm" method="post" onsubmit="disableSubmit(this)">
      <div class="add_form">
        <div class="add_form_title">店舗コード <span class="caution">*</span></div>
        <div class="annotation">グループに追加する店舗の店舗コードを指定します。</div>
        <div class="form_space">
          <input type="text" name="groupshopCd" size="10" maxlength="9" value="${fn:escapeXml(param.groupshopCd)}">
        </div>
      </div>
      <p>
        <input type="hidden" value="${fn:escapeXml(view.shopCd)}" name="shopCd">
        <input type="hidden" value="${fn:escapeXml(view.company)}" name="company" >
        <input type="hidden" value="${fn:escapeXml(view.bumon)}" name="bumon" >
        <input type="hidden" value="${fn:escapeXml(view.password)}" name="password" >
        <input type="hidden" value="${fn:escapeXml(view.title)}" name="title" >
        <input type="hidden" value="${fn:escapeXml(view.layout)}" name="layout" >
        <input type="hidden" value="${fn:escapeXml(view.selectBoxType)}" name="selectBoxType" >
        <input type="hidden" value="${fn:escapeXml(view.templateColor)}" name="templateColor" >
        <input type="hidden" value="${fn:escapeXml(view.searchItem)}" name="searchItem" >
        <input type="hidden" value="${fn:escapeXml(view.logoFlg)}" name="logoFlg" >
        <input type="hidden" value="${fn:escapeXml(view.policyFlg)}" name="policyFlg" >
        <input type="hidden" value="${fn:escapeXml(view.policyUrl)}" name="policyUrl" >
        <input type="hidden" value="${fn:escapeXml(view.aspShopStatus)}" name="aspShopStatus" >
        <input type="hidden" value="${fn:escapeXml(view.insDt)}" name="insDt" >
        <input type="hidden" value="${fn:escapeXml(view.updDt)}" name="updDt" >
        <input type="hidden" value="${fn:escapeXml(view.shopKanriUpdDt)}" name="shopKanriUpdDt" >
        <input type="submit" value="確認画面へ">
        <input type="button" name="back" value="戻る" onClick="_submit('AspShopInfo.do')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
