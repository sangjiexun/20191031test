<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="view" value="${RendoSendInfoView}" />
<c:set var="title" value="${view.keiyakuName}情報" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<div id="main">
  <%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/master/RendoSendList.do">連動元別出稿管理 </html:link>&gt; ${view.keiyakuName}情報
    </div>
    <h1>${view.keiyakuName}情報</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>
    <p class="section_header">連動元コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>連動元コード</th>
        <td>
          <c:out value="${view.rendoCd}" />
        </td>
      </tr>
      <tr>
        <th>連動元名称</th>
        <td>
          <c:out value="${view.rendoName}" />
        </td>
      </tr>
      <tr>
        <th>連動元会社名</th>
        <td>
          <c:out value="${view.rendoCompany}" />
        </td>
      </tr>
    </table>
    <!--${keiyakuName}設定情報-->
    <p class="section_header">${view.keiyakuName}情報</p>
    <p>&gt;&gt;
      <a href="RendoSendUpdatePage.do?rendoCd=${view.rendoCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}">新しい出稿許可期間を登録する</a>
    </p>
    <div class="add_form">
      <div class="form_space">
        <div class="annotation">※現在適用されている許可期間は黄色で表示されます。 </div>
      </div>
    </div>
    <p></p>
    <table class="type_list_pre">
      <colgroup>
        <col width="30%">
        <col width="40%">
        <col width="20%">
        <col width="10%">
      </colgroup>
      <tr>
        <th>出稿許可期間</th>
        <th>備考</th>
        <th>更新日</th>
        <th>削除</th>
      </tr>
      <c:forEach items="${view.rendoSendDetailList}" var="detail">
        <tr
          <c:if test="${detail.appliedFlg == '1'}">bgcolor="FFFF99"</c:if>>
          <td>
            <c:choose>
              <c:when test="${detail.linkFlg == '1'}">
                <a href="RendoSendUpdatePage.do?rendoSendNo=${detail.rendoSendNo}&rendoCd=${view.rendoCd}&keiyakuCd=${view.keiyakuCd}&keiyakuSubCd=${view.keiyakuSubCd}">${detail.permitStartYmForDisplay}～
                  <c:if test="${detail.permitEndDt != '99991231235959'}" >
                    <c:out value="${detail.permitEndYmForDisplay}"/>
                  </c:if>
                </a>
              </c:when>
              <c:otherwise>
                <c:out value="${detail.permitStartYmForDisplay}"/>～
                <c:if test="${detail.permitEndDt != '99991231235959'}" >
                  <c:out value="${detail.permitEndYmForDisplay}"/>
                </c:if>
              </c:otherwise>
            </c:choose>
          </td>
          <td align="left">
            <c:out value="${detail.note}" />
          </td>
          <td>
            <c:out value="${detail.updDt}"/>
          </td>
          <td>
            <c:choose>
              <c:when test="${detail.delFlg == '1'}">
                <html:form action="/master/RendoSendDeleteConfirm.do">
                  <input type="hidden" name="procKbn" value="delete">
                  <input type="submit" value="削除" >
                  <input type="hidden" name="permitStartDt" value="${detail.permitStartDt}">
                  <input type="hidden" name="permitEndDt" value="${detail.permitEndDt}">
                  <input type="hidden" name="rendoSendNo" value="${detail.rendoSendNo}">
                  <input type="hidden" name="rendoCd" value="${view.rendoCd}">
                  <input type="hidden" name="keiyakuCd" value="${view.keiyakuCd}">
                  <input type="hidden" name="keiyakuSubCd" value="${view.keiyakuSubCd}">
                </html:form>
              </c:when>
              <c:otherwise>- </c:otherwise>
            </c:choose>
          </td>
        </tr>
      </c:forEach>
      <c:if test="${empty view.rendoSendDetailList}">
        <tr>
          <td colspan="5" class="center">出稿許可期間が登録されていません。</td>
        </tr>
      </c:if>
    </table>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>