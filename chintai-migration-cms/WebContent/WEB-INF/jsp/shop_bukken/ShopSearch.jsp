<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="店舗・契約管理" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

<c:set var="view" value="${ShopSearchView}" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index.do">トップページ </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>

    <html:messages id ="errmsg" header="errors.header" footer="errors.footer">
      <c:out value="${errmsg}"></c:out><br>
    </html:messages>
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/><br>
    </html:messages>

	<p><a href="<c:url value='ShopBasicInfoAdd.admin'/>" target="_blank">&gt;&gt; 店舗基本情報を登録する</a></p>

    <form method="get" onsubmit="search();">
      <p class="section_header">検索条件設定</p>

      <table class="type_search_shop">
        <tr>
          <th>
            店舗情報から<br>検索
          </th>
          <td>
            <table class="type_searchbox">
              <tr>
                <td>
                  <span class="small">店舗コード</span>
                </td>
                <td>
                  <input type="text" name="shopCd" value="<c:out value="${view.shopCd}"/>" size="9" maxlength="9">

                </td>
                <td>
                  店舗メール
                </td>
                <td>
                  <input type="text" name="shopEmail" value="<c:out value="${view.shopEmail}"/>" size="9" maxlength="256">
                </td>
                <td>
                  代表者名
                </td>
                <td>
                  <input type="text" name="licTrustName" value="<c:out value="${view.licTrustName}"/>" size="9" maxlength="50">
                </td>
                <td>
                  代表TEL/FAX
                </td>
                <td>
                  <input type="text" name="shopTelFax" value="<c:out value="${view.shopTelFax}"/>" size="9" maxlength="20">
                </td>
              </tr>
              <tr>
                <td>
                  会社名/事務所名
                </td>
                <td colspan="7">
                  <input type="text" name="companyBumonName" value="<c:out value="${view.companyBumonName}"/>" size="30" maxlength="400">
                  <chintai:PropertyOptions name="andOrmode" fixValue="${view.andOrmode}" nameKey="AND_OR_NAME" valueKey="AND_OR_VALUE"/>
                  ※複数入力の場合は単語を半角スペースで区切って下さい。
                </td>
              </tr>
              <tr>
                <td>
                  最終更新日時
                </td>
                <td colspan="7">
                  <chintai:DateTag name="updDtFromYear" fixValue="${view.updDtFromYear}" type="year" /> 年
                  <chintai:DateTag name="updDtFromMonth" fixValue="${view.updDtFromMonth}" type="month" /> 月
                  <chintai:DateTag name="updDtFromDay" fixValue="${view.updDtFromDay}"  type="day" /> 日
                  <chintai:DateTag name="updDtFromTime" fixValue="${view.updDtFromTime}"  type="time" /> 時&nbsp;&nbsp;～
                  <chintai:DateTag name="updDtToYear" fixValue="${view.updDtToYear}"  type="year" /> 年
                  <chintai:DateTag name="updDtToMonth" fixValue="${view.updDtToMonth}"  type="month" /> 月
                  <chintai:DateTag name="updDtToDay" fixValue="${view.updDtToDay}"  type="day" /> 日
                  <chintai:DateTag name="updDtToTime" fixValue="${view.updDtToTime}"  type="time" /> 時&nbsp;&nbsp;
                </td>
              </tr>
              <tr>
                <td colspan="2">
                  有効物件数が 0 の店舗だけを表示
                  <c:choose>
                    <c:when test="${view.noBukkenShop == '1'}">
                      <input type="checkbox" name="noBukkenShop" value="1" checked="checked" />
                    </c:when>
                    <c:otherwise>
                      <input type="checkbox" name="noBukkenShop" value="1" />
                    </c:otherwise>
                  </c:choose>
                </td>
              </tr>
            </table>

            <table class="type_searchbox">
              <tr>
                <td>
                  承認
                </td>
                <td>
                  <chintai:PropertyOptions name="certifyFlg" fixValue="${view.certifyFlg}" nameKey="SHOPBUKKEN_CERTIFY_FLG_NAME" valueKey="SHOPBUKKEN_CERTIFY_FLG_VALUE" style="width:70px"/>
                </td>
                <td>
                  状態
                </td>
                <td>
                  <chintai:PropertyOptions name="shopStatus" fixValue="${view.shopStatus}" nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" style="width:70px"/>
                </td>
                <td>
                  CHINTAI<br>掲載
                </td>
                <td>
                  <chintai:PropertyOptions name="ctFlg" fixValue="${view.ctFlg}" nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" style="width:90px"/>
                </td>
                <td>
                  エイブル<br>掲載
                </td>
                <td>
                  <chintai:PropertyOptions name="ablFlg" fixValue="${view.ablFlg}" nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" style="width:90px"/>
                </td>
              </tr>
            </table>

            <table class="type_searchbox">
              <tr>
                <td>
                	<c:forEach items="${masterService.selectMstShopKeiyakuKanriCmsSearch()}" var="keiyakuKanri" varStatus="status">
						<div style="float:left;margin:0 0 5px 5px;${status.index % 4 == 0 ? 'clear: both;':''}">
                			<c:out value="${keiyakuKanri.keiyakuName}" />
		                	<chintai:springSelect path='ShopSearchView.shopKeiyakus[${keiyakuKanri.keiyakuCd}|${keiyakuKanri.keiyakuSubCd}]' pathType="map">
		                		<form:option value=""></form:option>
		                		<form:option value="0">未契約</form:option>
		                		<form:option value="1">契約済</form:option>
		                	</chintai:springSelect>
						</div>
                	</c:forEach>
                </td>
              </tr>
            </table>

            <table class="type_searchbox">
              <tr>
				<td>
                 	 連動元
                </td>
                <td colspan="3">
                	<form:select path="ShopSearchView.rendoCd" style="width:170px">
                		<form:option value=""></form:option>
                		<form:options items="${masterService.selectMstRendo()}" itemValue="rendoCd" itemLabel="rendoName"/>
                	</form:select>
                </td>
              </tr>
            </table>

          </td>
        </tr>
        <tr>
          <th>
            地域・沿線から<br>検索
          </th>
          <td>
            <table class="type_searchbox">
              <tr>
                <td rowspan="2">
                  エリア
                </td>
                <td rowspan="2">
                  <select name="area" style="width: 80px" onchange="putPrefList();putEnsenList();" id="area">
                  </select>
                </td>
                <td>
                  <label>
                    <c:choose>
                      <c:when test="${view.kbnAreaRosen == '1'}">
                        <input type="radio" name="kbnAreaRosen" value="1" onClick="putPrefList();" checked="checked">地域
                      </c:when>
                      <c:otherwise>
                        <input type="radio" name="kbnAreaRosen" value="1" onClick="putPrefList();">地域
                      </c:otherwise>
                    </c:choose>
                  </label>
                </td>
                <td>
                  <select name="pref" style="width: 110px" onChange="putCityList()" id="pref">
                  </select>
                </td>
                <td colspan="2">
                  <select name="city" style="width: 180px" id="city">
                  </select>
                </td>
              </tr>
              <tr>
                <td>
                  <label>
                    <c:choose>
                      <c:when test="${view.kbnAreaRosen == '2'}">
                        <input type="radio" name="kbnAreaRosen" value="2" onClick="putEnsenList()" checked="checked">沿線
                      </c:when>
                      <c:otherwise>
                        <input type="radio" name="kbnAreaRosen" value="2" onClick="putEnsenList()">沿線
                      </c:otherwise>
                    </c:choose>
                  </label>
                </td>
                <td>
                  <chintai:PropertyOptions name="ensenType" fixValue="${view.ensenType}" nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" onChange="putEnsenList()"/>
                </td>
                <td>
                  <select name="ensen" style="width: 180px" onChange="putEkiList()" id="ensen">
                  </select>
                </td>
                <td>
                  <select name="eki" style="width: 180px" id="eki">
                  </select>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr>
          <th>
            検索結果の出力方法
          </th>
          <td>
            <table class="type_searchbox">
              <tr>
                <td>
                  ソートキー
                </td>
                <td>
                  <chintai:PropertyOptions name="sortKey" fixValue="${view.sortKey}" nameKey="SHOPBUKKEN_SORT_KEY_NAME" valueKey="SHOPBUKKEN_SORT_KEY_VALUE"/>
                </td>
                <td>
                  順序
                </td>
                <td>
                  <chintai:PropertyOptions name="orderBy" fixValue="${view.orderBy}" nameKey="ORDER_BY_NAME" valueKey="ORDER_BY_VALUE"/>
                </td>
                <td>
                  表示件数
                </td>
                <td>
                  <c:choose>
                    <c:when test="${view.displayNum == ''}">
                      <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="50"/>
                    </c:when>
                    <c:otherwise>
                      <chintai:PropertyOptions name="displayNum" nameKey="DISPLAY_NUM_NAME" valueKey="DISPLAY_NUM_VALUE" fixValue="${view.displayNum}"/>
                    </c:otherwise>
                  </c:choose>
                </td>
                <td>
                  出力先
                </td>
                <td>
                <%--
                  <chintai:PropertyOptions name="outputMode" fixValue="${view.outputMode}" nameKey="DISPLAY_TYPE_NAME" valueKey="DISPLAY_TYPE_VALUE"/>
                --%>
				<select name="outputMode">
					<option value="gamen">画面</option>
				</select>
                </td>
              </tr>
            </table>
          </td>
        </tr>
      </table>
      <p>
        <input type="hidden" name="updateFrom">
        <input type="hidden" name="updateTo">
        <input type="hidden" name="offSet">
        <input type="submit" value="検索">
        <input type="reset" value="クリア" onclick="resetForm();">
      </p>
    </form>

    <!-- 検索結果 -->
    <c:if test="${not empty ShopSearchView.shopSearchList}">
      <p class="section_header">検索結果</p>
      <c:set var="helper" value="${ShopSearchView}"/>
      <%@ include file="/WEB-INF/jsp/parts/PagerHeader.jsp" %>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
      <table class="type_list_nomargin">
			<colgroup>
				<col width="10%">
				<col width="36%">
				<col width="18%">
				<col width="18%">
				<col width="18%">
			</colgroup>
        <tr>
          <th>店舗コード</th>
          <th>会社名<br>事務所名</th>
          <th>承認<br>状態</th>
          <th>CHINTAI掲載<br>エイブル掲載</th>
          <th>連動元</th>
        </tr>
        <c:forEach items="${ShopSearchView.shopSearchList}" var="shopSearchList" varStatus="i">
          <tr>
            <td>
              <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${shopSearchList.shopCd}"/></c:url>" target="_blank">
                <c:out value="${shopSearchList.shopCd}"></c:out>
              </a>
            </td>
            <td class="left"><c:out value="${shopSearchList.company}"/><br><c:out value="${shopSearchList.bumon}"/></td>
            <td>
              <chintai:CodePrint nameKey="CERTIFY_FLG_NAME" valueKey="CERTIFY_FLG_VALUE" code="${shopSearchList.certifyFlg}"/><br>
              <c:if test="${shopSearchList.shopStatus == '0'}"><font color="#FF3333"></c:if>
              <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${shopSearchList.shopStatus}"/>
              <c:if test="${shopSearchList.shopStatus == '0'}"></font></c:if>
            </td>
            <td>
              <chintai:CodePrint nameKey="SHOPBUKKEN_CT_FLG_NAME" valueKey="SHOPBUKKEN_CT_FLG_VALUE" code="${shopSearchList.ctFlg}"/><br>
              <chintai:CodePrint nameKey="SHOPBUKKEN_ABL_FLG_NAME" valueKey="SHOPBUKKEN_ABL_FLG_VALUE" code="${shopSearchList.ablFlg}"/>
            </td>
            <td>
              <c:out value="${shopSearchList.rendoName}"/>
            </td>
          </tr>
        </c:forEach>
      </table>
      <%@ include file="/WEB-INF/jsp/parts/Pager.jsp" %>
    </c:if>

  </div>
