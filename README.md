# Notion Google Analytics Proxy Server

노션 페이지 뷰(`pageview`) 이벤트를 수집하기 위한 프록시 서버입니다. 

*이 프로젝트는 [notion-ga 프로젝트](https://github.com/mskims/notion-ga)에서 아이디어를 얻었습니다.*

## Getting started

1. 네트워크로 연결 가능한 서버에 배포합니다.
1. 노션 블로그 글에 `/hits` API 경로를 가지는 이미지를 삽입합니다.
1. 끝 :) 

## Development Environment

* Openjdk 1.8
* Kotlin 1.3
* Spring boot 2.2

## Environment Variables

| Name | Description | Required |
| :----: | :---: | :---: |
| GA_TACKING_ID | 구글 애널리틱스에서 제공하는 ID | **Y** |

## API Description

### 페이지 뷰 이벤트 수집

* Path : `/hits`
* Method : GET
* Headerd :
   * `User-Agent` : 
      * optional
      * [표준화된 문자열](https://en.wikipedia.org/wiki/User_agent#Format)로 입력되어야 합니다.
   * `Host` :
      * optional
      * 페이지 뷰 요청을 하는 호스트의 정보
      * GA에서의 `cid`
* Parameters :
   * `page` : 
     * **Required**
     * GA에서 나타날 해당 페이지의 경로. 
     * `/`로 시작해야 합니다. 

