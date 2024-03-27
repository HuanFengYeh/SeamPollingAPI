# Polling Job API

The Polling Job API is designed to facilitate the scheduling and management of polling tasks that periodically request data from third-party APIs and store the responses.

## Getting Started

Follow these instructions to get the Polling Job API running on your local machine for development and testing purposes.

### Prerequisites

- Java 17
- Maven
- Spring Boot
- H2 database for testing

### Installation

1. Clone the repository:
```sh
git clone https://github.com/yourusername/polling-job-api.git
```
2.Navigate to the project directory:

3.Configure application properties:
Open src/main/resources/application.properties.
Set the database connection properties according to your setup.

## API Usage
{
  "userId": "user1",
  "apiEndpoint": "https://dummyapi.online/api/movies",
  "pollingInterval": 60000
}
Currently only support this apiEndpoint, please use the end point list above when testing.