</div>

<script type="text/javascript">
<!--
// 「店舗検索」の「地域・沿線から検索」の条件を表示するときに使用する
// 実装の一部分は DWR を使用する
function putAreaList() {
// 地域・沿線から検索のラジオボタンを選択したとき、
// 基本的に｢地域ラジオボタン｣をチェックさせる。
    if("${view.area}" == ''){
        var target = document.getElementsByName('kbnAreaRosen');
        target[0].checked = true;

        var thisForm = document.forms[0];
        thisForm.pref.disabled = false;
        thisForm.city.disabled = false;
        thisForm.ensenType.disabled = true;
        thisForm.ensen.disabled = true;
        thisForm.eki.disabled = true;

        var areaBlankData = [ {  areaCode:"", areaName:"" } ];
        var prefBlankData = [ { prefCode:"", prefName:"" } ];
        var cityBlankData = [ { cityCode:"", cityName:"" } ];
        var ensenBlankData = [ { ensenCode:"", ensenName:"" } ];
        var ekiBlankData = [ { ekiCode:"", ekiName:"" } ];

        AddressEnsenManager.getAreaList( function(ret) {
            dwr.util.removeAllOptions("area");
            dwr.util.addOptions("area", areaBlankData, "areaCode", "areaName");
            dwr.util.addOptions("area", ret, "areaCode", "areaName");

            var areaCode = dwr.util.getValue("area");
            AddressEnsenManager.getPrefList(areaCode, function(ret) {
               dwr.util.removeAllOptions("pref");
               dwr.util.addOptions("pref", prefBlankData, "prefCode", "prefName");
               dwr.util.addOptions("pref", ret, "prefCode", "prefName");

               var prefCode = dwr.util.getValue("pref");
               AddressEnsenManager.getCityList(prefCode, function(ret) {
                  dwr.util.removeAllOptions("city");
                  dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
                  dwr.util.addOptions("city", ret, "cityCode", "cityName");
               });
            });

            var ensenTypeCode = dwr.util.getValue("ensenType");
            AddressEnsenManager.getEnsenList(areaCode, ensenTypeCode, function(ret) {
                dwr.util.removeAllOptions("ensen");
                dwr.util.addOptions("ensen", ensenBlankData, "ensenCode", "ensenName");
                dwr.util.addOptions("ensen", ret, "ensenCode", "ensenName");

                var ensenCode = dwr.util.getValue("ensen");
                AddressEnsenManager.getEkiList(ensenCode, function(ret) {
                    dwr.util.removeAllOptions("eki");
                    dwr.util.addOptions("eki", ekiBlankData, "ekiCode", "ekiName");
                    dwr.util.addOptions("eki", ret, "ekiCode", "ekiName");
                });
            });
        });
    }
}

