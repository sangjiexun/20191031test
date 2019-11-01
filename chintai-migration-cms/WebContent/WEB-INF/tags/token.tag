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
%><%!
	private static Log logger = LogFactory.getLog("net.chintai.backend.sysadmin.crnwl.views.tags.token");
%><%

	StringBuilder results = new StringBuilder();

	if (session != null) {
	    String token =
	        (String) session.getAttribute(Globals.TRANSACTION_TOKEN_KEY);

	    if (token != null) {
	        results.append("<div><input type=\"hidden\" name=\"");
	        results.append(Globals.TOKEN_KEY);
	        results.append("\" value=\"");
	        results.append(token);
	        results.append("\" />");
	        results.append("</div>");
	    }
	}

	if(results.length() == 0){
		logger.warn("トークンがセットされていません。");
	}

%><%=results.toString()%>