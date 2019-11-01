<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ履歴詳細" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>
<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ</html:link> &gt;
      <html:link action="/shop_inquiry/InquiryRecentSearch.do">問い合せ履歴検索</html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    <!-- 店舗情報 -->
    <p class="section_header">店舗情報</p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">店舗コード</th>
        <td><c:out value="${InquiryRecentInfoView.shopCd}" /></td>
      </tr>
      <tr>
        <th class="text-left">店舗パスワード</th>
        <td><c:out value="${InquiryRecentInfoView.password}" /></td>
      </tr>
      <tr>
        <th class="text-left">会社名</th>
        <td><c:out value="${InquiryRecentInfoView.company}" /></td>
      </tr>
      <tr>
        <th class="text-left">事務所名</th>
        <td><c:out value="${InquiryRecentInfoView.bumon}" /></td>
      </tr>
      <tr>
        <th rowspan="2" class="text-left">住所</th>
        <td><c:out value="${InquiryRecentInfoView.address1}" /></td>
      </tr>
      <tr>
        <td><c:out value="${InquiryRecentInfoView.address2}" /></td>
      </tr>
      <tr>
        <th class="text-left">TEL</th>
        <td><c:out value="${InquiryRecentInfoView.tel}" /></td>
      </tr>
      <tr>
        <th class="text-left">FAX</th>
        <td><c:out value="${InquiryRecentInfoView.fax}" /></td>
      </tr>
      <tr>
        <th class="text-left">メールアドレス</th>
        <td>
          <c:if test="${(InquiryRecentInfoView.emailUseKbn1 == '0' || InquiryRecentInfoView.emailUseKbn1 == '1') && InquiryRecentInfoView.email1 != null}"><c:out value="${InquiryRecentInfoView.email1}" /><br></c:if>
          <c:if test="${(InquiryRecentInfoView.emailUseKbn2 == '0' || InquiryRecentInfoView.emailUseKbn2 == '1') && InquiryRecentInfoView.email2 != null}"><c:out value="${InquiryRecentInfoView.email2}" /><br></c:if>
          <c:if test="${(InquiryRecentInfoView.emailUseKbn3 == '0' || InquiryRecentInfoView.emailUseKbn3 == '1') && InquiryRecentInfoView.email3 != null}"><c:out value="${InquiryRecentInfoView.email3}" /><br></c:if>
          <c:if test="${(InquiryRecentInfoView.emailUseKbn4 == '0' || InquiryRecentInfoView.emailUseKbn4 == '1') && InquiryRecentInfoView.email4 != null}"><c:out value="${InquiryRecentInfoView.email4}" /><br></c:if>
          <c:if test="${(InquiryRecentInfoView.emailUseKbn5 == '0' || InquiryRecentInfoView.emailUseKbn5 == '1') && InquiryRecentInfoView.email5 != null}"><c:out value="${InquiryRecentInfoView.email5}" /><br></c:if>
        </td>
      </tr>
    </table>

    <!-- 問い合せ情報 -->
    <p class="section_header">問い合せ情報</p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">問い合せ日時</th>
        <td><c:out value="${InquiryRecentInfoView.insDt}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せID</th>
        <td><c:out value="${InquiryRecentInfoView.inqId}" /></td>
      </tr>
      <tr>
        <th class="text-left">問い合せ種類</th>
        <td>
          <c:out value="${InquiryRecentInfoView.inqFlgName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">問い合せ元</th>
        <td>
          <c:out value="${InquiryRecentInfoView.sysFlgName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">サイト種別</th>
        <td>
          <c:out value="${InquiryRecentInfoView.siteTypeName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">閲覧状況</th>
        <td>
          <c:out value="${InquiryRecentInfoView.refFlgName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">処理</th>
        <td>
          <c:out value="${InquiryRecentInfoView.inquiryStatusName}" />
        </td>
      </tr>
      <tr>
        <th class="text-left">最終更新日時</th>
        <td><c:out value="${InquiryRecentInfoView.updDt}" /></td>
      </tr>
    </table>

    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">送信時の店舗表記</th>
        <td>
          <c:out value="${InquiryRecentInfoView.sendCompanyNm}" />
          <c:out value="${InquiryRecentInfoView.sendOfficeNm}" />
          <br>
          <c:out value="${InquiryRecentInfoView.sendEmail}" />
        </td>
      </tr>
    </table>

    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">問い合せ者氏名<br>(カナ)</th>
        <td colspan="2">
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upName != null}">
            <c:out value="${InquiryRecentInfoView.upName}" />(
            <c:out value="${InquiryRecentInfoView.upNameKana}" />)
          </c:when>
          <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">性別/生年月日</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upSex != null}">
            <c:out value="${InquiryRecentInfoView.upSex}" />/
          </c:when>
          <c:otherwise>（未記入）/</c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upBirthday != null}">
            <c:out value="${InquiryRecentInfoView.upBirthday}" />
          </c:when>
          <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th rowspan="6" class="text-left">連絡方法</th>
        <td>連絡方法指定 ：
          <c:if test="${InquiryRecentInfoView.upResFlgEmail == '1'}">
            <chintai:CodePrint nameKey="UP_RES_FLG_NAME" valueKey="UP_RES_FLG_VALUE" code="1"/>&nbsp;
          </c:if>
          <c:if test="${InquiryRecentInfoView.upResFlgTel == '1'}">
            <chintai:CodePrint nameKey="UP_RES_FLG_NAME" valueKey="UP_RES_FLG_VALUE" code="2"/>&nbsp;
          </c:if>
          <c:if test="${InquiryRecentInfoView.upResFlgFax == '1'}">
            <chintai:CodePrint nameKey="UP_RES_FLG_NAME" valueKey="UP_RES_FLG_VALUE" code="3"/>&nbsp;
          </c:if>
          <c:if test="${InquiryRecentInfoView.upResFlgOther == '1'}">
            <chintai:CodePrint nameKey="UP_RES_FLG_NAME" valueKey="UP_RES_FLG_VALUE" code="4"/>
          </c:if>
        </td>
      </tr>
      <tr>
        <td>連絡可能時間 ：
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upResTime != null}">
            <c:out value="${InquiryRecentInfoView.upResTime}" />
          </c:when>
          <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <td>メールアドレス ：
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upResEmail != null}">
            <c:out value="${InquiryRecentInfoView.upResEmail}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <td>電話番号 ：
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upResTel != null}">
            <c:out value="${InquiryRecentInfoView.upResTel}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <td>FAX番号 ：
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upResFax != null}">
            <c:out value="${InquiryRecentInfoView.upResFax}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <td>その他連絡方法 ：
        <c:choose>
          <c:when test="${InquiryRecentInfoView.upResOther != null}">
            <c:out value="${InquiryRecentInfoView.upResOther}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">問い合せ内容</th>
        <td>
        <chintai:filter changeNL2BR="true"><c:out value="${InquiryRecentInfoView.upInquiry}" /></chintai:filter>
        </td>
      </tr>
    </table>

    <table class="type_detail_pre">
      <colgroup>
        <col width="20%">
        <col width="80%">
      </colgroup>
      <tr>
        <th class="text-left">引越時期</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubMoveTime != null}">
            <c:out value="${InquiryRecentInfoView.ubMoveTime}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">引越動機</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubMoveReason != null}">
            <c:out value="${InquiryRecentInfoView.ubMoveReason}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">希望エリア・沿線・駅</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubHopeArea != null}">
            <c:out value="${InquiryRecentInfoView.ubHopeArea}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">希望間取り</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubHopeRoom != null}">
            <c:out value="${InquiryRecentInfoView.ubHopeRoom}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">希望家賃</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubHopeRentDown != null}">
            <c:out value="${InquiryRecentInfoView.ubHopeRentDown}" />万円～
          </c:when>
        <c:otherwise>（未記入）万円～</c:otherwise>
        </c:choose>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubHopeRentUp != null}">
            <c:out value="${InquiryRecentInfoView.ubHopeRentUp}" />万円
          </c:when>
        <c:otherwise>（未記入）万円</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">現在家賃</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubNowRent != null}">
            <c:out value="${InquiryRecentInfoView.ubNowRent}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">希望のこだわり内容</th>
        <td>
        <c:choose>
          <c:when test="${InquiryRecentInfoView.ubHopeBody != null}">
            <c:out value="${InquiryRecentInfoView.ubHopeBody}" />
          </c:when>
        <c:otherwise>（未記入）</c:otherwise>
        </c:choose>
        </td>
      </tr>
      <tr>
        <th class="text-left">物件情報</th>
        <td>
          <chintai:filter changeNL2BR="true"><c:out value="${InquiryRecentInfoView.bkInfo}" /></chintai:filter>
        </td>
      </tr>
    </table>
  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>