function putPrefList() {
    var thisForm = document.forms[0];
    var radioObj = document.getElementsByName('kbnAreaRosen');
    var kbnAreaRosenValue = null;
    for(i = 0; i < radioObj.length ; i++){
       if(radioObj[i].checked){
          kbnAreaRosenValue = radioObj[i].value;
       }
    }

    if(kbnAreaRosenValue == 1){
       thisForm.pref.disabled = false;
       thisForm.city.disabled = false;
       thisForm.ensenType.disabled = true;
       thisForm.ensen.disabled = true;
       thisForm.eki.disabled = true;

       var prefBlankData = [ { prefCode:"", prefName:"" } ];
       var cityBlankData = [ { cityCode:"", cityName:"" } ];

       var areaCode = dwr.util.getValue("area");
       AddressEnsenManager.getPrefList(areaCode, function(ret) {
           dwr.util.removeAllOptions("pref");
           dwr.util.addOptions("pref", prefBlankData, "prefCode", "prefName");
           dwr.util.addOptions("pref", ret, "prefCode", "prefName");

           var prefCode = dwr.util.getValue("pref");
           AddressEnsenManager.getCityList(prefCode, function(ret) {
              dwr.util.removeAllOptions("city");
              dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
              dwr.util.addOptions("city", ret, "cityCode", "cityName");
           });
       });
    }
}

