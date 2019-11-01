<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="java.util.Date"
%>
      <table class="type_detail">
        <colgroup>
          <col span="1" width="20%">
          <col span="1" width="40%">
          <col span="1" width="40%">
        </colgroup>
        <tr>
          <th class="text-left">管理コード</th>
          <td colspan="2">
            <c:out value="${view.shopCd}" />-
            <c:out value="${view.bkCd}" />-
            <c:out value="${view.roomNo}" />
          </td>
        </tr>
        <tr>
          <th class="text-left">物件名称 / カナ</th>
          <td colspan="2">
            <c:out value="${view.bkName}" /> /
            <c:out value="${view.bkKana}" />
          </td>
        </tr>
        <tr>
          <th class="text-left">掲載状態</th>
          <td colspan="2">
            <c:if test="${view.ctStopDt != null && view.ablStopDt != null}">停止</c:if>
            <c:if test="${view.ctStopDt == null || view.ablStopDt == null}">通常</c:if>
          </td>
        </tr>
        <tr>
          <th class="text-left">レコード情報</th>
          <td style="border: none ;">
            <!-- inline table -->
            <table class="type_none">
              <tr>
                <th class="text-left">管理最終更新日時</th>
                <td>
                  <c:out value="${view.bukkenAdminUpdDt}" />
                </td>
              </tr>
            </table>
            <table class="type_none">
              <tr>
                <td height="1" bgcolor="#505050" colspan="2" style="padding: 0px;"></td>
                </td>
              </tr>
              <tr>
                <th class="text-left">入稿状態</th>
                <td>
                  <chintai:CodePrint nameKey="INS_KBN_NAME" valueKey="INS_KBN_VALUE" code="${view.insKbn}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">削除状態</th>
                <td>
                  <c:set var="kugiriFlg" value="false"></c:set>
                  <c:if test="${view.insKbn eq '9' or view.heyadomeKbn eq '1'}">
                    <c:out value="手動"></c:out>
                    <c:set var="kugiriFlg" value="true"></c:set>
                  </c:if>
                  <c:if test="${view.ctStopDt != null || view.ablStopDt != null}">
                    <c:if test="${view.changeSourceKbn == '1'}">
	                    <c:if test="${kugiriFlg eq 'true'}">
	                      <c:out value="・"></c:out>
	                    </c:if>
	                    <c:out value="CHINTAI"></c:out>
	                    <c:set var="kugiriFlg" value="true"></c:set>
                    </c:if>
                    <c:if test="${view.changeSourceKbn == '2'}">
	                    <c:if test="${kugiriFlg eq 'true'}">
	                      <c:out value="・"></c:out>
	                    </c:if>
	                    <c:out value="審査"></c:out>
	                    <c:set var="kugiriFlg" value="true"></c:set>
                    </c:if>
                  </c:if>
                  <c:if test="${view.insKbn ne '9' and
                                view.heyadomeKbn ne '1' and
                                view.ctStopDt == null and view.ablStopDt == null}">
                    <c:if test="${view.ablEndDtFlg eq 'true'}">
                      <c:if test="${kugiriFlg eq 'true'}"><c:out value="・"></c:out></c:if>
                      <c:out value="エイブル期限切れ"></c:out>
                      <c:set var="kugiriFlg" value="true"></c:set>
                    </c:if>
                    <c:if test="${view.ctEndDtFlg eq 'true'}">
                      <c:if test="${kugiriFlg eq 'true'}"><c:out value="・"></c:out></c:if>
                      <c:out value="CHINTAI期限切れ"></c:out>
                      <c:set var="kugiriFlg" value="true"></c:set>
                    </c:if>
                  </c:if>
                </td>
              </tr>
              <tr>
                <th class="text-left">最終入稿登録日時</th>
                <td>
                  <c:out value="${view.insDt}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">最終フロント反映日時</th>
                <td>
                  <c:out value="${view.updDt}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">物件初回登録日時(CHINTAI)</th>
                <td>
                  <c:out value="${view.ctStartDt}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">物件初回登録日時(エイブル)</th>
                <td>
                  <c:out value="${view.ablStartDt}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">地図プロット</th>
                <td>
                  <chintai:CodePrint nameKey="MAPPING_FLG_NAME" valueKey="MAPPING_FLG_VALUE" code="${view.mappingFlg}" />
                </td>
              </tr>
              <tr>
                <th class="text-left">座標情報</th>
                <td>
                 <c:choose>
                  <c:when test="${view.ctLocationFlg != null}">
                    <chintai:CodePrint nameKey="LOCATION_FLG_NAME" valueKey="LOCATION_FLG_VALUE" code="${view.ctLocationFlg}" />
                  </c:when>
                  <c:otherwise>
                  --
                  </c:otherwise>
                 </c:choose>
                </td>
              </tr>
              <tr>
                <th class="text-left">フロント掲載状況（CHINTAI）</th>
                <td>
                 	<c:if test="${view.ckbShopcd == null}">未掲載</c:if>
                 	<c:if test="${view.ckbShopcd != null}">掲載中</c:if>
                </td>
              </tr>
              <tr>
                <th class="text-left">フロント掲載状況（エイブル）</th>
                <td>
                    <c:if test="${view.akbShopcd == null}">未掲載</c:if>
                 	<c:if test="${view.akbShopcd != null}">掲載中</c:if>
                </td>
              </tr>

            </table>
          </td>
          <td style="border: none; vertical-align: top;">
            <p style="border: 1px dashed gray; padding: 2ex;">
             【削除種類】<br>
             　　手動・・・業者より手動で削除されたもの<br>
             　　CHINTAI・・・CHINTAIにより手動で削除されたもの<br>
             　　審査・・・審査メールにより自動削除されたもの<br>
             　　CHINTAI期間切れ・・・掲載期間が切れ、自動削除されたもの<br>
             　　エイブル期間切れ・・・掲載期間が切れ、自動削除されたもの<br><br>

             　※ 「手動」「CHINTAI」「審査」のいずれも当てはまらない場合、<br>
             　　&nbsp;「CHINTAI期間切れ」「エイブル期間切れ」が表示されます。
            </p>
          </td>
        </tr>
      </table>


      <!-- 物件情報 2 -->
      <table class="type_list" style="margin-bottom: 0em;">
        <tr>
          <th>沿線/駅<br>所在地</th>
          <th>所要時間</th>
          <th>家賃<br>管理費・共益費</th>
          <th>敷金<br>礼金</th>
          <th>保証金<br>解約金/償却金</th>
          <th>間取<br>面積</th>
          <th>建物種別<br>構造</th>
          <th>築年</th>
          <th>契約方式</th>
        </tr>
        <tr>
          <td>
          	<c:choose>
            	<c:when test="${view.otherTransName != null}">
            		<c:out value="${view.otherTransName}" />/
            		<c:out value="${view.otherTransPlatform}" /><br>
           	    </c:when>
           	    <c:otherwise>
	              	<c:if test="${view.ensenName != null}">
            			<c:out value="${view.ensenName}" />
            		</c:if>
            		<c:if test="${view.ensenName == null}">
            			--
            		</c:if>
            		/
            		<c:if test="${view.ekiName != null}">
            			<c:out value="${view.ekiName}" />
            		</c:if>
            		<c:if test="${view.ekiName == null}">
            			--
            		</c:if>
            		<br>
	            </c:otherwise>
            </c:choose>

            <c:if test="${view.shozaichi != null}">
                <c:out value="${view.shozaichi}" />
            </c:if>
            <c:if test="${view.shozaichi == null}">
                --
            </c:if>
            <br>
            <c:if test="${view.bkAdr1 != null}">
                <c:out value="${view.bkAdr1}" />
            </c:if>
            <c:if test="${view.bkAdr1 == null}">
                --
            </c:if>
            <br>
            <c:if test="${view.bkAdr2 != null}">
                <c:out value="${view.bkAdr2}" />
            </c:if>
            <c:if test="${view.bkAdr2 == null}">
                --
            </c:if>
            <br>
            <c:if test="${view.bkAdr3 != null}">
                <c:out value="${view.bkAdr3}" />
            </c:if>
            <c:if test="${view.bkAdr3 == null}">
                --
            </c:if>

          </td>
          <td>
            <c:if test="${view.ekiToho ne '0' and not empty view.ekiToho}">
              徒歩<c:out value="${view.ekiToho}" />分<br>
            </c:if>
            <c:if test="${view.bus ne '0' and not empty view.bus}">
              バス<c:out value="${view.bus}" />分　<c:out value="${view.busTei}"/>下車：停歩<c:out value="${view.busTeiho}" />分<br>
            </c:if>
            <c:if test="${view.car ne '0' and not empty view.car}">
              車移動　<c:out value="${view.car}" />分<c:out value="${view.carKyori}" />km
            </c:if>
          </td>
          <td><fmt:formatNumber pattern="###,###,###,###円" type="number" value="${view.chinryo}" /><br>
             <c:choose>
              <c:when test="${not empty view.kanriKin and view.kanriKin != 0}">
                <fmt:formatNumber pattern="###,###,###,###円" type="number" value="${view.kanriKin}" />
              </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
          </td>
          <td>
             <c:choose>
              <c:when test="${not empty view.shikiKin and view.shikiKin ne '0'}">
                <label><fmt:formatNumber maxFractionDigits="6" value="${view.shikiKin}" /><c:out value="${view.shikiTan}" /></label>
              </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
             <br>
             <c:choose>
               <c:when test="${not empty view.reiKin and view.reiKin ne '0'}">
                 <label><fmt:formatNumber maxFractionDigits="6" value="${view.reiKin}" /><c:out value="${view.reiTan}" /></label>
               </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
          </td>
          <td>
             <c:choose>
               <c:when test="${not empty view.hoshoKin and view.hoshoKin ne '0'}">
                 <label><fmt:formatNumber maxFractionDigits="6" value="${view.hoshoKin}" /><c:out value="${view.hoshoTan}" /></label>
               </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
             <br>
             <c:choose>
               <c:when test="${not empty view.kaiyakuKin and view.kaiyakuKin ne '0'}">
                 <label><fmt:formatNumber maxFractionDigits="6" value="${view.kaiyakuKin}" /><c:out value="${view.kaiyakuTan}" /></label>
               </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
             /
             <c:choose>
               <c:when test="${not empty view.shoukyakuKin and not empty view.shoukyakuKin and view.shoukyakuKin ne '0'}">
                 <label><fmt:formatNumber maxFractionDigits="6" value="${view.shoukyakuKin}" /><c:out value="${view.shoukyakuTan}" /></label>
               </c:when>
              <c:otherwise>
              --
              </c:otherwise>
             </c:choose>
          </td>
          <td>
            <c:if test="${view.madori != null}">
                <c:out value="${view.madori}" />
            </c:if>
            <c:if test="${view.madori == null}">
                --
            </c:if>
            <br>
            <c:out value="${view.senMenseki}" />平米
          </td>
          <td>
            <c:if test="${view.shubetsu != null}">
                <c:out value="${view.shubetsu}" />
            </c:if>
            <c:if test="${view.shubetsu == null}">
                --
            </c:if>
            <br>
            <c:if test="${view.kouzou != null}">
                <c:out value="${view.kouzou}" />
            </c:if>
            <c:if test="${view.kouzou == null}">
                --
            </c:if>
          </td>
          <td>
            <c:if test="${view.chikunen != null}">
                <c:out value="${view.chikunen}" />
            </c:if>
            <c:if test="${view.chikunen == null}">
                --
            </c:if>
          </td>
          <td>
            <c:if test="${view.keiyakuKbn == 0}">一般契約</c:if>
            <c:if test="${view.keiyakuKbn == 1}">定借契約</c:if>
            <c:if test="${view.keiyakuKbn == 2}">公正契約</c:if>
            <c:if test="${view.keiyakuKbn != 0 && view.keiyakuKbn != 1 && view.keiyakuKbn != 2}">--</c:if>
          </td>
        </tr>
      </table>