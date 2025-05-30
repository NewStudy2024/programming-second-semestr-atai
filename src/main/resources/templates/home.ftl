<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Hello Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 2rem;
            background-color: #f9f9f9;
            color: #333;
        }

        h1 {
            color: #2c3e50;
        }

        button {
            padding: 0.6rem 1rem;
            font-size: 1rem;
            border: none;
            background-color: #3498db;
            color: white;
            border-radius: 5px;
            cursor: pointer;
        }

        button:hover {
            background-color: #2980b9;
        }

        dialog {
            border: none;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.2);
            padding: 2rem;
            max-width: 400px;
        }

        form label {
            display: block;
            margin-bottom: 1rem;
            font-weight: bold;
        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 0.5rem;
            margin-top: 0.25rem;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        form button {
            margin-top: 1rem;
            margin-right: 0.5rem;
        }

        ul {
            list-style-type: none;
            padding: 0;
            margin-top: 2rem;
        }

        li {
            background: #fff;
            padding: 1rem;
            margin-bottom: 1rem;
            border-radius: 8px;
            box-shadow: 0 1px 3px rgba(0,0,0,0.1);
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        .product-info {
            flex: 1;
        }

        .product-actions a {
            margin-left: 1rem;
            color: #3498db;
            text-decoration: none;
            font-weight: bold;
        }

        .product-actions a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>${title}</h1>

<button onclick="showDialog()">Add New Product</button>

<!-- Dialog for creating new product -->
<dialog id="productDialog">
    <form method="post" action="/addProduct">
        <h3>Add New Product</h3>
        <label>
            Name:
            <input type="text" name="name" required />
        </label>
        <label>
            Quantity:
            <input type="number" name="quantity" required min="1" />
        </label>

        <button type="submit">Add</button>
        <button type="button" onclick="closeDialog()">Cancel</button>
    </form>
</dialog>

<ul>
    <#list products as product>
        <li>
            <div class="product-info">
                <strong>${product.name}</strong> — ${product.quantity}
            </div>
            <div class="product-actions">
                <a href="/detail?index=${product_index}">Details</a>
                <a href="/delete?index=${product_index}">Delete</a>
            </div>
        </li>
    </#list>
</ul>

<script>
    function showDialog() {
        document.getElementById("productDialog").showModal();
    }

    function closeDialog() {
        document.getElementById("productDialog").close();
    }
</script>
</body>
</html>
