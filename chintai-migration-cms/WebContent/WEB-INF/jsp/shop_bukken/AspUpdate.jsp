<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@page import="net.chintai.backend.sysadmin.common.properties.ServerProperties"%>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="不動産ASP設定情報編集"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<script type="text/javascript">

function setSubmit(){
    var thisForm = document.forms[0];

    var prefs = thisForm.pref01.value + thisForm.pref02.value + thisForm.pref03.value + thisForm.pref04.value;
    prefs = prefs + thisForm.pref05.value + thisForm.pref06.value + thisForm.pref07.value + thisForm.pref15.value;
    prefs = prefs + thisForm.pref20.value + thisForm.pref19.value + thisForm.pref13.value + thisForm.pref14.value;
    prefs = prefs + thisForm.pref11.value + thisForm.pref12.value + thisForm.pref08.value + thisForm.pref09.value;
    prefs = prefs + thisForm.pref10.value + thisForm.pref16.value + thisForm.pref17.value + thisForm.pref18.value;
    prefs = prefs + thisForm.pref23.value + thisForm.pref21.value + thisForm.pref22.value + thisForm.pref24.value;
    prefs = prefs + thisForm.pref27.value + thisForm.pref28.value + thisForm.pref26.value + thisForm.pref25.value;
    prefs = prefs + thisForm.pref29.value + thisForm.pref30.value + thisForm.pref31.value + thisForm.pref32.value;
    prefs = prefs + thisForm.pref33.value + thisForm.pref34.value + thisForm.pref35.value + thisForm.pref36.value;
    prefs = prefs + thisForm.pref37.value + thisForm.pref38.value + thisForm.pref39.value + thisForm.pref40.value;
    prefs = prefs + thisForm.pref41.value + thisForm.pref42.value + thisForm.pref43.value + thisForm.pref44.value;
    prefs = prefs + thisForm.pref45.value + thisForm.pref46.value + thisForm.pref47.value;
    thisForm.prefs.value = prefs;

    _submit('AspUpdateConfirm.do');
}

addEvent('load', window, function(){document.getElementsByName('title')[0].focus(); DisableTextBoxUrl(); DisableTextBoxImg();});

 function DisableTextBoxUrl() {
     var thisForm = document.forms[0];
    if(thisForm.policyFlg[1].checked == true) {
      thisForm.policyUrl.disabled = false;
      thisForm.policyUrl.style.backgroundColor='#FFFFFF';
      thisForm.policyUrl.maxlength = '255';
    } else if(thisForm.policyFlg[0].checked == true) {
      thisForm.policyUrl.disabled = true;
      thisForm.policyUrl.style.backgroundColor='#D4D0C8';
    }
 }

 function DisableTextBoxImg() {
     var thisForm = document.forms[0];
    if(thisForm.logoFlg[1].checked == true) {
      thisForm.logoFlgImage.disabled = false;
      thisForm.logoFlgImage.style.backgroundColor='#FFFFFF';
    } else if(thisForm.logoFlg[0].checked == true) {
      thisForm.logoFlgImage.disabled = true;
      thisForm.logoFlgImage.style.backgroundColor='#D4D0C8';
    }
 }

