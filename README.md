# KTOR demo

For running locally, check [run configurations](.runLocal)

For running in Docker, check

- docker-compose.yml

  Dependencies without KTOR Service

- docker-compose-library.yml

  Dependencies + KTOR Service with loaded [library](src/main/kotlin/ktor/demo/modules/dsl) module

- docker-compose-performance.yml

  Dependencies + KTOR Service with loaded [performance client](src/main/kotlin/ktor/demo/modules/performance/client) 
  module + KTOR Service with loaded [performance server](src/main/kotlin/ktor/demo/modules/performance/server) module
