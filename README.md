## book-store-microservices

This is a big personal project to put in practice some microservices technologies and patterns like:
- Kubernetes (not implemented yet)
- Istio (not implemented yet)
- Kiali (not implemented yet)
- Distributed logs (not implemented yet)
- Distributed tracing (not implemented yet)
- Authentication (not implemented yet)
- gRPC (not implemented yet)
- Domain Driven Design
- Saga (not implemented yet)

### Multiple Repositories Implementations
#### Múltiplas Implementações de Repositórios
**EN:**<br>
TODO

**PT-BR:**<br>
Os serviços possuem dois tipos padrões de implementações de repositório: **mongo** e **mock**.
- **mongo:** Implementação padrão. Utiliza o banco de dados MongoDB definido na propriedade `mongodb.uri`.
- **mock:** Utiliza recursos previamente mockados sem nenhum uso de banco de dados. Os métodos **POST**, **PUT** ou **DELETE** não afetarão os recursos.

Trocando entre as implementações:

No `application.yaml`, a propriedade abaixo define a implementação que será injetada:
```yaml
service:
  database:
    use: mongo
```
Altere de `mongo` para `mock` caso não queira configurar (ou usar) um banco de dados MongoDB.


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

