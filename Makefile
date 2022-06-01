docker-clean:
	docker-compose up -d

tests-run: docker-clean
	docker-compose up -d
	lein test