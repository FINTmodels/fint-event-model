# FINT Event Model

[![Build Status](https://jenkins.fintlabs.no/buildStatus/icon?job=FINTmodels/fint-event-model/master)](https://jenkins.fintlabs.no/job/FINTmodels/fint-event-model/master)
[![Coverage Status](https://coveralls.io/repos/github/FINTmodels/fint-event-model/badge.svg?branch=master)](https://coveralls.io/github/FINTmodels/fint-event-model?branch=master)

Event model for FINT

## Installation

build.gradle

```groovy
repositories {
    maven {
        url  "http://repo.fintlabs.no/releases"
    }
}

implementation 'no.fintlabs:fint-event-model:4.0.0'
```

## Usage

Create new Event.

```java
Event<String> event = new Event<>("rogfk.no", "FK1", "GET_ALL", "VFS");
```

with action enum
```java
Event<String> event = new Event<>("rogfk.no", "FK1", DefaultActions.HEALTH, "test");
```


Transform Event to json.

```java
String json = EventUtil.toJson(event);
```

Transform json to Event.

```java
Event event = EventUtil.toEvent(json);
```

Convert Event data into objects.

```java
List<TestDto> eventData = EventUtil.convertEventData(event, new TypeReference<List<TestDto>>() {});
```
