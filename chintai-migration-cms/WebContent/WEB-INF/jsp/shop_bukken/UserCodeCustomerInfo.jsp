<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先詳細"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
 <div class="popup_layout">
    <div class="topic_path">
      <a href="userCode_customer_list.vm">取引先検索</a> &gt;
        ${title}
    </div>
    <h1>${title}</h1>

 <table class="type_none" width="100%">
  <tr>
    <td align="left">
   	 <input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択">&nbsp;<input type="button" value="戻る" onClick="history.go(-1)">
    </td>
  </tr>  
 </table>
   <p class="section_header">不動産店舗情報</p>
   <table class="type_detail">
    <colgroup>
     <col width="20%" align="center">
     <col width="30%">
     <col width="20%" align="center">
     <col width="30%">
    </colgroup>       
    <tr>
     <th>不動産会社名</th>
     <td colspan="3">(有)アークブラン&nbsp;
    </tr>  
    <tr>
     <th>不動産店舗名</th>
     <td>エイブルネットワーク岩国店</td>
     <th>不動産店舗コード</th>
     <td>0001</td>     
    </tr>
    <tr>
        <th rowspan="4">住所</th>
        <td colspan="3">〒740-0081</td>
    </tr>    
    <tr>
     <td colspan="3">
      山口県


     </td>
    </tr>
    <tr>
     <td colspan="3">岩国市門前町３－１５－２５</td>
    </tr>
    <tr>
     <td colspan="3">&nbsp;</td>
    </tr>	
    <tr>
     <th>電話番号</th>
     <td>0827-03-1425</td>
     <th>FAX番号</th>
     <td>0827-03-1425</td>
    </tr>
    <tr>
     <th>担当者名</th>
     <td colspan="3">&nbsp;</td>
    </tr>
    <tr>
     <th>ネット契約開始日</th>
     <td>2007年3月10日</td>
     <th>ネット契約終了日</th>
     <td>2007年8月10日</td>
    </tr>
    <tr>
     <th>取引担当支社</th>
     <td>九州支社</td>
     <th>営業担当者</th>
     <td>賃貸　花子</td>     
    </tr>
    <tr>
     <th>登録日</th>
     <td>2005/03/24 10:56:11</td>
     <th>更新日</th>
     <td>2005/03/25 12:11:32</td>
    </tr>
   </table>
   <!--請求情報-->
   <p class="section_header">請求情報</p>
   <table class="type_detail">
    <colgroup>
     <col span="1" width="20%" align="center">
     <col span="1" width="30%">
     <col span="1" width="20%" align="center">
     <col span="1" width="30%">
    </colgroup> 
    <tr>
     <th>締日</th>
     <td>25日
     </td>
     <th>振込日</th>
     <td>翌々月5日</td>
    </tr>
    <tr>
     <th>支払方法</th>
     <td colspan="3">なし</td>
     </table>
   <!--契約履歴-->
   <p class="section_header">契約履歴</p>
   <p>※次回適用(超過料金計算)の契約内容はグリーンで表示されます。</p>
   <table class="type_list">
    <tr>
     <th>適用<br>開始月</th>
     <th>契約<br>種別</th>
     <th>出稿<br>種別</th>
     <th>契約内容</th>
     <th>業務管理<br>機能</th>
     <th>売買物件<br>発信</th>
     <th>複数店舗<br>割引</th>
     <th>基本料<br>割引</th>
    </tr>
    <tr bgcolor="#33FF33">
     <td>2007/10</td>
     <td>従量</td>
     <td>単体利用</td>
     <td>東京23区－CRS－掲載件数200件まで</td>
     <td>なし</td>
     <td>なし</td>
     <td>なし</td>
     <td>なし</td>
    </tr>
   </table>
  <!--売上商品情報-->
   <p class="section_header">売上商品情報</p>
   <p>※最終売上月：2005年05月</p>
   <table class="type_list">
    <tr>
     <th>適用<br>開始月</th>
     <th>商品名</th>
     <th>数量</th>
     <th>単価</th>
     <th>金額</th>
    </tr>
   </table>  
  </div>
 </div>

<%@ include file="../parts/ContentsFooter.jsp" %>
