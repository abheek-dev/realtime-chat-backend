# Real-Time Chat Application - Backend

Intern ID: CITS2533

Basic Spring Boot + MySQL backend for a real-time chat app (REST APIs for users, chat rooms, and messages — no auth yet).

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Lombok

## Features
- CRUD APIs for Users
- CRUD APIs for Chat Rooms
- Send/retrieve Messages linked to a User and Chat Room
- Fetch all messages within a specific chat room

## Entities
- **User** — id, username, email
- **ChatRoom** — id, roomName, createdAt
- **Message** — id, content, timestamp, sender (User), chatRoom (ChatRoom)

## API Endpoints

### Users
- `POST /api/users`
- `GET /api/users`
- `GET /api/users/{id}`
- `PUT /api/users/{id}`
- `DELETE /api/users/{id}`

### Chat Rooms
- `POST /api/chatrooms`
- `GET /api/chatrooms`
- `GET /api/chatrooms/{id}`
- `PUT /api/chatrooms/{id}`
- `DELETE /api/chatrooms/{id}`

### Messages
- `POST /api/messages?senderId={id}&chatRoomId={id}&content={text}`
- `GET /api/messages`
- `GET /api/messages/{id}`
- `GET /api/messages/chatroom/{chatRoomId}`
- `DELETE /api/messages/{id}`

## Setup
1. Clone the repo
2. Copy `src/main/resources/application-example.properties` to `src/main/resources/application.properties`
3. Fill in your own MySQL username/password in `application.properties`
4. Run `./mvnw spring-boot:run`

## Notes
- Auth is intentionally not implemented in this version
- WebSocket-based real-time messaging planned as a future upgrade

