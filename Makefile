.DEFAULT_GOAL := build-run

setup:
	cd app && ./gradlew wrapper --gradle-version 8.5

clean:
	cd app && ./gradlew clean

build:
	cd app && ./gradlew clean build

install:
	cd app && ./gradlew clean install

run-dist:
	cd app && ./build/install/app/bin/app

run:
	cd app && ./gradlew run

test:
	cd app && ./gradlew test

report:
	cd app && ./gradlew jacocoTestReport

lint:
	cd app && ./gradlew checkstyleMain

check-deps:
	cd app && ./gradlew dependencyUpdates -Drevision=release

build-run: build run

.PHONY: build
