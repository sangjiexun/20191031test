<!-- debug info start -->
<hr>
<h2>Debug Infomation:</h2>
<br>

<table border="1" width="50" style="font-family: sans-serif">
	<tr>
		<th colspan="3">
			<h1>Request Parameters</h1>
		</th>
	</tr>
	<c:forEach items="${paramValues}" var="parameter">
		<tr>
			<td><c:out value="${parameter.key}"></c:out> </td>
			<td colspan="2">
				<c:forEach items="${parameter.value}" var="value">
					<label><c:out value="${value}"></c:out></label>
				</c:forEach>
			</td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Initialization Parameters</h1>
		</th>
	</tr>
	<c:forEach items="${initParam}" var="parameter">
		<tr>
			<td><c:out value="${parameter.key}"></c:out> </td>
			<td colspan="2">
					<label><c:out value="${parameter.value}"></c:out></label>
			</td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Cookies</h1>
		</th>
	</tr>
	<c:forEach items="${Cookies}" var="map">
		<tr>
			<td rowspan="8"><c:out value="${map.key}"></c:out> </td>
			<td align="right">Name:</td>
			<td ><c:out value="${map.value.name}"></c:out></td>
			<td align="right">Value:</td>
			<td ><c:out value="${map.value.value}"></c:out></td>
			<td align="right">Domain:</td>
			<td ><c:out value="${map.value.domain}"></c:out></td>
			<td align="right">Max Age:</td>
			<td ><c:out value="${map.value.maxAge}"></c:out></td>
			<td align="right">Path:</td>
			<td ><c:out value="${map.value.path}"></c:out></td>
			<td align="right">Secure:</td>
			<td ><c:out value="${map.value.secure}"></c:out></td>
			<td align="right">Version:</td>
			<td ><c:out value="${map.value.version}"></c:out></td>
			<td align="right">Comment:</td>
			<td ><c:out value="${map.value.comment}"></c:out></td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Page Scope Attributes</h1>
		</th>
	</tr>
	<c:forEach items="${pageScope}" var="page">
		<tr>
			<td><c:out value="${page.key}"></c:out> </td>
			<td colspan="2">
					<label><c:out value="${page.value}"></c:out></label>
			</td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Request Scope Attributes</h1>
		</th>
	</tr>
	<c:forEach items="${requestScope}" var="request">
		<tr>
			<td><c:out value="${request.key}"></c:out> </td>
			<td colspan="2">
					<label><c:out value="${request.value}"></c:out></label>
			</td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Session Scope Attributes</h1>
		</th>
	</tr>
	<c:forEach items="${sessionScope}" var="session">
		<tr>
			<td><c:out value="${session.key}"></c:out> </td>
			<td colspan="2">
					<label><c:out value="${session.value}"></c:out></label>
			</td>
		</tr>
	</c:forEach>

	<tr>
		<th colspan="3">
			<h1>Application Scope Attributes</h1>
		</th>
	</tr>
	<c:forEach items="${applicationScope}" var="app">
		<tr>
			<td><c:out value="${app.key}"></c:out> </td>
			<td colspan="2" align="left" >
				<c:choose>
					<c:when test="${app.key eq 'org.apache.struts.action.PLUG_INS'}">
						<c:forEach items="${app.value}" var="subItem">
							<textarea rows="2" cols="80">
								<c:out value="${subItem}"></c:out>
							</textarea>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<textarea rows="2" cols="80">
							<c:out value="${app.value}"></c:out>
						</textarea>
					</c:otherwise>
				</c:choose>
			</td>
		</tr>
	</c:forEach>

</table>
<!-- debug info end -->