function putCityList() {
    var cityBlankData = [ { cityCode:"", cityName:"" } ];
    var prefCode = dwr.util.getValue("pref");
    AddressEnsenManager.getCityList(prefCode, function(ret) {
        dwr.util.removeAllOptions("city");
        dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
        dwr.util.addOptions("city", ret, "cityCode", "cityName");
    });
}

function putEnsenList() {
    var thisForm = document.forms[0];
    var radioObj = document.getElementsByName('kbnAreaRosen');
    var kbnAreaRosenValue = null;
    for(i = 0; i < radioObj.length ; i++){
       if(radioObj[i].checked){
          kbnAreaRosenValue = radioObj[i].value;
       }
    }

    if(kbnAreaRosenValue == 2){
       thisForm.ensenType.disabled = false;
       thisForm.ensen.disabled = false;
       thisForm.eki.disabled = false;
       thisForm.pref.disabled = true;
       thisForm.city.disabled = true;
       var ensenBlankData = [ { ensenCode:"", ensenName:"" } ];
       var ekiBlankData = [ { ekiCode:"", ekiName:"" } ];
       var areaCode = dwr.util.getValue("area");
       var ensenTypeCode = dwr.util.getValue("ensenType");
       AddressEnsenManager.getEnsenList(areaCode, ensenTypeCode, function(ret) {
           dwr.util.removeAllOptions("ensen");
           dwr.util.addOptions("ensen", ensenBlankData, "ensenCode", "ensenName");
           dwr.util.addOptions("ensen", ret, "ensenCode", "ensenName");

           var ensenCode = dwr.util.getValue("ensen");
           AddressEnsenManager.getEkiList(ensenCode, function(ret) {
               dwr.util.removeAllOptions("eki");
               dwr.util.addOptions("eki", ekiBlankData, "ekiCode", "ekiName");
               dwr.util.addOptions("eki", ret, "ekiCode", "ekiName");
           });
       });
    }
}

