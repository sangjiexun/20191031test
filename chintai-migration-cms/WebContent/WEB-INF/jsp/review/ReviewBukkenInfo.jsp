<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="物件詳細" />
<c:set var="view" value="${ReviewBukkenInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
<div class="popup_layout">
<div class="topic_path">${title}</div>
<h1>${title}</h1>
<html:errors />
<html:messages id ="msg" message="true" header="info.header" footer="info.footer">
  <c:out value="${msg}"/>
</html:messages>
    <!-- ショートカット -->
    <p>
      <a href="#1">[物件情報]</a>
      <a href="#2">[Web審査状況]</a>
      <a href="#3">[Web審査警告履歴]</a>
      <a href="#5">[店舗情報]</a>
    </p>

    <!-- 物件情報 1 -->
    <p class="section_header"><a name="1">物件情報</a></p>
    <p>
      <fmt:setBundle basename="resources.server" var="resource" />
      <fmt:message bundle="${resource}" key="chintai.bukkenDetailUrl" var="chintaiBukkenDetailUrl">
        <fmt:param><c:out value="${view.shopCd}${view.bkCd}${view.roomNo}" /></fmt:param>
        <fmt:param><c:out value="${view.prefKey}" /></fmt:param>
      </fmt:message>
      <a href="${chintaiBukkenDetailUrl}" target="_blank">&gt;&gt; この物件の CHINTAI.NET での表示を確認する</a>
    </p>
    <p>
      <fmt:message bundle="${resource}" key="able.bukkenDetailUrl" var="ableBukkenDetailUrl">
        <fmt:param><c:out value="${view.shopCd}${view.bkCd.substring(9,15)}${view.roomNo.substring(1,4)}" /></fmt:param>
        <fmt:param><c:out value="${view.prefKey}" /></fmt:param>
      </fmt:message>
      <a href="${ableBukkenDetailUrl}" target="_blank">&gt;&gt; この物件の エイブルでの表示を確認する</a>
    </p>

      <%@ include  file="../shop_bukken/parts/BukkenInfoPart.jsp"  %>

    <!-- 入稿履歴確認ページ表示用リンク 2008.5.16 李昊燮 追加-->
      <p style="margin-bottom: 5px;">
        <a href="
          <c:url value="../shop_bukken/BukkenRirekiInfo.do">
            <c:param name="roomKey" value="${view.roomKey}" />
          </c:url>" target="_blank">
          &gt;&gt;入稿履歴を確認する
        </a>
      </p>

    <!-- Web審査状況 -->
    <p class="section_header"><a name="2">Web審査状況</a></p>
    <c:set var="kanriCd" value="${view.shopCd}-${view.bkCd}-${view.roomNo}" />
    <p><a href="ReviewBukkenStatusUpdatePage.do?roomKey=${param.roomKey}">&gt;&gt;物件対象外設定を変更する</a></p>
    <p><a href="ReviewBukkenWebStatusUpdatePage.do?roomKey=${param.roomKey}">&gt;&gt;CHINTAI NET掲載状態を変更する</a></p>
    <table class="type_detail">
      <colgroup>
        <col width="20%">
        <col width="*">
      </colgroup>
      <tr>
        <th class="text-left">物件対象外設定</th>
        <td>
          <!-- inline table -->
          <table class="type_none">
            <tr>
              <th class="text-left">初回審査</th>
              <td><chintai:CodePrint code="${view.syokaiSkipFlg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
            <tr>
              <th class="text-left">定期審査</th>
              <td><chintai:CodePrint code="${view.teikiSkipFlg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
            <tr>
              <th class="text-left">自動削除</th>
              <td><chintai:CodePrint code="${view.autoDelSkipflg}" nameKey="WEB_BUKKEN_SKIP_NAME" valueKey="WEB_BUKKEN_SKIP_VALUE"/></td>
            </tr>
          </table>
          <hr>
          <table class="type_none">
            <tr>
              <th class="text-left">備　考</th>
              <td><chintai:filter changeNL2BR="true"><c:out value="${view.shinsaSkipBikou}" /></chintai:filter></td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <th class="text-left">CHINTAI NET掲載状態</th>
        <td>
          <table class="type_none">
            <tr>
              <th class="text-left">掲載状態</th>
              <td>
                <c:if test="${view.changeSourceKbn == '2' && view.ctStopDt != null}">停止</c:if>
                <c:if test="${view.changeSourceKbn != '2' || view.ctStopDt == null}">通常</c:if>
              </td>
            </tr>
          </table>
          <hr>
          <table class="type_none">
            <tr>
              <th class="text-left">備　考</th>
              <td><chintai:filter changeNL2BR="true"><c:out value="${view.shinsaBukkenStatusBikou}" /></chintai:filter></td>
            </tr>
          </table>
        </td>
      </tr>
     <tr>
        <th class="text-left">Web審査状態</th>
        <td>
          <table class="type_none">
            <tr>
              <th class="text-left">警告対象</th>
              <td>
                <c:choose>
                  <c:when test="${empty view.warningCd}">
                    なし
                  </c:when>
                  <c:when test="${view.warningCd eq '0'}">
                    初回審査警告対象
                  </c:when>
                  <c:otherwise>
                    定期審査警告対象
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
            <tr>
              <th class="text-left">返信内容</th>
              <td>
                <c:choose>
                  <c:when test="${empty view.warningCd}">
                    なし
                  </c:when>
                  <c:when test="${view.warningCd eq '0'}">
                    <c:choose>
                      <c:when test="${view.statusKbn eq '0'}">
	                    未送信
	                  </c:when>
                      <c:when test="${view.statusKbn eq '1'}">
	                    <c:out value="${view.syokaiAutoDelDt}" />&nbsp;削除予定
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn eq '3'}">
	                    問題なし
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn ne '3'}">
	                    問題あり
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '3'}">
	                    自動削除
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '4'}">
	                    警告無効(再発信）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '5'}">
	                    警告無効（掲載落ち）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '6'}">
	                    警告無効（最新警告回答済）
	                  </c:when>
	                </c:choose>
                  </c:when>
                  <c:otherwise>
                    <c:choose>
                      <c:when test="${view.statusKbn eq '0'}">
	                    未送信
	                  </c:when>
                      <c:when test="${view.statusKbn eq '1'}">
	                    <c:out value="${view.teikiAutoDelDt}" />&nbsp;削除予定
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn eq '3'}">
	                    問題なし
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '2' and  view.syoriKbn ne '3'}">
	                    問題あり
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '3'}">
	                    自動削除
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '4'}">
	                    警告無効(再発信）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '5'}">
	                    警告無効（掲載落ち）
	                  </c:when>
	                  <c:when test="${view.statusKbn eq '6'}">
	                    警告無効（最新警告回答済）
	                  </c:when>
	                </c:choose>
                  </c:otherwise>
                </c:choose>
              </td>
            </tr>
          </table>
        </td>
      </tr>
      <tr>
        <th class="text-left">掲載日数</th>
        <td>
          <!-- inline table -->
          <table class="type_none">
            <tr>
              <th class="text-left">Web審査掲載起算日</th>
              <td>
                <c:if test="${not empty view.elapsedDays}">
                  <c:out value="${view.shinsaStartDt}"></c:out>
                </c:if>
              </td>
            </tr>
            <tr>
              <th class="text-left">連続掲載経過日数</th>
              <td>
                <c:if test="${not empty view.elapsedDays}">
                  <c:out value="${view.elapsedDays}"></c:out>日
                </c:if>
              </td>
            </tr>
          </table>
        </td>
      </tr>
    </table>



    <!-- Web審査警告履歴 -->
    <c:if test="${not empty view.detailList}">
    <p class="section_header"><a name="3">Web審査警告履歴</a></p>
      <table class="type_list">
        <tr>
          <th rowspan="2">警告日</th>
          <th rowspan="2">返信日</th>
          <th rowspan="2">警告内容</th>
          <th colspan="4">返信入力内容</th>
        </tr>
        <tr>
          <th>空室となった年月日又は空室予定日<br>(新築の場合は完成年月日)</th>
          <th>最終条件確認年月日</th>
          <th>処理内容</th>
          <th>その他ご意見など</th>
        </tr>
        <c:forEach items="${view.detailList}" var="detail">
          <c:choose>
            <c:when test="${detail.statusKbn eq '1' || detail.statusKbn eq '0'}">
              <tr>
                <td><c:out value="${detail.warningDt}" /></td>
                <td>
                  <c:choose>
                    <c:when test="${empty detail.syoriDt}">
                      --
                    </c:when>
                    <c:otherwise>
                      <c:out value="${detail.syoriDt}" />
                    </c:otherwise>
                  </c:choose>
                </td>
                <td><c:out value="${detail.warningName}" /></td>
                <td colspan="4">
                  <a href="ReviewReplayPage.do?roomKey=${param.roomKey}">返信入力内容を入力する</a>
                </td>
              </tr>
            </c:when>
            <c:otherwise>
              <tr>
                <td><c:out value="${detail.warningDt}" /></td>
                <td>
                  <c:choose>
                    <c:when test="${empty detail.syoriDt}">
                      --
                    </c:when>
                    <c:otherwise>
                      <c:out value="${detail.syoriDt}" />
                    </c:otherwise>
                  </c:choose>
                </td>
                <td><c:out value="${detail.warningName}" /></td>
                <td>
                  <c:choose>
                    <c:when test="${empty detail.vacantYmd}">
                      --
                    </c:when>
                    <c:otherwise>
                      <c:out value="${detail.vacantYmd}" />
                    </c:otherwise>
                  </c:choose>
                  <c:if test="${not empty detail.vacantYmd and detail.shinchikuFlg eq '1'}">
                    （新築）
                  </c:if>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${empty detail.lastConfirmYmd}">
                      --
                    </c:when>
                    <c:otherwise>
                      <c:out value="${detail.lastConfirmYmd}" />
                    </c:otherwise>
                  </c:choose>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${detail.statusKbn eq '3'}">
                      自動削除
                    </c:when>
                    <c:when test="${detail.statusKbn eq '2' and detail.syoriKbn eq '1'}">
                      物件をWEBから削除する。
                    </c:when>
                    <c:when test="${detail.statusKbn eq '2' and detail.syoriKbn eq '2'}">
                      CRSから修正データを再発信する
                    </c:when>
                    <c:when test="${detail.statusKbn eq '2' and detail.syoriKbn eq '3'}">
                      問題なし
                    </c:when>
                    <c:when test="${detail.statusKbn eq '4'}">
                      警告無効(再発信）
                    </c:when>
                    <c:when test="${detail.statusKbn eq '5'}">
                      警告無効（掲載落ち）
                    </c:when>
                    <c:when test="${detail.statusKbn eq '6'}">
                      警告無効（最新警告回答済）
                    </c:when>
                    <c:otherwise>
                      --
                    </c:otherwise>
                  </c:choose>
                </td>
                <td>
                  <c:choose>
                    <c:when test="${empty detail.bikou}">
                      --
                    </c:when>
                    <c:otherwise>
                      <div class="text-left"><chintai:filter changeNL2BR="true"><c:out value="${detail.bikou}" /></chintai:filter></div>
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </c:otherwise>
          </c:choose>
        </c:forEach>
      </table>
  </c:if>
    <!-- 店舗情報 -->
    <p class="section_header"><a name="5">店舗情報</a></p>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="20%">
        <col span="1" width="80%">
      </colgroup>
      <tr>
        <th class="text-left">店舗名</th>
        <td><label><c:out value="${view.company}" /> <c:if test="${not empty view.bumon}">/</c:if><c:out value="${view.bumon}" /></label></td>
      </tr>
      <tr>
        <th class="text-left">店舗コード</th>
        <td><label><c:out value="${view.shopCd}" /></label></td>
      </tr>
      <tr>
        <th class="text-left">お客様設定パスワード</th>
        <td><c:out value="${view.password}" /></td>
      </tr>
      <tr>
        <th class="text-left">承認状態</th>
        <td><chintai:CodePrint code="${view.certifyFlg}" nameKey="CERTIFY_FLG_NAME" valueKey="CERTIFY_FLG_VALUE"/></td>
      </tr>
      <tr>
        <th class="text-left">店舗状態</th>
        <td><chintai:CodePrint code="${view.shopStatus}" nameKey="STATUS_NAME" valueKey="STATUS_VALUE"/></td>
      </tr>
      <tr>
        <th class="text-left">備考</th>
        <td>
          <chintai:filter changeNL2BR="true"><c:out value="${view.adminNote}" /></chintai:filter>
        </td>
      </tr>
      <tr>
        <th class="text-left">管理最終更新日時</th>
        <td>
          <label><c:out value="${view.shopAdminUpdDt}" /></label>
        </td>
      </tr>
      <tr>
        <th class="text-left">取扱店</th>
        <td>
          <c:if test="${ReviewBukkenInfoView.tantouShopList != null}">
            <c:forEach items="${ReviewBukkenInfoView.tantouShopList}" var="tantouShop">
              <c:if test="${tantouShop.shopcd != ReviewBukkenInfoView.shopCd}">
                <c:out value="${tantouShop.shopcd}" />：
                <c:out value="${tantouShop.company}" />/
                <c:out value="${tantouShop.bumon}" /><br>
              </c:if>
            </c:forEach>
          </c:if>
        </td>
      </tr>
    </table>
  </div>

</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
