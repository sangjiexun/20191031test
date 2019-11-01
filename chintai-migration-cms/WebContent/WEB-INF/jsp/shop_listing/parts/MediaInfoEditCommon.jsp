<%@ page contentType="text/html;charset=UTF-8" language="Java" %>

<script src="${pageContext.request.contextPath}/dwr/interface/AddressEnsenManager.js"></script>
<script src="${pageContext.request.contextPath}/dwr/engine.js"></script>
<script src="${pageContext.request.contextPath}/dwr/util.js"></script>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &nbsp;&gt;&nbsp;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <html:form action="/shop_listing/MediaInfoRegisterConfirm" onsubmit="setHiddenValue();">
      <p class="section_header">出稿情報</p>
      <div class="add_form">
        <div class="add_form_title">出稿対象駅指定</div>
        <div class="annotation">出稿対象駅（最大２０駅）を指定します。</div>
        <div class="form_space">
          エリア
          <chintai:Area name="areaCd" onChange="childControl(this.name, 'ensenTypeCd');" />&nbsp;&nbsp;
          沿線タイプ
          <chintai:PropertyOptions name="ensenTypeCd" nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" onChange="putEnsenList();" />
          沿線
          <select name="ensenCd" style="width: 180px" onChange="putEkiList();">
          </select>&nbsp;&nbsp;
          駅
          <select name="ekiCd" style="width: 180px" onChange="setDiabledAddEki();">
          </select>&nbsp;&nbsp;
          <input type="button" name="btnAddEki" value="追加" onClick="addEki();"/>
        </div>
        <div class="annotation">選択済みの駅リスト</div>
        <div class="form_space">
          <select name="selectEki" size="5" multiple style="width: 70%" onChange="setDisableSelectEki();">
          </select>&nbsp;&nbsp;
          <input type="button" name="btnDeleteEki" value="選択中の駅を削除" onClick="deleteEki();"/>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">出稿対象市区町村指定</div>
        <div class="annotation">出稿対象市区町村（最大２０市区町村）を指定します。</div>
        <div class="form_space">
          エリア
          <chintai:Area name="cityAreaCd" onChange="childControl(this.name, 'prefCd');putPrefList();" />&nbsp;&nbsp;
          都道府県
          <select name="prefCd" style="width: 110px" onChange="putCityList();">
          </select>
          市区町村
          <select name="cityCd" style="width: 180px" onChange="setDiabledAddCity();">
          </select>
          <input type="button" name="btnAddCity" value="追加" onClick="addCity();"/>
        </div>
        <div class="annotation">選択済みの市区町村リスト</div>
        <div class="form_space">
          <select name="selectedCity" size="5" multiple style="width: 70%" onChange="setDisableSelectCity();">
          </select>&nbsp;&nbsp;
          <input type="button" name="btnDeleteCity" value="選択中の市区町村を削除" onClick="deleteCity();"/>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">キャッチフレーズ<span class="caution">*</span></div>
          <table>
            <tr>
              <td><div class="annotation">キャッチフレーズを設定します。</div></td>
              <td align="right"><div id="progressbar1" class="progress"></div></td>
            </tr>
            <tr>
              <td colspan="2" >
                <div class="form_space">
                  <textarea rows="2" cols="80" name="catchPhrase"id="catchphrase"
                         onKeyDown="textCounter(this,'progressbar1',20)"
                         onKeyUp="textCounter(this,'progressbar1',20)"
                         onFocus="textCounter(this,'progressbar1',20)"><c:out value="${view.catchPhrase}" /></textarea>
              </td>
            </tr>
          </table>
      </div>

      <div class="add_form">
        <div class="add_form_title">アピールコメント<span class="caution">*</span></div>
        <table>
          <tr>
            <td><div class="annotation">アピールコメントを設定します。</div></td>
            <td align="right"><div id="progressbar2" class="progress"></div></td>
          </tr>
          <tr>
            <td colspan="2" >
              <div class="form_space">
                <textarea rows="5" cols="80" name="appealComment" id="appealComment"
                  onKeyDown="textCounter(this,'progressbar2',200)"
                  onKeyUp="textCounter(this,'progressbar2',200)"
                  onFocus="textCounter(this,'progressbar2',200)" ><c:out value="${view.appealComment}" /></textarea><br />
              </div>
            </td>
          </tr>
        </table>
      </div>

      <div class="add_form">
        <div class="add_form_title">店舗画像<span class="caution">*</span></div>
        <div class="annotation">リスティングに表示する店舗画像を設定します。</div>
        <div class="form_space">
          <table class="type_list">
            <colgroup>
              <col width="10%" id="shopImgTd2">
              <col width="23%" id="shopImgDetailTd2">
              <col width="10%" id="shopImgTd3">
              <col width="23%" id="shopImgDetailTd3">
              <col width="34%" id="shopImgTd1">
            </colgroup>
            <tr>
              <th colspan="2">店舗画像(左側)</th>

              <th colspan="2">店舗画像(右側)</th>
              <th>表示しない</th>
            </tr>
            <tr>
              <td colspan="2">
                <label for="shopImg1">
