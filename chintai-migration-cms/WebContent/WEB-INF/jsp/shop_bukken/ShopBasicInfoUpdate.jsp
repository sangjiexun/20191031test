<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="${empty shopBasicInfoUpdateForm.shopcd?'店舗基本情報登録':'店舗基本情報更新'}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<c:set var="view" value="${ShopBasicInfoUpdateView}" />
<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

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
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer" >
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
    <form:form action="${!empty shopBasicInfoUpdateForm.shopcd ? 'ShopBasicInfoUpdateConfirm.admin' : 'ShopBasicInfoAddConfirm.admin'}" commandName="shopBasicInfoUpdateForm">
		<!-- 基本情報 -->
      <p class="section_header"><a name="2">基本情報更新</a></p>
      <div class="caution">※店舗からの発信で上書きされる可能性があります。</div>
		<div class="add_form">
			<%--
			<div class="add_form_title">事業者区分<span class="caution">*</span></div>
			<div class="annotation"></div>
			<div class="form_space">
				<label><form:radiobutton path="companyKbn" value="1"/><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="1"/></label>
				<label><form:radiobutton path="companyKbn" value="2"/><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="2"/></label>
				<label><form:radiobutton path="companyKbn" value="3"/><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="3"/></label>
				<label><form:radiobutton path="companyKbn" value="4"/><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="4"/></label>
			</div>
 			--%>
			<div class="add_form_title">連動元<span class="caution">*</span></div>
			<div class="form_space">
				<c:choose>
					<c:when test="${!empty shopBasicInfoUpdateForm.shopcd}">
						<c:set var="mstRendo" value="${masterService.selectMstRendoByPrimaryKey(refData.shopRireki.rendoCd)}"/>
						<c:choose>
							<c:when test="${mstRendo.rendoUpdFlg == '0'}">
								<c:out value="${mstRendo.rendoName}"/>
								<form:hidden path="rendoCd"/>
							</c:when>
							<c:when test="${empty refData.shopRireki.rendoCd || mstRendo.rendoUpdFlg == '1'}">
								<form:select path="rendoCd" style="width:200px">
				               		<form:option value=""></form:option>
				               		<form:options items="${masterService.selectMstRendoUpdFlg()}" itemValue="rendoCd" itemLabel="rendoName"/>
				               	</form:select>
							</c:when>
						</c:choose>
	               	</c:when>
	               	<c:otherwise>
		               	<form:select path="rendoCd" style="width:200px">
		               		<form:option value=""></form:option>
		               		<form:options items="${masterService.selectMstRendoInsFlg()}" itemValue="rendoCd" itemLabel="rendoName"/>
		               	</form:select>
	               	</c:otherwise>
               	</c:choose>
			</div>

			<%--
			<div class="add_form_title">送信元アプリケーション<span class="caution">*</span></div>
			<div class="form_space">
				<form:select path="clientsystemType" style="width:200px">
					<form:option value=""></form:option>
					<c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
						<form:option value="1"><chintai:CodePrint nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE" code="1"/></form:option>
						<form:option value="2"><chintai:CodePrint nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE" code="2"/></form:option>
						<form:option value="3"><chintai:CodePrint nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE" code="3"/></form:option>
						<form:option value="4"><chintai:CodePrint nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE" code="4"/></form:option>
					</c:if>
					<form:option value="6"><chintai:CodePrint nameKey="CLIENTSYSTEM_SEARCH_NAME" valueKey="CLIENTSYSTEM_SEARCH_VALUE" code="6"/></form:option>
				</form:select>
			</div>
			 --%>
		</div>



      <div class="add_form">
        <div class="add_form_title">名寄せ設定<span class="caution">*</span></div>
        <div class="annotation">物件データの名寄せを設定します。</div>
        <div class="form_space">
          <label><form:radiobutton path="nayoseSkip" value="false"/>名寄せする</label>
          <label><form:radiobutton path="nayoseSkip" value="true"/>名寄せしない</label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">会社名<span class="caution">*</span></div>
        <div class="annotation">会社名を表示します。</div>
        <div class="form_space">
          <label><chintai:inputResolveMaxLength path="company" sameSizeMaxlength="true"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">事務所名</div>
        <div class="annotation">事務所名を表示します。</div>
        <div class="form_space">
          <label><chintai:inputResolveMaxLength path="bumon" sameSizeMaxlength="true"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">所属団体名</div>
        <div class="annotation">所属団体名を表示します。</div>
        <div class="form_space">
          <label><chintai:inputResolveMaxLength path="dantai" sameSizeMaxlength="true"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">代表者名</div>
        <div class="annotation">代表者名を表示します。</div>
        <div class="form_space">
          <label><chintai:inputResolveMaxLength path="licTrust" sameSizeMaxlength="true"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">グループ名</div>
        <div class="annotation">グループ名を表示します。</div>
        <div class="form_space">
          <label><chintai:inputResolveMaxLength path="groupname" sameSizeMaxlength="true"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">住所</div>
        <div class="annotation">住所を設定します。郵便番号はハイフン抜きで入力してください。</div>
        <div class="form_space">
          <table class="type_none">
            <tr>
              <td><label>郵便番号<span class="caution">*</span></label></td>
              <td>
              	<chintai:inputResolveMaxLength path="zip" size="7" cssClass="integer"/>
              	<input type="button" value="住所を自動入力" onclick="AddressEnsenManager.getAddress($('#zip').val(),function(data){
              		if(data.prefname == ''){
              			alert('住所が取得できません。');
              			return;
              		}
              		$('#address1').val(data.prefname + data.cityname + data.address);
              	})">
              </td>
            </tr>
            <tr>
              <td><label>住所１<span class="caution">*</span></label></td>
              <td><chintai:inputResolveMaxLength path="address1" size="60"/></td>
            </tr>
            <tr>
              <td><label>住所２</label></td>
              <td><chintai:inputResolveMaxLength path="address2" size="60"/></td>
            </tr>
            <c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
				<tr>
					<td><label>緯度</label></td>
					<td><chintai:inputResolveMaxLength path="locationY" size="11"/></td>
				</tr>
				<tr>
					<td><label>経度</label></td>
					<td><chintai:inputResolveMaxLength path="locationX" size="11"/></td>
				</tr>
			</c:if>
		</table>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">TEL<span class="caution">*</span></div>
        <div class="annotation">電話番号を設定します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="tel" size="13"/>
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">反響用TEL<span class="caution">*</span></div>
        <div class="annotation">反響用TEL電話番号を設定します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="telInq" size="13"/>
        </div>
      </div>
	  <div class="add_form">
        <div class="add_form_title">フリーコール(CHINTAI)用TEL</div>
        <div class="annotation">フリーコール(CHINTAI)用TEL電話番号を設定します。</div>
        <div class="form_space">
          <c:choose>
	          <c:when test="${empty shopBasicInfoUpdateForm.shopcd || !shopService.isExistsShopReserve(shopBasicInfoUpdateForm.shopcd)}">
	            <label><form:radiobutton path="telFreeCtKbn" value="1"/>使用する</label>
	            <label><form:radiobutton path="telFreeCtKbn" value="0"/>使用しない</label>
	          </c:when>
	          <c:otherwise>
	            <c:if test="${shopBasicInfoUpdateForm.telFreeCtKbn == '1'}"><label>使用する</label></c:if>
	            <c:if test="${shopBasicInfoUpdateForm.telFreeCtKbn == '0'}"><label>使用しない</label></c:if>
	            <form:hidden path="telFreeCtKbn"/>
	          </c:otherwise>
          </c:choose>
        </div>
        <div class="form_space">
          <c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
            <c:set var="ppcInfoChintai" value="${shopService.selectPpcInfoChintaiDateEditByPrimaryKey(shopBasicInfoUpdateForm.shopcd) }"/>
			  <c:if test="${ppcInfoChintai != null}">
	          	<chintai:copyBodyContent name="chintaiHtml">番号：<c:out value="${ppcInfoChintai.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoChintai.ppcStartDt}"/>～<c:out value="${ppcInfoChintai.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoChintai.ppcRecycleDt}"/></chintai:copyBodyContent>
	          	<%String chintaiHtml = (String)request.getAttribute("chintaiHtml");%>
	          	<html:hidden property="chintaiHtml" value="${chintaiHtml}"/>
			  </c:if>
          </c:if>
        </div>
        <form:hidden path="telFreeCt"/>
      </div>
      <div class="add_form">
        <div class="add_form_title">フリーコール(店舗)用TEL</div>
        <div class="annotation">フリーコール(店舗)用TEL電話番号を設定します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="telFreeShop" size="13"/>
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">電話番号選択<span class="caution">*</span></div>
        <div class="annotation">Web上でどちらの電話番号を表示するかを設定します。</div>
        <div class="form_space">
          	<label><form:radiobutton path="telDispKbn" value="1"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="1"/></label>
          	<label><form:radiobutton path="telDispKbn" value="2"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="2"/></label>
          	<label><form:radiobutton path="telDispKbn" value="3"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="3"/></label>
        </div>
      </div>

	  <div class="add_form">
        <div class="add_form_title">フリーコール(エイブル)用TEL</div>
        <div class="annotation">フリーコール(エイブル)用TEL電話番号を設定します。</div>
        <div class="form_space">
          <c:choose>
	          <c:when test="${empty shopBasicInfoUpdateForm.shopcd || !shopService.isExistsShopReserve(shopBasicInfoUpdateForm.shopcd)}">
	            <label><form:radiobutton path="telFreeAblKbn" value="1"/>使用する</label>
	            <label><form:radiobutton path="telFreeAblKbn" value="0"/>使用しない</label>
	          </c:when>
	          <c:otherwise>
	            <c:if test="${shopBasicInfoUpdateForm.telFreeAblKbn == '1'}"><label>使用する</label></c:if>
	            <c:if test="${shopBasicInfoUpdateForm.telFreeAblKbn == '0'}"><label>使用しない</label></c:if>
	            <form:hidden path="telFreeAblKbn"/>
	          </c:otherwise>
          </c:choose>
        </div>
        <div class="form_space">
          <c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
            <c:set var="ppcInfoAbl" value="${shopService.selectPpcInfoAblDateEditByPrimaryKey(shopBasicInfoUpdateForm.shopcd) }"/>
			  <c:if test="${ppcInfoAbl != null}">
	          	<chintai:copyBodyContent name="ablHtml">番号：<c:out value="${ppcInfoAbl.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoAbl.ppcStartDt}"/>～<c:out value="${ppcInfoAbl.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoAbl.ppcRecycleDt}"/></chintai:copyBodyContent>
	          	<%String ablHtml = (String)request.getAttribute("ablHtml");%>
	          	<html:hidden property="ablHtml" value="${ablHtml}"/>
			  </c:if>
          </c:if>
        </div>
        <form:hidden path="telFreeAbl"/>
      </div>

      <div class="add_form">
        <div class="add_form_title">電話番号選択(エイブル)<span class="caution">*</span></div>
        <div class="annotation">Web上でどちらの電話番号を表示するかを設定します。</div>
        <div class="form_space">
          	<label><form:radiobutton path="telDispKbnAbl" value="1"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="1"/></label>
          	<label><form:radiobutton path="telDispKbnAbl" value="4"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="4"/></label>
          	<label><form:radiobutton path="telDispKbnAbl" value="3"/><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="3"/></label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">フリーコール(雑誌)用TEL</div>
        <div class="annotation">フリーコール(雑誌)用TEL電話番号を設定します。</div>
        <div class="form_space">
          <c:choose>
	          <c:when test="${empty shopBasicInfoUpdateForm.shopcd || !shopService.isExistsShopReserve(shopBasicInfoUpdateForm.shopcd)}">
	        	<label><form:radiobutton path="telMagazineKbn" value="1"/>使用する</label>
	            <label><form:radiobutton path="telMagazineKbn" value="0"/>使用しない</label>
	          </c:when>
	          <c:otherwise>
	            <c:if test="${shopBasicInfoUpdateForm.telMagazineKbn == '1'}"><label>使用する</label></c:if>
	            <c:if test="${shopBasicInfoUpdateForm.telMagazineKbn == '0'}"><label>使用しない</label></c:if>
	            <form:hidden path="telMagazineKbn"/>
	          </c:otherwise>
          </c:choose>
        </div>
        <div class="form_space">
          <c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
            <c:set var="ppcInfoMagazine" value="${shopService.selectPpcInfoMagazineDateEditByPrimaryKey(shopBasicInfoUpdateForm.shopcd) }"/>
          	<c:if test="${ppcInfoMagazine != null}">
	          	<chintai:copyBodyContent name="magazineHtml">番号：<c:out value="${ppcInfoMagazine.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoMagazine.ppcStartDt}"/>～<c:out value="${ppcInfoMagazine.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoMagazine.ppcRecycleDt}"/></chintai:copyBodyContent>
	          	<%String magazineHtml = (String)request.getAttribute("magazineHtml");%>
	          	<html:hidden property="magazineHtml" value="${magazineHtml}"/>
          	</c:if>
          </c:if>
        </div>
        <form:hidden path="telMagazine"/>
      </div>
      <div class="add_form">
        <div class="add_form_title">FAX</div>
        <div class="annotation">ファクス番号を設定します。</div>
        <div class="form_space">
        	<chintai:inputResolveMaxLength path="fax" size="13"/>
        </div>
      </div>

	<div class="add_form">
		<div class="add_form_title">
			沿線・駅 <span class="caution">*</span>
		</div>
		<div class="annotation">沿線・駅情報を設定します。</div>
		<tags:ensenEkiSelectUI/>
	</div>
	<c:if test="${!empty shopBasicInfoUpdateForm.ekis}">
		<c:set var="json">
			<json:array items="${shopBasicInfoUpdateForm.ekis}" var="item">
				<c:set var="mstEnsen" value="${masterService.selectMstEnsenByPrimaryKey(item.ensencd)}"/>
				<c:set var="mstEki" value="${masterService.selectMstEkiByPrimaryKey(item.ensencd,item.ekicd)}"/>
				<c:set var="isValid" value="${false}"/>
				<c:choose>
					<c:when test="${empty item.ensencd}">
						<c:set var="isValid" value="${true}"/>
					</c:when>
					<c:otherwise>
						<c:if test="${mstEnsen.delKbn == 0 && mstEki.delKbn == 0}">
							<c:set var="isValid" value="${true}"/>
						</c:if>
					</c:otherwise>
				</c:choose>
				<c:if test="${isValid}">
					<json:object>
						<json:property name="ensencd" value="${item.ensencd}"/>
						<json:property name="ekicd" value="${item.ekicd}"/>
						<c:choose>
							<c:when test="${!empty item.otherTransName}">
								<json:property name="ensenname" value="${item.otherTransName}"/>
								<json:property name="ekiname" value="${item.otherTransPlatform}"/>
							</c:when>
							<c:otherwise>
								<json:property name="ensenname" value="${mstEnsen.ensenname}"/>
								<json:property name="ekiname" value="${mstEki.ekiname}"/>
							</c:otherwise>
						</c:choose>
						<json:property name="otherTransName" value="${item.otherTransName}"/>
						<json:property name="otherTransPlatform" value="${item.otherTransPlatform}"/>
					</json:object>
				</c:if>
			</json:array>
		</c:set>
		<script type="text/javascript">
			var _selectEki = $('#_selectEki');
			var list = $.grep(${json},function(e){return e;});
			$.each(list,function(){
				_selectEki.append($('<option />').html(this.ensenname + this.ekiname).data('eki',this));
			});
		</script>
	</c:if>
	<script type="text/javascript">
		$('#shopBasicInfoUpdateForm').submit(function(){
			$('#_selectEki').children().each(function(i){
				var eki = $(this).data('eki');
				var idx = i + 1;
				$('<input>').attr({type: 'hidden',name: 'ekis['+idx+'].ensencd',value : eki.ensencd}).appendTo('#shopBasicInfoUpdateForm');
				$('<input>').attr({type: 'hidden',name: 'ekis['+idx+'].ekicd',value : eki.ekicd}).appendTo('#shopBasicInfoUpdateForm');
				$('<input>').attr({type: 'hidden',name: 'ekis['+idx+'].otherTransName',value : eki.otherTransName}).appendTo('#shopBasicInfoUpdateForm');
				$('<input>').attr({type: 'hidden',name: 'ekis['+idx+'].otherTransPlatform',value : eki.otherTransPlatform}).appendTo('#shopBasicInfoUpdateForm');
			});
		});
	</script>
      <div class="add_form">
        <div class="add_form_title">免許証番号<span class="caution">*</span></div>
        <div class="annotation">免許証番号を設定します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="licNum" size="50"/>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">免許証有効期限（開始）</div>
        <div class="annotation">免許証登録日を表示します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="licEntry" size="8" cssClass="integer"/>
          <script type="text/javascript">
            $('#licEntry').focusout(function(){
            var entry = $('#licEntry').val();
            if(entry.match(/^[0-9]+$/)
            	&& entry.length == 8
            	&& $('#licValid').val() == '') {
              // 5年後登録

              var year = parseInt(entry.substr(0, 4));
              var month = parseInt(entry.substr(4, 2)) - 1;
              var day = parseInt(entry.substr(6, 2));
              var inputDate = new Date(year, month, day);

              //入力された日付不正チェック
              var beforeYear = inputDate.getFullYear();
              var beforeMonth = inputDate.getMonth() + 1;
              if(beforeMonth < 10){
            	  beforeMonth = '0' + beforeMonth;
              }
              var beforeDay = inputDate.getDate();
              if(beforeDay < 10){
            	  beforeDay = '0' + beforeDay;
              }

              if((beforeYear.toString() + beforeMonth.toString() + beforeDay.toString()) == entry){
            	  inputDate = new Date(year + 5, month, day - 1);

                  var afterYear = inputDate.getFullYear();
                  var afterMonth = inputDate.getMonth() + 1;
                  if(afterMonth < 10){
                	  afterMonth = '0' + afterMonth;
                  }
                  var afterDay = inputDate.getDate();
                  if(afterDay < 10){
                	  afterDay = '0' + afterDay;
                  }

                  $('#licValid').val(afterYear.toString() + afterMonth.toString() + afterDay.toString())
              }
            }
          });
        </script>
       </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">免許証有効期限（終了）</div>
        <div class="annotation">免許証有効期間を表示します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="licValid" size="8" cssClass="integer"/>
        </div>

      </div>

      <div class="add_form">
        <div class="add_form_title">宅建取引主任者名</div>
        <div class="annotation">宅建取引主任者名を表示します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="licChief" size="50"/>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">担当者名</div>
        <div class="annotation">担当者名を表示します。</div>
        <div class="form_space">
          <chintai:inputResolveMaxLength path="tantou" size="50"/>
        </div>
      </div>


			<table>
				<tbody>
					<tr>
						<td>
							<div class="add_form">
								<div class="add_form_title">ホームページリンク名称</div>
								<div class="annotation">
									ホームページリンク名称を設定します。<br>
									<br>
								</div>
								<ul style="list-style-type: none;">
									<c:forEach begin="1" end="5" var="i">
										<li class="form_space">
											<chintai:inputResolveMaxLength path="hps[${i}].name" size="64"/>
										</li>
									</c:forEach>
								</ul>
							</div>

						</td>
						<td>
							<div class="add_form">
								<div class="add_form_title">自社ホームページURL</div>
								<div class="annotation">自社ホームページURLを設定します。</div>
								<div class="annotation">入力可能な文字は半角英数字記号、形式はhttp://○○○○○○です。</div>
								<ul style="list-style-type: none;">
									<c:forEach begin="1" end="5" var="i">
										<li class="form_space">
											<chintai:inputResolveMaxLength path="hps[${i}].url" size="64"/>
										</li>
									</c:forEach>
								</ul>
							</div>
						</td>
					</tr>
				</tbody>
			</table>

      <div class="add_form">
        <div class="add_form_title">メールアドレス<span class="caution">*</span></div>
        <div class="annotation">メールアドレスおよび用途を設定します。</div>
        <div class="annotation">入力可能な文字は半角英数字記号、形式は○○○@○○○です。</div>
        <div class="form_space">
			<ul style="list-style-type: none;">
				<c:forEach begin="1" end="5" var="i">
					<li class="form_space">
						<chintai:inputResolveMaxLength path="mails[${i}].email" size="48"/>
						<form:select  path="mails[${i}].useKbn" >
							<form:option value=""></form:option>
							<form:option value="0">共通</form:option>
							<form:option value="1">反響</form:option>
							<form:option value="2">WEB審査</form:option>
							<form:option value="3">営業連絡用</form:option>
						</form:select>
					</li>
				</c:forEach>
			</ul>
		</div>
      </div>

      <div class="add_form">
        <div class="add_form_title">連絡方法 <span class="caution">*</span></div>
        <div class="annotation">連絡方法を表示します。</div>
        <div class="form_space">
          	<label><form:radiobutton path="fmKbn" value="M" checked="checked"/>MAIL</label>
          	<label><form:radiobutton path="fmKbn" value="F"/>FAX</label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">営業時間</div>
        <div class="annotation">営業時間を設定します。</div>
        <div class="form_space">
          <input type="radio" name="businessHoursType" value="0" checked="checked">
          <label>
            <chintai:PropertyOptions id="fromHour" name="fromHour" nameKey="BUSINESS_HOURS_TIME" valueKey="BUSINESS_HOURS_TIME" fixValue="" />時
          </label>
          <label>
            <chintai:PropertyOptions id="fromMin" name="fromMin" nameKey="BUSINESS_HOURS_MINUTE" valueKey="BUSINESS_HOURS_MINUTE" fixValue="" />分
          </label>
          ～
          <label>
            <chintai:PropertyOptions id="toHour" name="toHour" nameKey="BUSINESS_HOURS_TIME" valueKey="BUSINESS_HOURS_TIME" fixValue="" />時
          </label>
          <label>
            <chintai:PropertyOptions id="toMin" name="toMin" nameKey="BUSINESS_HOURS_MINUTE" valueKey="BUSINESS_HOURS_MINUTE" fixValue="" />分
          </label>
        </div>
        <div class="form_space">
          <input type="radio" name="businessHoursType" value="1">
          <chintai:inputResolveMaxLength path="businessHours" size="50"/>
        </div>
        <script type="text/javascript">
        	$(':radio[name=businessHoursType]').click(function(){
				var radio = $(this);
				$(':radio[name=businessHoursType]').parent('div').find(':text,select').prop('disabled',true);
				var e = radio.parent('div').find(':text,select');
				if(radio.prop('checked')){
					e.prop('disabled',false);
				}
        	}).triggerHandler('click');
        	var s = $('#businessHours').val();
        	if(s != ''){
        		var m = s.match(/([01][0-9]|2[0-3]):([01][0-9]|[2-5][0-9])～([01][0-9]|2[0-3]):([01][0-9]|[2-5][0-9])/);
        		if(m){
        			$('#fromHour').val(m[1]);
        			$('#fromMin').val(m[2]);
        			$('#toHour').val(m[3]);
        			$('#toMin').val(m[4]);
        			$('#businessHours').val('');
        		}else{
        			$(':radio[name=businessHoursType][value=1]').prop('checked', true).trigger('click');
        		}
        	}
        	$('#shopBasicInfoUpdateForm').submit(function(){
        		if($(':radio[name=businessHoursType]:checked').val() == '0'){
        			var s1 = $('#fromHour').val();
        			var s2 = $('#fromMin').val();
        			var s3 = $('#toHour').val();
        			var s4 = $('#toMin').val();
        			var msg = [];
        			$('#businessHours').val('');
        			if(s1 != '' && s2 != '' && s3 != '' && s4 != ''){
        				if((s1 + ':' + s2) >= (s3 + ':' + s4)){
        					msg.push('営業時間（終了）が不正です。営業時間(開始)以降の値を入力してください。');
        				}else{
        					$('#businessHours').val(s1 + ':' + s2 + '～' + s3 + ':' + s4).prop('disabled',false);
        				}
        			}else if(s1 == '' && s2 == '' && s3 == '' && s4 == ''){
        				$('#businessHours').prop('disabled',false);
        			}else{

        				if(s1 == ''){
        					msg.push('営業時間(開始時)を選択してください。');
        				}
        				if(s2 == ''){
        					msg.push('営業時間(開始分)を選択してください。');
        				}
        				if(s3 == ''){
        					msg.push('営業時間(終了時)を選択してください。');
        				}
        				if(s4 == ''){
        					msg.push('営業時間(終了分)を選択してください。');
        				}
        			}
        			if(msg.length > 0){
        				var p = $('<p></p>').attr('id','null.errors').addClass('notify').html(msg.join('<br>'));
						$('#null\\.errors').remove();
						$('h1').after(p);
						window.scrollTo(0,0);
						return false;
        			}
        		}
        	});
        </script>
      </div>

      <div class="add_form">
        <div class="add_form_title">定休日</div>
        <div class="annotation">定休日を設定します。</div>
        <div class="form_space">
          <input type="radio" name="holidayType" value="0" checked="checked">
          <chintai:PropertyOptions id="holidayOption" name="holidayOption" nameKey="HOLIDAY" valueKey="HOLIDAY" fixValue="${shopBasicInfoUpdateForm.holiday}" />
        </div>
        <div class="form_space">
          <input type="radio" name="holidayType" value="1">
          <chintai:inputResolveMaxLength path="holiday" size="50"/>
        </div>
        <script type="text/javascript">
	    	$(':radio[name=holidayType]').click(function(){
				var radio = $(this);
				$(':radio[name=holidayType]').parent('div').find(':text,select').prop('disabled',true);
				var e = radio.parent('div').find(':text,select');
				if(radio.prop('checked')){
					e.prop('disabled',false);
				}
	    	}).triggerHandler('click');
        	var s = $('#holiday').val();
        	if(s != ''){
        		if( $('#holidayOption').val() != ''){
       				$('#holiday').val('');
        		}else{
        			$(':radio[name=holidayType][value=1]').prop('checked', true).trigger('click');
        		}
        	}
        	$('#shopBasicInfoUpdateForm').submit(function(){
        		if($(':radio[name=holidayType]:checked').val() == '0'){
       				$('#holiday').val($('#holidayOption').val()).prop('disabled',false);
        		}
        	});
        </script>
      </div>
