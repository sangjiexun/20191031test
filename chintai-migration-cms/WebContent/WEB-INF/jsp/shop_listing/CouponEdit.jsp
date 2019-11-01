<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="title" value="クーポン情報編集" />
<c:set var="view" value="${CouponEditView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
      <html:link action="/shop_listing/KeiyakuShopInfo" paramId="shopCd" paramName="view" paramProperty="shopCd">
        契約店舗詳細
      </html:link>
      &gt;&nbsp;${title}
    <h1>${title}</h1>
    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="msg"/>
    </html:messages>


    <!-- 店舗コード -->
    <p class="section_header"><a name="1">店舗コード</a></p>
<%@ include file="parts/ShopBasicInfo.jsp" %>

    <p class="section_header"><a name="1">クーポン情報</a></p>
    <div class="annotation">クーポンを設定します。※設定されていても「クーポン発行」オプションが未契約の場合は表示されません。</div>
    <div class="caution">*開始年月日が未選択のクーポンは登録されません。</div>
    <div class="caution">*開始年月日を選択すると、利用対象、特典、提示条件、ソート順が必須入力項目となります。</div>
    <html:form action="/shop_listing/CouponEditConfirm.do" onsubmit="recoveryAll();">
      <div class="add_form">
        <table class="type_detail" id="couponInfo">
          <colgroup>
            <col width="10%" align="center">
            <col width="20%">
            <col width="50%">
            <col width="10%" align="center">
            <col width="10%" align="center">
          </colgroup>
          <tr>
            <th align="center">項番</th>
            <th align="center" colspan="2">内容</th>
            <th align="center">ソート順</th>
            <th align="center">非表示</th>
          </tr>

<c:forEach begin="1" end="${view.displayLimit}" varStatus="i">
          <tr>
            <th rowspan="4"><c:out value="${i.index}" /></th>
            <th>開始年月日～終了年月日</th>
            <td>
              <input type="hidden" name="couponSeqs" value="${view.couponSeqs[i.index-1]}">
              <input type="hidden" name="updDt"      value="${view.updDt[i.index -1]}" />

              <chintai:DateTag name="startYears" type="year" todayFix="false" fixValue="${view.startYears[i.index -1]}" addYear="3"/>年
              <chintai:DateTag name="startMonths" type="month" todayFix="false" fixValue="${view.startMonths[i.index -1]}" />月
              <chintai:DateTag name="startDays" type="day" todayFix="false" fixValue="${view.startDays[i.index -1]}" />日　～　
              <chintai:DateTag name="endYears" type="year" todayFix="false" fixValue="${view.endYears[i.index -1]}" addYear="3" />年
              <chintai:DateTag name="endMonths" type="month" todayFix="false" fixValue="${view.endMonths[i.index -1]}" />月
              <chintai:DateTag name="endDays" type="day" todayFix="false" fixValue="${view.endDays[i.index -1]}" />日
            </td>
            <td rowspan="4"><input type="text" name="sortKeys" size="4" maxlength="4" value="${view.sortKeys[i.index -1]}" /></td>
  <c:choose>
    <c:when test="${not empty view.delFlgs[i.index -1] and view.delFlgs[i.index -1] ne '0'}">
            <td rowspan="4"><input type="checkbox" name="delFlgs" value="${i.index}" checked="checked"/></td>
    </c:when>
    <c:otherwise>
            <td rowspan="4"><input type="checkbox" name="delFlgs" value="${i.index}" /></td>
    </c:otherwise>
  </c:choose>

          </tr>
          <tr>
            <th>利用対象</th>
            <td>
