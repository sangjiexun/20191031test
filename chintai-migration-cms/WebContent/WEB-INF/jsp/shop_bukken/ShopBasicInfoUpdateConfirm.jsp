<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="${empty shopBasicInfoUpdateForm.shopcd?'店舗基本情報登録':'店舗基本情報更新'}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<c:set var="view" value="${ShopBasicInfoUpdateView}" />
<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
    	<c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
	      <a href ="<c:url value="${empty shopBasicInfoUpdateForm.shopcd?'ShopSearchPage.do':'ShopInfo.do'}"><c:param name="shopCd" value="${refData.shopRireki.shopcd}"/></c:url>">
	        ${empty shopBasicInfoUpdateForm.shopcd?'店舗・契約管理':'店舗・契約詳細'}
	      </a>&gt;
      	</c:if>
      ${title}
    </div>
    <h1>${title}</h1>

    <!-- エラーメッセージ -->
    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"></c:out>
    </html:messages>
	<form:errors path="shopBasicInfoUpdateForm.*" element="p" cssClass="notify"/>

	<c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
	    <!-- 店舗コード -->
	    <p class="section_header"><a name="1">店舗コード</a></p>
	    <table class="type_detail">
	      <colgroup>
	        <col span="1" width="22%">
	        <col span="1" width="78%">
	      </colgroup>
	      <tr>
	        <th class="text-left">店舗名</th>
	      <td>
	        <c:out value="${refData.shopRireki.company}" />
	        <c:if test="${not empty refData.shopRireki.company and not empty refData.shopRireki.bumon}"> / </c:if>
	        <c:out value="${refData.shopRireki.bumon}" />
	      </td>
	      </tr>
	      <tr>
	        <th class="text-left">店舗コード</th>
	        <td><c:out value="${refData.shopRireki.shopcd}" /></td>
	      </tr>
	      <tr>
	        <th class="text-left">お客様設定パスワード</th>
	        <td><c:out value="${crnwl:decypt(refData.shopRireki.passwordEnc)}" /></td>
	      </tr>
	    </table>
	</c:if>

    <!-- 基本情報 -->

    <p class="section_header"><a name="2">基本情報更新内容の確認</a></p>
    <table class="type_detail">
      <colgroup>
        <col width="11%" class="type_detail_head">
        <col width="11%" class="type_detail_head">
        <col width="$td_width" class="type_detail_body">
      </colgroup>
      <c:set var="mstRendo" value="${masterService.selectMstRendoByPrimaryKey(shopBasicInfoUpdateForm.rendoCd)}"/>
      <tr>
        <th colspan="2" class="text-left">事業者区分</th>
        <td><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="${mstRendo.companyKbn}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">連動元</th>
        <td><c:out value="${mstRendo.rendoName}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">名寄せ設定</th>
        <td>
          <c:if test="${!shopBasicInfoUpdateForm.nayoseSkip}">名寄せする</c:if>
          <c:if test="${shopBasicInfoUpdateForm.nayoseSkip}">名寄せしない</c:if>
        </td>
      </tr>



      <tr>
        <th colspan="2" class="text-left">会社名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.company}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">事務所名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.bumon}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">所属団体名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.dantai}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">代表者名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.licTrust}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">グループ名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.groupname}"/></td>
      </tr>

      <!-- join 3 rows -->
      <tr>
        <th rowspan="${!empty shopBasicInfoUpdateForm.shopcd ? '5' : '3'}" class="text-left">住所</th>
        <th class="text-left">郵便番号</th>
        <td><c:out value="${shopBasicInfoUpdateForm.zip}"/></td>
      </tr>
      <tr>
        <th class="text-left">住所１</th>
        <td><c:out value="${shopBasicInfoUpdateForm.address1}"/></td>
      </tr>
      <tr>
        <th class="text-left">住所２</th>
        <td><c:out value="${shopBasicInfoUpdateForm.address2}"/></td>
      </tr>
	<c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
		<tr>
			<th class="text-left"><label>緯度</label></th>
			<td><c:out value="${shopBasicInfoUpdateForm.locationY}"/></td>
		</tr>
		<tr>
			<th class="text-left"><label>経度</label></th>
			<td><c:out value="${shopBasicInfoUpdateForm.locationX}"/></td>
		</tr>
	</c:if>

      <tr>
        <th colspan="2" class="text-left">電話番号</th>
        <td><c:out value="${shopBasicInfoUpdateForm.tel}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">電話番号（反響）</th>
        <td><c:out value="${shopBasicInfoUpdateForm.telInq}"/></td>
      </tr>

      <%-- 2013/07/26 店舗電話番号変更対応２次リリース分 ３項目追加 --%>
      <tr>
        <th colspan="2" class="text-left">フリーコール(CHINTAI)用TEL</th>
        <td>
        	<c:if test="${shopBasicInfoUpdateForm.telFreeCtKbn == '1'}">使用する</c:if>
        	<c:if test="${shopBasicInfoUpdateForm.telFreeCtKbn == '0'}">使用しない</c:if>
        	<c:if test="${!empty shopBasicInfoUpdateForm.chintaiHtml}">(<c:out value="${shopBasicInfoUpdateForm.chintaiHtml}"/>)</c:if>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">フリーコール(店舗)用TEL</th>
        <td><c:out value="${shopBasicInfoUpdateForm.telFreeShop}"/></td>
      </tr>

      <tr>
        <th colspan="2" class="text-left">電話番号選択</th>
        	<td>
        		<chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="${shopBasicInfoUpdateForm.telDispKbn}"/>
        	</td>
      </tr>

	  <tr>
        <th colspan="2" class="text-left">フリーコール(エイブル)用TEL</th>
        <td>
        	<c:if test="${shopBasicInfoUpdateForm.telFreeAblKbn == '1'}">使用する</c:if>
        	<c:if test="${shopBasicInfoUpdateForm.telFreeAblKbn == '0'}">使用しない</c:if>
        	<c:if test="${!empty shopBasicInfoUpdateForm.ablHtml}">(<c:out value="${shopBasicInfoUpdateForm.ablHtml}"/>)</c:if>
        </td>
      </tr>

      <tr>
        <th colspan="2" class="text-left">電話番号選択(エイブル)</th>
        	<td>
        		<chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="${shopBasicInfoUpdateForm.telDispKbnAbl}"/>
        	</td>
      </tr>

      <tr>
        <th colspan="2" class="text-left">フリーコール(雑誌)用TEL</th>
        <td>
        	<c:if test="${shopBasicInfoUpdateForm.telMagazineKbn == '1'}">使用する</c:if>
        	<c:if test="${shopBasicInfoUpdateForm.telMagazineKbn == '0'}">使用しない</c:if>
        	<c:if test="${!empty shopBasicInfoUpdateForm.magazineHtml}">(<c:out value="${shopBasicInfoUpdateForm.magazineHtml}"/>)</c:if>
        </td>
      </tr>
      <%-- 2013/7/26 end --%>

      <tr>
        <th colspan="2" class="text-left">FAX</th>
        <td><c:out value="${shopBasicInfoUpdateForm.fax}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">地域</th>
        <td>
          <label>
          <c:set var="address" value="${masterService.getAddress(shopBasicInfoUpdateForm.zip) }"/>
            エリア : [<c:out value="${address.areacd}" />] <c:out value="${address.areaname}" /> /
            都道府県 : [<c:out value="${address.prefcd}" />] <c:out value="${address.prefname}" /> /
            市区町村 : [<c:out value="${address.citycd}" />] <c:out value="${address.cityname}" />
          </label>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">沿線</th>
        <td>
          <ul class="list-unstyled">
          	<c:forEach items="${shopBasicInfoUpdateForm.ekis}" var="e">
          		<li>
	          		<c:set var="eki" value="${e.value}"/>
	          		<c:set var="mstEnsen" value="${masterService.selectMstEnsenByPrimaryKey(eki.ensencd)}"/>
	          		<c:set var="mstEki" value="${masterService.selectMstEkiByPrimaryKey(eki.ensencd,eki.ekicd)}"/>
	          		<c:set var="mstArea" value="${masterService.selectMstAreaByPrimaryKey(mstEnsen.areacd)}"/>
	        		<c:choose>
	        			<c:when test="${! empty eki.otherTransName}">
	          エリア : [] /
	          沿線タイプ : [] /
	         その他交通機関 /沿線 : [] <c:out value="${eki.otherTransName}"/> /
	          駅名 : [] <c:out value="${eki.otherTransPlatform}"/>
	        			</c:when>
	        			<c:otherwise>
	          エリア : [<c:out value="${mstArea.areacd}"/>] <c:out value="${mstArea.areaname}"/> /
	          沿線タイプ : [00<c:out value="${mstEnsen.ensentype}"/>] <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="${mstEnsen.ensentype}"/> /
	          沿線 : [<c:out value="${mstEnsen.ensencd}"/>] <c:out value="${mstEnsen.ensenname}"/> /
	          駅名 : [<c:out value="${mstEki.ekicd}"/>] <c:out value="${mstEki.ekiname}"/>
	        			</c:otherwise>
	        		</c:choose>
	            </li>
          	</c:forEach>
          </ul>
        </td>

      </tr>
      <tr>
        <th colspan="2" class="text-left">免許証番号</th>
        <td><c:out value="${shopBasicInfoUpdateForm.licNum}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">免許証有効期限（開始）</th>
        <td><c:out value="${shopBasicInfoUpdateForm.licEntry}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">免許証有効期限（終了）</th>
        <td><c:out value="${shopBasicInfoUpdateForm.licValid}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">宅建取引主任者名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.licChief}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">担当者名</th>
        <td><c:out value="${shopBasicInfoUpdateForm.tantou}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">ホームページリンク名称</th>
        <td>
			<ul class="list-unstyled">
				<c:forEach begin="1" end="5" var="i">
					<li class="form_space">
						<c:out value="${shopBasicInfoUpdateForm.hps[i].name}"/>
					</li>
				</c:forEach>
			</ul>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">自社ホームページURL</th>
        <td>
			<ul class="list-unstyled">
				<c:forEach begin="1" end="5" var="i">
					<li class="form_space">
						<c:out value="${shopBasicInfoUpdateForm.hps[i].url}"/>
					</li>
				</c:forEach>
			</ul>

        </td>
      </tr>

      <tr>
        <th colspan="2" class="text-left">メールアドレス</th>
        <td>
			<ul class="list-unstyled">
				<c:forEach var="e" items="${shopBasicInfoUpdateForm.mails}">
					<c:set var="mail" value="${e.value}"/>
					<c:if test="${!empty mail.email}">
						<li class="form_space">
							<c:out value="${mail.email}"/>
							(
								<c:choose>
									<c:when test="${mail.useKbn == '0'}">共通</c:when>
									<c:when test="${mail.useKbn == '1'}">反響</c:when>
									<c:when test="${mail.useKbn == '2'}">WEB審査</c:when>
									<c:when test="${mail.useKbn == '3'}">営業連絡用</c:when>
								</c:choose>
							)
						</li>
					</c:if>
				</c:forEach>
			</ul>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">連絡方法</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_FM_KBN_NAME" valueKey="SHOPBUKKEN_FM_KBN_VALUE" code="${shopBasicInfoUpdateForm.fmKbn}"/>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">営業時間</th>
        <td><c:out value="${shopBasicInfoUpdateForm.businessHours}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">定休日</th>
        <td><c:out value="${shopBasicInfoUpdateForm.holiday}"/></td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">［エイブル専用］店舗名ひらがな名称</th>
        <td>
          <c:out value="${shopBasicInfoUpdateForm.bumonkana}"/>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">CHINTAI支社</th>
        <td>
          <c:out value="${masterService.selectMstCtShisyaByPrimaryKey(shopBasicInfoUpdateForm.ctShisyaCd).ctShisyaName}"/>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">通知先情報</th>
        <td>
          <c:out value="${shopBasicInfoUpdateForm.noticeEmail}"/>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">反響管理用メールアドレス</th>
        <td>
          <c:out value="${shopBasicInfoUpdateForm.inqMngEmail}"/>
        </td>
      </tr>
      <tr>
        <th colspan="2" class="text-left">店舗LINE＠ID</th>
        <td>
          <c:out value="${shopBasicInfoUpdateForm.lineAccount}"/>
        </td>
      </tr>
	</table>



    <form:form action="${!empty shopBasicInfoUpdateForm.shopcd ? 'ShopBasicInfoUpdateCommit.admin' : 'ShopBasicInfoAddCommit.admin'}" commandName="shopBasicInfoUpdateForm" onsubmit="disableSubmit(this)">
    	<tags:token/>
      <p>
      <c:forEach items="${shopBasicInfoUpdateForm.getClass().getDeclaredFields()}" var="f">
      	<c:if test="${f.name != 'ekis' && f.name != 'hps' && f.name != 'mails'}">
      		<form:hidden path="${f.name}"/>
      	</c:if>
      </c:forEach>
      <c:forEach items="${shopBasicInfoUpdateForm.ekis}" var="e">
      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
      		<form:hidden path="ekis[${e.key}].${f.name}"/>
      	</c:forEach>
      </c:forEach>
      <c:forEach items="${shopBasicInfoUpdateForm.hps}" var="e">
      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
      		<form:hidden path="hps[${e.key}].${f.name}"/>
      	</c:forEach>
      </c:forEach>
      <c:forEach items="${shopBasicInfoUpdateForm.mails}" var="e">
      	<c:forEach items="${e.value.getClass().getDeclaredFields()}" var="f">
      		<form:hidden path="mails[${e.key}].${f.name}"/>
      	</c:forEach>
      </c:forEach>
        <input type="submit" value="${empty shopBasicInfoUpdateForm.shopcd?'登録':'更新'}" name="commit">
        <input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
      </p>
    </form:form>


  </div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
