# Blaze Test API

This is a test project to create and edit orders and products. An order includes a list of items. Each order item has a product and a quantity which will be used to calculate the order total amount.

## API products

In order to create, edit, or list products you can find the nexts endpoints:

| #   | description               | endpoint                               | verb HTTP |
| --- | ------------------------- | -------------------------------------- | --------- |
| 1   | To List products pageable | `/api/products/pageable?page=0&size=2` | GET       |
| 2   | To List a product by ID   | `/api/products/1`                      | GET       |
| 3   | To Save a product         | `/api/products`                        | POST      |
| 4   | To Edit a product         | `/api/products`                        | POST      |
| 5   | To Delete a product       | `/api/products/1`                      | DELETE    |
| 5   | To Get all products       | `/api/products`                        | GET       |

### Example to save a product

You **dont need** to pass an id with in Json body.

`{ "name": "Galap", "category": "Cookies", "unitPrice": "1.00", "isActive": true }`

### Example to edit a product

You **must pass** an id with in Json body.

`{ "id":"1", "name": "Galap", "category": "Cookies", "unitPrice": "1.00", "isActive": true }`

## API orders

In order to create, edit, or list orders you can find the nexts endpoints:

| #   | description             | endpoint                             | verb HTTP |
| --- | ----------------------- | ------------------------------------ | --------- |
| 1   | To List orders pageable | `/api/orders/pageable?page=0&size=2` | GET       |
| 2   | To List a order by ID   | `/api/orders/1`                      | GET       |
| 3   | To Save a order         | `/api/orders`                        | POST      |
| 4   | To Edit a order         | `/api/orders`                        | POST      |
| 5   | To Delete a order       | `/api/orders/1`                      | DELETE    |
| 5   | To Get all orders       | `/api/orders`                        | GET       |

### Example to save an order

You **dont need** to pass an id with in Json body.

`{ "status": "Completed", "createdAt": "2021-08-05", "customer": "Josep Evans", "products": [ { "id": 8, "name": "Galapagitos", "category": "Cookies", "unitPrice": 1.2, "isActive": true }, { "id": 10, "name": "Galap", "category": "Cookies", "unitPrice": 1.0, "isActive": true } ] }`

### Example to edit an order

You **must pass** an id with in Json body.

`{ "id": 3, "status": "Completed", "createdAt": "2021-08-05", "customer": "Thomas Muller", "products": [ { "id": 1, "name": "Choko", "category": "Cookies", "unitPrice": 0.8, "isActive": true }, { "id": 4, "name": "Redbull", "category": "Drinks", "unitPrice": 3.5, "isActive": true }, { "id": 5, "name": "V220", "category": "Drinks", "unitPrice": 2.5, "isActive": true } ] }`