</script>
<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${AspUpdateView.shopCd}"/></c:url>">
        店舗・契約詳細
      </a>&gt;
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${AspUpdateView.shopCd}"/></c:url>">
        不動産ASP設定情報
      </a>&gt;
        ${title}
    </div>
    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

    <!-- 店舗コード -->
    <p class="section_header">店舗コード</p>
    <table class="type_detail_pre">
      <colgroup>
        <col span="1" width="22%">
        <col span="1" width="78%">
      </colgroup>
      <tr>
        <th>店舗名</th>
        <td>
          <c:out value="${AspUpdateView.company}" />
          <c:if test="${not empty AspUpdateView.company and not empty AspUpdateView.bumon}"> / </c:if>
          <c:out value="${AspUpdateView.bumon}" />
        </td>
      </tr>
      <tr>
        <th>店舗コード</th>
        <td><c:out value="${AspUpdateView.shopCd}"/></td>
      </tr>
      <tr>
        <th>お客様設定パスワード</th>
        <td><c:out value="${AspUpdateView.password}"/></td>
      </tr>
    </table>

    <p class="section_header">基本設定</p>
    <html:form method="post" enctype="multipart/form-data" onsubmit="setSubmit();">
      <div class="add_form">
        <div class="add_form_title">タイトル表示用</div>
        <div class="annotation">ASP検索画面に設定されるタイトルです。</div>
        <div class="form_space">
          <input type="text" name="title" value="${fn:escapeXml(AspUpdateView.title)}" size="50" maxlength=330">
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">画面レイアウト <span class="caution">*</span></div>
        <div class="annotation">画面のレイアウトを選択します。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.layout == 'left' || AspUpdateView.layout == null }">
              <input type="radio" name="layout" value="left" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.layout != 'left' && AspUpdateView.layout != null }">
              <input type="radio" name="layout" value="left">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="left"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.layout == 'center' }">
              <input type="radio" name="layout" value="center" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.layout != 'center' }">
              <input type="radio" name="layout" value="center">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="center"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.layout == 'right' }">
              <input type="radio" name="layout" value="right" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.layout != 'right' }">
              <input type="radio" name="layout" value="right">
            </c:if>
            <chintai:CodePrint  nameKey="SHOPBUKKEN_ASP_DISP_LAYOUT_NAME" valueKey="SHOPBUKKEN_ASP_DISP_LAYOUT_VALUE" code="right" />
          </label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">セレクトボックスタイプ <span class="caution">*</span></div>
        <div class="annotation">沿線・エリア検索画面セレクトボックスの表示タイプを選択します。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.selectBoxType == '1' || AspUpdateView.selectBoxType == null }">
              <input type="radio" name="selectBoxType" value="1" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.selectBoxType != '1' && AspUpdateView.selectBoxType != null }">
              <input type="radio" name="selectBoxType" value="1">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="1"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.selectBoxType == '2' }">
              <input type="radio" name="selectBoxType" value="2" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.selectBoxType != '2' }">
              <input type="radio" name="selectBoxType" value="2">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="2"/>
          </label>
          <br>
          <label>
            <c:if test = "${AspUpdateView.selectBoxType == '3' }">
              <input type="radio" name="selectBoxType" value="3" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.selectBoxType != '3' }">
              <input type="radio" name="selectBoxType" value="3">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="3"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.selectBoxType == '4' }">
              <input type="radio" name="selectBoxType" value="4" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.selectBoxType != '4' }">
              <input type="radio" name="selectBoxType" value="4">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_BOX_TYPE_NAME" valueKey="SHOPBUKKEN_ASP_BOX_TYPE_VALUE" code="4"/>
          </label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">テンプレートカラー <span class="caution">*</span></div>
        <div class="annotation">テンプレートの色を選択します。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.templateColor == 'gray' || AspUpdateView.templateColor == null }">
              <input type="radio" name="templateColor" value="gray" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.templateColor != 'gray' && AspUpdateView.templateColor != null }">
              <input type="radio" name="templateColor" value="gray">
            </c:if>
            <span style="color:#759F94">■</span>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="gray"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.templateColor == 'yellow' }">
              <input type="radio" name="templateColor" value="yellow" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.templateColor != 'yellow' }">
              <input type="radio" name="templateColor" value="yellow">
            </c:if>
            <span style="color:#F79400">■</span>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="yellow"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.templateColor == 'purple' }">
              <input type="radio" name="templateColor" value="purple" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.templateColor != 'purple' }">
              <input type="radio" name="templateColor" value="purple">
            </c:if>
            <span style="color:#6868FF">■</span>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="purple"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.templateColor == 'kimidori' }">
              <input type="radio" name="templateColor" value="kimidori" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.templateColor != 'kimidori' }">
              <input type="radio" name="templateColor" value="kimidori">
            </c:if>
            <span style="color:#84C146">■</span>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="kimidori"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.templateColor == 'red' }">
              <input type="radio" name="templateColor" value="red" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.templateColor != 'red' }">
              <input type="radio" name="templateColor" value="red">
            </c:if>
            <span style="color:#FF2020">■</span>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_COLORKEY_NAME" valueKey="SHOPBUKKEN_ASP_COLORKEY_VALUE" code="red"/>
          </label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">検索条件付加項目 <span class="caution">*</span></div>
        <div class="annotation">検索条件付加項目の表示範囲を設定します。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.searchItem == '0' || AspUpdateView.searchItem == null }">
              <input type="radio" name="searchItem" value="0" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.searchItem != '0' && AspUpdateView.searchItem != null }">
              <input type="radio" name="searchItem" value="0">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="0"/>
          </label>
          <br>
          <label>
            <c:if test = "${AspUpdateView.searchItem == '1' }">
              <input type="radio" name="searchItem" value="1" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.searchItem != '1' }">
              <input type="radio" name="searchItem" value="1">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="1"/>
          </label>
          <br>
          <label>
            <c:if test = "${AspUpdateView.searchItem == '2' }">
              <input type="radio" name="searchItem" value="2" checked="checked">
            </c:if>
            <c:if test = "${AspUpdateView.searchItem != '2' }">
              <input type="radio" name="searchItem" value="2">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SEARCH_ITEM_NAME" valueKey="SHOPBUKKEN_ASP_SEARCH_ITEM_VALUE" code="2"/>
          </label>
        </div>
      </div>

      <div class="add_form">
        <div class="add_form_title">会社ロゴ <span class="caution">*</span></div>
        <div class="annotation">会社ロゴを表示する場合は、「表示する」を選択し、ファイルをアップロードします。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.logoFlg == '0' || AspUpdateView.logoFlg == null }">
              <input type="radio" name="logoFlg" value="0" checked="checked" onClick="DisableTextBoxImg();">
            </c:if>
            <c:if test = "${AspUpdateView.logoFlg != '0' && AspUpdateView.logoFlg != null }">
              <input type="radio" name="logoFlg" value="0" onClick="DisableTextBoxImg();">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_LOGO_FLG_NAME" valueKey="SHOPBUKKEN_ASP_LOGO_FLG_VALUE" code="0"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.logoFlg == '1' }">
              <input type="radio" name="logoFlg" value="1" checked="checked" onClick="DisableTextBoxImg();">
            </c:if>
            <c:if test = "${AspUpdateView.logoFlg != '1' }">
              <input type="radio" name="logoFlg" value="1" onClick="DisableTextBoxImg();">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_LOGO_FLG_NAME" valueKey="SHOPBUKKEN_ASP_LOGO_FLG_VALUE" code="1"/>
          </label>
          <input type="file" size="60" name="logoFlgImage" disabled="disabled" value="${param.logoFlgImage}"  accept="image/jpeg">
          <script>
            $(function(){
                $('input[type=file]').change(function(e){
                    var ok = /\.(jpe?g|gif|png)$/i.test($(e.target).val());
                    if(!ok){
                        $(e.target).val('');
                    }
                });
                $('#aspAddPageForm').submit(function(){
                    $('input[type=file]').each(function(){
                        if($(this).val() != ''){
                            }else{
                                $(this).prop('disabled',true);
                                }
                        });
                    });
                var accepts =[];
                <c:forEach var="mstContentTypes" items="${masterService.getReceiveMstContentType()}">
                  accepts.push('${mstContentTypes.contentType}');
                </c:forEach>
                $('input[type=file]').attr('accept',accepts.join(','));
            });
            </script>
	        </div>
      </div>
      <c:if test = "${(AspUpdateView.logoFlg == '1' && not empty AspUpdateView.imgUrlPath)}">
        <div class="add_form">
          <p style="font-weight:bold;">現在登録されている画像</p>
          <div class="asp_img_box">
            <c:if test = "${(not empty AspUpdateView.imgRealPath )}">
              <c:set var="serverPath" value="${pageContext.request.contextPath}" />
            </c:if>
            <c:if test = "${(empty AspUpdateView.imgRealPath )}">
              <c:set var="serverPath" >https://</c:set>
            </c:if>
            <img src="${serverPath}${fn:escapeXml(AspUpdateView.imgUrlPath)}${fn:escapeXml(AspUpdateView.imgFileNm)}?resize=227:*">
          </div>
        </div>
      </c:if>

      <div class="add_form">
        <div class="add_form_title">個人情報保護方針 <span class="caution">*</span></div>
        <div class="annotation"> 「表示する」が選択され、URLが設定されている場合に、「同意する/しない」が表示されます。</div>
        <div class="form_space">
          <label>
            <c:if test = "${AspUpdateView.policyFlg == '0' || AspUpdateView.policyFlg == null }">
              <input type="radio" name="policyFlg" value="0" checked="checked" onClick="DisableTextBoxUrl();">
            </c:if>
            <c:if test = "${AspUpdateView.policyFlg != '0' && AspUpdateView.policyFlg != null }">
              <input type="radio" name="policyFlg" value="0" onClick="DisableTextBoxUrl();">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_POLICY_FLG_NAME" valueKey="SHOPBUKKEN_ASP_POLICY_FLG_VALUE" code="0"/>
          </label>
          <label>
            <c:if test = "${AspUpdateView.policyFlg == '1' }">
              <input type="radio" name="policyFlg" value="1" checked="checked" onClick="DisableTextBoxUrl();">
            </c:if>
            <c:if test = "${AspUpdateView.policyFlg != '1' }">
              <input type="radio" name="policyFlg" value="1" onClick="DisableTextBoxUrl();">
            </c:if>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_POLICY_FLG_NAME" valueKey="SHOPBUKKEN_ASP_POLICY_FLG_VALUE" code="1"/>
          </label>
          <c:if test = "${AspUpdateView.policyUrl == null }">
            <input type="text" size="60" maxlength="1024" name="policyUrl" value="http://">
          </c:if>
          <c:if test = "${AspUpdateView.policyUrl != null }">
            <input type="text" size="60" maxlength="1024" name="policyUrl" value="${AspUpdateView.policyUrl}">
          </c:if>
        </div>
      </div>

      <p class="section_header">エリア設定</p>
      <p>表示する都道府県に半角数字で並び順を指定します。</p>
      <table class="type_asp">
        <c:forEach items="${AspUpdateView.aspAreaPrefInfoList}" var="aspAreaPrefInfo" varStatus="i">
          <tr>
            <th>${aspAreaPrefInfo.areaName}</th>
            <c:forEach items="${aspAreaPrefInfo.prefList}" var="aspPrefInfo" varStatus="k">
              <td>
                ${aspPrefInfo.prefName}
                <input type="text" name="${aspPrefInfo.prefCodeName}" value="${fn:escapeXml(aspPrefInfo.prefSortKey)}" size="1" maxlength="2">
              </td>
              <c:set var="index" value="${k.count}"/>
            </c:forEach>
            <c:forEach begin="1" end="${7 - index}" step="1">
              <td class="no_item"></td>
            </c:forEach>
          </tr>
        </c:forEach>
      </table>
      <p class="section_header">沿線設定</p>
      <p>沿線名に半角数字で並び順を指定します。全項目入力必須です。 <span class="caution">*</span></p>
      <table class="type_asp">
        <tr>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="1"/>
            <input type="text" name="ensenCd1" value="${fn:escapeXml(AspUpdateView.ensenCd1)}" size="1" maxlength="1">
          </td>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="2"/>
            <input type="text" name="ensenCd2" value="${fn:escapeXml(AspUpdateView.ensenCd2)}" size="1" maxlength="1">
          </td>
          <td>
            <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="3"/>
            <input type="text" name="ensenCd3" value="${fn:escapeXml(AspUpdateView.ensenCd3)}" size="1" maxlength="1">
          </td>
         </tr>
      </table>
      <p>
        <input type="hidden" name="company" value="${fn:escapeXml(AspUpdateView.company)}">
        <input type="hidden" name="bumon" value="${fn:escapeXml(AspUpdateView.bumon)}">
        <input type="hidden" name="shopCd" value="${fn:escapeXml(AspUpdateView.shopCd)}">
        <input type="hidden" name="password" value="${fn:escapeXml(AspUpdateView.password)}">
        <input type="hidden" name="prefs">
        <input type="hidden" name="logoFlg" value="${fn:escapeXml(AspUpdateView.logoFlg)}">
        <input type="hidden" name="imgRealPath" value="${fn:escapeXml(AspUpdateView.imgRealPath)}">
        <input type="hidden" name="imgUrlPath" value="${fn:escapeXml(AspUpdateView.imgUrlPath)}">
        <input type="hidden" name="imgFileNm" value="${fn:escapeXml(AspUpdateView.imgFileNm)}">
        <input type="hidden" name="imgKbn" value="${fn:escapeXml(AspUpdateView.imgKbn)}">
        <input type="hidden" name="imgFileType" value="${fn:escapeXml(AspUpdateView.imgFileType)}">
        <input type="hidden" name="updDt" value="${fn:escapeXml(AspUpdateView.updDt)}">
        <input type="hidden" name="shopKanriUpdDt" value="${fn:escapeXml(AspUpdateView.shopKanriUpdDt)}">
        <input type="hidden" name="imgId" value="${fn:escapeXml(AspUpdateView.imgId)}">
        <input type="submit" value="確認画面へ">
        <input type="button" value="戻る" onClick="_submit('AspUpdateBack.do');">
      </p>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
