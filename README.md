# msa-study-api-gateway

### Api Gateway 
실제 백엔드 서비스 또는 데이터와 접속하고 API 호출에 대한 정책, 인증 및 일반 액세스 제어를 적용하여 중요한 데이터를 보호하는 트래픽 관리자

### YML 설정 정보
routes:
- id: order-service  //id 정보
- uri: lb://ORDER-SERVICE // discovery-service에 등록된 application name 서버로 라우팅 하겠다는뜻
- predicates:
  - Path=/order/** // 해당 패스를 위 uri로 라우트 하겠다는 
- filters:
  - AddRequestHeader=order-request, order-requests-header2
  - AddResponseHeader=order-response, order-response-header2
  - name: LoggingFilter  
    - args:
    - baseMessage: test
    - preLogger: true
    - postLogger: true
- name: CustomFilter
- RewritePath=/order/(?<segment>.*), /$\{segment}  // gateway uri를 rewrite하는 설정

## Cloud Config(bootstrap.yml설정)
- config, bootstarp, actuator, bus-amqp dependency 추가
- bbotstarp.yml 설정 확인
- management.endpoints.web.exposure.include: busrefresh
- amqp (rabbit mq 또는 kafka 설정)