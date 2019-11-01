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
								<th><input type="radio" name="_searchTypeArea" checked="checked" value="1"></th>
								<td>
									<table class="type_searchbox">
										<tbody>
											<tr>
												<td>エリア</td>
												<td>
													<select id="__areacd">
														<option value=""></option>
														<c:forEach items="${masterService.selectMstArea()}" var="area">
															<option value="${area.areacd }"><c:out value="${area.areaname}"/></option>
														</c:forEach>
													</select>
												</td>
												<td>都道府県</td>
												<td>
													<select id="__prefcd" style="width: 110px">
													</select>
												</td>
												<td>市区町村</td>
												<td>
												 	<select id="__citycd" style="width: 180px">
													</select>
												</td>
											</tr>
										</tbody>
									</table>
									<script type="text/javascript">
										$('#__areacd').change(function(){
											var __prefcd = $('#__prefcd');
											__prefcd.children().remove();
											__prefcd.append($('<option />'));
											var e = $(this).val();
											if(e != ""){
												AddressEnsenManager.getPrefList(e, function(ret) {
													$.each(ret,function(){
														__prefcd.append($('<option />').val(this.prefCode).html(this.prefName));
													});
											    });
											}
											__prefcd.change();
										});
										$('#__prefcd').change(function(){
											var __citycd = $('#__citycd');
											__citycd.children().remove();
											__citycd.append($('<option />'));
											var e = $(this).val();
											var name = $(this).children(':selected').text();
											if(e != ""){
												AddressEnsenManager.getValidCityList(e, function(ret) {
													$.each(ret,function(){
														__citycd.append($('<option />').html(this.cityName)
																		.data('area',{
																			'prefcd':e,
																			'prefname':name,
																			'citycd':this.cityCode,
																			'cityname':this.cityName
																		})
														);
													});
											    });
											}
											__citycd.change();
										});
									</script>
								</td>
								<td rowspan="3" style="border: none;">
									<table>
										<tbody>
											<tr>
												<td style="border: none;">&nbsp;&nbsp;
													<input type="button" id="__btnAddCity" value="追加">
												</td>
											</tr>
										</tbody>
									</table>
								</td>
							</tr>
							<tr>
								<th>市区町村名から探す</th>
								<th><input type="radio" name="_searchTypeArea" value="2"></th>
								<td>
									<table class="type_searchbox">
										<tbody>
											<tr>
												<td>市区町村名</td>
												<td><input id="__cityname" size="80" maxlength="64" type="text" disabled=""></td>
												<td><input id="__citynameSearch" type="button" value="検索" disabled=""></td>
											</tr>
											<tr>
												<td colspan="3">検索結果</td>
											</tr>
											<tr>
												<td colspan="3">
													<select id="__prefCityList" size="5" multiple="" style="width: 100%" disabled="">
													</select>
												</td>
											</tr>
										</tbody>
									</table>
									<script type="text/javascript">
										$('#__citynameSearch').click(function(){
											var __prefCityList = $('#__prefCityList');
											__prefCityList.children().remove();
											var e = $('#__cityname').val();
											if(e != ""){
												AddressEnsenManager.getPrefCity(e, function(ret) {
													$.each(ret,function(){
														__prefCityList.append($('<option />').html(this.PREFNAME + this.CITYNAME)
																.data('area',{
																	'prefcd':this.PREFCD,
																	'prefname':this.PREFNAME,
																	'citycd':this.CITYCD,
																	'cityname':this.CITYNAME
																})
														);
													});
											    });
											}
										});
									</script>
								</td>
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">
						$(':radio[name=_searchTypeArea]').click(function(){
							var radio = $(this);
							$(':radio[name=_searchTypeArea]').parents('tr').children('td').find(':input').prop('disabled',true);
							var e = radio.parents('tr').children('td').find(':input');
							if(radio.prop('checked')){
								e.prop('disabled',false);
							}
							$('#__btnAddCity').prop('disabled',false);
						}).triggerHandler('click');
						$('#__btnAddCity').click(function(){
							var v = $(':radio[name=_searchTypeArea]:checked').val();
							var list = [];
							var select;
							if(v == '1')
								select = $('#__citycd option:selected');
							else
								select = $('#__prefCityList option:selected');

							select.each(function(){
								var area = $(this).data('area');
								if(area)
									list.push(area);
							});
							var __selectedCity = $('#__selectedCity');
							var opts = __selectedCity.children();
							$.each(list,function(){
								var area = this;
								var contain = $.grep(opts,function(opt){
									var _area = $(opt).data('area');
									return area.prefcd == _area.prefcd &&
											area.citycd == _area.citycd ;
								}).length != 0 ;
								if(!contain){
									__selectedCity.append($('<option />').html(this.prefname + this.cityname)
											.data('area',this));
								}
							});
						});
					</script>
				</div>
				<div class="annotation">選択済みの市区町村リスト</div>
				<div class="form_space">
					<table style="width: 100%">
						<colgroup>
                  			<col span="1" width="60%">
                  			<col span="1" width="40%">
                  		</colgroup>
						<tbody>
							<tr>
								<td rowspan="3" style="border: none;" width="50%">
									<select id="__selectedCity" size="10" style="width: 95%">
									</select>
								</td>
								<td>
									<input type="button" id="__btnUp" value="上へ">
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" id="__btnDown" value="下へ">
								</td>
							</tr>
							<tr>
								<td>
									<input type="button" id="__btnDel" value="選択中の市区町村を削除">
								</td>
							</tr>
						</tbody>
					</table>
					<script type="text/javascript">
						$('#__btnUp').click(function(){
							var _selectEki = $('#__selectedCity');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i > 0){
								$( opts[i] ).insertBefore($(opts[i-1]));
							}
						});
						$('#__btnDown').click(function(){
							var _selectEki = $('#__selectedCity');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i < opts.length -1){
								$( opts[i] ).insertAfter($(opts[i+1]));
							}
						});
						$('#__btnDel').click(function(){
							var _selectEki = $('#__selectedCity');
							var i = _selectEki.prop("selectedIndex");
							var opts = _selectEki.children();
							if(i != -1){
								$(opts[i]).remove();
							}
						});
					</script>
				</div>
