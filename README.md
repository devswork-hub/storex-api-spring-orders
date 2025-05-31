1. Subdomínio: `Orders`

- Bounded Context: `Order Management`
  - Linguagem Ubíqua: `Pedido`, `Item do Pedido`, `Status do Pedido`(Criado, Pago, Faturado, Enviado, Cancelado), `Endereço de Entrega`, `etc`...
  - Módulo (no código): Um conjunto de classes/pacotes/arquivos que implementam a lógica de `Order Management`.
  - Microserviço: `Orders Service` (um serviço deployável e autônomo)

## Subdominio

`Orders` é responsável por toda a lógica de negócio relacionada a pedidos. Ele tem sua própria fronteira de responsabilidade e seu próprio modelo de domínio.

## Bounded Context (Order Management)

Este é o Bounded Context principal que vive dentro do subdomínio Orders. Ele contém toda a lógica, entidades (como Order, OrderItem, Address), agregados, repositórios e serviços de domínio para o ciclo de vida do pedido: criação, atualização de status interno (pago, processando, faturado), cancelamento, etc. É aqui que o "CRUD" e as transições de estado do pedido são gerenciados.

## Bounded Context (Tracking)

Agora, imagine que "tracking" não é apenas o status interno do pedido, mas sim a integração com transportadoras externas e o gerenciamento do ciclo de vida físico da entrega (ex: coleta, transporte, roteirização, tentativas de entrega, localização GPS do pacote). Neste caso, "Tracking" (ou talvez um Shipping / Logistics Bounded Context) se torna um Bounded Context separado do Orders.

No Tracking BC: Haveria entidades como Shipment, DeliveryEvent, Carrier (transportadora), Location. O significado de "rastreamento" aqui é sobre o movimento físico e a cadeia de suprimentos.

```http
POST /shipments (para criar um novo rastreamento/envio).
PUT /shipments/{id}/status (para atualizar o status da entrega com base em webhooks de transportadoras).
GET /shipments/{id}/events (para obter o histórico de eventos de rastreamento).
```

<!-- ![alt text](image.png) -->

## Expectativas com esse projeto

- [] Entidades e ORM
- [] Migrations
- [] DTO Pattern
- [] Repository Pattern

###Resumo Simplificado para Clarificar:

Pense assim:

- Subdomínio: É uma área de negócio.
- Bounded Context: É o modelo de software que resolve os problemas dessa área de negócio.
- Módulo: É a organização do código desse modelo de software.
- Microserviço: É a unidade de deploy e execução desse modelo de software (normalmente, um Bounded Context por microserviço).
