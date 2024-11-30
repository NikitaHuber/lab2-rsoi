-- file: 10-create-user-and-db.sql
CREATE DATABASE library;
CREATE ROLE program WITH PASSWORD 'test';
GRANT ALL PRIVILEGES ON DATABASE library TO program;
ALTER ROLE program WITH LOGIN;