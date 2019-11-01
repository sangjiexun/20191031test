<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="グループ化店舗の編集"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
<c:set value="${AspGroupInfoView}" var="view"/>
<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      <a href ="<c:url value="ShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
        店舗・契約詳細
      </a> &gt;
      <a href ="<c:url value="AspShopInfo.do"><c:param name="shopCd" value="${view.shopCd}"/></c:url>">
      不動産ASP設定情報</a> &gt;
        ${title}
    </div>
    <h1>${title}</h1>
    <p class="section_header">編集する店舗の情報</p>
       <html:form action="/shop_bukken/AspGroupUpdateConfirm" method="post" onsubmit="disableSubmit(this)">
         <table class="type_list">
           <tr>
             <th>店舗コード</th>
             <th>会社名<br>事務所名</th>
             <th>店舗状態</th>
             <th>不動産ASP状態</th>
           </tr>
           <tr>
             <td><c:out value="${view.groupshopCd}" /></td>
             <td><c:out value="${view.company}"/><br><c:out value="${view.bumon}" /></td>
             <td>
               <c:if test="${view.shopStatus == '0'}"><font color="#FF3333"></c:if>
                 <chintai:CodePrint nameKey="SHOPBUKKEN_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_SHOP_STATUS_VALUE" code="${view.shopStatus}"/>
               <c:if test="${view.shopStatus == '0'}"></font></c:if>
               </span>
             </td>
             <td>
               <c:if test="${view.aspFlg == '1'}"><font color="#FF3333"></c:if>
                 <chintai:CodePrint nameKey="SHOPBUKKEN_ASP_SHOP_STATUS_NAME" valueKey="SHOPBUKKEN_ASP_SHOP_STATUS_VALUE" code="${view.aspFlg}"/>
               <c:if test="${view.aspFlg == '1'}"></font></c:if>
             </td>
           </tr>
         </table>
         <div class="add_form">
           <div class="add_form_title">不動産ASP状態 <span class="caution">*</span></div>
           <div class="annotation">状態を「停止」にすると、その店舗に関連する物件がASPの検索対象から外れます。</div>
           <div class="form_space">
             <c:choose>
               <c:when test="${view.aspFlg == '1'}">
                 <label><input type="radio" name="aspFlg" value="0" >通常</label>
                 <label><input type="radio" name="aspFlg" value="1" checked="checked">停止</label>
               </c:when>
               <c:otherwise>
                 <label><input type="radio" name="aspFlg" value="0" checked="checked">通常</label>
                 <label><input type="radio" name="aspFlg" value="1" >停止</label>
               </c:otherwise>
             </c:choose>
           </div>
         </div>
         <p>
           <input type="hidden" name="shopCd" value="${fn:escapeXml(view.shopCd)	}">
           <input type="hidden" name="groupshopCd" value="${fn:escapeXml(view.groupshopCd)}">
           <input type="hidden" name="company" value="${fn:escapeXml(view.company)}">
           <input type="hidden" name="bumon" value="${fn:escapeXml(view.bumon)}">
           <input type="hidden" name="shopStatus" value="${fn:escapeXml(view.shopStatus)}">
           <input type="hidden" name="updDt" value="${fn:escapeXml(view.updDt)}">
           <input type="hidden" name="aspFlg" value="${fn:escapeXml(view.aspFlg)}">
           <input type="hidden" name="aspShopSeq" value="${fn:escapeXml(view.aspShopSeq)}">
           <input type="hidden" name="shopKanriUpdDt" value="${fn:escapeXml(view.shopKanriUpdDt)}" >
           <input type="submit" value="確認画面へ">
           <input type="button" name="back" value="戻る" onClick="_submit('AspShopInfo.do?shopCd=${view.shopCd}')">
         </p>
       </html:form>
    </div>
  </div>

<%@ include file="../parts/ContentsFooter.jsp" %>
