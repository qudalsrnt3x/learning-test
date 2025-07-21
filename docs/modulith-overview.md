# Spring Modulith

## 개요

---

### 도메인 기반 모듈 구조 지원

- 대규모 애플리케이션을 도메인 기반 모듈로 구성하여 **내부적 모듈화(modular monolith)**를 실현합니다.
- 각 도메인은 독립적인 모듈로 구성되며, 모듈 간 의존성을 최소화하여 높은 **응집도(cohesion)**와 낮은 **결합도(coupling)**를 지향합니다.
- 모듈 간 통신은 **도메인 이벤트 기반(event-based communication)**으로 수행되며, 이를 통해 **느슨한 결합(loose coupling)**을 유지할 수 있습니다.
- Spring Modulith는 모듈 간 구조적 경계를 자동 분석하고, 모듈 간 의존성 검증, 문서화, 테스트 분리, 런타임 추적 기능 등을 지원합니다.
- 배포는 단일 애플리케이션(monolith)로 수행되지만, 각 모듈은 논리적으로 독립적으로 개발 및 테스트 가능하게 설계됩니다.
- 결과적으로, Spring Modulith는 Microservices로 전환하기 전 단계의 준비 또는 대안 구조로도 매우 적합합니다.

### 부가 설명: "Spring Modulith vs Microservices"

| 항목  | Spring Modulith    | Microservices          |
|-----|--------------------|------------------------|
| 구조  | 논리적 모듈화된 단일 애플리케이션 | 완전히 독립된 서비스들           |
| 배포  | 단일 배포              | 각 서비스 개별 배포            |
| 경계  | 패키지/클래스 단위의 모듈 경계  | 네트워크 기반의 서비스 경계        |
| 통신  | 주로 내부 이벤트          | HTTP, 메시지 브로커 등        |
| 테스트 | 모듈 단위 통합 테스트 용이    | 서비스 간 통합 테스트 필요        |
| 복잡도 | 상대적으로 낮음           | 상대적으로 높음 (분산 환경 관리 필요) |


## 핵심 개념

---

### Application Module

- 모듈 단위 구조
  - Provided interface: 외부에 노출되는 API 및 이벤트
  - Internal components: 내부 구현 세부사항
  - Required interface: 다른 모듈의 API나 이벤트에 대한 의존

### 검증 & 문서화

**구조 검증**
- `ApplicationModules.of(Application.class).verify()`로 모듈 간 의존성 검증 (순환 의존 방지, 내부 패키지 접근 차단 등) 

**문서화**
- `Documenter`를 이용해 PlantUML 기반 모듈 다이어그램 (C4/UML) + Module Canvas(API, 이벤트 등 요약 테이블) 자동 생성

### 모듈 단위 통합 테스트

- `@ApplicationModuleTest` 애노테이션을 사용하여 모듈 단위 테스트 작성

### 이벤트 기반 통신
- `@ApplicationModuleListener`로 모듈 간 이벤트 핸들러 등록.
- `spring-modulith-events-*` 스타터 사용 시 이벤트 퍼블리시 로그, 트랜잭션 안전 보장, 재발행, 비동기 리스너 등 기능 이용 가능