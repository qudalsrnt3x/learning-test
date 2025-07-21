# Git Commit Message Convention

이 저장소는 학습 기록을 명확하게 남기고 추후 복습 및 공유가 용이하도록 하기 위해 다음과 같은 커밋 메시지 컨벤션을 사용합니다.

## ✅ Commit Message Format

---

## 🏷️ 타입 목록 (Type)

| 타입         | 설명                                |
|------------|-----------------------------------|
| `feat`     | 새로운 기능 추가                         |
| `fix`      | 버그 수정                             |
| `refactor` | 코드 리팩터링 (동작 변화 없음)                |
| `test`     | 테스트 코드 추가/수정                      |
| `chore`    | 설정, 의존성, 빌드, CI 관련 등 코드 외 작업      |
| `doc`      | 문서(README 등) 작성 또는 수정             |
| `style`    | 코드 포맷팅, 공백, 세미콜론 등 변경 (동작 변화 없음)  |
| `wip`      | 작업 중인 커밋 (push 목적 등으로 임시 저장 시 사용) |

---

## 📁 모듈명 표기 예시

모듈명은 프로젝트의 `settings.gradle` 또는 `build.gradle.kts`에 정의된 모듈명을 기준으로 작성합니다. 예시:

- `modulith/core`
- `eventing`
- `recommendation`
- `common`
- `infra`
- `doc`

문서나 공통 설정과 같이 모듈에 속하지 않는 경우에는 `[doc]`, `[infra]`, `[build]` 등도 사용 가능합니다.

---

## 🔁 커밋 메시지 예시

[chore] init: 빈 Spring Boot 프로젝트 초기화

[modulith] feat: modulith 모듈 생성 및 Gradle 설정 추가
[modulith] feat: core 패키지 구조 및 기본 클래스 정의
[modulith] refactor: 모듈 간 의존성 및 package-info.java 정리

[eventing] feat: eventing 모듈 생성 및 도메인 이벤트 기본 구조 구현
[eventing] test: 이벤트 퍼블리싱 동작 테스트 코드 추가
[eventing] refactor: 이벤트 발행자 유틸 분리

[recommendation] feat: 추천 알고리즘 모듈 스켈레톤 구성
[recommendation] feat: 유사도 기반 추천 로직 초기 버전 구현
[recommendation] test: 추천 결과 검증용 단위 테스트 작성

[common] chore: 공통 모듈 생성 및 날짜 포맷터 유틸 추가
[common] refactor: 반복 로직 공통 모듈로 이동

[infra] chore: 로컬 개발용 docker-compose.yml 추가
[infra] chore: application-local.yml 구성 분리

[doc] doc: README에 프로젝트 개요 및 커밋 컨벤션 설명 추가
[doc] doc: 모듈 구조도 이미지 및 사용법 문서 추가
