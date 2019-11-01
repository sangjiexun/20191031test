<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/chintai.tld" prefix="chintai"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <table class="type_detail">
      <colgroup>
        <col span="1" width="11%">
        <col span="1" width="11%">
        <col span="1" width="78%">
      </colgroup>
      <c:set var="mstRendo" value="${masterService.selectMstRendoByPrimaryKey(view.shopRireki.rendoCd)}"/>
      <tr>
        <th class="text-left" colspan="2">事業者区分</th>
        <td><chintai:CodePrint nameKey="SHOPBUKKEN_COMPANY_KBN_NAME" valueKey="SHOPBUKKEN_COMPANY_KBN_VALUE" code="${mstRendo.companyKbn}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">連動元</th>
        <td><c:out value="${mstRendo.rendoName}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">名寄せ設定</th>
        <td>
        	<c:if test="${!empty view.ctNayoseSkipShop }">
        		名寄せしない
        	</c:if>
        	<c:if test="${empty view.ctNayoseSkipShop }">
        		名寄せする
        	</c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">会社名</th>
        <td><c:out value="${view.company}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">事務所名</th>
        <td><c:out value="${view.bumon}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">所属団体名</th>
        <td><c:out value="${view.dantai}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">代表者名</th>
        <td><c:out value="${view.licTrust}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">グループ名</th>
        <td><c:out value="${view.groupName}"/></td>
      </tr>
      <!-- join 3 rows -->
      <tr>
        <th rowspan="5" class="text-left">住所</th>
        <th class="text-left">郵便番号</th>
        <td><c:out value="${view.zipCd}"/></td>
      </tr>
      <tr>
        <th class="text-left">住所１</th>
        <td><c:out value="${view.address1}"/></td>
      </tr>
      <tr>
        <th class="text-left">住所２</th>
        <td><c:out value="${view.address2}"/></td>
      </tr>
      <tr>
		<th class="text-left"><label>緯度</label></th>
		<td><c:out value="${view.locationY}"/></td>
	  </tr>
	  <tr>
		<th class="text-left"><label>経度</label></th>
		<td><c:out value="${view.locationX}"/></td>
	  </tr>
      <!-- join end -->
      <tr>
        <th class="text-left" colspan="2">TEL</th>
        <td><c:out value="${view.tel}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">反響用TEL</th>
        <td><c:out value="${view.shopRireki.telInq}"/></td>
      </tr>
      <%-- 2013/07/25 店舗電話番号変更対応２次リリース分 ３項目追加 --%>
      <tr>
        <th class="text-left" colspan="2">フリーコール（CHINTAI）用TEL</th>
        <td>
        	<c:if test="${!empty view.shopRireki.telFreeCt}">使用する</c:if>
        	<c:if test="${empty view.shopRireki.telFreeCt}">使用しない</c:if>
        	<c:set var="ppcInfoChintai" value="${shopService.selectPpcInfoChintaiDateEditByPrimaryKey(view.shopCd) }"/>
        	<c:if test="${ppcInfoChintai != null}">
        		(番号：<c:out value="${ppcInfoChintai.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoChintai.ppcStartDt}"/>～<c:out value="${ppcInfoChintai.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoChintai.ppcRecycleDt}"/>)
   			</c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">フリーコール（店舗）用TEL</th>
        <td><c:out value="${view.shopRireki.telFreeShop}"/></td>
      </tr>

      <tr>
        <th class="text-left" colspan="2">電話番号選択</th>
            <td><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="${view.shopRireki.telDispKbn}"/></td>
      </tr>

      <tr>
        <th class="text-left" colspan="2">フリーコール（エイブル）用TEL</th>
        <td>
        	<c:if test="${!empty view.shopRireki.telFreeAbl}">使用する</c:if>
        	<c:if test="${empty view.shopRireki.telFreeAbl}">使用しない</c:if>
        	<c:set var="ppcInfoAbl" value="${shopService.selectPpcInfoAblDateEditByPrimaryKey(view.shopCd) }"/>
        	<c:if test="${ppcInfoAbl != null}">
        		(番号：<c:out value="${ppcInfoAbl.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoAbl.ppcStartDt}"/>～<c:out value="${ppcInfoAbl.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoAbl.ppcRecycleDt}"/>)
   			</c:if>
        </td>
      </tr>

	  <tr>
        <th class="text-left" colspan="2">電話番号選択（エイブル）</th>
            <td><chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_TEL_KBN_NAME" valueKey="SHOPBUKKEN_SHOP_TEL_KBN_VALUE" code="${view.shopRireki.telDispKbnAbl}"/></td>
      </tr>

      <tr>
        <th class="text-left" colspan="2">フリーコール（雑誌）用TEL</th>
        <td>
        	<c:if test="${!empty view.shopRireki.telMagazine}">使用する</c:if>
			<c:if test="${empty view.shopRireki.telMagazine}">使用しない</c:if>
			<c:set var="ppcInfoMagazine" value="${shopService.selectPpcInfoMagazineDateEditByPrimaryKey(view.shopCd) }"/>
			<c:if test="${ppcInfoMagazine != null}">
				(番号：<c:out value="${ppcInfoMagazine.ppcTelNo}"/> 転送期間：<c:out value="${ppcInfoMagazine.ppcStartDt}"/>～<c:out value="${ppcInfoMagazine.ppcEndDt}"/> ガイダンス通知期限：<c:out value="${ppcInfoMagazine.ppcRecycleDt}"/>)
   			</c:if>
        </td>
      </tr>
      <%-- 2013/7/25 end --%>

      <tr>
        <th class="text-left" colspan="2">FAX</th>
        <td><c:out value="${view.shopRireki.fax}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">地域</th>
        <td>
          エリア : [<c:out value="${view.areaCd}"/>] <c:out value="${view.areaName}"/> /
          都道府県 : [<c:out value="${view.prefCd}"/>] <c:out value="${view.prefName}"/> /
          市区町村 : [<c:out value="${view.cityCd}"/>] <c:out value="${view.cityName}"/>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">沿線</th>
        <td>
        	<c:forEach items="${view.shopRirekiEkis}" var="shopRirekiEki">
        		<c:set var="mstEnsen" value="${masterService.selectMstEnsenByPrimaryKey(shopRirekiEki.ensencd)}"/>
        		<c:set var="mstEki" value="${masterService.selectMstEkiByPrimaryKey(shopRirekiEki.ensencd,shopRirekiEki.ekicd)}"/>
        		<c:choose>
        			<c:when test="${! empty shopRirekiEki.otherTransName}">
          沿線タイプ : [] /
         その他交通機関 /沿線 : [] <c:out value="${shopRirekiEki.otherTransName}"/> /
          駅名 : [] <c:out value="${shopRirekiEki.otherTransPlatform}"/> <br>
        			</c:when>
        			<c:otherwise>
          沿線タイプ : [00<c:out value="${mstEnsen.ensentype}"/>] <chintai:CodePrint nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE" code="${mstEnsen.ensentype}"/> /
          沿線 : [<c:out value="${mstEnsen.ensencd}"/>] <c:out value="${mstEnsen.ensenname}"/> /
          駅名 : [<c:out value="${mstEki.ekicd}"/>] <c:out value="${mstEki.ekiname}"/> <br>
        			</c:otherwise>
        		</c:choose>
        	</c:forEach>
        </td>

      </tr>
      <tr>
        <th class="text-left" colspan="2">免許証番号</th>
        <td><c:out value="${view.licNum}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">免許証有効期限（開始）</th>
        <td><c:out value="${view.licEntry}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">免許証有効期限（終了）</th>
        <td><c:out value="${view.licValid}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">宅建取引主任者名</th>
        <td><c:out value="${view.licChief}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">担当者名</th>
        <td><c:out value="${view.tantou}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">ホームページリンク名称</th>
        <td>
        	<div><c:out value="${view.shopRireki.hpName1}"/></div>
        	<div><c:out value="${view.shopRireki.hpName2}"/></div>
        	<div><c:out value="${view.shopRireki.hpName3}"/></div>
        	<div><c:out value="${view.shopRireki.hpName4}"/></div>
        	<div><c:out value="${view.shopRireki.hpName5}"/></div>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">自社ホームページURL</th>
        <td>
        	<div><c:out value="${view.shopRireki.hpUrl1}"/></div>
        	<div><c:out value="${view.shopRireki.hpUrl2}"/></div>
        	<div><c:out value="${view.shopRireki.hpUrl3}"/></div>
        	<div><c:out value="${view.shopRireki.hpUrl4}"/></div>
        	<div><c:out value="${view.shopRireki.hpUrl5}"/></div>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">メールアドレス</th>
        <td>
        	<c:if test="${!empty view.shopRireki.email1}">
	        	<div><c:out value="${view.shopRireki.email1}"/>
	        		(<chintai:CodePrint nameKey="SHOPBUKKEN_EMAIL_USE_KBN_NAME" valueKey="SHOPBUKKEN_EMAIL_USE_KBN_VALUE" code="${view.shopRireki.emailUseKbn1}"/>)
	        	</div>
        	</c:if>
        	<c:if test="${!empty view.shopRireki.email2}">
	        	<div><c:out value="${view.shopRireki.email2}"/>
	        		(<chintai:CodePrint nameKey="SHOPBUKKEN_EMAIL_USE_KBN_NAME" valueKey="SHOPBUKKEN_EMAIL_USE_KBN_VALUE" code="${view.shopRireki.emailUseKbn2}"/>)
	        	</div>
        	</c:if>
        	<c:if test="${!empty view.shopRireki.email3}">
	        	<div><c:out value="${view.shopRireki.email3}"/>
	        		(<chintai:CodePrint nameKey="SHOPBUKKEN_EMAIL_USE_KBN_NAME" valueKey="SHOPBUKKEN_EMAIL_USE_KBN_VALUE" code="${view.shopRireki.emailUseKbn3}"/>)
	        	</div>
        	</c:if>
        	<c:if test="${!empty view.shopRireki.email4}">
	        	<div><c:out value="${view.shopRireki.email4}"/>
	        		(<chintai:CodePrint nameKey="SHOPBUKKEN_EMAIL_USE_KBN_NAME" valueKey="SHOPBUKKEN_EMAIL_USE_KBN_VALUE" code="${view.shopRireki.emailUseKbn4}"/>)
	        	</div>
        	</c:if>
        	<c:if test="${!empty view.shopRireki.email5}">
	        	<div><c:out value="${view.shopRireki.email5}"/>
	        		(<chintai:CodePrint nameKey="SHOPBUKKEN_EMAIL_USE_KBN_NAME" valueKey="SHOPBUKKEN_EMAIL_USE_KBN_VALUE" code="${view.shopRireki.emailUseKbn5}"/>)
	        	</div>
	        </c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">連絡方法</th>
        <td>
          <chintai:CodePrint nameKey="SHOPBUKKEN_FM_KBN_NAME" valueKey="SHOPBUKKEN_FM_KBN_VALUE" code="${view.fmKbn}"/>
        </td>
      </tr>
