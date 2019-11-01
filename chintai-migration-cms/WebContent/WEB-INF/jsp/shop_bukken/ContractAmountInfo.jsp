<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view"  value="${ContractAmountInfoView}" />
<c:set var="title" value="${ContractAmountInfoView.keiyakuName}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">
<!--
//addEvent('load', window, function(){document.getElementsByName('')[0].focus();});
-->
</script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo.do">
      <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
        ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <p class="section_header">店舗コード</p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
         <td>
          <c:out value="${view.company}" />
          <c:if test="${not empty view.company and not empty view.bumon}"> / </c:if>
          <c:out value="${view.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td> <c:out value="${view.shopCd}" /></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td>
          <c:out value="${view.password}" />
        </td>
      </tr>
    </table>

    <!--物件枠設定情報-->
    <p class="section_header">${title}設定情報</p>
    <html:form action="/shop_bukken/ContractAmountDeleteConfirm.do">
    <p>&gt;&gt;<a href="javascript:_submit('ContractAmountAddPage.do')">新しい${title}を登録する</a></p>
    <p>※現在適用されている${title}は黄色で表示されます。</p>
      <table class="type_list">
        <colgroup>
          <col width="25%">
          <col width="15%">
          <col width="25%">
          <col width="15%">
          <col width="10%">
          <col width="10%">
        </colgroup>
        <tr>
          <th>契約期間</th>
          <th>${title}</th>
          <th>備考</th>
          <th>更新日</th>
          <th>削除</th>
          <th>予約元</th>
        </tr>
        <c:forEach items="${view.wakuInfoList}" var="detail">
          <tr bgcolor="${detail.appliedFlg}">
            <td>
              <c:choose>
                <c:when test="${not empty detail.linkFlg}">
                   <a href="javascript:_submit('ContractAmountUpdatePage.do?keiyakuNo=${detail.keiyakuNo}')">${detail.keiyakuStartYmForDisplay}～
                   <c:if test="${detail.keiyakuEndDt != '99999999999999'}" >
                    <c:out value="${detail.keiyakuEndYmForDisplay}"/>
                   </c:if>
                   </a>
                </c:when>
                <c:otherwise>
                  <c:out value="${detail.keiyakuStartYmForDisplay}"/>～<c:out value="${detail.keiyakuEndYmForDisplay}"/>
                </c:otherwise>
              </c:choose>
            </td>
            <td class="right"><c:out value="${detail.wakuCnt}" />件</td>
            <td align="left">
              <c:out value="${detail.keiyakuNote}" />
            </td>
            <td class="right"><c:out value="${detail.updDt}" /></td>
            <td>
            <c:choose>
              <c:when test="${not empty detail.delFlg}">
                <c:choose>
                  <c:when test="${not empty detail.checkFlg}">
                    <input type="checkbox" name="delFlgList" value="${detail.keiyakuNo}" checked="checked" />
                  </c:when>
                  <c:otherwise>
                    <input type="checkbox" name="delFlgList" value="${detail.keiyakuNo}" />
                  </c:otherwise>
                </c:choose>
              </c:when>
              <c:otherwise>
                -
              </c:otherwise>
            </c:choose>
            </td>
            <td>
              <chintai:CodePrint nameKey="RESERVE_KBN_NAME" valueKey="RESERVE_KBN_VALUE" code="${detail.reserveKbn}"/>
            </td>
          </tr>
        </c:forEach>
        <c:if test="${empty view.wakuInfoList}">
          <tr><td colspan="6" class="center">${title}設定情報が登録されていません。</td></tr>
        </c:if>
      </table>
      <div class="add_from">
        <input type="hidden" name="keiyakuCd"   value="${view.keiyakuCd}">
        <input type="hidden" name="shopCd"   value="${view.shopCd}">
        <input type="hidden" name="keiyakuSubCd"   value="${view.keiyakuSubCd}">
        <c:if test="${not empty view.wakuInfoList}">
          <p align="right"><input type="submit" value="チェックした${title}設定情報を削除"></p>
        </c:if>
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
