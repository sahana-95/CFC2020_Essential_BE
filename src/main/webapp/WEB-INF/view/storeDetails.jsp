<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:forEach items="${storeList}" var="store">

       <h5>StoreName : ${store.storeName}</h5>

       <c:forEach items="${store.items}" var="item">
       <h5>ItemName : ${item.itemName}     ItemPrice : ${item.itemPrice}</h5>
       </c:forEach>

 </c:forEach>