function putEkiList() {
    var ensenCode = dwr.util.getValue("ensen");
    var ekiBlankData = [ { ekiCode:"", ekiName:"" } ];
    AddressEnsenManager.getEkiList(ensenCode, function(ret) {
        dwr.util.removeAllOptions("eki");
        dwr.util.addOptions("eki", ekiBlankData, "ekiCode", "ekiName");
        dwr.util.addOptions("eki", ret, "ekiCode", "ekiName");
    });
}

// 「店舗検索」の「地域・沿線から検索」の条件を表示するときに使用する
// 検索した後、使用した条件を表示させる機能。
function loadAreaEnsenList(){

        var thisForm = document.forms[0];
        var radioObj = null;
        var searchTypeCode = null;
        var kbnAreaRosenCode = null;

        radioObj = document.getElementsByName('searchType');
        for(i = 0; i < radioObj.length ; i++){
          if(radioObj[i].checked){
            searchTypeCode = radioObj[i].value;
          }
        }

        radioObj = document.getElementsByName('kbnAreaRosen');
        for(i = 0; i < radioObj.length ; i++){
          if(radioObj[i].checked){
            kbnAreaRosenCode = radioObj[i].value;
          }
        }

        if(searchTypeCode == 1){
           disabledAreaEnsenSearch();
        }else if(searchTypeCode == 2){
           disabledShopSearch();

           if(kbnAreaRosenCode == 1){
              thisForm.pref.disabled = false;
              thisForm.city.disabled = false;
              thisForm.ensenType.disabled = true;
              thisForm.ensen.disabled = true;
              thisForm.eki.disabled = true;
           }else if(kbnAreaRosenCode == 2){
              thisForm.ensenType.disabled = false;
              thisForm.ensen.disabled = false;
              thisForm.eki.disabled = false;
              thisForm.pref.disabled = true;
              thisForm.city.disabled = true;
           }
        }

        var areaBlankData = [ { areaCode:"", areaName:"" } ];
        var prefBlankData = [ { prefCode:"", prefName:"" } ];
        var cityBlankData = [ { cityCode:"", cityName:"" } ];
        var ensenBlankData = [ { ensenCode:"", ensenName:"" } ];
        var ekiBlankData = [ { ekiCode:"", ekiName:"" } ];

        if(kbnAreaRosenCode == 1){
           AddressEnsenManager.getAreaList( function(ret) {
               dwr.util.removeAllOptions("area");
               dwr.util.addOptions("area", areaBlankData, "areaCode", "areaName");
               dwr.util.addOptions("area", ret, "areaCode", "areaName");
               dwr.util.setValue("area", "${view.area}");

               var areaCode = dwr.util.getValue("area");
               AddressEnsenManager.getPrefList(areaCode, function(ret) {
                   dwr.util.removeAllOptions("pref");
                   dwr.util.addOptions("pref", prefBlankData, "prefCode", "prefName");
                   dwr.util.addOptions("pref", ret, "prefCode", "prefName");
                   dwr.util.setValue("pref", "${view.pref}");

                   var prefCode = dwr.util.getValue("pref");
                   AddressEnsenManager.getCityList(prefCode, function(ret) {
                       dwr.util.removeAllOptions("city");
                       dwr.util.addOptions("city", cityBlankData, "cityCode", "cityName");
                       dwr.util.addOptions("city", ret, "cityCode", "cityName");
                       dwr.util.setValue("city", "${view.city}");
                   });
               });
           });
        }else{
           AddressEnsenManager.getAreaList( function(ret) {
               dwr.util.removeAllOptions("area");
               dwr.util.addOptions("area", areaBlankData, "areaCode", "areaName");
               dwr.util.addOptions("area", ret, "areaCode", "areaName");
               dwr.util.setValue("area", "${view.area}");

               AddressEnsenManager.getEnsenList("${view.area}", "${view.ensenType}", function(ret) {
                   dwr.util.removeAllOptions("ensen");
                   dwr.util.addOptions("ensen", ensenBlankData, "ensenCode", "ensenName");
                   dwr.util.addOptions("ensen", ret, "ensenCode", "ensenName");
                   dwr.util.setValue("ensen", "${view.ensen}");

                   var ensenCode = dwr.util.getValue("ensen");
                   AddressEnsenManager.getEkiList(ensenCode, function(ret) {
                       dwr.util.removeAllOptions("eki");
                       dwr.util.addOptions("eki", ekiBlankData, "ekiCode", "ekiName");
                       dwr.util.addOptions("eki", ret, "ekiCode", "ekiName");
                       dwr.util.setValue("eki", "${view.eki}");
                   });
               });
           });
        }

}

