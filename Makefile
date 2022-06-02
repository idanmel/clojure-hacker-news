docker-clean:
	docker-compose down -v

docker-up:
	docker-compose up -d

lein-test:
	lein test

run-tests: docker-clean docker-up lein-test
	docker-compose down -v
