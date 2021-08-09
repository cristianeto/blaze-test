# Blaze Test API

This is a test project to create and edit orders and products. An order includes a list of items. Each order item has a product and a quantity which will be used to calculate the order total amount.

## API products

[/api/products/pageable?page=0&size=2](https://blazetest-cris.herokuapp.com/api/products/pageable?page=0&size=2)

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

`{ "name": "Sweet Cake", "category": "Cakes", "unitPrice": 1.20, "isActive": true, "quantity": 10 }`

### Example to edit a product

You **must pass** an id with in Json body.

`{ "id": 1, "name": "Sweet Cake", "category": "Cakes", "unitPrice": 1.20, "isActive": true, "quantity": 10 }`

## API orders

[/api/orders/pageable?page=0&size=2](https://blazetest-cris.herokuapp.com/api/products/pageable?page=0&size=2)
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

You **dont need** to pass an id inside Json body.

`{ "status": "Completed", "customer": "Clen Eastwood", "products": [ { "id": 3, "name": "Ritz", "category": "Cookies", "unitPrice": 1.8, "isActive": true, "quantity": 2 }, { "id": 4, "name": "Chocake", "category": "Cakes", "unitPrice": 4.8, "isActive": true, "quantity": 3 } ] }`

### Example to edit an order

You **must pass** an id inside Json body.

`{ "id": 2,"status": "Completed", "customer": "Clen Eastwood", "products": [ { "id": 3, "name": "Ritz", "category": "Cookies", "unitPrice": 1.8, "isActive": true, "quantity": 2 }, { "id": 4, "name": "Chocake", "category": "Cakes", "unitPrice": 4.8, "isActive": true, "quantity": 3 } ] }`