<c:choose>
  <c:when test="${not empty view.shopImgLeft}">
                  <img src="${view.shopImgLeft}"  id="img1" onload="setImageInfo('img1', 'picSize1','fileSize1','rate1');" />
  </c:when>
  <c:otherwise>
                  「画像が登録されていません。」
  </c:otherwise>
</c:choose>

                </label>
              </td>
              <td colspan="2">
                <label>
<c:choose>
  <c:when test="${not empty view.shopImgRight}">
                  <img src="${view.shopImgRight}" id="img2" onload="setImageInfo('img2', 'picSize2','fileSize2','rate2');" />
  </c:when>
  <c:otherwise>
                  「画像が登録されていません。」
  </c:otherwise>
</c:choose>
                </label>
              </td>
              <td rowspan="5"><input type="radio" name="picFlg" value="0" onClick="changeShopImg();" /> </td>
            </tr>
            <tr>
              <th>大きさ(横×縦)</th>
              <td id="picSize1"></td>
              <th>大きさ(横×縦)</th>
              <td id="picSize2"></td>
            </tr>
            <tr>
              <th>サイズ</th>
              <td id="fileSize1"></td>
              <th>サイズ</th>


              <td id="fileSize2"></td>
            </tr>
            <tr>
              <th>比率(横：縦)</th>
              <td>
              <label id="rate1"></label>&nbsp;
              <span class="caution">(推奨比率 1：0.75)</span>
              </td>
              <th>比率(横：縦)</th>
              <td>
              <label id="rate2"></label>&nbsp;
              <span class="caution">(推奨比率 1：0.75)</span>
              </td>
            </tr>

            <tr>
              <td colspan="2"><input type="radio" id="shopImg2" name="picFlg" value="1" onClick="changeShopImg();" checked="checked"/></td>
              <td colspan="2"><input type="radio" id="shopImg3" name="picFlg" value="2" onClick="changeShopImg();"/></td>
            </tr>
          </table>
        </div>
      </div>

     <div class="add_form">
      <div class="add_form_title">アピールアイコン</div>
      <div class="annotation">アピールアイコン/リスティングを設定します（アピールアイコンは全選択可能/リスティングは2個まで選択可能）。</div>
      <div class="form_space">
          <table class="type_list" style="width: 99%;">
            <colgroup>
              <col width="10%">
              <col width="15%" align="left">
              <col width="30%" align="left">
              <col width="5%">
              <col width="15%">
              <col width="15%">
            </colgroup>
            <tr>
              <th>アピール<br>アイコン</th>
              <th align="center">アイコン名</th>
              <th align="center">内容</th>
              <th>種別</th>
              <th>アピールアイコン</th>
              <th>リスティング選択</th>
            </tr>
<c:forEach items="${view.detailList}" var="detail" varStatus="i" begin="1">
            <tr>
              <td><img alt="${detail.iconName}" src="${detail.iconImgPath}"></td>
              <td><c:out value="${detail.iconName}" /></td>
              <td><c:out value="${detail.iconComment}" /></td>
              <td><c:out value="${detail.iconShubetsu}" /></td>
              <td><input type="checkbox" name="chkAppeal" value="${i.index}" onClick="controlCheckbox(this,'chkListing${i.index}');"></td>
              <td><input type="checkbox" name="chkListing" id="chkListing${i.index}" value="${i.index}" disabled="disabled"></td>
            </tr>
