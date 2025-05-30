<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Detail</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 2rem;
            background-color: #f4f6f8;
            color: #333;
        }

        h1 {
            color: #2c3e50;
        }

        p {
            font-size: 1.2rem;
            background: #fff;
            padding: 1rem;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0,0,0,0.1);
        }

        a {
            display: inline-block;
            margin-top: 1rem;
            text-decoration: none;
            color: #3498db;
            font-weight: bold;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<h1>${title}</h1>

<p>
    <strong>Product Name:</strong> ${product.name}<br>
    <strong>Quantity:</strong> ${product.quantity}
</p>

<a href="/"> < Back to Home</a>
</body>
</html>
