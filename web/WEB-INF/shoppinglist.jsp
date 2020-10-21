<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping list</h1>
         <!--Print hello with username-->
         <p><a href="ShoppingList?action=logout">Logout</a></p>
         
         <form action="" method="POST">
             <h2>Add Item</h2>
             <input type="text" name="item"><input type="submit" value="Add Item">
             <input type="hidden" name="action" value="add">
         </form>
         
         <form action="" method="POST">
             <!--Loop for list items that are added-->
             <input type="submit" value="Delete">
             <input type="hidden" name="action" value="delete">
         </form>
    </body>
</html>
