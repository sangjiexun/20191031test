<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ情報追加" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<script type="text/javascript">

 addEvent('load', window, function(){document.getElementsByName('commit')[0].focus();});

</script>
<c:set value="${AspShopInfoView}" var="view"/>
<c:set var="title" value="グループ情報追加"></c:set>
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
          <td>${view.title}</td>
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
    <p class="section_header">グループ追加する店舗の確認</p>
    <html:form action="/shop_bukken/AspGroupAddCommit" method="post" onsubmit="disableSubmit(this)">
      <c:if test="${not empty AspShopInfoView.aspGroupList}" >
          <table class="type_list">
            <tr>
              <th>店舗コード</th>
              <th>会社名<br>事務所名</th>
              <th>承認<br>状態</th>
              <th>CHINTAI掲載<br>エイブル掲載</th>
              <th>連動元</th>
             </tr>
          <c:forEach items="${AspShopInfoView.aspGroupList}" var="groupList">
            <tr>
              <td>${groupList.groupshopCd}
                <input type="hidden" value="${groupList.groupshopCd}" name="groupshopCd" >
                <input type="hidden" value="${groupList.aspShopSeq}" name="aspShopSeq" >
                <input type="hidden" value="${groupList.aspFlg}" name="aspFlg" >
                <input type="hidden" value="${groupList.shopStatus}" name="shopStatus" >
              </td>
              <td><c:out value="${groupList.company}"/><br><c:out value="${groupList.bumon}"/></td>
              <td>
                <c:if test="${groupList.certifyFlg == '0'}"><font color="#FF3333"></c:if>
                  <chintai:CodePrint nameKey="SHOPBUKKEN_CERTIFY_FLG_NAME" valueKey="SHOPBUKKEN_CERTIFY_FLG_VALUE" code="${groupList.certifyFlg}"/>
                <c:if test="${groupList.certifyFlg == '0'}"></font></c:if>
                <br>
                <c:if test="${groupList.shopStatus == '0'}"><font color="#FF3333"></c:if>
                  <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${groupList.shopStatus}"/>
                <c:if test="${groupList.shopStatus == '0'}"></font></c:if>
              </td>
              <td>
                <c:if test="${groupList.ctFlg == '0'}"><font color="#FF3333"></c:if>
                  <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${groupList.ctFlg}"/>
                <c:if test="${groupList.ctFlg == '0'}"></font></c:if>
                <br>
                <c:if test="${groupList.ablFlg == '0'}"><font color="#FF3333"></c:if>
                  <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${groupList.ablFlg}"/>
                <c:if test="${groupList.ablFlg == '0'}"></font></c:if>
              </td>
             <td>
                ${groupList.rendoName}
              </td>
            </tr>
        </c:forEach>
        </table>
      </c:if>
      <p>
        <input type="hidden" value="${view.shopCd}" name="shopCd" >
        <input type="hidden" value="${view.shopKanriUpdDt}" name="shopKanriUpdDt" >
        <input type="submit" value="グループへ追加" name="commit">
        <input type="button" name="back" value="戻る" onClick="_submit('AspGroupAddPage.do')">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
