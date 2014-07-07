
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<%@include file = "header.jsp" %>
<script>
    function updateInterface(id, name){
        document.getElementById('addId').value = id;
        document.getElementById('addName').value = name;
        document.getElementById('addButton').value = 'Применить';
        document.getElementById('addAction').value = 'update';  
    }
</script>
<table border="1">
    <h2>Факультеты</h2>
        <tr>
            <th>Id</th>
            <th>Название факультета</th>
            <th class="changeHeader">Изменение</th>
            <th class="deleteHeader">Удаление</th>
        </tr>
        <c:forEach var="item" items="${table}">
            <tr>
                <td><c:out value="${item.id}"/></td>
                <td><c:out value= "${item.name}" /></td>
                <td><input type="button" value="Изменение" 
                           onclick = "updateInterface('${item.id}', '${item.name}');"/>
                </td>
                <td><form action="" method="POST">
                        <input name="action" type="hidden" value="delete"/>
                        <input name="id" type="hidden" value="${fn:escapeXml(item.id)}"/>
                        <input type="submit" value="Удаление"/>
                    </form>
                </td>

            <tr>    
        </c:forEach>
        <tr>
            <form action="" method="POST">
                <td><input id="addId" name="id" type="text" readonly="readonly"/></td>
                <td>
                    <input id="addName" name="name" type="text" 
                           placeholder="Название факультета"/>
                </td>
                <td colspan="2"> 
                    <input id="addButton" align="center" type="submit" value="Добавить"/>
                </td>
                <input id="addAction" name="action" type="hidden" value="add"/>
            </form>
        </tr>
</table>
<%@include file = "footer.jsp" %>
