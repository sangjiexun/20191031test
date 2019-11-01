<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="契約情報更新" />
<c:set var="view" value="${KeiyakuUpdateView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &gt;&nbsp;${title}
    </div>
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>
    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <html:form action="/shop_listing/KeiyakuUpdateConfirm" onsubmit="joinDate();">

      <!-- 契約種別 -->
      <p class="section_header">契約種別</p>
      <div class="add_form">
        <div class="add_form_title">契約種別<span class="caution">*</span></div>
        <div class="annotation">契約種別を選択します。</div>
<c:choose>
  <c:when test="${view.keiyakuShubetsu eq 1}">
        <div class="form_space">
          <input type="radio" name="keiyakuShubetsu" id="keiyakuShubetsu0" value="0" onclick="keiyakuShubetsuControl();" />
          <label for="keiyakuShubetsu0">CHINTAI店舗リスティングに参加する</label>
        </div>
        <div class="form_space">
          <input type="radio" name="keiyakuShubetsu" id="keiyakuShubetsu1" value="1" checked="checked" onclick="keiyakuShubetsuControl();" />
          <label>CHINTAI店舗リスティングに参加せずにエイブルWEB用店舗情報を入力する</label>
        </div>
  </c:when>
  <c:otherwise>
        <div class="form_space">
          <input type="radio" name="keiyakuShubetsu" id="keiyakuShubetsu0" value="0" checked="checked" onclick="keiyakuShubetsuControl();" />
          <label for="keiyakuShubetsu0">CHINTAI店舗リスティングに参加する</label>
        </div>
        <div class="form_space">
          <input type="radio" name="keiyakuShubetsu" id="keiyakuShubetsu1" value="1" onclick="keiyakuShubetsuControl();" >
          <label>CHINTAI店舗リスティングに参加せずにエイブルWEB用店舗情報を入力する</label>
        </div>
  </c:otherwise>
</c:choose>
      </div>

    <!-- 契約情報 -->
    <p class="section_header">契約情報</p>
    <div class="add_form">
      <div class="add_form_title">基本契約<span class="caution">*</span></div>
      <div class="annotation">基本契約の有無を選択します。</div>
        <div class="form_space">
<c:choose>
  <c:when test="${view.kihonKeiyakuFlg eq '1'}">
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="1" checked="checked">契約開始する</label>
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="0">契約終了する</label>
  </c:when>
  <c:when test="${view.kihonKeiyakuFlg eq '0'}">
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="1">契約開始する</label>
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="0" checked="checked">契約終了する</label>
  </c:when>
  <c:otherwise>
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="1">契約開始する</label>
          <label><input type="radio" name="kihonKeiyakuFlg" onclick="kihonDateControl();" value="0">契約終了する</label>
  </c:otherwise>
</c:choose>
        </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">契約期間</div>
      <div class="annotation">契約期間を選択します。契約終了年月を指定しない場合、無期限となります。</div>
        <div class="form_space">契約開始年月&nbsp;
          <chintai:DateTag name="keiyakuStartYear" type="year" todayFix="false" fixValue="${view.keiyakuStartYear}" addYear="3" />年
          <chintai:DateTag name="keiyakuStartMonth" type="month" todayFix="false" fixValue="${view.keiyakuStartMonth}" />月
          <span class="caution">*</span>
          &nbsp;～&nbsp;契約終了年月&nbsp;
          <chintai:DateTag name="keiyakuEndYear" type="year" todayFix="false" fixValue="${view.keiyakuEndYear}" addYear="3" />年
          <chintai:DateTag name="keiyakuEndMonth" type="month" todayFix="false" fixValue="${view.keiyakuEndMonth}" />月
        </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">クーポン発行(オプション契約)</div>
      <div class="annotation">クーポン発行(オプション契約)を契約する場合は、「契約する」を選択し、開始年月・終了年月を設定します。終了年月を指定しない場合、無期限となります。</div>
      <div class="form_space">
<c:choose>
  <c:when test="${view.couponKeiyakuFlg eq '1'}">
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="1" checked="checked" >契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="0" >契約しない</label>
  </c:when>
  <c:when test="${view.couponKeiyakuFlg eq '0'}">
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="1" >契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="0" checked="checked" >契約しない</label>
  </c:when>
  <c:otherwise>
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="1" >契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="couponKeiyakuFlg" onclick="couponDateControl();" value="0" >契約しない</label>
  </c:otherwise>
</c:choose>
        開始年月
        <chintai:DateTag name="couponStartYear" type="year" todayFix="false" fixValue="${view.couponStartYear}" addYear="3" />年
        <chintai:DateTag name="couponStartMonth" type="month" todayFix="false" fixValue="${view.couponStartMonth}" />月
        &nbsp;～&nbsp;
        終了年月
        <chintai:DateTag name="couponEndYear" type="year" todayFix="false" fixValue="${view.couponEndYear}" addYear="3" />年
        <chintai:DateTag name="couponEndMonth" type="month" todayFix="false" fixValue="${view.couponEndMonth}" />月
      </div>
    </div>
    <div class="add_form">
      <div class="add_form_title">外部リンク表示(オプション契約)</div>
      <div class="annotation">外部リンク表示(オプション契約)を契約する場合は、「契約する」を選択し、開始年月・終了年月を設定します。終了年月を指定しない場合、無期限となります。</div>
      <div class="form_space">
