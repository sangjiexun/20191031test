<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="駅一覧" />
<c:set var="view" value="${EkiClientSettingInfoView}" />
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>
<%@ include file="../parts/PopUpContentsHeadline.jsp"%>
<%@ page import = "java.net.URLDecoder"%>


<!-- メイン -->
<div id="main">
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>

    <h1>${title}</h1>

    <html:errors />
    <html:messages id ="msg" message="true" header="info.header" footer="info.footer">
      <c:out value="${msg}"/>
    </html:messages>

<c:if test="${not empty view.ekiNameList}">

    <p class="section_header">
      駅一覧
      (
      <c:out value="${view.ensenName}"/>
      )：
      <c:out value="${view.dcoName}"/>
    </p>

    <html:form action="/dataoutput/EkiClientSettingUpdate" method="post">

    <p>
      <html:link href="#" onclick="_submit('EkiClientSettingUpdate.do');">
        &gt;&gt; 駅別データ元出力設定を更新する
      </html:link>
    </p>
    <input type="hidden" name="dcoType" Value="${view.dcoType}" >
    <input type="hidden"  name="dcoName" value="${view.dcoName}">
    <input type="hidden" name="ensenCd" Value="${view.ensenCd}" >
    <input type="hidden" name="ensenName" Value="${view.ensenName}" >
    <input type="hidden" name="ensenType" Value="${view.ensenType}" >

    </html:form>

    <div  class="annotation_left">※■は、出力する設定となっているデータ元です</div>
      <table class="type_list">
        <colgroup>
          <col width="40%">
          <col width="60%">
        </colgroup>
        <tr>
          <th>駅名</th>
          <th>設定値(※)</th>
        </tr>
        <c:set var="clientsystemTypeMap" value="${view.clientsystemTypeMap}" />
        <c:forEach items="${view.ekiNameList}" var="ekiList" varStatus="i">
          <tr>
            <td>
              <c:out value="${ekiList.ekiName}"/>
            </td>
            <c:set var="crs" value="" />
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][0] eq '0'}">
                <c:set var="crs" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][0] ne '0'}">
                <c:set var="crs" value="■" />
            </c:if>

            <c:set var="ans" value="" />
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][1] eq '0'}">
                <c:set var="ans" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][1] ne '0'}">
                <c:set var="ans" value="■" />
            </c:if>

            <c:set var="able" value="" />
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][2] eq '0'}">
                <c:set var="able" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][2] ne '0'}">
                <c:set var="able" value="■" />
            </c:if>

            <c:set var="magazine" value="" />
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][3] eq '0'}">
                <c:set var="magazine" value="□" />
            </c:if>
            <c:if test="${clientsystemTypeMap[ekiList.ekiCd][3] ne '0'}">
                <c:set var="magazine" value="■" />
            </c:if>

            <td align="left" class="section_header">${crs}CRS　　　　${ans}ANS　　　　${able}エイブル直営店　　　　${magazine}手書き</td>
          </tr>
        </c:forEach>
      </table>
      </c:if>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