function disabledShopSearch(){
    var thisForm = document.forms[0];
    var kbnAreaRosenCode = null;

    thisForm.shopCd.disabled = true;
    thisForm.shopEmail.disabled = true;
    thisForm.licTrustName.disabled = true;
    thisForm.shopTelFax.disabled = true;
    thisForm.companyBumonName.disabled = true;
    thisForm.andOrmode.disabled = true;
    thisForm.noBukkenShop.disabled = true;
    thisForm.updDtFromYear.disabled = true;
    thisForm.updDtFromMonth.disabled = true;
    thisForm.updDtFromDay.disabled = true;
    thisForm.updDtFromTime.disabled = true;
    thisForm.updDtToYear.disabled = true;
    thisForm.updDtToMonth.disabled = true;
    thisForm.updDtToDay.disabled = true;
    thisForm.updDtToTime.disabled = true;
    thisForm.certifyFlg.disabled = true;
    thisForm.shopStatus.disabled = true;
    thisForm.ctFlg.disabled = true;
    thisForm.ablFlg.disabled = true;
    thisForm.clientSystemType.disabled = true;
    thisForm.aspFlg.disabled = true;
    thisForm.adparkFlg.disabled = true;

    var target = document.getElementsByName('kbnAreaRosen');
    if("${view.kbnAreaRosen}" == 1){
       thisForm.area.disabled = false;
       target[0].checked = true;
       thisForm.kbnAreaRosen[0].disabled = false;
       thisForm.kbnAreaRosen[1].disabled = false;
       thisForm.pref.disabled = false;
       thisForm.city.disabled = false;
       thisForm.ensenType.disabled = true;
       thisForm.ensen.disabled = true;
       thisForm.eki.disabled = true;
    }else if("${view.kbnAreaRosen}" == 2){
       thisForm.area.disabled = false;
       target[1].checked = true;
       thisForm.kbnAreaRosen[0].disabled = false;
       thisForm.kbnAreaRosen[1].disabled = false;
       thisForm.ensenType.disabled = false;
       thisForm.ensen.disabled = false;
       thisForm.eki.disabled = false;
       thisForm.pref.disabled = true;
       thisForm.city.disabled = true;
    }else{
       thisForm.area.disabled = false;
       target[0].checked = true;
       thisForm.kbnAreaRosen[0].disabled = false;
       thisForm.kbnAreaRosen[1].disabled = false;
       thisForm.pref.disabled = false;
       thisForm.city.disabled = false;
       thisForm.ensenType.disabled = true;
       thisForm.ensen.disabled = true;
       thisForm.eki.disabled = true;
       putAreaList();
    }
}