<c:choose>
  <c:when test="${view.riyouTaisyoType[i.index -1] eq '1'}">
              <input type="radio" name="target${i.index}" value="1" checked="checked" onclick="swapDisable('riyouTaisyoCustom${i.index}', 'riyouTaisyo${i.index}'); setType('${i.index-1}', 'riyouTaisyoType', this);">
              <chintai:PropertyOptions name="riyouTaisyo" id="riyouTaisyo${i.index}" nameKey="SHOP_LISTING_RIYOU_TAISYO" valueKey="SHOP_LISTING_RIYOU_TAISYO" fixValue="${view.riyouTaisyo[i.index-1]}" />
              <br>
              <input type="radio" name="target${i.index}" value="2" onclick="swapDisable('riyouTaisyo${i.index}','riyouTaisyoCustom${i.index}');setType('${i.index-1}', 'riyouTaisyoType', this);">
              <input type="text" name="riyouTaisyoCustom" id="riyouTaisyoCustom${i.index}" size="50" maxlength="50" style="background-color:silver;">
              <input type="hidden" name="riyouTaisyoType" value="${view.riyouTaisyoType[i.index -1]}" />
  </c:when>
  <c:when test="${view.riyouTaisyoType[i.index -1] eq '2'}">
              <input type="radio" name="target${i.index}" value="1" onclick="swapDisable('riyouTaisyoCustom${i.index}', 'riyouTaisyo${i.index}'); setType('${i.index-1}', 'riyouTaisyoType', this);">
              <chintai:PropertyOptions name="riyouTaisyo" id="riyouTaisyo${i.index}" nameKey="SHOP_LISTING_RIYOU_TAISYO" valueKey="SHOP_LISTING_RIYOU_TAISYO" style="background-color:silver;" />
              <br>
              <input type="radio" name="target${i.index}" value="2" checked="checked" onclick="swapDisable('riyouTaisyo${i.index}','riyouTaisyoCustom${i.index}'); setType('${i.index-1}', 'riyouTaisyoType', this);">
              <input type="text" name="riyouTaisyoCustom" id="riyouTaisyoCustom${i.index}" value="${view.riyouTaisyoCustom[i.index-1]}" size="50" maxlength="50" >
              <input type="hidden" name="riyouTaisyoType" value="${view.riyouTaisyoType[i.index -1]}" />
  </c:when>
  <c:otherwise>
              <input type="radio" name="target${i.index}" value="1" checked="checked" onclick="swapDisable('riyouTaisyoCustom${i.index}', 'riyouTaisyo${i.index}'); setType('${i.index-1}', 'riyouTaisyoType', this);">
              <chintai:PropertyOptions name="riyouTaisyo" id="riyouTaisyo${i.index}" nameKey="SHOP_LISTING_RIYOU_TAISYO" valueKey="SHOP_LISTING_RIYOU_TAISYO" />
              <br>
              <input type="radio" name="target${i.index}" value="2" onclick="swapDisable('riyouTaisyo${i.index}','riyouTaisyoCustom${i.index}'); setType('${i.index-1}', 'riyouTaisyoType', this);">
              <input type="text" name="riyouTaisyoCustom" id="riyouTaisyoCustom${i.index}" size="50" maxlength="50" style="background-color:silver;">
              <input type="hidden" name="riyouTaisyoType" value="1" />
  </c:otherwise>
</c:choose>
            </td>
          </tr>
          <tr>
            <th>特典</th>
            <td>
<c:choose>
  <c:when test="${view.tokutenType[i.index - 1] eq '1'}">
              <input type="radio" name="benefit${i.index}" value="1" checked="checked" onclick="swapDisable('tokutenCustom${i.index}','tokuten${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <chintai:PropertyOptions name="tokuten" fixValue="${view.tokuten[i.index-1]}" id="tokuten${i.index}" nameKey="SHOP_LISTING_TOKUTEN" valueKey="SHOP_LISTING_TOKUTEN" delimiter="|" />
              <br>
              <input type="radio" name="benefit${i.index}" value="2" onclick="swapDisable('tokuten${i.index}','tokutenCustom${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <input type="text" name="tokutenCustom" id="tokutenCustom${i.index}" size="40" maxlength="40" style="background-color:silver;">
              <input type="hidden" name="tokutenType" value="${view.tokutenType[i.index -1]}" />
  </c:when>
  <c:when test="${view.tokutenType[i.index -1] eq '2'}">
              <input type="radio" name="benefit${i.index}" value="1" onclick="swapDisable('tokutenCustom${i.index}','tokuten${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <chintai:PropertyOptions name="tokuten" id="tokuten${i.index}" nameKey="SHOP_LISTING_TOKUTEN" valueKey="SHOP_LISTING_TOKUTEN" delimiter="|" style="background-color:silver;" />
              <br>
              <input type="radio" name="benefit${i.index}" value="2"  checked="checked" onclick="swapDisable('tokuten${i.index}','tokutenCustom${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <input type="text" name="tokutenCustom" id="tokutenCustom${i.index}" value="${view.tokutenCustom[i.index -1]}" size="40" maxlength="40">
              <input type="hidden" name="tokutenType" value="${view.tokutenType[i.index -1]}" />
  </c:when>
  <c:otherwise>
              <input type="radio" name="benefit${i.index}" value="1" checked="checked" onclick="swapDisable('tokutenCustom${i.index}','tokuten${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <chintai:PropertyOptions name="tokuten" id="tokuten${i.index}" nameKey="SHOP_LISTING_TOKUTEN" valueKey="SHOP_LISTING_TOKUTEN" delimiter="|" />
              <br>
              <input type="radio" name="benefit${i.index}" value="2" onclick="swapDisable('tokuten${i.index}','tokutenCustom${i.index}'); setType('${i.index-1}', 'tokutenType', this);">
              <input type="text" name="tokutenCustom" id="tokutenCustom${i.index}" size="40" maxlength="40" style="background-color:silver;">
              <input type="hidden" name="tokutenType" value="1" />
  </c:otherwise>
</c:choose>
            </td>
          </tr>
          <tr>
            <th>提示条件</th>
            <td>
