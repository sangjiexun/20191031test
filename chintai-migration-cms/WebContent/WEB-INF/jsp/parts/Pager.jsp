<%@ page contentType="text/html;charset=UTF-8"%>
<div class="pager">
<c:if test="${helper.prev}">
      <a href="javascript:page(<c:out value="${helper.prevOffset}"/>)">前へ</a>
</c:if>

<c:forEach varStatus="status" begin="${helper.displayPageIndexBegin}" end="${helper.displayPageIndexEnd}">
   <c:if test="${(status.index+helper.offset) != helper.currentPageIndex+helper.offset}">
      <a href="javascript:page(<c:out value="${status.index * helper.limit}"/>)"><c:out value="${status.count+helper.displayPageIndexBegin}"/></a>
   </c:if>
   <c:if test="${(status.index+helper.offset) == helper.currentPageIndex+helper.offset && helper.displayPageIndexEnd > 0 }">
      <c:out value="${status.count+helper.displayPageIndexBegin} "/>
   </c:if>
</c:forEach>

<c:if test="${helper.next}">
      <a href="javascript:page(<c:out value="${helper.nextOffset}"/>)">後へ</a>
</c:if>
</div>