function disabledAreaEnsenSearch(){
    var thisForm = document.forms[0];

    thisForm.shopCd.disabled = false;
    thisForm.shopEmail.disabled = false;
    thisForm.licTrustName.disabled = false;
    thisForm.shopTelFax.disabled = false;
    thisForm.companyBumonName.disabled = false;
    thisForm.andOrmode.disabled = false;
    thisForm.noBukkenShop.disabled = false;
    thisForm.updDtFromYear.disabled = false;
    thisForm.updDtFromMonth.disabled = false;
    thisForm.updDtFromDay.disabled = false;
    thisForm.updDtFromTime.disabled = false;
    thisForm.updDtToYear.disabled = false;
    thisForm.updDtToMonth.disabled = false;
    thisForm.updDtToDay.disabled = false;
    thisForm.updDtToTime.disabled = false;
    thisForm.certifyFlg.disabled = false;
    thisForm.shopStatus.disabled = false;
    thisForm.ctFlg.disabled = false;
    thisForm.ablFlg.disabled = false;
    thisForm.clientSystemType.disabled = false;
    thisForm.aspFlg.disabled = false;
    thisForm.adparkFlg.disabled = false;

    thisForm.area.disabled = true;
    var target = document.getElementsByName('kbnAreaRosen');
    target[0].checked = false;
    target[0].checked = false;
    thisForm.kbnAreaRosen[0].disabled = true;
    thisForm.kbnAreaRosen[1].disabled = true;
    thisForm.pref.disabled = true;
    thisForm.city.disabled = true;
    thisForm.ensenType.disabled = true;
    thisForm.ensen.disabled = true;
    thisForm.eki.disabled = true;
}

function setSubmit(){
    var thisForm = document.forms[0];
    var sDate = thisForm.updDtFromYear.value + thisForm.updDtFromMonth.value + thisForm.updDtFromDay.value + thisForm.updDtFromTime.value;
    var eDate = thisForm.updDtToYear.value + thisForm.updDtToMonth.value + thisForm.updDtToDay.value + thisForm.updDtToTime.value;
    thisForm.updateFrom.value = sDate;
    thisForm.updateTo.value = eDate;

    thisForm.action = 'ShopSearch.do';
}

function page(offSet){
    var thisForm = document.forms[0];
    thisForm.offSet.value=offSet;

    target = document.getElementsByName('noBukkenShop');
    if("${view.noBukkenShop}" == 1){
      target[0].checked = true;
    }else{
      target[0].checked = false;
    }

    var target = document.getElementsByName('kbnAreaRosen');
    if("${view.kbnAreaRosen}" == 1){
      target[0].checked = true;
      thisForm.pref.disabled = false;
      thisForm.city.disabled = false;
      thisForm.ensenType.disabled = true;
      thisForm.ensen.disabled = true;
      thisForm.eki.disabled = true;
    }else{
      target[1].checked = true;
      thisForm.pref.disabled = true;
      thisForm.city.disabled = true;
      thisForm.ensenType.disabled = false;
      thisForm.ensen.disabled = false;
      thisForm.eki.disabled = false;
    }

    var thisForm = document.forms[0];
    var sDate = thisForm.updDtFromYear.value + thisForm.updDtFromMonth.value + thisForm.updDtFromDay.value + thisForm.updDtFromTime.value;
    var eDate = thisForm.updDtToYear.value + thisForm.updDtToMonth.value + thisForm.updDtToDay.value + thisForm.updDtToTime.value;
    var searchTypeValue;
    thisForm.updateFrom.value = sDate;
    thisForm.updateTo.value = eDate;

    var radioObj = document.getElementsByName('searchType');
    for(i = 0; i < radioObj.length ; i++){
      if(radioObj[i].checked){
        searchTypeValue = radioObj[i].value;
      }
    }
/*
    if(searchTypeValue == 1){
      thisForm.action = 'ShopSearchByShopInfoPaging.do';
    }else{
      thisForm.action = 'ShopSearchByAreaPaging.do';
    }
*/
	thisForm.action = 'ShopSearch.do';
    thisForm.submit();
}

function search(){
     document.forms[0].offSet.value="";
     setSubmit();
}

function resetForm(){
     var thisForm = document.forms[0];

     target = document.getElementsByName('kbnAreaRosen');
     if("${view.kbnAreaRosen}" == 1){
        target[0].checked = true;
     }else{
        target[1].checked = true;
     }

    loadAreaEnsenList();
}

// 'load'のeventに検索した後、使用した条件を表示させる関数を設定。
addEvent('load', window, loadAreaEnsenList);
addEvent('load', window, function(){document.getElementsByName('shopCd')[0].focus();});
$(function(){
	$(':radio[name=kbnAreaRosen]:checked').triggerHandler('click');
});
//-->
</script>

<%@ include file="../parts/ContentsFooter.jsp" %>