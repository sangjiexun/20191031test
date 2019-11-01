<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産ASP設定情報" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${AspShopInfoView.shopCd}"/></c:url>">
        店舗・契約詳細
      </a> &gt;
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

    <c:if test="${not empty AspShopInfoView.ensenTypeList}">
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>ASPサービスURL</th>
        <td>
          <fmt:setBundle basename="resources.server" var="resource" />
          <fmt:message bundle="${resource}" key="chintai.aspServiceUrl" var="aspServiceUrl">
            <fmt:param><c:out value="${AspShopInfoView.shopCd}" /></fmt:param>
          </fmt:message>
          <a href="${aspServiceUrl}" target="_blank">${aspServiceUrl}</a>
        </td>
      </tr>
    </table>
    </c:if>

    <c:if test="${AspShopInfoView.layout == null}">
      <p class="section_header">基本情報</p>
      <p>不動産ASP情報が設定されていません。</p>
      <p>
        <a href ="<c:url value="AspAddPage.do"><c:param name="shopCd" value="${AspShopInfoView.shopCd}"/></c:url>">
          &gt;&gt; 不動産ASP設定情報を登録する
        </a>
      </p>
    </c:if>

    <c:if test="${not empty AspShopInfoView.ensenTypeList}">
      <p class="section_header">基本設定</p>
      <p>
        <a href ="<c:url value="AspUpdate.do"><c:param name="shopCd" value="${AspShopInfoView.shopCd}"/></c:url>">
          &gt;&gt; 不動産ASP設定情報を編集する
        </a>
      </p>
      <table class="type_detail">
        <colgroup>
          <col width="22%">
          <col width="78%">
        </colgroup>
        <tr>
          <th>タイトル表示用</th>
          <td><c:out value="${AspShopInfoView.title}"/></td>
        </tr>
        <tr>
          <th>画面レイアウト</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="${AspShopInfoView.layout}"/>
          </td>
        </tr>
        <tr>
          <th>セレクトボックスタイプ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="${AspShopInfoView.selectBoxType}"/>
          </td>
        </tr>
        <tr>
          <th>テンプレートカラー</th>
          <td>
            <c:if test = "${AspShopInfoView.templateColor == 'gray' }">
              <span style="color:#759F94">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspShopInfoView.templateColor}"/>
            </c:if>
            <c:if test = "${AspShopInfoView.templateColor == 'yellow' }">
              <span style="color:#F79400">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspShopInfoView.templateColor}"/>
            </c:if>
            <c:if test = "${AspShopInfoView.templateColor == 'purple' }">
              <span style="color:#6868FF">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspShopInfoView.templateColor}"/>
            </c:if>
            <c:if test = "${AspShopInfoView.templateColor == 'kimidori' }">
              <span style="color:#84C146">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspShopInfoView.templateColor}"/>
            </c:if>
            <c:if test = "${AspShopInfoView.templateColor == 'red' }">
              <span style="color:#FF2020">■</span>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="${AspShopInfoView.templateColor}"/>
            </c:if>
          </td>
        </tr>
        <tr>
          <th>検索条件付加項目</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="${AspShopInfoView.searchItem}"/>
          </td>
        </tr>
        <tr>
          <th>会社ロゴ</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_LOGO_FLG_NAME" valueKey="SHOPBUKKEN_ASP_LOGO_FLG_VALUE" code="${AspShopInfoView.logoFlg}"/>
            <c:if test = "${AspShopInfoView.logoFlg == '1' }">
              <br><img src="https://${AspShopInfoView.imgUrlPath}${AspShopInfoView.imgFileNm}?resize=227:*">
            </c:if>
          </td>
        </tr>
        <tr>
          <th>個人情報保護方針</th>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_POLICY_FLG_NAME" valueKey="SHOPBUKKEN_ASP_POLICY_FLG_VALUE" code="${AspShopInfoView.policyFlg}"/>
          </td>
        </tr>
      </table>

      <p class="section_header">エリア設定</p>
      <p>検索対象のエリア、およびその表示順です。</p>
      <table class="type_asp_areaview">
        <tr>
          <th>対象の都道府県</th>
          <th>表示順</th>
        </tr>
        <c:forEach items="${AspShopInfoView.prefList}" var="prefList" varStatus="i">
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

      <p class="section_header">沿線設定</p>
      <p>沿線の表示順です。</p>
      <table class="type_asp_areaview">
        <tr>
          <th>沿線</th>
          <th>表示順</th>
        </tr>
        <c:forEach items="${AspShopInfoView.ensenTypeList}" var="ensenTypeList" varStatus="i">
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
    </c:if>
    <p class="section_header">グループ情報</p>
    <c:if test="${AspShopInfoView.layout != null}">
    <p><a href="<c:url value="AspGroupAddPage.do">
                <c:param name="shopCd" value="${AspShopInfoView.shopCd}"/>
                </c:url>">
       >> グループ化する店舗を設定する</a>
    </p>
    </c:if>
    <c:choose>
      <c:when test="${not empty AspShopInfoView.aspGroupList}" >
          <table class="type_list">
            <tr>
              <th>店舗コード</th>
              <th>会社名<br>事務所名</th>
              <th>店舗状態<br>不動産ASP状態</th>
              <th>最終更新日時</th>
              <th>状態変更</th>
              <th>解除</th>
            </tr>
        <html:form  method="post">
          <c:forEach items="${AspShopInfoView.aspGroupList}" var="groupList">
            <tr>
              <td>${groupList.groupshopCd}</td>
              <td><c:out value="${groupList.company}"/><br><c:out value="${groupList.bumon}"/></td>
              <td>
                <c:if test="${groupList.shopStatus == '0'}"><font color="#FF3333"></c:if>
                  <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${groupList.shopStatus}"/>
                <c:if test="${groupList.shopStatus == '0'}"></font></c:if>
                <br>
                <c:if test="${groupList.aspFlg == '1'}"><font color="#FF3333"></c:if>
                <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_ASP_SHOP_STATUS_VALUE" code="${groupList.aspFlg}"/>
                <c:if test="${groupList.aspFlg == '1'}"></font></c:if>
              </td>
              <td>${groupList.updDt}</td>
              <td>
                <input type="button" value="更新" onClick="_submit('AspGroupUpdatePage.do?groupshopCd=${groupList.groupshopCd}&shopCd=${AspShopInfoView.shopCd}')">
              </td>
              <td>
                <c:if test="${groupList.delFlg != null}">
                  <input type="checkbox" value="${groupList.groupshopCd}" name="groupshopCd" checked>
                  <input type="hidden" value="" name="groupshopCd">
                </c:if>
                <c:if test="${groupList.delFlg == null}">
                  <input type="checkbox" value="${groupList.groupshopCd}" name="groupshopCd">
                </c:if>
              </td>
            </tr>
        </c:forEach>
        </table>
        <div align="right">
          <input type="button" value="グループから外す" onClick="_submit('AspGroupDeleteConfirm.do?shopCd=${AspShopInfoView.shopCd}')">
        </html:form>
        </div>
      </c:when>
      <c:otherwise>
        <p>不動産ASP情報が設定されていません。</p>
      </c:otherwise>
    </c:choose>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
