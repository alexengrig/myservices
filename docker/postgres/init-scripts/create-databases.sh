#!/bin/bash

set -e
set -u

echo "Start executing create-databases.sh"

function create_database_by_name() {
  local db=$1
  echo "Creating database: $db"
  psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	    CREATE DATABASE $db;
	    GRANT ALL PRIVILEGES ON DATABASE $db TO $POSTGRES_USER;
EOSQL
}

if [ -n "$POSTGRES_DB_LIST" ]; then
  echo "Start creating databases: $POSTGRES_DB_LIST"
  for db in $(echo "$POSTGRES_DB_LIST" | tr ',' ' '); do
    create_database_by_name "$db"
  done
  echo "Finished creating databases"
fi

echo "Finished executing create-databases.sh"
