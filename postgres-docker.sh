#!/bin/sh


if [ "create" = "$1" ]; then
	docker run --name hammerheaddb -e POSTGRES_PASSWORD=password -d -p 5432:5432 postgres
fi

if [ "start" = "$1" ]; then
	docker start hammerheaddb
fi

if [ "stop" = "$1" ]; then
	docker stop hammerheaddb
fi

if [ "destroy" = "$1" ]; then
	docker rm -f hammerheaddb
fi
