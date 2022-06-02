docker-clean:
	docker-compose down -v

tests-run: docker-clean
	docker-compose up -d
	lein test