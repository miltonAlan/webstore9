---------------------------
-- CLEAN
-- BUILD WITH DEPENDENCIES
-- GLASSFISH 5.1.0
-- JDK 1.8
---------------------------


-- POST
http://localhost:8080/webstore9/rest/cart
{
    "id":"111",
    "cartItems": [
        {
            "id":"1",
            "productId":"P1234",
            "quantity":1
        },
        {
            "id":"2",
            "productId":"P1235",
            "quantity":1

        }
    ]
}

-- PUT
http://localhost:8080/webstore9/rest/cart/111
{
    "id":"111",
    "cartItems": [
        {
            "id":"1",
            "productId":"P1234",
            "quantity":3
        },
        {
            "id":"2",
            "productId":"P1235",
            "quantity":6

        }
    ]
}

-- GET
http://localhost:8080/webstore9/rest/cart/111