<%--
      <div class="add_form">
      	<div class="add_form_title">［エイブル専用］混雑時間帯コメント</div>
        <div class="annotation">混雑時間帯コメントを設定します。</div>
        <div class="form_space">
          <fmt:setBundle basename="resources.SystemProperties" var="resource" />
          <fmt:message bundle="${resource}" key="BUSY_COMMEN_SUFFIXT" var="suffuixt" />
          <chintai:inputResolveMaxLength path="busyComment" size="38"/>
          <c:out value="${suffuixt}" />
        </div>
      </div>
        --%>
			<div class="add_form">
				<div class="add_form_title">［エイブル専用］店舗名ひらがな名称</div>
				<div class="annotation">この店舗のひらがなの読みを設定します。</div>
				<div class="form_space">
					<chintai:inputResolveMaxLength path="bumonkana" size="50"/>
				</div>
			</div>

			<div class="add_form">
				<div class="add_form_title">
					CHINTAI支社<c:if test="${empty shopBasicInfoUpdateForm.shopcd}"><span class="caution">*</span></c:if>
				</div>
				<div class="annotation">支社を設定します。支社を設定していない場合、承認状態を承認済に変更できません。</div>
				<div class="form_space">
					<select id="ctShisyaCd" name="ctShisyaCd">
						<option label="" value=""></option>
					</select>
					<c:set var="json">
						<json:array items="${masterService.selectMstCtShisya()}" var="item">
							<json:object>
								<json:property name="ctShisyaCd" value="${item.ctShisyaCd}"/>
								<json:property name="ctShisyaName" value="${item.ctShisyaName}"/>
								<json:property name="zipcd" value="${item.zipcd}"/>
								<json:property name="prefcd" value="${item.prefcd}"/>
								<json:property name="address1" value="${item.address1}"/>
								<json:property name="address2" value="${item.address2}"/>
								<json:property name="tel" value="${item.tel}"/>
								<json:property name="fax" value="${item.fax}"/>
								<json:property name="shisyaKbn" value="${item.shisyaKbn}"/>
								<json:array name="emails">
									<json:property value="${item.email1}"/>
									<json:property value="${item.email2}"/>
									<json:property value="${item.email3}"/>
									<json:property value="${item.email4}"/>
									<json:property value="${item.email5}"/>
								</json:array>
							</json:object>
						</json:array>
					</c:set>
					<script type="text/javascript">
						var data = ${json};
						var ctShisyaCd = $('#ctShisyaCd');
						$.each(data,function(){
							ctShisyaCd.append($('<option />').html(this.ctShisyaName).val(this.ctShisyaCd).data('shisya',this));
						});
						ctShisyaCd.change(function(){
							var _selectMail = $('#_selectMail');
							_selectMail.children().remove();
							$(this).children('option:selected').each(function(){
								var shisya = $(this).data('shisya');
								_selectMail.data('shisya',shisya);
								$.each(shisya.emails,function(){
									if(this != '')
										_selectMail.append($('<option />').html(this).val(this));
								});
							});
						});
						$(function(){
							ctShisyaCd.val('${shopBasicInfoUpdateForm.ctShisyaCd}').change();
						});
					</script>
				</div>
			</div>
			<div class="add_form">
				<div class="add_form_title">通知先情報<c:if test="${empty shopBasicInfoUpdateForm.shopcd}"><span class="caution">*</span></c:if></div>
				<div class="annotation">CHINTAI支社に紐付く通知先メールアドレスを選択します。（複数選択可能です。）</div>
				<div class="form_space">
					<select id="_selectMail" size="5" multiple style="width: 100%">
					</select>
					<input type="button" id="_btnAddEmail" value="追加">
				</div>
				<div class="add_form">
					<div class="annotation">通知先メールアドレスを設定します。（カンマ区切りで複数入力可能です。）</div>
					<div class="form_space">
						<chintai:textareaResolveMaxLength path="noticeEmail" rows="5" cols="80" />
					</div>
				</div>
				<script type="text/javascript">
					$('#_btnAddEmail').click(function(){
						var _emailTextArea = $('#noticeEmail');
						var emails = _emailTextArea.val().split(',');
						$('#_selectMail option:selected').each(function(){
							var email = $(this).val();
							if($.inArray(email,emails) == -1){
								emails.push(email);
							}
						});
						_emailTextArea.val(emails.filter(Boolean).join(',')).change();
					});
				</script>
			</div>
			<div class="add_form">
				<div class="add_form_title">反響管理用メールアドレス</div>
				<div class="annotation">反響管理用メールアドレスを設定します。</div>
				<div class="form_space">
					<chintai:inputResolveMaxLength path="inqMngEmail" size="50"/>
				</div>
			</div>
			<div class="add_form">
				<div class="add_form_title">店舗LINE＠ID</div>
				<div class="annotation">店舗のLINE＠IDを設定します。</div>
				<div class="form_space">
					<chintai:inputResolveMaxLength path="lineAccount" size="30"/>
				</div>
			</div>
			<p>
			<form:hidden path="shopcd"/>
			<form:hidden path="shopKanriUpdDt"/>
        	<input type="submit" value="確認画面へ">
        	<c:if test="${!empty shopBasicInfoUpdateForm.shopcd}">
        		<input type="submit" name="${BaseController.CANCEL_KEY}" value="戻る">
        	</c:if>
    	</p>
	</form:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->
<%@ include file="../parts/ContentsFooter.jsp" %>