</c:forEach>
          </table>
        </div>
      </div>

    <div class="add_form">
      <div class="add_form_title">クーポン情報　注釈</div>
      <div class="annotation">クーポン情報の注釈を入力します。</div>
        <table class="type_detail">
          <colgroup>
            <col width="10%" align="center">
            <col width="5%" align="center">
            <col width="85%">
          </colgroup>
          <tr>
            <th rowspan="3">注釈</th>
            <th>①</th>
            <td><input type="text" name="couponComment1" value="${view.couponComment1}" size="80" maxlength="30"></td>
          </tr>
          <tr>
            <th>②</th>
            <td><input type="text" name="couponComment2" value="${view.couponComment2}" size="80" maxlength="30"></td>
          </tr>
          <tr>
            <th>③</th>
            <td><input type="text" name="couponComment3" value="${view.couponComment3}" size="80" maxlength="30"></td>
          </tr>
        </table>
    </div>

      <div class="add_form">
        <div class="add_form_title">備考</div>
        <div class="annotation">この店舗の出稿情報に関するメモなどを入力します。</div>
          <textarea name="note" rows="5" cols="50"><c:out value="${view.note}" /></textarea>
      </div>

      <!-- HIDDEN -->
      <input type="hidden" name="selectEkiValue"/>
      <input type="hidden" name="selectCityValue"/>
      <input type="hidden" name="chkListingCnt" />
      <input type="hidden" name="shopCd" value="${view.shopCd}"/>
      <input type="hidden" name="shopImgLeft" value="${view.shopImgLeft}" />
      <input type="hidden" name="shopImgRight" value="${view.shopImgRight}" />
      <input type="hidden" name="clientSystemType" value="${view.clientSystemType}"/>

      <p>
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('KeiyakuShopInfo.do');">
      </p>

    </html:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->
<script type="text/javascript">
<!--

function setDiabledAddEki(){
  // Init
  var thisForm = document.forms[0];
  var isSelectEki = false;

  // 既に選択されているかチェックする
  for(var loop = 0; loop < thisForm.selectEki.length; loop++){
    isSelectEki = isSelectEki ||
                  thisForm.selectEki[loop].value == thisForm.ekiCd[thisForm.ekiCd.selectedIndex].value;
  }

  thisForm.btnAddEki.disabled = thisForm.areaCd.selectedIndex == 0 ||
                                thisForm.ensenTypeCd.selectedIndex == 0 ||
                                thisForm.ensenCd.selectedIndex == 0 ||
                                thisForm.ekiCd.selectedIndex == 0 ||
                                thisForm.selectEki.length >= 20 ||
                                isSelectEki;
}

function setDisableSelectEki(){
  // Init
  var thisForm = document.forms[0];

  // リスト
  thisForm.selectEki.disabled = thisForm.selectEki.length == 0;

  // 削除ボタン
  thisForm.btnDeleteEki.disabled = true;
  for(var loop = thisForm.selectEki.length - 1; loop >= 0; loop--){
    if(thisForm.selectEki[loop].selected){
      thisForm.btnDeleteEki.disabled = false;
    }
  }
}

function addEki(){
  // Init
  var thisForm = document.forms[0];

  // コンボボックスで選択されている駅をリストに追加
  thisForm.selectEki[thisForm.selectEki.length] = new Option(thisForm.ensenCd[thisForm.ensenCd.selectedIndex].text + '　' +
                                                             thisForm.ekiCd[thisForm.ekiCd.selectedIndex].text,
                                                             thisForm.ensenCd[thisForm.ensenCd.selectedIndex].value +
                                                             thisForm.ekiCd[thisForm.ekiCd.selectedIndex].value);

  // HIDDENにValueをセットする
  thisForm.selectEkiValue.value = '';
  for(var loop = 0; loop < thisForm.selectEki.length; loop++){
    if(loop == 0){
      thisForm.selectEkiValue.value = thisForm.selectEki[loop].value;
    }else{
      thisForm.selectEkiValue.value = thisForm.selectEkiValue.value + ',' + thisForm.selectEki[loop].value;
    }
  }

  // 駅追加ボタンのDisabled設定
  setDiabledAddEki();

  // 駅選択リストのDisabled設定
  setDisableSelectEki();
}

