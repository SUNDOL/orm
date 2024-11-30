# ORM
ORM을 활용한 아주 간단한 CRUD 구현

## 개발 환경
* 백엔드: Java 21 (Amazon Corretto 21 LTS)
* 데이터베이스: PostgreSQL
* IDE: STS4
* Maven 안 쓰고 Gradle 씀
* 데이터베이스 조회는 DBeaver 사용
* 데이터베이스는 Docker에 PostgreSQL Container 하나 만들어서 씀
* 기타 잡다한 설정은 application.properties 파일 혹은 build.gradle 참조

## Database를 위한 Docker 설치
* wsl2 설치 선행 (아마도? 하도 오래 전에 설치해서 까먹음)
* Docker Desktop 설치 (권장)

## Database를 위한 Docker 명령어 (Docker 설치가 됐다는 가정 하에)
* 터미널 열고 아래 명령어 주루루루룩 입력
* SQL로 테이블 만들고 이럴 필요 없음 (DB 연결 잘 되어 있으면 서버 시작 시 JPA가 만들어 둔 Entity 참조하여 알아서 다 자동으로 해줌)
> docker run --name orm -e POSTGRES_USER=orm -e POSTGRES_PASSWORD=orm -e TZ=Asia/Seoul -d -p 5432:5432 postgres
* 굳이 Docker 안 쓰고 PostgreSQL Database 단독으로 사용해도 무방

## 백엔드 실행
* 기존 스프링/스프링부트 환경과 같음
* http://localhost:8080/swagger-ui/index.html#/ 주소 들어가서 Swagger UI 열리면 성공

## 기타
* Spring Security, JWT Token, OAuth 등 기능은 싹 빼버림
* encoding UTF-8 설정하는 부분 까먹음 (그래도 잘 될 거임)
* 실무에서도 예시처럼 String 으로 대충 return 하고 이러면 싸대기 맞을 수 있음
