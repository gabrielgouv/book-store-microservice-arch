## book-store-microservices

This is a big personal project to put in practice some microservices technologies and patterns like:
- Kubernetes (not implemented yet)
- Istio (not implemented yet)
- Kiali (not implemented yet)
- Distributed logs (not implemented yet)
- Distributed tracing (not implemented yet)
- Authentication (not implemented yet)
- gRPC (not implemented yet)
- DDD
- Saga (not implemented yet)

### Resume:

**book-service (Service)**
- [X] Register books
- [ ] Remove books
- [ ] Reserve books
- [ ] Update books
- [ ] Get all books
- [ ] Get one book

**user-service (Service)**
- [ ] Create users
- [ ] Delete users
- [ ] Disable users
- [ ] Get all users
- [ ] Get one user

**cart-service (Service)**
- [ ] Create cart
- [ ] Delete cart
- [ ] Put items in cart
- [ ] Remove items from cart
- [ ] Checkout (maybe call another service)

**user-library-service (Service)**
- [ ] Get user's books

**book-store-core (Java Library)**
<br>
It's a shared core lib for all services