function deleteEki(){
  // Init
  var thisForm = document.forms[0];

  for(var loop = thisForm.selectEki.length - 1; loop >= 0; loop--){
    if(thisForm.selectEki[loop].selected){
      thisForm.selectEki[loop] = null;
    }
  }

  // HIDDENにValueをセットする
  thisForm.selectEkiValue.value = '';
  for(var loop = 0; loop < thisForm.selectEki.length; loop++){
    if(loop == 0){
      thisForm.selectEkiValue.value = thisForm.selectEki[loop].value;
    }else{
      thisForm.selectEkiValue.value = thisForm.selectEkiValue.value + ',' + thisForm.selectEki[loop].value;
    }
  }

  // 駅追加ボタンのDisabled設定
  setDiabledAddEki();

  // 駅選択リストのDisabled設定
  setDisableSelectEki();
}

function setDiabledAddCity(){
  // Init
  var thisForm = document.forms[0];
  var isSelectCity = false;

  // 既に選択されているかチェックする
  for(var loop = 0; loop < thisForm.selectedCity.length; loop++){
    isSelectCity = isSelectCity ||
                   thisForm.selectedCity[loop].value == thisForm.cityCd[thisForm.cityCd.selectedIndex].value;
  }

//alert(thisForm.cityAreaCd.selectedIndex + thisForm.cityAreaCd.selectedIndex == 0);
//  alert(thisForm.prefCd.selectedIndex == 0);
//  alert(thisForm.cityCd.selectedIndex == 0);
//  alert(isSelectCity);

  thisForm.btnAddCity.disabled = thisForm.cityAreaCd.selectedIndex == 0 ||
                                 thisForm.prefCd.selectedIndex == 0 ||
                                 thisForm.cityCd.selectedIndex == 0 ||
                                 thisForm.selectedCity.length >= 20 ||
                                 isSelectCity;
}

function setDisableSelectCity(){
  // Init
  var thisForm = document.forms[0];

  // リスト
  thisForm.selectedCity.disabled = thisForm.selectedCity.length == 0;

  // 削除ボタン
  thisForm.btnDeleteCity.disabled = true;
  for(var loop = thisForm.selectedCity.length - 1; loop >= 0; loop--){
    if(thisForm.selectedCity[loop].selected){
      thisForm.btnDeleteCity.disabled = false;
    }
  }
}

function addCity(){
  // Init
  var thisForm = document.forms[0];

  // コンボボックスで選択されている駅をリストに追加
  thisForm.selectedCity[thisForm.selectedCity.length] = new Option(thisForm.prefCd[thisForm.prefCd.selectedIndex].text + '　' +
                                                                   thisForm.cityCd[thisForm.cityCd.selectedIndex].text,
                                                                   thisForm.cityCd[thisForm.cityCd.selectedIndex].value);

  // HIDDENにValueをセットする
  thisForm.selectCityValue.value = '';
  for(var loop = 0; loop < thisForm.selectedCity.length; loop++){
    if(loop == 0){
      thisForm.selectCityValue.value = thisForm.selectedCity[loop].value;
    }else{
      thisForm.selectCityValue.value = thisForm.selectCityValue.value + ',' + thisForm.selectedCity[loop].value;
    }
  }

  //alert(thisForm.selectCityValue.value);

  // 駅追加ボタンのDisabled設定
  setDiabledAddCity();

  // 駅選択リストのDisabled設定
  setDisableSelectCity();
}

function deleteCity(){
  // Init
  var thisForm = document.forms[0];

  for(var loop = thisForm.selectedCity.length - 1; loop >= 0; loop--){
    if(thisForm.selectedCity[loop].selected){
      thisForm.selectedCity[loop] = null;
    }
  }

  // HIDDENにValueをセットする
  thisForm.selectCityValue.value = '';
  for(var loop = 0; loop < thisForm.selectedCity.length; loop++){
    if(loop == 0){
      thisForm.selectCityValue.value = thisForm.selectedCity[loop].value;
    }else{
      thisForm.selectCityValue.value = thisForm.selectCityValue.value + ',' + thisForm.selectedCity[loop].value;
    }
  }

  // 駅追加ボタンのDisabled設定
  setDiabledAddCity();

  // 駅選択リストのDisabled設定
  setDisableSelectCity();

  // 店舗画像の選択状態の設定
  changeShopImg();
}

