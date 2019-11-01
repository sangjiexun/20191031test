<%@ page contentType="text/html;charset=UTF-8" language="Java" %>
<%@ include file="../parts/ContentsImport.jsp" %>
<c:set var="title" value="取引先検索"></c:set>
<%@ include file="../parts/ContentsHeaderNoSideBar.jsp" %>

<div id="main">
<%@ include file="../parts/PopUpContentsHeadline.jsp" %>
  <div class="popup_layout">
    <div class="topic_path">
      ${title}
    </div>
    <h1>${title}</h1>

 <!-- 検索条件 -->
 #parse("userCode_customer_list_common.vm")
 <form name="resultFrm" action="user_code_bind_info.vm" method="post">    
  <!-- 検索結果 -->
  <p class="section_header">検索結果</p>
  <p>123 件中 1 件目 ～ 10 件目を表示中です。</p>
  <div class="pager">
   <a href="#">前へ</a>
	#foreach($hoge in [1..10])
   <a href="#">$velocityCount</a>
	#end
   <a href="#">後へ</a>
  </div>
  <table class="type_list">
   <tr>
    <th>不動産店舗コード</th>
    <th>不動産会社名</th>
    <th>不動産店舗名</th>
    <th>住所</th>
    <th>選択</th>
  </tr>

  <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>
    <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>
    <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>
    <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>
    <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>
  <tr>
   <td><a href="userCode_customer_info_update.vm">0001-0001</a></td>
   <td align="left">株式会社　ベックビルメンテナンス</td>
   <td align="left">中野店</td>
   <td align="left">東京都中野区中野４－２－１３</td>
   <td><input type="button" onClick="selectCustomer('0001-0001','株式会社　ベックビルメンテナンス');" value="選択"></td>
  </tr>

  </table> 
  <div class="pager">
  <a href="#">前へ</a>
  #foreach($hoge in [1..10])
  <a href="#">$velocityCount</a>
  #end
  <a href="#">後へ</a>
  </div>
 </form>    
</div>
</div>
<%@ include file="../parts/ContentsFooter.jsp" %>