<!-- 2009/05/22 李昊燮 追加開始 -->
      <tr>
        <th class="text-left" colspan="2">営業時間</th>
        <td><c:out value="${view.businessHours}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">定休日</th>
        <td><c:out value="${view.holiday}"/></td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">店舗最終更新日時</th>
        <td>
          <c:if test="${view.shopUpdDt != null}">
            <c:out value="${view.shopUpdDt}"/>
          </c:if>
          <c:if test="${view.shopUpdDt == null}">
            --
          </c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">店舗名ひらがな名称</th>
        <td><c:out value="${view.bumonKana}"/></td>
      </tr>


      <tr>
        <th class="text-left" colspan="2">CHINTAI支社</th>
        <td>
        	<c:if test="${! empty view.shopRireki.ctShisyaCd }">
        		<c:out value="${view.shopRireki.ctShisyaCd}"/> <c:out value="${masterService.selectMstCtShisyaByPrimaryKey(view.shopRireki.ctShisyaCd).ctShisyaName}"/>
        	</c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">通知先</th>
        <td><c:out value="${view.shopRireki.noticeEmail }"/> </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">反響管理用メールアドレス</th>
        <td>
        	<c:if test="${! empty view.shopRireki.inqMngEmail}">
        		<c:out value="${view.shopRireki.inqMngEmail}"/>
        	</c:if>
        </td>
      </tr>
      <tr>
        <th class="text-left" colspan="2">管理最終更新日時</th>
        <td>
          <c:if test="${view.adminUpdDt != null}">
            <c:out value="${view.adminUpdDt}"/>
          </c:if>
        </td>
      </tr>
<!-- 2009/05/22 李昊燮 追加終了 -->
<!-- 2015/12/10 櫻庭哲史 店舗LINE＠ID追加 -->
      <tr>
        <th class="text-left" colspan="2">店舗LINE＠ID</th>
        <td><c:out value="${view.lineAccount}"/></td>
      </tr>
    </table>