// 下位オブジェクトをコントロールします。
// 親オブジェクトの値がヌルーの場合、子オブジェクトを非活性化します。
// 親オブジェクトの値がヌルーではない場合、子オブジェクトを活性化します。
function childControl(parentsObjName ,childObjName){

  var parentsObj = document.getElementsByName(parentsObjName)[0];
  var childObj = document.getElementsByName(childObjName)[0];

  if (parentsObj.value == null || parentsObj.value == '') {
    childObj.disabled = true;
  } else {
    childObj.disabled = false;
  }
}

// 沿線プルダウンを動的に生成します。
// dwr.util.addOptions(selectid, map, valueprop, textprop);
function putEnsenList() {
    var thisForm = document.forms[0];
    var areaCd = dwr.util.getValue("areaCd");
    var ensenTypeCd = dwr.util.getValue("ensenTypeCd");
    var ensenBlankData = [{ ensenCd : "", ensenName : ""}];
    AddressEnsenManager.getEnsenList(areaCd, ensenTypeCd, function(ret) {
        dwr.util.removeAllOptions("ensenCd");
        dwr.util.addOptions("ensenCd", ensenBlankData, "ensenCode", "ensenName");
        dwr.util.addOptions("ensenCd", ret, "ensenCode", "ensenName");
    });
}

// 駅プルダウンを動的に生成します。
// dwr.util.addOptions(selectid, map, valueprop, textprop);
function putEkiList() {
    var ensenCd = document.getElementById("ensenCd").value;
    var ekiBlankData = [ { ekiCd:null, ekiName:"" } ];
    AddressEnsenManager.getEkiList(ensenCd, function(ret) {
        dwr.util.removeAllOptions("ekiCd");
        dwr.util.addOptions("ekiCd", ekiBlankData, "ekiCode", "ekiName");
        dwr.util.addOptions("ekiCd", ret, "ekiCode", "ekiName");
    });
}

// 都道府県プルダウンを動的に生成します。
// dwr.util.addOptions(selectid, map, valueprop, textprop);
function putPrefList() {
    var cityAreaCd = dwr.util.getValue("cityAreaCd");
    var prefBlankData = [ { prefCd:"", prefName:"" } ];
    AddressEnsenManager.getPrefList(cityAreaCd, function(ret) {
      dwr.util.removeAllOptions("prefCd");
      dwr.util.addOptions("prefCd", prefBlankData, "prefCode", "prefName");
      dwr.util.addOptions("prefCd", ret, "prefCode", "prefName");
    });
}

// プルダウンを動的に生成します。
// dwr.util.addOptions(selectid, map, valueprop, textprop);
function putCityList() {
    var prefCd = dwr.util.getValue("prefCd");
    var cityBlankData = [ { cityCode:"", cityName:"" } ];
    AddressEnsenManager.getCityList(prefCd, function(ret) {
        dwr.util.removeAllOptions("cityCd");
        dwr.util.addOptions("cityCd", cityBlankData, "cityCode", "cityName");
        dwr.util.addOptions("cityCd", ret, "cityCode", "cityName");
    });
}

function changeShopImg(){
  // Init
  var thisForm = document.forms[0];

  for(var loop = 0; loop < thisForm.picFlg.length; loop++){
    var tdArea = document.getElementById('shopImgTd' + eval(loop + 1));

    if(thisForm.picFlg[loop].checked){
      tdArea.style.backgroundColor = "#FFFF99";
    }else{
      tdArea.style.backgroundColor = "#FFFFFF";
    }
    if (loop != 0) {
      var tdDetailArea = document.getElementById('shopImgDetailTd' + eval(loop + 1));
      if(thisForm.picFlg[loop].checked){
        tdDetailArea.style.backgroundColor = "#FFFF99";
      }else{
        tdDetailArea.style.backgroundColor = "#FFFFFF";
      }
    }

  }
}

//-->
</script>