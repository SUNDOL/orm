# ORM
ORM을 활용한 아주 간단한 CRUD 구현

## 개발 환경
* 백엔드: Java 21 (Amazon Corretto 21 LTS)
* 데이터베이스: PostgreSQL
* IDE: STS4
* 데이터베이스는 Docker에 PostgreSQL Container 하나 만들어서 씀
* 기타 잡다한 설정은 application.properties 파일 혹은 build.gradle 참조

## Docker 설치
* wsl2 설치 선행
* Docker Desktop 설치 (권장)

## Docker 명령어 (Docker 설치가 됐다는 가정 하에)
* 터미널 열고 입력
> docker run --name orm -e POSTGRES_USER=orm -e POSTGRES_PASSWORD=orm -e TZ=Asia/Seoul -d -p 5432:5432 posgres

