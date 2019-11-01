<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="問い合せ種別編集" />
<%@ include file="../parts/ContentsHeader.jsp" %>
<%@ include file="../parts/ContentsSidebar.jsp" %>

<script type="text/javascript">
  addEvent('load', window, function(){document.getElementsByName('inqTitle')[0].focus();});
</script>
<c:set var="view" value="${CjnInquiryTypeUpdateView}" scope="page" />

<div id="main">
<%@ include file="../parts/ContentsHeadline.jsp" %>
  <div class="main_layout">
    <div class="topic_path">
      <html:link action="/Index">トップページ</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeList">問い合せ種別一覧</html:link> &gt;
      <html:link action="/cjn_inquiry/CjnInquiryTypeInfo">
        <html:param name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        問い合せ種別詳細
      </html:link> &gt;
      ${title}
    </div>
    <h1>${title}</h1>
    
    <html:errors />
    
    <p class="section_header">問い合せ種別編集</p>
    <html:form action="/cjn_inquiry/CjnInquiryTypeUpdateConfirm" method="post" onsubmit="disableSubmit(this)">
      <div class="add_form">
        <div class="add_form_title">タイトル<span class="caution">*</span></div>
        <div class="annotation">問い合せフォームのタイトルを設定します(内部閲覧用)。</div>
        <div class="form_space">
          <input type="text" name="inqTitle" size="50" maxlength="50" value="${fn:escapeXml(view.inqTitle)}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">説明文<span class="caution">*</span></div>
        <div class="annotation">問い合せの説明文を記述します(内部閲覧用)。</div>
        <div class="form_space">
          <input type="text" name="inqComment" size="50" maxlength="50" value="${fn:escapeXml(view.inqComment)}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">問い合せURL<span class="caution">*</span></div>
        <div class="annotation">問い合せフォームのURLを設定します。</div>
        <div class="form_space">
          <input type="text" name="inqUrl" size="80" maxlength="500" value="${fn:escapeXml(view.inqUrl)}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">表示用タイトル</div>
        <div class="annotation">問い合せフォームの表示用タイトルを設定します。</div>
        <div class="form_space">
          <input type="text" name="dispTitle" size="50" maxlength="35" value="${fn:escapeXml(view.dispTitle)}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">表示用ソートキー</div>
        <div class="annotation">同一画面に問い合せフォームを複数設置する場合に表示順を設定します。</div>
        <div class="form_space">
          <input type="text" name="dispSortKey" size="5" maxlength="2" value="${fn:escapeXml(view.dispSortKey)}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">問い合せグループ<span class="caution">*</span></div>
        <div class="annotation">この問い合せフォームが属するグループを設定します。</div>
        <div class="form_space">
          <chintai:PropertyOptions
              name="inqGroupType"
              nameKey="CJN_INQ_GROUP_TYPE_NAME"
              valueKey="CJN_INQ_GROUP_TYPE_VALUE"
              fixValue="${view.inqGroupType}" />
        </div>
      </div>
      <div class="add_form">
        <div class="add_form_title">管理メモ</div>
        <div class="annotation">問い合せについての管理メモを記述します。</div>
        <div class="form_space">
          <textarea name="adminNote" cols="60" rows="5"><c:out value="${view.adminNote}" /></textarea>
        </div>
      </div>
      <div class="add_form">
        <input type="hidden" name="cjnInqKindSeq" value="${view.cjnInqKindSeq}" />
        <input type="hidden" name="updDt" value="${view.updDt}" />
        <input type="submit" name="confirm" value="確認画面へ" />
        <input type="button" name="back" value="戻る" onclick="_submit('CjnInquiryTypeInfo.do?cjnInqKindSeq=${view.cjnInqKindSeq}')" />
      </div>
    </html:form>
  </div>
</div>

<%@ include file="../parts/ContentsFooter.jsp" %>