<c:choose>
  <c:when test="${view.linkKeiyakuFlg eq '1'}">
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="1" checked="checked">契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="0">契約しない</label>
  </c:when>
  <c:when test="${view.linkKeiyakuFlg eq '0'}">
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="1">契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="0" checked="checked">契約しない</label>
  </c:when>
  <c:otherwise>
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="1">契約する</label>&nbsp;&nbsp;
        <label><input type="radio" name="linkKeiyakuFlg" onclick="linkDateControl();" value="0">契約しない</label>
  </c:otherwise>
</c:choose>
        開始年月
        <chintai:DateTag name="linkStartYear" type="year" todayFix="false" fixValue="${view.linkStartYear}" addYear="3" />年
        <chintai:DateTag name="linkStartMonth" type="month" todayFix="false" fixValue="${view.linkStartMonth}" addYear="3" />月
        &nbsp;～&nbsp;
        終了年月
        <chintai:DateTag name="linkEndYear" type="year" todayFix="false" fixValue="${view.linkEndYear}" addYear="3" />年
        <chintai:DateTag name="linkEndMonth" type="month" todayFix="false" fixValue="${view.linkEndMonth}" />月
      </div>
    </div>

    <div class="add_form">
      <div class="add_form_title">備考</div>
      <div class="annotation">この店舗の契約情報に関するメモなどを入力します。</div>
        <textarea rows="5" cols="50" name="note"><c:out value="${view.note}" /></textarea>
    </div>

    <!-- 出稿対象駅/市区町村数上限設定 -->
    <p class="section_header">出稿対象駅／市区町村数上限設定</p>
    <div class="add_form">
      <div class="add_form_title">出稿対象駅上限数</div>
      <div class="annotation"> CHINTAINETの店舗リスティングで表示する出稿対象駅上限数を設定します。</div>
        <input name="ekiCnt" type="text" size="2" maxlength="2" value="${view.ekiCnt}" >駅
    </div>

    <div class="add_form">
      <div class="add_form_title">出稿対象市区町村上限数</div>
      <div class="annotation"> CHINTAINETの店舗リスティングで表示する出稿対象市区町村上限数を設定します。</div>
        <input name="cityCnt" type="text" size="2" maxlength="2" value="${view.cityCnt}" >市区町村
    </div>
    <br>

    <p>
      <input type="hidden" name="keiyakuStartYm" />
      <input type="hidden" name="keiyakuEndYm" />
      <input type="hidden" name="couponStartYm" />
      <input type="hidden" name="couponEndYm" />
      <input type="hidden" name="linkStartYm" />
      <input type="hidden" name="linkEndYm" />
      <input type="hidden" name="pkShopListingSeq"        value="${view.pkShopListingSeq}" />
      <input type="hidden" name="keiyakuShubetsuBefore"   value="${view.keiyakuShubetsuBefore}" />
      <input type="hidden" name="shopListingKeiyakuUpdDt" value="${view.shopListingKeiyakuUpdDt}" />
      <input type="hidden" name="shopCd"                  value="${view.shopCd}" />
      <input type="hidden" name="updDt"                   value="${view.updDt}" />
      <input type="submit" value="確認画面へ">
      <input type="button" value="戻る" onClick="_submit('KeiyakuShopInfo.do');">
    </p>
    </html:form>

  </div><!-- popup_layout END -->
