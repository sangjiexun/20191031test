<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約状況更新"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<script type="text/javascript">
<!--//
function openTorihikisakiSearch() {
	newWin = window.open("","TorihikisakiSearchFromKanri", "width=800,height=600,scrollbars=yes,toolbar=no,menubar=no,resizable=yes,status=yes");
	newWin.document.location.href="../demand/TorihikisakiSearchForBindPage.do";
}

function closeChildWindow(){
	try{
		if(newWin) { // newWinがObjectだったら以下を実行
			newWin.window.close();
		}
	} catch(e) {
		// no-op
	}
}
//-->
</script>
<style>
table th{
	text-align: left;
}
</style>
<c:set var="view" value="${ShopRegistrationStautsUpdatePageView}" />

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_bukken/ShopInfo">
        <html:param name="shopCd" value="${view.shopCd}" />
        店舗・契約詳細
      </html:link> &gt;
      ${title}
    </div>

    <h1>${title}</h1>

    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
    <html:form method="post" action="/shop_bukken/ShopRegistrationStatusUpdateConfirm" onsubmit="disableSubmit(this);closeChildWindow();">
    <table class="type_detail">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>${view.company} / ${view.bumon}</td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td>${view.shopCd}</td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${crnwl:decypt(view.password)}" /></td>
      </tr>
    </table>

    <!-- 登録状況更新 -->
    <p class="section_header"><a name="3">契約状況更新</a></p>

      <div class="add_form">
        <div class="add_form_title">システム利用状態 <span class="caution">*</span></div>
        <div class="annotation">「停止」にすると、すべての機能が利用できなくなります。</div>
        <div class="form_space">
          <c:if test="${view.shopStatus == 0 || view.shopStatus == null}">
            <label><input type="radio" name="shopStatus" value="0" checked="checked">停止</label>
          </c:if>
          <c:if test="${view.shopStatus != 0 && view.shopStatus != null}">
            <label><input type="radio" name="shopStatus" value="0">停止</label>
          </c:if>

          <c:if test="${view.shopStatus == 1}">
            <label><input type="radio" name="shopStatus" value="1" checked="checked">通常</label>
          </c:if>
          <c:if test="${view.shopStatus != 1}">
            <label><input type="radio" name="shopStatus" value="1">通常</label>
          </c:if>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">CHINTAIに掲載 <span class="caution">*</span></div>
        <div class="annotation">物件データをCHINTAIに掲載します。</div>
        <div class="form_space">
          <c:if test="${view.ctFlg == 0 || view.ctFlg == null}">
            <label><input type="radio" name="ctFlg" value="0" checked="checked">掲載しない</label>
          </c:if>
          <c:if test="${view.ctFlg != 0 && view.ctFlg != null}">
            <label><input type="radio" name="ctFlg" value="0">掲載しない</label>
          </c:if>

          <c:if test="${view.ctFlg == 1}">
            <label><input type="radio" name="ctFlg" value="1" checked="checked">掲載する</label>
          </c:if>
          <c:if test="${view.ctFlg != 1}">
            <label><input type="radio" name="ctFlg" value="1">掲載する</label>
          </c:if>
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">エイブルに掲載 <span class="caution">*</span></div>
        <div class="annotation">物件データをエイブルに掲載します。</div>
        <div class="form_space">
          <c:if test="${view.ablFlg == 0 || view.ablFlg == null}">
            <label><input type="radio" name="ablFlg" value="0" checked="checked">掲載しない</label>
          </c:if>
          <c:if test="${view.ablFlg != 0 && view.ablFlg != null}">
            <label><input type="radio" name="ablFlg" value="0">掲載しない</label>
          </c:if>

          <c:if test="${view.ablFlg == 1}">
            <label><input type="radio" name="ablFlg" value="1" checked="checked">掲載する</label>
          </c:if>
          <c:if test="${view.ablFlg != 1}">
            <label><input type="radio" name="ablFlg" value="1">掲載する</label>
          </c:if>
        </div>
      </div>
<%--
      <div class="add_form">
        <div class="add_form_title">送信元アプリケーション</div>
        <div class="annotation">店舗、物件データの送信元です。</div>
        <div class="form_space">
          <chintai:CodePrint nameKey="CLIENTSYSTEM_NAME" valueKey="CLIENTSYSTEM_VALUE" code="${view.clientSystemType}"/>
          <span class="caution">(※変更できません。)</span>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">店舗サイト権限 <span class="caution">*</span></div>
        <div class="annotation">店舗サイトの利用権限について設定します。</div>
        <div class="form_space">
          <c:if test="${view.shopSiteRole == 0 || view.shopSiteRole == null}">
            <label><input type="radio" name="shopSiteRole" value="0" checked="checked">ログイン不可</label>
          </c:if>
          <c:if test="${view.shopSiteRole != 0 && view.shopSiteRole != null}">
            <label><input type="radio" name="shopSiteRole" value="0">ログイン不可</label>
          </c:if>

          <c:if test="${view.shopSiteRole == 1}">
            <label><input type="radio" name="shopSiteRole" value="1" checked="checked">ログイン可</label>
          </c:if>
          <c:if test="${view.shopSiteRole != 1}">
            <label><input type="radio" name="shopSiteRole" value="1">ログイン可</label>
          </c:if>

          <c:if test="${view.shopSiteRole == 2}">
            <label><input type="radio" name="shopSiteRole" value="2" checked="checked">ログイン可+業者向登録登録状況メール可</label>
          </c:if>
          <c:if test="${view.shopSiteRole != 2}">
            <label><input type="radio" name="shopSiteRole" value="2">ログイン可+業者向登録登録状況メール可</label>
          </c:if>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">店舗名ひらがな名称</div>
        <div class="annotation">この店舗のひらがなの読みを設定します。</div>
        <div class="form_space">
          <input type="text" name="bumonKana" value="${fn:escapeXml(view.bumonKana)}" size="50" maxlength="50">
        </div>
      </div>
      <!-- 2009/03/23 李昊燮 「地図上の店舗アイコン表示状態」削除処理 -->
 --%>
      <div class="add_form">
        <div class="add_form_title">備考</div>
        <div class="annotation">この店舗に関する特記事項、メモなどを記述します。</div>
        <div class="form_space">
          <textarea rows="5" cols="80" name="adminNote"><c:out value="${view.adminNote}" /></textarea>
        </div>
      </div>

      <div class="add_form">
        <input type="hidden" name="company" value="${view.company}">
        <input type="hidden" name="bumon" value="${view.bumon}">
        <input type="hidden" name="shopCd" value="${view.shopCd}">
        <input type="hidden" name="password" value="${view.password}">
        <input type="hidden" name="clientSystemType" value="${view.clientSystemType}">
        <input type="hidden" name="updDt" value="${view.updDt}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('ShopInfo.do?shopCd=${view.shopCd}');">
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
