# FINT Event Model

[![Build Status](https://travis-ci.org/FINTmodels/fint-event-model.svg?branch=master)](https://travis-ci.org/FINTmodels/fint-event-model) 
[![Coverage Status](https://coveralls.io/repos/github/FINTmodels/fint-event-model/badge.svg?branch=master)](https://coveralls.io/github/FINTmodels/fint-event-model?branch=master)

Event model for FINT

## Installation

build.gradle

```groovy
repositories {
    maven {
        url  "http://dl.bintray.com/fint/maven"
    }
}

compile('no.fint:fint-event-model:0.0.25')
```

## Usage

Create new Event.

```java
Event event = new Event("rogfk.no", "FK1", "GET_ALL", "VFS");
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