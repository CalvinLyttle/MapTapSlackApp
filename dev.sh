#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "$0")"

if [[ ! -f .env ]]; then
  echo "error: .env not found at $(pwd)/.env" >&2
  exit 1
fi

set -a
# shellcheck disable=SC1091
source .env
set +a

exec mvn clean compile exec:java -Dexec.mainClass="Main" "$@"