</div><!-- main END -->
<script type="text/javascript">
<!--
function joinDate(){
    var thisForm = document.forms[0];

    thisForm.keiyakuStartYm.value = thisForm.keiyakuStartYear.value + thisForm.keiyakuStartMonth.value;
    thisForm.keiyakuEndYm.value = thisForm.keiyakuEndYear.value + thisForm.keiyakuEndMonth.value;

    thisForm.couponStartYm.value = thisForm.couponStartYear.value + thisForm.couponStartMonth.value;
    thisForm.couponEndYm.value = thisForm.couponEndYear.value + thisForm.couponEndMonth.value;

    thisForm.linkStartYm.value = thisForm.linkStartYear.value + thisForm.linkStartMonth.value;
    thisForm.linkEndYm.value = thisForm.linkEndYear.value + thisForm.linkEndMonth.value;

    thisForm.keiyakuStartYear.disabled = false;
    thisForm.keiyakuStartMonth.disabled = false;
    thisForm.keiyakuEndYear.disabled = false;
    thisForm.keiyakuEndMonth.disabled = false;

    thisForm.couponStartYear.disabled = false;
    thisForm.couponStartMonth.disabled = false;
    thisForm.couponEndYear.disabled = false;
    thisForm.couponEndMonth.disabled = false;

    thisForm.linkStartYear.disabled = false;
    thisForm.linkStartMonth.disabled = false;
    thisForm.linkEndYear.disabled = false;
    thisForm.linkEndMonth.disabled = false;

    thisForm.kihonKeiyakuFlg[0].disabled = false;
    thisForm.kihonKeiyakuFlg[1].disabled = false;
    thisForm.couponKeiyakuFlg[0].disabled = false;
    thisForm.couponKeiyakuFlg[1].disabled = false;
    thisForm.linkKeiyakuFlg[0].disabled = false;
    thisForm.linkKeiyakuFlg[1].disabled = false;

    if (thisForm.kihonKeiyakuFlg[1].checked) {
        thisForm.keiyakuStartYm.value = "";
        thisForm.keiyakuEndYm.value = "";

        thisForm.couponStartYm.value = "";
        thisForm.couponEndYm.value = "";

        thisForm.linkStartYm.value = "";
        thisForm.linkEndYm.value = "";
    }
    if (thisForm.couponKeiyakuFlg[1].checked) {
        thisForm.couponStartYm.value = "";
        thisForm.couponEndYm.value = "";
    }
    if (thisForm.linkKeiyakuFlg[1].checked) {
        thisForm.linkStartYm.value = "";
        thisForm.linkEndYm.value = "";
    }

    //alert(thisForm.keiyakuStartYm.value + thisForm.keiyakuEndYm.value);
    //alert(thisForm.keiyakuStartYm.disabled);
  }

function kihonDateControl(){
    var thisForm = document.forms[0];
    if (thisForm.keiyakuShubetsu[1].checked || thisForm.kihonKeiyakuFlg[1].checked) {
      thisForm.keiyakuStartYear.disabled = true;
      thisForm.keiyakuStartMonth.disabled = true;
      thisForm.keiyakuEndYear.disabled = true;
      thisForm.keiyakuEndMonth.disabled = true;

      thisForm.couponKeiyakuFlg[0].disabled = true;
      thisForm.couponKeiyakuFlg[1].disabled = true;
      thisForm.linkKeiyakuFlg[0].disabled = true;
      thisForm.linkKeiyakuFlg[1].disabled = true;
    } else {
      thisForm.keiyakuStartYear.disabled = false;
      thisForm.keiyakuStartMonth.disabled = false;
      thisForm.keiyakuEndYear.disabled = false;
      thisForm.keiyakuEndMonth.disabled = false;

      thisForm.couponKeiyakuFlg[0].disabled = false;
      thisForm.couponKeiyakuFlg[1].disabled = false;
      thisForm.linkKeiyakuFlg[0].disabled = false;
      thisForm.linkKeiyakuFlg[1].disabled = false;
    }
    couponDateControl();
    linkDateControl();
}

function couponDateControl(){
  var thisForm = document.forms[0];
  if (thisForm.couponKeiyakuFlg[0].checked && thisForm.kihonKeiyakuFlg[0].checked && thisForm.keiyakuShubetsu[0].checked) {
    thisForm.couponStartYear.disabled = false;
    thisForm.couponStartMonth.disabled = false;
    thisForm.couponEndYear.disabled = false;
    thisForm.couponEndMonth.disabled = false;
  } else {
    thisForm.couponStartYear.disabled = true;
    thisForm.couponStartMonth.disabled = true;
    thisForm.couponEndYear.disabled = true;
    thisForm.couponEndMonth.disabled = true;
  }
}

function linkDateControl(){
  var thisForm = document.forms[0];
  if (thisForm.linkKeiyakuFlg[0].checked && thisForm.kihonKeiyakuFlg[0].checked && thisForm.keiyakuShubetsu[0].checked) {
    thisForm.linkStartYear.disabled = false;
    thisForm.linkStartMonth.disabled = false;
    thisForm.linkEndYear.disabled = false;
    thisForm.linkEndMonth.disabled = false;
  } else {
    thisForm.linkStartYear.disabled = true;
    thisForm.linkStartMonth.disabled = true;
    thisForm.linkEndYear.disabled = true;
    thisForm.linkEndMonth.disabled = true;
  }
}

function keiyakuShubetsuControl() {
    var thisForm = document.forms[0];
    if (thisForm.keiyakuShubetsu[1].checked) {
        thisForm.kihonKeiyakuFlg[0].disabled = true;
        thisForm.kihonKeiyakuFlg[1].disabled = true;
    } else {
    	thisForm.kihonKeiyakuFlg[0].disabled = false;
    	thisForm.kihonKeiyakuFlg[1].disabled = false;
    }
    kihonDateControl();
    couponDateControl();
    linkDateControl();
}

keiyakuShubetsuControl();

 //addEvent('load', window, function(){document.getElementsByName('keiyakuStartYear')[0].focus();});
//-->
</script>

<%@ include file="../parts/ContentsFooter.jsp" %>