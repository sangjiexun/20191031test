<%--
/*
 * Copyright 2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
--%><%@ tag body-content="empty" pageEncoding="UTF-8" import="org.apache.struts.Globals,org.apache.commons.logging.Log,org.apache.commons.logging.LogFactory"
%><%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="/WEB-INF/tld/chintai.tld" prefix="chintai"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


				<div class="form_space">
					<table class="type_search_shop">
						<tbody>
							<tr>
								<th>エリアから探す</th>
								<th><input type="radio" name="_searchType" checked="checked" value="1"></th>
								<td>
									<table class="type_searchbox">
										<tbody>
											<tr>
												<td>エリア</td>
												<td>
													<select id="_areacd">
														<option value=""></option>
														<c:forEach items="${masterService.selectMstArea()}" var="area">
															<option value="${area.areacd }"><c:out value="${area.areaname}"/></option>
														</c:forEach>
													</select>
												</td>
												<td>沿線タイプ</td>
												<td>
													<chintai:PropertyOptions id="_ensentype" name="" fixValue="" nameKey="SHOPBUKKEN_ENSENTYPE_NAME" valueKey="SHOPBUKKEN_ENSENTYPE_VALUE"/>
												</td>
												<td>沿線</td>
												<td>
													<select id="_ensencd" style="width: 180px">
														<option value=""></option>
													</select>
												</td>
												<td>駅</td>
												<td>
													<select id="_ekicd" style="width: 180px">
														<option value=""></option>
													</select>
												</td>
											</tr>
										</tbody>
									</table>
									<script type="text/javascript">
										$('#_areacd').change(function(){
											$('#_ensentype').val("").change();
										});
										$('#_ensentype').change(function(){
											var _ensencd = $('#_ensencd');
											_ensencd.children().remove();
											_ensencd.append($('<option />'));
											var e = $(this).val();
											if(e != ""){
												AddressEnsenManager.getEnsenList($('#_areacd').val(), e, function(ret) {
													$.each(ret,function(){
														_ensencd.append($('<option />').val(this.ensenCode).html(this.ensenName));
													});
											    });
											}
											_ensencd.change();
										});
										$('#_ensencd').change(function(){
											var _ekicd = $('#_ekicd');
											_ekicd.children().remove();
											_ekicd.append($('<option />'));
											var e = $(this).val();
											var name = $(this).children(':selected').text();
											if(e != ""){
												AddressEnsenManager.getEkiList(e, function(ret) {
													$.each(ret,function(){
														_ekicd.append(
																$('<option />').html(this.ekiName)
																.data('eki',{
																	'ensencd':e,
																	'ensenname':name,
																	'ekicd':this.ekiCode,
																	'ekiname':this.ekiName
																})
														);
													});
											    });
											}
											_ekicd.change();
										});
									</script>
								</td>
								<td rowspan="3" style="border: none;">
									<table>
										<tbody>
											<tr>
												<td style="border: none;">&nbsp;&nbsp;
													<input type="button" id="_btnAddEki" value="追加">
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<th>駅名から探す</th>
								<th><input type="radio" name="_searchType" value="2"></th>
								<td>
									<table class="type_searchbox">
										<tbody>
											<tr>
												<td>駅名</td>
												<td><input id="_ekiname" size="80" maxlength="64" type="text"></td>
												<td><input id="_ekinameSearch" type="button" value="検索"></td>
											</tr>
											<tr>
												<td colspan="3">検索結果</td>
											</tr>
											<tr>
												<td colspan="3">
													<select id="_ensenEkiList" size="5" multiple style="width: 100%">
													</select>
												</td>
											</tr>
										</tbody>
									</table>
									<script type="text/javascript">
										$('#_ekinameSearch').click(function(){
											var _ensenEkiList = $('#_ensenEkiList');
											_ensenEkiList.children().remove();
											var e = $('#_ekiname').val();
											if(e != ""){
												AddressEnsenManager.getEnsenEki(e, function(ret) {
													$.each(ret,function(){
														_ensenEkiList.append($('<option />').html(this.ENSENNAME + this.EKINAME)
																.data('eki',{
																	'ensencd':this.ENSENCD,
																	'ensenname':this.ENSENNAME,
																	'ekicd':this.EKICD,
																	'ekiname':this.EKINAME
																})
														);
													});
											    });
											}
										});
									</script>
								</td>
							</tr>
							<tr>
								<th>その他交通機関</th>
								<th><input type="radio" name="_searchType" value="3"></th>
								<td>
									<table class="type_searchbox">
										<tbody>
											<tr>
												<td>その他交通機関名</td>
												<td><input id="_otherTransName" size="96" maxlength="48" type="text"></td>
											</tr>
											<tr>
												<td>その他交通機関乗降場</td>
												<td><input id="_otherTransPlatform" size="40" maxlength="20" type="text"></td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">
						$(':radio[name=_searchType]').click(function(){
							var radio = $(this);
							$(':radio[name=_searchType]').parents('tr').children('td').find(':input').prop('disabled',true);
							var e = radio.parents('tr').children('td').find(':input');
							if(radio.prop('checked')){
								e.prop('disabled',false);
							}
							$('#_btnAddEki').prop('disabled',false);
						}).triggerHandler('click');
						$('#_btnAddEki').click(function(){
							var v = $(':radio[name=_searchType]:checked').val();
							var list = [];
							if(v == '3'){
								var t = $.trim($('#_otherTransName').val());
								var p = $.trim($('#_otherTransPlatform').val());
								if(t != '' && p != ''){
									var eki = {
											'ensenname': t,
											'ekiname' : p,
											'otherTransName' : t,
											'otherTransPlatform' : p
									};
									list.push(eki);
								}
							}else{
								var select;
								if(v == '1')
									select = $('#_ekicd option:selected');
								else
									select = $('#_ensenEkiList option:selected');

								select.each(function(){
									var eki = $(this).data('eki');
									if(eki)
										list.push(eki);
								});
							}
							var _selectEki = $('#_selectEki');
							var opts = _selectEki.children();
							$.each(list,function(){
								var eki = this;
								var contain = $.grep(opts,function(opt){
									var _eki = $(opt).data('eki');
									return eki.ensencd == _eki.ensencd &&
											eki.ekicd == _eki.ekicd &&
											eki.otherTransName == _eki.otherTransName &&
											eki.otherTransPlatform == _eki.otherTransPlatform;
								}).length != 0 ;
								if(!contain){
									_selectEki.append($('<option />').html(this.ensenname + this.ekiname)
											.data('eki',this));
								}
							});
						});
					</script>
				</div>
				<div class="annotation">選択済みの駅リスト</div>
				<div class="form_space">
					<table style="width: 100%">
						<colgroup>
                  			<col span="1" width="60%">
                  			<col span="1" width="40%">
                  		</colgroup>
						<tbody>
							<tr>
								<td rowspan="3" style="border: none;" width="50%">
									<select	id="_selectEki" size="10" style="width: 95%">
									</select>
								</td>
								<td>
									<input type="button" id="_btnUp" value="上へ">
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" id="_btnDown" value="下へ">
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" id="_btnDel" value="選択中の駅を削除">
								</td>
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">
						$('#_btnUp').click(function(){
							var _selectEki = $('#_selectEki');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i > 0){
								$( opts[i] ).insertBefore($(opts[i-1]));
							}
						});
						$('#_btnDown').click(function(){
							var _selectEki = $('#_selectEki');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i < opts.length -1){
								$( opts[i] ).insertAfter($(opts[i+1]));
							}
						});
						$('#_btnDel').click(function(){
							var _selectEki = $('#_selectEki');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i != -1){
								$(opts[i]).remove();
							}
						});
					</script>
				</div>