<c:choose>
  <c:when test="${view.joukenType[i.index -1] eq '1'}">
              <input type="radio" name="display${i.index}" value="1" checked="checked" onclick="swapDisable('joukenCustom${i.index}','jouken${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <chintai:PropertyOptions name="jouken" id="jouken${i.index}" fixValue="${view.jouken[i.index-1]}" nameKey="SHOP_LISTING_JOUKEN" valueKey="SHOP_LISTING_JOUKEN" />
              <br>
              <input type="radio" name="display${i.index}" value="2" onclick="swapDisable('jouken${i.index}','joukenCustom${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <input type="text" name="joukenCustom" id="joukenCustom${i.index}" size="30" maxlength="30" style="background-color:silver;">
              <input type="hidden" name="joukenType" value="${view.joukenType[i.index -1]}"  />
  </c:when>
  <c:when test="${view.joukenType[i.index -1] eq '2'}">
              <input type="radio" name="display${i.index}" value="1" onclick="swapDisable('joukenCustom${i.index}','jouken${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <chintai:PropertyOptions name="jouken" id="jouken${i.index}" nameKey="SHOP_LISTING_JOUKEN" valueKey="SHOP_LISTING_JOUKEN" style="background-color:silver;" />
              <br>
              <input type="radio" name="display${i.index}" value="2" checked="checked" onclick="swapDisable('jouken${i.index}','joukenCustom${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <input type="text" name="joukenCustom" id="joukenCustom${i.index}" value="${view.joukenCustom[i.index -1]}" size="30" maxlength="30" >
              <input type="hidden" name="joukenType" value="${view.joukenType[i.index -1]}"  />
  </c:when>
  <c:otherwise>
              <input type="radio" name="display${i.index}" value="1" checked="checked" onclick="swapDisable('joukenCustom${i.index}','jouken${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <chintai:PropertyOptions name="jouken" id="jouken${i.index}" nameKey="SHOP_LISTING_JOUKEN" valueKey="SHOP_LISTING_JOUKEN" />
              <br>
              <input type="radio" name="display${i.index}" value="2" onclick="swapDisable('jouken${i.index}','joukenCustom${i.index}'); setType('${i.index-1}', 'joukenType', this);">
              <input type="text" name="joukenCustom" id="joukenCustom${i.index}" size="30" maxlength="30" style="background-color:silver;">
              <input type="hidden" name="joukenType" value="1"  />
  </c:otherwise>
</c:choose>
            </td>
          </tr>
</c:forEach>
        </table>
          <p>
            <input type="hidden" name="shopCd" value="${param.shopCd}">
            <input type="submit" value="確認画面へ" >
            <input type="button" value="戻る" onClick="_submit('KeiyakuShopInfo.do');">
          </p>
      </div>
    </html:form>
  </div><!-- popup_layout END -->
</div><!-- main END -->
<script type="text/javascript">
<!--
function swapDisable(disableTarget, recoveryTarget, index) {
    document.getElementById(disableTarget).disabled = true;
    document.getElementById(disableTarget).style.backgroundColor = "silver";
    document.getElementById(recoveryTarget).disabled = false;
    document.getElementById(recoveryTarget).style.backgroundColor = "white";
}

function setType (index, name, obj) {
    var targets = document.getElementsByName(name);
    targets[index].value = obj.value;
}

function recoveryAll () {
    var thisForm = document.forms[0];
    var length = document.getElementsByName('sortKeys').length;
    for (i=0; i < length; i++) {
        thisForm.riyouTaisyo[i].disabled = false;
        thisForm.riyouTaisyoCustom[i].disabled = false;
        thisForm.tokuten[i].disabled = false;
        thisForm.tokutenCustom[i].disabled = false;
        thisForm.jouken[i].disabled = false;
        thisForm.joukenCustom[i].disabled = false;
    }
}

function init () {
    var thisForm = document.forms[0];
    var length = document.getElementsByName('riyouTaisyoType').length;
    for (i=0; i < length; i++) {
        if (thisForm.riyouTaisyoType[i].value == '2') {
        	thisForm.riyouTaisyo[i].disabled = true;
        } else {
        	thisForm.riyouTaisyoCustom[i].disabled = true;
        }

        if (thisForm.tokutenType[i].value == '2') {
        	thisForm.tokuten[i].disabled = true;
        } else {
        	thisForm.tokutenCustom[i].disabled = true;
        }

        if (thisForm.joukenType[i].value == '2') {
        	thisForm.jouken[i].disabled = true;
        } else {
        	thisForm.joukenCustom[i].disabled = true;
        }
    }
}

init();

// 'load'のeventに各コントロールの初期設定を行う
//addEvent('load', window, setDiasbleContorl);
//-->
</script>


<%@ include file="../parts/ContentsFooter.jsp" %>